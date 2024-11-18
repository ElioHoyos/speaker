package com.example.CRUD.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Long studentId) {
        super("Student not found with id: " + studentId);
    }

}
