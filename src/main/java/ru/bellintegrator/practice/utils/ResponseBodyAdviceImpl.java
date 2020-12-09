package ru.bellintegrator.practice.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 *  Настройка ответа до выполнения метода контроллера @ResponseBody
 * */
@RestControllerAdvice("ru.bellintegrator.practice.controller")
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     *  Донастройка тела ответа перед отправкой
     *  */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        final HttpServletResponse servletResponse = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse();

        if (body instanceof ErrorView) {
            return body;
        }

        if (methodParameter.getGenericParameterType().getTypeName().equals("void")) {
            return new ResultView();
        }

        return new Wrapper<Object>(body);
    }

    /**
     * Класс обертка
     * */
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @JsonSerialize
    private class Wrapper<T> {
        private final Object data;

        public Wrapper(Object data) {
            this.data = data;
        }
    }
}
