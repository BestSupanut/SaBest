package com.cpe.wongnai.repository;



import java.util.List;
import com.cpe.wongnai.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ingredientrepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByText(String text);
}
