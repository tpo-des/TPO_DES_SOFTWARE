package tpo.jugar.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tpo.jugar.dto.ErrorDto;
import tpo.jugar.exception.NotFoundException;

@RestControllerAdvice
class NotFoundExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorDto notFoundHandler(NotFoundException ex) {
        return new ErrorDto(ex.getMessage());
    }
}