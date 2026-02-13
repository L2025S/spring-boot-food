package se.iths.lw.springbootfood.exception;

public class InvalidFoodPriceException extends RuntimeException{
    public InvalidFoodPriceException(String message) {
        super(message);
    }
}
