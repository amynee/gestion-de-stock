package com.amin.gestiondestock.services;

import com.amin.gestiondestock.dto.ArticleDto;
import com.amin.gestiondestock.model.Article;

import java.util.List;

public interface ArticleService {
	
	ArticleDto save(ArticleDto dto);
	ArticleDto findById(Integer id);
	ArticleDto findByCode(String codeArticle);
	List<ArticleDto> findAll();
	void delete(Integer id);
	

}
