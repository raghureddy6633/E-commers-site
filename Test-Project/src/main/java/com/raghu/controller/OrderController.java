package com.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.dto.CreateOrderRequest;
import com.raghu.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/orders")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public void createOrder(@RequestBody CreateOrderRequest orderRequest) {
		log.info("create new Order :" + orderRequest);
		orderService.createOrderInfo(orderRequest);

		return;
	}

}
