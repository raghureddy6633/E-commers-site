package com.raghu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.entity.Category;
import com.raghu.exceptionhandling.ResourceNotFoundException;
import com.raghu.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category createCategoryInfo(Category category) {
		log.info("category info :" + category.getName());
		return categoryRepository.save(category);
	}

	public Category fetchCategory(long catId) {

		return categoryRepository.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found With id :" + catId));

	}

	public List<Category> fetchAllCategory() {

		return categoryRepository.findAll();
	}

	public Category updateCategory(long catId, Category category) {
		return categoryRepository.findById(catId).map(cate -> {
			cate.setName(category.getName());
			return categoryRepository.save(cate);

		}).orElseThrow(() -> new ResourceNotFoundException("Category Not Found With Id :" + catId));

	}

}
