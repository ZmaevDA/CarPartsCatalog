package ru.vsu.cs.zmaev.carpartscatalog.controller.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.vsu.cs.zmaev.carpartscatalog.exception.EntityException;
import ru.vsu.cs.zmaev.carpartscatalog.exception.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Reference;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityException.class)
    public ResponseEntity<Object> handleGlobalException(
            EntityException e) {
        log.error(e.getErrorMessage(), e);
        return ResponseEntity
                .status(e.getStatus())
                .body(new ErrorMessage(e.getStatus().toString(), e.getErrorMessage(), e.getInstant()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Неправильный формат значения для поля " + ex.getName() + ": " + ex.getValue();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        StringBuilder messageSb = new StringBuilder("Invalid input for fields: [");
        if (mostSpecificCause instanceof InvalidFormatException invalidFormatException) {
            List<JsonMappingException.Reference> references = invalidFormatException.getPath();
            String fieldNames = references.stream()
                    .map(JsonMappingException.Reference::getFieldName)
                    .collect(Collectors.joining("."));
            messageSb.append(fieldNames);
        }
        messageSb.append("]");
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), messageSb.toString());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }
}
