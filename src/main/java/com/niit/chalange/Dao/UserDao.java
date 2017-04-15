package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.User;


public interface UserDao {
    public User isValidated(String email,String pws);
	public boolean saveorupdate(User user);
	public boolean delete(String id);
	public User getUser(String id);
	public List<User> list();
	public User getUseremail(String email);

}
