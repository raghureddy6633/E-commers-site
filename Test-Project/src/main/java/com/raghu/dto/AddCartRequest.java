package com.raghu.dto;

import com.raghu.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@NoArgsConstructor
public class AddCartRequest {
	
	private User user;
	private long productId;
	private int quantity;

}
