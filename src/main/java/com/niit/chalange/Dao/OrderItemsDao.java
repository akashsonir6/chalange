package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.OrderItems;



public interface OrderItemsDao 
{
	public boolean Saveorupdate(OrderItems orderItems);
	public boolean delete(String orderItem_id);
	public OrderItems get(String orderItem_id);
	public List<OrderItems> getOrderItemsbyOrder(String order_id);
	public List <OrderItems> list();

}
