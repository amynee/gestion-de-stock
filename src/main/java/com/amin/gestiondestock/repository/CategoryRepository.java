package com.amin.gestiondestock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCode(String code);

}
