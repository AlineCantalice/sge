package com.sge.sge.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Erro de negócio.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegrasNegocioException extends RuntimeException {

    private String msg;
    private int request;

    public RegrasNegocioException(final String message) {
        this(message, null);
    }

    public RegrasNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}