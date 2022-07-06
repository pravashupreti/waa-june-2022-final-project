package edu.miu.amp.exception.custom;

public class PropertyAlreadyRented extends RuntimeException{

    public PropertyAlreadyRented(String message){
        super(message);
    }
}
