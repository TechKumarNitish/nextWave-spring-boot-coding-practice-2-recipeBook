/*
 * 
 * You can use the following import statements
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable int recipeId) {
        recipeService.deleteRecipe(recipeId);
    }
}
