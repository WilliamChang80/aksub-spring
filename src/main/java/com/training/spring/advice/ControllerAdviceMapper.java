package com.training.spring.advice;

import com.training.spring.dto.ErrorDto;
import com.training.spring.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerAdviceMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DataNotFoundException.class})
    public ErrorDto handleDataNotFound(Exception e) {
        log.error(e.getMessage());

        return new ErrorDto(404, e.getMessage());
    }

}
