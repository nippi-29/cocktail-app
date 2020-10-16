package com.example.cocktailapp;


import com.example.cocktailapp.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
}
