package ru.vsu.cs.zmaev.carpartscatalog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public abstract class EntityException extends RuntimeException {
    private final int errorCode;
    private final HttpStatus status;
    private final String errorMessage;
    private final Instant instant;

    protected EntityException(HttpStatus httpStatus, String errorMessage) {
        this.errorCode = httpStatus.value();
        this.status = httpStatus;
        this.errorMessage = errorMessage;
        this.instant = Instant.now();
    }
}
