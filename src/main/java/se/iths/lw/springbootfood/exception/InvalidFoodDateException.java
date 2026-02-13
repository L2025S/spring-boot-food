package se.iths.lw.springbootfood.exception;

public class InvalidFoodDateException extends RuntimeException{
    public InvalidFoodDateException(String message) {
        super(message);
    }
}
