package ru.bellintegrator.practice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


/**
 * Обработчик исключений
 */
@RestControllerAdvice("ru.bellintegrator.practice.controller")
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView otherException (Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.error = e.getMessage();
        return errorView;
    }

    /**
     * Метод перехватывает пустые данные
     */
    @ExceptionHandler(BadDataException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorView badDataException (BadDataException e) {
        ErrorView errorView = new ErrorView();
        errorView.error = "Данные не найдены";
        return errorView;
    }

    /**
     * Метод перехватывает возникающие ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView constrainViolationException (ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String message = violation.getMessage();
            errors.add(message);
        }

        ErrorView errorView = new ErrorView();
        errorView.error = errors;
        return errorView;
    }
}
