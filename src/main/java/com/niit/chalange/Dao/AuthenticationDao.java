package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Authentication;


public interface AuthenticationDao 
{
	public boolean Saveorupdate(Authentication authentication);
	public boolean delete(String role_Id);
	public Authentication get(String role_id);
	public List <Authentication> list();

}
