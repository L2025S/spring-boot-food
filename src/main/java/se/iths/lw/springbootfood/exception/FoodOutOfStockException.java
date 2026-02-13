package se.iths.lw.springbootfood.exception;

public class FoodOutOfStockException extends RuntimeException{
    public FoodOutOfStockException(String message) {
        super(message);
    }
}
