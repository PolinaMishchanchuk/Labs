package com.company;

public class NasedkaLogicException extends Exception {
    public NasedkaLogicException(){
    }
    public NasedkaLogicException(String message, Throwable exception){
        super(message,exception);
    }
    public NasedkaLogicException(String message){
        super(message);
    }
    public NasedkaLogicException(Throwable exception){
        super(exception);
    }

}
