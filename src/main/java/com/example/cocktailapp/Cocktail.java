package com.example.cocktailapp;


import javax.persistence.*;

@Entity
@Table(name = "cocktail")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String material1;

    private String material2;

    private String recipe;

    private int alc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getMaterial2() {
        return this.material2;
    }

    public void setMaterial2(String material2) {
        this.material2 = material2;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getAlc() {
        return alc;
    }

    public void setAlc(int alc) {
        this.alc = alc;
    }
}
