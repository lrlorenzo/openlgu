package com.openlgu.psgc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/psgc")
public class PsgcController {
	
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
