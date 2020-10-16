package com.example.cocktailapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CocktailService {
    @Autowired
    private CocktailRepository cocktailRepository;

    public List<Cocktail> searchAll() {
        return cocktailRepository.findAll();
    }

    public Cocktail findById(Integer id){
        return cocktailRepository.findById(id).get();
    }
}
