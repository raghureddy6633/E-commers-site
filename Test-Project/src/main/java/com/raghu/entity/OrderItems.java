package com.raghu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "product_id",nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(columnDefinition = "order_id", nullable = false)
	@JsonIgnore
	private Order order;

}
