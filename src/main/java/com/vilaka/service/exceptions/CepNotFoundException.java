package com.vilaka.service.exceptions;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException(String message) {
        super(message);
    }
}
