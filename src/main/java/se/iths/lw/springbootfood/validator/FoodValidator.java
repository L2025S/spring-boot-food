package se.iths.lw.springbootfood.validator;


import org.springframework.stereotype.Component;
import se.iths.lw.springbootfood.exception.InvalidFoodDateException;
import se.iths.lw.springbootfood.exception.InvalidFoodNameException;
import se.iths.lw.springbootfood.exception.InvalidFoodPriceException;
import se.iths.lw.springbootfood.exception.InvalidFoodQuantityException;
import se.iths.lw.springbootfood.model.Food;

import java.time.LocalDate;

@Component
public class FoodValidator {
    public void validateName(String name){
        if (name == null || name.isBlank()){
            throw new InvalidFoodNameException("Food item name cannot be empty.");
        }
    }

    public void validateQuantity(int quantity) {
        if (quantity < 0){
            throw new InvalidFoodQuantityException("Food item quantity cannot be negative.");
        }
    }

    public void validatePrice(double price) {
        if(price < 0) {
            throw new InvalidFoodPriceException("Food item price cannot be negative.");
        }
    }

    public void validateBestBefore(LocalDate date) {
        if (date == null) {
            throw new InvalidFoodDateException("Food item date cannot be null.");
        }
        if(date.isBefore(LocalDate.now())){
            throw new InvalidFoodDateException("Best-before date cannot be in the past.");
        }
    }

    public void validate(Food food) {
        validateName(food.getName());
        validateQuantity(food.getQuantity());
        validatePrice(food.getPrice());
        validateBestBefore(food.getBestBefore());
    }
}
