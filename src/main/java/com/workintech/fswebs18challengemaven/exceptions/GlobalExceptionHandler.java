package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardException.class)
    public ResponseEntity<CardErrorResponse> cardErrorMassage(CardException cardException){
        CardErrorResponse exception = new CardErrorResponse(cardException.getMessage(),cardException.getHttpStatus());
        return new ResponseEntity<>(exception,cardException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> globalErrors(Exception exception){
        CardErrorResponse exception1 = new CardErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exception1,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
