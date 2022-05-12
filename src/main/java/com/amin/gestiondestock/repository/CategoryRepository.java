package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
