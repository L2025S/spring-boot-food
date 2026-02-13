package se.iths.lw.springbootfood.exception;

public class FoodNotFoundException extends RuntimeException{

    public FoodNotFoundException(String message) {
        super(message);
    }
}
