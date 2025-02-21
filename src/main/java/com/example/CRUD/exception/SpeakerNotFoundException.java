package com.example.CRUD.exception;

public class SpeakerNotFoundException extends RuntimeException {
    public SpeakerNotFoundException(String message) {
        super(message);
    }

  public SpeakerNotFoundException(Long studentId) {
    super("Speaker no encontrado: " + studentId);
  }
}
