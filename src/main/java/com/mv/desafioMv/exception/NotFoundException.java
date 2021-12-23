package com.mv.desafioMv.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("Not Found");
    }
}
