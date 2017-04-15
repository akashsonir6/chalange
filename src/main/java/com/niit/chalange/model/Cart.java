package com.niit.chalange.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Cart 
{
	@SuppressWarnings("unused")
	private static final long SerialVersionUID=1l;
	@Id
	private String CartId;
	private double grandtotal=0.0;
	private int totalItems=0;
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartitem;
	public Cart(){
		this.CartId="CART" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCartId() {
		return CartId;
	}
	public void setCartId(String cartId) {
		CartId = cartId;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	

}
