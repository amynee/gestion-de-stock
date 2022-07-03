package com.amin.gestiondestock.services.impl;

import com.amin.gestiondestock.dto.CategoryDto;
import com.amin.gestiondestock.exception.EntityNotFoundException;
import com.amin.gestiondestock.exception.ErrorCodes;
import com.amin.gestiondestock.exception.InvalidEntityException;
import com.amin.gestiondestock.model.Category;
import com.amin.gestiondestock.repository.ArticleRepository;
import com.amin.gestiondestock.repository.CategoryRepository;
import com.amin.gestiondestock.services.CategoryService;
import com.amin.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Category is not valid{}", dto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(dto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun category avec l'ID = " + id + " n'été trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public CategoryDto findByCode(String code) {

        if (!StringUtils.hasLength(code)) {
            log.error("Category CODE is null");
        }

        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                    "Aucun category avec le CODE = " + code + " n'été trouvé dans le BDD",
                    ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        categoryRepository.deleteById(id);
    }
}
