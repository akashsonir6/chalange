package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component

public class CartItem {
	@Id
	private String cartItem_Id;
	@ManyToOne
	@JoinColumn(name="CartId")
	private Cart cart;
	@OneToOne
	@JoinColumn(name="P_id")
	private Product Product;
	
	private float price;
	
	public CartItem(){
		this.cartItem_Id ="cItem" +UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getCartItem_Id() {
		return cartItem_Id;
	}

	public void setCartItem_Id(String cartItem_Id) {
		this.cartItem_Id = cartItem_Id;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	
	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

}
