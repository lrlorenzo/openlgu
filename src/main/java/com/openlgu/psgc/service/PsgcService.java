package com.openlgu.psgc.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import com.openlgu.psgc.dto.PsgcImportResponse;
import com.openlgu.psgc.dto.PsgcRegisterRequest;
import com.openlgu.psgc.dto.PsgcResponse;
import com.openlgu.psgc.entity.Psgc;
import com.openlgu.psgc.repository.PsgcRepository;
import com.openlgu.shared.config.ImportProperties;
import com.openlgu.shared.exception.FileProcessingException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PsgcService {
	private static final Logger log = LoggerFactory.getLogger(PsgcService.class);
	private static final String UPLOAD_PREFIX = "upload-";
	private static final String SUFFIX = ".xlsx";
	private static final String DEFAULT_SHEET = "PSGC";
	private static final int ID_INDEX = 0;
	private static final int NAME_INDEX = 1;
	private static final int CORRESPONDENCE_CODE_INDEX = 2;
	private static final int GEOGRAPHIC_LEVEL_INDEX = 3;
	private static final int CITY_CLASS_INDEX = 5;
	private static final int INCOME_CLASSIFICATION_INDEX = 6;
	private static final int URBAN_RURAL_INDEX = 7;

	private final PsgcRepository repository;
	private final R2dbcEntityTemplate template;
	private final ImportProperties importProperties;

	public PsgcService(PsgcRepository repository, R2dbcEntityTemplate template, ImportProperties importProperties) {
		this.repository = repository;
		this.template = template;
		this.importProperties = importProperties;
	}

	public Mono<PsgcResponse> register(PsgcRegisterRequest request) {
		log.info("Register Request:{}", request);
		Psgc psgc = toEntity(request);

		return repository.save(psgc).map(this::toResponse);

	}

	public Flux<PsgcImportResponse> process(Flux<FilePart> files) {
		return files.flatMap(this::processFile);
	}

	private Mono<PsgcImportResponse> processFile(FilePart file) {
		Path tempFile;

		try {
			tempFile = Files.createTempFile(UPLOAD_PREFIX, SUFFIX);
		} catch (IOException e) {
			return Mono.error(e);
		}

		Mono<PsgcImportResponse> importTask = Mono.fromCallable(() -> {
			return importExcel(tempFile, file.filename());
		});

		Mono<PsgcImportResponse> scheduledTask = importTask.subscribeOn(Schedulers.boundedElastic());

		return file.transferTo(tempFile).then(scheduledTask).doFinally(signal -> {
			try {
				Files.deleteIfExists(tempFile);
			} catch (IOException e) {

			}
		});
	}

	private PsgcImportResponse importExcel(Path tempFile, String originalFilename) {
		int batchSize = importProperties.getBatchSize();
		List<Psgc> batch = new ArrayList<>(batchSize);

		log.info("importExcel Request:{}", tempFile);

		try (InputStream is = Files.newInputStream(tempFile); ReadableWorkbook workbook = new ReadableWorkbook(is)) {

			Optional<Sheet> optionalSheet = workbook.findSheet(DEFAULT_SHEET);
			if (optionalSheet.isEmpty()) {
				throw new FileProcessingException();
			}

			Sheet sheet = optionalSheet.get();

			PsgcImportResponse response = new PsgcImportResponse();
			response.setFilename(originalFilename);
			int inputSize = 0;

			try (Stream<Row> rows = sheet.openStream()) {
				Iterator<Row> iterator = rows.iterator();

				// skip the header
				if (iterator.hasNext()) {
					iterator.next();
				}

				while (iterator.hasNext()) {
					Row row = iterator.next();
					Psgc psgc = mapRow(row);

					if (psgc.getId() == null || psgc.getId().isBlank()) {
						break;
					}

					batch.add(psgc);

					if (batch.size() >= batchSize) {
						saveBatch(batch);
						inputSize += batch.size();
						batch.clear();
					}
				}

				if (!batch.isEmpty()) {
					saveBatch(batch);
					inputSize += batch.size();
					batch.clear();
				}
			}

			response.setSize(inputSize);

			return response;

		} catch (IOException e) {
			throw new FileProcessingException(e);
		}

	}

	private void saveBatch(List<Psgc> batch) {
		Set<String> ids = batch.stream().map(Psgc::getId).collect(Collectors.toSet());
		Set<String> existingIds = repository.findAllById(ids).map(Psgc::getId).collectList().block().stream()
				.collect(Collectors.toSet());

		List<Psgc> inserts = new ArrayList<>();
		List<Psgc> updates = new ArrayList<>();

		for (Psgc psgc : batch) {
			if (existingIds.contains(psgc.getId())) {
				updates.add(psgc);
			} else {
				inserts.add(psgc);
			}
		}

		if (!updates.isEmpty()) {
			repository.saveAll(batch).then().block();
		}

		if (!inserts.isEmpty()) {
			Flux.fromIterable(inserts).flatMap(template::insert).then().block();
		}
	}

	private Psgc mapRow(Row row) {
		Psgc psgc = new Psgc();
		psgc.setId(row.getCellText(ID_INDEX));
		psgc.setName(row.getCellText(NAME_INDEX));
		psgc.setCorrespondenceCode(row.getCellText(CORRESPONDENCE_CODE_INDEX));
		psgc.setGeographicLevel(row.getCellText(GEOGRAPHIC_LEVEL_INDEX));
		psgc.setCityClass(row.getCellText(CITY_CLASS_INDEX));
		psgc.setIncomeClassification(row.getCellText(INCOME_CLASSIFICATION_INDEX));
		psgc.setUrbanRural(row.getCellAsString(URBAN_RURAL_INDEX).orElse(" "));

		return psgc;
	}

	private Psgc toEntity(PsgcRegisterRequest request) {
		Psgc psgc = new Psgc();
		// TODO:
		return psgc;
	}

	private PsgcResponse toResponse(Psgc psgc) {
		PsgcResponse response = new PsgcResponse();
		// TODO:
		return response;
	}

}
