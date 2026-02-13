package se.iths.lw.springbootfood.exception;

public class FoodAlreadyExistsException extends RuntimeException{
    public FoodAlreadyExistsException(String message) {
        super(message);
    }
}
