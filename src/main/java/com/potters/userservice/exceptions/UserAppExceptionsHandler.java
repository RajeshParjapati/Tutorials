package com.potters.userservice.exceptions;

import com.potters.userservice.exceptions.bussiness.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserAppExceptionsHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
    Map<String, String> errormap = new HashMap<>();

    ex.getFieldErrors()
        .forEach(
            fieldError -> {
              errormap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
    return errormap;
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(UserNotFoundException.class)
  public String handleUserNotFoundException(UserNotFoundException ex){
      return ex.getMessage();
  }
}
