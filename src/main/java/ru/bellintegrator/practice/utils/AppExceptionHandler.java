package ru.bellintegrator.practice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice("ru.bellintegrator.practice.controller")
public class AppExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ErrorView unhandledException (Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.error = e.getMessage();
        return errorView;
    }

    /**
     * Метод перехватывает возникающие NullPointerException
     */
    @ExceptionHandler(BadDataException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorView handleException (BadDataException e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "Данные не найдены";
        return errorView;
    }

    /**
     * Метод перехватывает возникающие ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView handleException (ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String message = violation.getMessage();
            errors.add(message);
        }

        ErrorView errorView = new ErrorView();
        errorView.error = StringUtils.arrayToDelimitedString(errors.toArray(),", ");
        return errorView;
    }
}
