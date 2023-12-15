package ru.vsu.cs.zmaev.carpartscatalog.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message, Throwable e) {
        super(message, e);
    }
}
