package com.example.CRUD.controller.handler;

import com.example.CRUD.exception.NotFoundException;
import com.example.CRUD.exception.SpeakerNotFoundException;
import com.example.CRUD.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleMultiNotFoundException(NotFoundException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        errors.put("errores", ex.getMessages().stream().map(Throwable::getMessage).collect(Collectors.toList()));
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptionsIllegal(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Error: ", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(SpeakerNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handleValidationSpeakerNotFound(SpeakerNotFoundException ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("Error: ", ex.getMessage());
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(StudentNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handleValidationStudentNotFound(StudentNotFoundException ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("Error: ", ex.getMessage());
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler({SpeakerNotFoundException.class, StudentNotFoundException.class})
//    public ResponseEntity<Map<String, String>> handleNotFoundExceptions(RuntimeException ex) {
//        Map<String, String> errors = new HashMap<>();
//        errors.put("Error: ", ex.getMessage());
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler({SpeakerNotFoundException.class, StudentNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleNotFoundExceptions(RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();

        // Verifica el tipo de excepción y agrega el mensaje correspondiente
        if (ex instanceof SpeakerNotFoundException) {
            errors.put("Speaker Error", ex.getMessage());
        }

        if (ex instanceof StudentNotFoundException) {
            errors.put("Student Error", ex.getMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}


