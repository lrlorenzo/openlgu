package com.openlgu.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.openlgu.resident.exception.ResidentNotFoundException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResidentNotFoundException.class)
    public Mono<ResponseEntity<ErrorResponse>> handle(ResidentNotFoundException ex,
                                                     ServerHttpRequest request) {

        ErrorResponse error = new ErrorResponse(
                ex.getCode(),
                ex.getMessage(),
                request.getPath().value()
        );

        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(error));
    }

}
