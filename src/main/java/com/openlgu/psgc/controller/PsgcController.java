package com.openlgu.psgc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.openlgu.psgc.dto.PsgcRegisterRequest;
import com.openlgu.psgc.dto.PsgcResponse;
import com.openlgu.psgc.service.PsgcService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/psgc")
public class PsgcController {
    private static final Logger log = LoggerFactory.getLogger(PsgcController.class);
	
    private final PsgcService service;
    
    public PsgcController(PsgcService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PsgcResponse> register(@RequestBody PsgcRegisterRequest request) {
        log.info("Register Request:{}", request);
        return service.register(request);
    }

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Flux<String> upload(@RequestPart("files") Flux<FilePart> files) {
		
	    return Flux.error(
	            new ResponseStatusException(
	                HttpStatus.SERVICE_UNAVAILABLE,
	                "Upload feature is not ready yet"
	            )
	        );		
	}

}
