package se.iths.lw.springbootfood.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.lw.springbootfood.model.Food;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);
    Optional<Food> findByBarcode(String barcode);
    List<Food> findByHasSeafoodTrue();
    List<Food> findByHasLactoseTrue();
    List<Food> findByNameContainingIgnoreCase(String keyword);
    List<Food> findByQuantityLessThanEqual( int quantity);
    List<Food> findByBestBeforeBefore(LocalDate date);
    List<Food> findByBestBeforeBetween(LocalDate start, LocalDate end);

}

