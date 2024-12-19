package com.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.dto.AddCartRequest;
import com.raghu.entity.Product;
import com.raghu.entity.ShoppingCart;
import com.raghu.exceptionhandling.ValidationFailException;
import com.raghu.service.ProductService;
import com.raghu.service.ShoppingCartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/carts")
public class ShoppingCartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Long createCart(@RequestParam Long userId) {
		var result = shoppingCartService.createShoppingCart(userId);
		return result.getId();

	}

	@PostMapping("{cartId}/items")
	public void createCartItems(@PathVariable long cartId, @RequestBody AddCartRequest request) {

		log.info("request to load cart items :" + request.getProductId() + " cart id :" + request.getQuantity()
				+ " user details :" + request.getUser().getId() + " jksfjs :" + request);

		if (request.getQuantity() == 0) {
			throw new ValidationFailException("In Valid Quantity");
		}

		ShoppingCart cart = shoppingCartService.getShoppingCart(cartId);

		Product product = productService.fetchProduct(request.getProductId());

		shoppingCartService.createCartItems(cart, product, request);

	}

}
