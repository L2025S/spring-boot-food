package se.iths.lw.springbootfood.exception;

public class FoodInvalidPriceException extends RuntimeException{
    public FoodInvalidPriceException(String message){
        super(message);
    }
}
