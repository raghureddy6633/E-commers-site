package com.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.dto.AddCartRequest;
import com.raghu.entity.CartItems;
import com.raghu.entity.Product;
import com.raghu.entity.ShoppingCart;
import com.raghu.entity.User;
import com.raghu.exceptionhandling.ResourceNotFoundException;
import com.raghu.repository.ShoppingCartRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart createShoppingCart(Long userId) {
		ShoppingCart cart = new ShoppingCart();
		User user = new User();
		user.setId(userId);
		cart.setUser(user);
		return shoppingCartRepository.save(cart);
	}

//	public ShoppingCart createCartItems(long cartId, AddCartRequest request) {
//		
//		
//		cartRepository.findById(cartId)
//		
//		// verify shopping cart id
//		// verify product id 
//		// verify user 
//		return null;
//	}

	public ShoppingCart getShoppingCart(long cartId) {

		return shoppingCartRepository.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("Shopping Cart Not Found With Id :" + cartId));

	}

	public void createCartItems(ShoppingCart cart, Product product, AddCartRequest request) {

		CartItems items = cartItemsInCart(cart, product);

		if (items != null) {
			items.setQuantity(items.getQuantity() + request.getQuantity());
		} else {
			items = createNewCartItems(cart, product, request);
			//log.info("items :" + items.toString());
			cart.getCartItems().add(items);
		}
		ShoppingCart shoppingCart = shoppingCartRepository.save(cart);
		log.info("shopping cart items saved successfull :" + shoppingCart.getCartItems().toString());

	}

	private CartItems createNewCartItems(ShoppingCart cart, Product product, AddCartRequest request) {

		CartItems items = new CartItems();
		items.setProduct(product);
		items.setQuantity(request.getQuantity());
		items.setShoppingCart(cart);

		items.setUser(request.getUser());

		return items;
	}

	private CartItems cartItemsInCart(ShoppingCart cart, Product product) {
		//try {
			return cart.getCartItems().stream().filter(item -> item.getProduct().equals(product)).findFirst()
					.orElse(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}

	}

}
