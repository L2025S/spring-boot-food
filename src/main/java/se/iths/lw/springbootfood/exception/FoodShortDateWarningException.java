package se.iths.lw.springbootfood.exception;

public class FoodShortDateWarningException extends RuntimeException{
    public FoodShortDateWarningException(String message) {
        super (message);
    }
}
