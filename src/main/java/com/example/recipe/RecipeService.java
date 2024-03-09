package com.example.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecipeService implements RecipeRepository {

    private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
    private static int count = 5;

    public RecipeService() {
        recipeBook.put(1,
                new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipeBook.values());
    }

    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = recipeBook.get(recipeId);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
        return recipe;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        count++;
        recipe.setRecipeId(count);
        recipeBook.put(count, recipe);
        return recipe;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipe) {
        if (!recipeBook.containsKey(recipeId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
        recipe.setRecipeId(recipeId);
        recipeBook.put(recipeId, recipe);
        return recipe;
    }

    @Override
    public void deleteRecipe(int recipeId) {
        if (!recipeBook.containsKey(recipeId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
        recipeBook.remove(recipeId);
    }
}
