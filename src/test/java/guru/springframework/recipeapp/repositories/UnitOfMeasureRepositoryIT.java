package guru.springframework.recipeapp.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.recipeapp.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	void setUp() throws Exception {

	}

	@Test
	@DirtiesContext
	void findByDescription() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	@Test
	void findByDescriptionCup() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
