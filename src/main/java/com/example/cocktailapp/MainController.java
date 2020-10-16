package com.example.cocktailapp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private CocktailService cocktailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Cocktail> cocktails = (List) cocktailService.searchAll();
        model.addAttribute("cocktails", cocktails);
        return "index";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Integer id, Model model) {
        Cocktail cocktail = cocktailService.findById(id);
        model.addAttribute("cocktailRequest",cocktail);
        return "view";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(Model model, Form form) {
        return "form";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(
            Model model, @ModelAttribute("form") Form form
    ){
        model.addAttribute("name", form.getName());
        model.addAttribute("material1", form.getMaterial1());
        model.addAttribute("material2", form.getMaterial2());
        model.addAttribute("recipe", form.getRecipe());
        model.addAttribute("alc", form.getAlc());

        Cocktail n = new Cocktail();
        n.setName(form.getName());
        n.setMaterial1(form.getMaterial1());
        n.setMaterial2(form.getMaterial2());
        n.setRecipe(form.getRecipe());
        n.setAlc(form.getAlc());
        cocktailRepository.save(n);

        return "forms";
    }
}
