package se.iths.lw.springbootfood.exception;

public class FoodInvalidQuantityException extends Exception{
    public FoodInvalidQuantityException(String message){
        super (message);
    }
}
