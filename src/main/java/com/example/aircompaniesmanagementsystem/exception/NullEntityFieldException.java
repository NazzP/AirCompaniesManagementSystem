package com.example.aircompaniesmanagementsystem.exception;

public class NullEntityFieldException extends RuntimeException{
    public NullEntityFieldException() {    }

    public NullEntityFieldException(String message) {
        super(message);
    }
}
