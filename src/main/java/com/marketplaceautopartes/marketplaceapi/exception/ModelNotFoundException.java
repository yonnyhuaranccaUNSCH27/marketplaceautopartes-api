package com.marketplaceautopartes.marketplaceapi.exception;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String message){
        super(message);
    }
}
