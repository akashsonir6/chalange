package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Order;

public interface OrderDao 
{
	public boolean Saveorupdate(Order order);
	public boolean delete(String order_id);
	public Order get(String u_id);
	public List <Order> list();
}
