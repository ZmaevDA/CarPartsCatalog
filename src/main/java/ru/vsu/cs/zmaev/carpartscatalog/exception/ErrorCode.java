package ru.vsu.cs.zmaev.carpartscatalog.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {
    INCORRECT_ATTRIBUTE_NAME("No such attribute with name: ");

    private final String codeDescription;

}
