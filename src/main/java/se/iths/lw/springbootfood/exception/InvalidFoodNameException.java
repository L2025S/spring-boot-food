package se.iths.lw.springbootfood.exception;

public class InvalidFoodNameException extends RuntimeException {
    public InvalidFoodNameException(String message){
        super(message);
    }
}
