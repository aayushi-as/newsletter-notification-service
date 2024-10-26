package com.project.newsletter.exception;

public class DuplicateEventException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DuplicateEventException(String message) {
        super(message);
    }
}
