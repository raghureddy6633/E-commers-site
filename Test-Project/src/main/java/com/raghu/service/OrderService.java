package com.raghu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.dto.CreateOrderRequest;
import com.raghu.dto.OrderItemsRequest;
import com.raghu.entity.Order;
import com.raghu.entity.OrderItems;
import com.raghu.entity.OrderStatus;
import com.raghu.exceptionhandling.ResourceNotFoundException;
import com.raghu.exceptionhandling.ValidationFailException;
import com.raghu.repository.OrderRepository;
import com.raghu.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	public void createOrderInfo(CreateOrderRequest orderRequest) {

		if (orderRequest.getItems() == null || orderRequest.getItems().isEmpty()) {
			throw new ValidationFailException("order should contain atleast one item ");
		}
		double price = calicatePrice(orderRequest.getItems());

		Order order = frameOrderObj(orderRequest, price);

		var resp = orderRepository.save(order);
		log.info("response :" + resp.getId());
	}

	private Order frameOrderObj(CreateOrderRequest orderRequest, double price) {
		Order order = new Order();
		order.setDateTime(LocalDateTime.now());
		order.setUser(orderRequest.getUser());
		order.setPrice(price);
		order.setStatus(OrderStatus.CREATED);
		order.setOrderItems(OrderItemsObjectFrame(orderRequest.getItems(), order));
		return order;

	}

	private List<OrderItems> OrderItemsObjectFrame(List<OrderItemsRequest> items, Order order) {
		return items.stream().map(item -> {
			OrderItems orderItems = new OrderItems();
			orderItems.setQuantity(item.getQuantity());
			orderItems.setOrder(order);
			orderItems.setProduct(productRepository.findById(item.getProductId()).orElse(null));
			return orderItems;

		}).collect(Collectors.toList());
		// return null;
	}

	private double calicatePrice(List<OrderItemsRequest> items) {
		return items.stream().mapToDouble(item -> item.getQuantity() * getProductPrice(item.getProductId())).sum();

	}

	private double getProductPrice(long productId) {
		var product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found With Product Id :" + productId));
		return product != null ? product.getPrice() : 0.0;
	}

}
