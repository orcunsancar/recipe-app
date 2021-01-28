package guru.springframework.recipeapp.services;

import java.util.Set;

import guru.springframework.recipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
	
	Set<UnitOfMeasureCommand> listAllUoms();
}
