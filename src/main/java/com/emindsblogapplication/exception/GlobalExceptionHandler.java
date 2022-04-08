package com.emindsblogapplication.exception;

import com.emindsblogapplication.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity <ErrorMessage> postNotFoundException(PostNotFoundException exception , WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);


    }


    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> dataAlreadyExistException(DataAlreadyExistsException alreadyExistsException,
                                                                   WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.CONFLICT,alreadyExistsException.getMessage());

        return   ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

}
