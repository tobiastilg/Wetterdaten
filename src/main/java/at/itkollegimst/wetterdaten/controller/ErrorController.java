package at.itkollegimst.wetterdaten.controller;

import at.itkollegimst.wetterdaten.entity.Error;
import at.itkollegimst.wetterdaten.exception.MesswertNotFoundException;
import at.itkollegimst.wetterdaten.exception.MesswertValidate;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MesswertNotFoundException.class)
    public ResponseEntity<Error> messwertNotFoundException(MesswertNotFoundException exception) {
        Error message = new Error("1000", HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(MesswertValidate.class)
    public ResponseEntity<Error> messwertValidate(MesswertValidate exception) {
        Error message = new Error("2000", HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
