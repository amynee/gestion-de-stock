package com.amin.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amin.gestiondestock.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	
}
