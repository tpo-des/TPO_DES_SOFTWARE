package tpo.jugar.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tpo.jugar.dto.ErrorDto;
import tpo.jugar.exception.InvalidoEstadoPartidoException;

@RestControllerAdvice
class InvalidoEstadoPartidoAdvice {

    @ExceptionHandler(InvalidoEstadoPartidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    ErrorDto employeeNotFoundHandler(InvalidoEstadoPartidoException ex) {
        return new ErrorDto(ex.getMessage());
    }
}