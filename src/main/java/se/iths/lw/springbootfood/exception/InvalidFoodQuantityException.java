package se.iths.lw.springbootfood.exception;

public class InvalidFoodQuantityException extends RuntimeException{
    public InvalidFoodQuantityException(String message){
        super(message);
    }
}
