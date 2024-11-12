package com.renlife.cloud.demo.advice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Priority;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Priority(110)
@RestControllerAdvice
public class AppControllerAdvice {

    private static final String DEFAULT_ERROR_MESSAGE = "Возникла внутренняя ошибка сервиса. Пожалуйста, " +
            "попробуйте снова или обратитесь в тех. поддержку";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var message = DEFAULT_ERROR_MESSAGE;

        var annotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        if (null != annotation) {
            String exceptionMessage = e.getMessage();
            message = StringUtils.hasText(exceptionMessage) ? exceptionMessage : message;
            status = annotation.code();
            if (status.is5xxServerError()) {
                log.error("Internal error occurred", e);
            }
        } else {
            log.error("Uncaught exception occurred", e);
        }

        var error = ErrorDto.createBuilder(status).message(message).build();

        return createResponse(error, request);
    }

    private ResponseEntity<ErrorDto> createResponse(ErrorDto dto, WebRequest request) {
        if (request instanceof ServletWebRequest servletRequest) {
            dto.setPath(servletRequest.getRequest().getRequestURI());
        } else {
            dto.setPath("");
        }

        dto.setTimestamp(ZonedDateTime.now());

        return new ResponseEntity<>(dto, new HttpHeaders(), dto.getHttpStatus());
    }

    @Data
    @Builder(builderMethodName = "internalBuilder")
    @Accessors(chain = true)
    @JsonPropertyOrder({"timestamp", "status", "error", "message", "path", "errors"})
    public static class ErrorDto {

        private ZonedDateTime timestamp;

        @JsonIgnore
        private HttpStatus httpStatus;
        private Integer statusCode;
        private String error;
        private String message;
        private String path;
        private Map<String, String> errors;

        public static ErrorDtoBuilder createBuilder(HttpStatus httpStatus) {
            return internalBuilder()
                    .httpStatus(httpStatus)
                    .statusCode(httpStatus.value())
                    .error(httpStatus.getReasonPhrase())
                    .errors(new HashMap<>());
        }
    }
}
