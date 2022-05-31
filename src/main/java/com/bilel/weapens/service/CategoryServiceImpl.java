package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Category;
import com.bilel.weapens.repos.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
	
		return categoryRepository.findAll();
		
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category) ;
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);		
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);		
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).get();
	}

	

	@Override
	public Page<Category> getAllCategorysParPage(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page, size));
	}

}
