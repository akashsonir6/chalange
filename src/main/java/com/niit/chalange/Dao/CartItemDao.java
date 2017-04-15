package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.CartItem;



public interface CartItemDao 
{
	public boolean Save(CartItem CartItem);
	public boolean delete(String cartItem_Id);
	public CartItem get(String cartItem_Id);
	public List<CartItem> getlist(String   CartId);
	public CartItem getlistall(String   CartId,String pro);
	public List<CartItem> getlistbyproId(String  p_id);
	public List <CartItem> list();

}
