package com.raghu.dto;

import java.util.List;

import com.raghu.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateOrderRequest {

	private User user;

	private List<OrderItemsRequest> items;
}
