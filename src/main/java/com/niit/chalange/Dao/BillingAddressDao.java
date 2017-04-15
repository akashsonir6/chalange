package com.niit.chalange.Dao;

import java.util.List;


import com.niit.chalange.model.BillingAddress;

public interface BillingAddressDao 
{
	public boolean Saveorupdate(BillingAddress billingAddress);
	public boolean delete(String billin_id);
	public BillingAddress get(String u_id);
	public List <BillingAddress> list();
}
