package com.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.entity.Category;
import com.raghu.service.CategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategoryInfo(category);
	}

	@GetMapping("{catId}")
	public Category fetchCategory(@PathVariable long catId) {

		return categoryService.fetchCategory(catId);
	}

	@PutMapping("{catId}")
	public Category updateCategory(@PathVariable long catId, @RequestBody Category category) {

		return categoryService.updateCategory(catId, category);
	}

	@DeleteMapping
	public void deleteCategory() {

	}

	@GetMapping
	public List<Category> fetchAllCategory() {
		return categoryService.fetchAllCategory();
	}

}
