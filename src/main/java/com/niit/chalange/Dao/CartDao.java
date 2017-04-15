package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Cart;


public interface CartDao 
{
	public boolean Save(Cart cart);
	public boolean delete(String CartId);
	public Cart get(String CartId);
	public List <Cart> list();

}
