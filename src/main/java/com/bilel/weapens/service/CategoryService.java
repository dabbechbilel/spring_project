package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Category;

import org.springframework.data.domain.Page;

public interface CategoryService {
	List <Category> findAll();
	Category saveCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Category category);
	void deleteCategoryById(Long id);
	Category getCategory(Long id);
	Page<Category> getAllCategorysParPage(int page, int size);
}
