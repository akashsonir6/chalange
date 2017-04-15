package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String orderItem_id;
	@ManyToOne
	@JoinColumn(name = "order_Id")
	private Order order;
	private String product_id;

	public OrderItems() {
		this.orderItem_id = "ORDERITEM" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getOrderItem_id() {
		return orderItem_id;
	}

	public void setOrderItem_id(String orderItem_id) {
		this.orderItem_id = orderItem_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

}
