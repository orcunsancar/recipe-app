package guru.springframework.recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void testGetRecipes() {

		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository,times(1)).findAll();
	}

}
