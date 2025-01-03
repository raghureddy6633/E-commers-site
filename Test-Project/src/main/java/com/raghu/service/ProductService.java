package com.raghu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.entity.Product;
import com.raghu.exceptionhandling.ResourceNotFoundException;
import com.raghu.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProductInfo(Product product) {
		product.setInStock(true);
		return productRepository.save(product);

	}

	public List<Product> findAllproducts() {

		return productRepository.findAll();
	}

	public Product fetchProduct(long productId) {

		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found :" + productId));
	}
	
	public List<Product> findProductOnCategoryName(String name){
		return productRepository.findByCategoryName(name);
	}
	

}
