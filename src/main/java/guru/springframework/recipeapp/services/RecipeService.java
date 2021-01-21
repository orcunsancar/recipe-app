package guru.springframework.recipeapp.services;

import java.util.Set;

import guru.springframework.recipeapp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long l);
}
