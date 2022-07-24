package com.amin.gestiondestock;

import static org.junit.jupiter.api.Assertions.*;

import com.amin.gestiondestock.dto.CategoryDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

	@Autowired
	private CategoryService service;

	@Test
	void shouldSaveCategoryWithSuccess() {
		CategoryDto expectedCategory = CategoryDto.builder()
				.code("Cat test")
				.designation("Designation test")
				.idEntreprise(1)
				.build();

		CategoryDto savedCategory = service.save(expectedCategory);

		assertNotNull(savedCategory);
		assertNotNull(savedCategory.getId());
		assertEquals(expectedCategory.getCode(), savedCategory.getCode());
		assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation());
		assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise());
	}

	@Test
	void shouldUpdateCategoryWithSuccess() {
		CategoryDto expectedCategory = CategoryDto.builder()
				.code("Cat test")
				.designation("Designation test")
				.idEntreprise(1)
				.build();

		CategoryDto savedCategory = service.save(expectedCategory);

		CategoryDto categoryToUpdate = savedCategory;

		categoryToUpdate.setCode("Cat Updated");

		assertNotNull(categoryToUpdate);
		assertNotNull(categoryToUpdate.getId());
		assertEquals(categoryToUpdate.getCode(), savedCategory.getCode());
		assertEquals(categoryToUpdate.getDesignation(), savedCategory.getDesignation());
		assertEquals(categoryToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());
	}

	@Test
	void shouldThrowInvalidEntityException() {
		CategoryDto expectedCategory = CategoryDto.builder().build();

		InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () -> service.save(expectedCategory));
		assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
		assertEquals(1, expectedException.getErrors().size());
		assertEquals("Veuillez renseigner le code de la category", expectedException.getErrors().get(0));
	}

	//@Test
	//void shouldThrowEntityNotFoundException() {
	//	EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, () -> service.findById(50));
	//	assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
	//	assertEquals("Aucun category l'ID = 0 n'été trouvé dans le BDD", expectedException.getMessage());
	//}

	//@Test(expected = EntityNotFoundException.class)
	//public void shouldThrowEntityNotFoundException() {
	//	service.findById(0);
	//}

}
