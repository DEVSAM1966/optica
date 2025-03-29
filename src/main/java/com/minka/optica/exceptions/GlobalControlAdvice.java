package com.minka.optica.exceptions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControlAdvice {

  @ExceptionHandler(BdNotFoundException.class)
  public ResponseEntity<Object> bdNotFoundHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - The object in BD not found")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(BdNotSaveException.class)
  public ResponseEntity<Object> bdNotSaveHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - The object in BD can´t be saved")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(InvalidPasswordException.class)
  public ResponseEntity<Object> invalidPasswordHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - The object in BD can´t be saved for password incorrected")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<Object> objectNotFoundHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - The object in BD not found")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> methodArgumentNotValidHandler(MethodArgumentNotValidException ex) {

    // Map para almacenar los errores de validación
    Map<String, String> validationErrors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      validationErrors.put(error.getField(), error.getDefaultMessage());
    });

    // Crear ApiError con los detalles adicionales
    ApiError apiError = ApiError.builder()
        .message("Validation failed")
        .description("Error in object validation")
        .date(LocalDate.now())
        .additionalDetails(validationErrors)
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }
}
