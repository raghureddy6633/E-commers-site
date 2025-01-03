package com.raghu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemsRequest {
	private long productId;
	private int quantity;

}
