package com.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.entity.Product;
import com.raghu.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		log.info("product :" + product.getCategory().getId());
		return productService.saveProductInfo(product);
	}

	@GetMapping
	public List<Product> fetchAll() {

		return productService.findAllproducts();

	}

	@GetMapping("{productId}")
	public Product fetchProduct(@PathVariable long productId) {
		return productService.fetchProduct(productId);
	}

	@GetMapping("/categoryName/{name}")
	public List<Product> fetchProductOnCategoryName(@PathVariable(name = "name") String categoryName) {
		return productService.findProductOnCategoryName(categoryName);
	}

}
