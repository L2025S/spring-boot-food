package se.iths.lw.springbootfood.exception;

public class FoodLowStockException extends RuntimeException {
    public FoodLowStockException(String message) {
        super(message);
    }
}
