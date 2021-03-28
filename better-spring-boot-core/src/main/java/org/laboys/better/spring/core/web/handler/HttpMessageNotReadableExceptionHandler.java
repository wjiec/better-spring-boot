package org.laboys.better.spring.core.web.handler;

import org.laboys.better.spring.core.annotation.web.RestExceptionHandler;
import org.laboys.better.spring.core.web.decoration.DecorationError;
import org.laboys.better.spring.core.web.decoration.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.Collections;
import java.util.List;

@RestExceptionHandler(value = HttpMessageNotReadableException.class,
    statusCode = StatusCode.METHOD_ERROR, httpStatus = HttpStatus.BAD_REQUEST)
public class HttpMessageNotReadableExceptionHandler implements Handler<HttpMessageNotReadableException> {

    @Override
    public List<? extends DecorationError> errors(HttpMessageNotReadableException ex) {
        return Collections.singletonList(DecorationError.builder()
            .error("empty-http-message")
            .message("Message not readable")
            .build());
    }

}
