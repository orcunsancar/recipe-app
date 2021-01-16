package guru.springframework.recipeapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.services.RecipeServiceImpl;

public class IndexControllerTest {

	@Mock
	RecipeServiceImpl recipeService;

	@Mock
	Model model;

	IndexController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		controller = new IndexController(recipeService);
	}

	@Test
	public void getIndexPage() {

		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());

		Recipe recipe = new Recipe();
		recipe.setId(1L);

		recipes.add(recipe);

		when(recipeService.getRecipes()).thenReturn(recipes);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// when
		String viewName = controller.getIndexPage(model);

		// then
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}