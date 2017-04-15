package com.niit.chalange.Dao;

import java.util.List;

import com.niit.chalange.model.Card;

public interface CardDao {
	public boolean Saveorupdate(Card  card);
	public boolean delete(String card_id);
	public List<Card> getcardbyuser(String u_id);
	public List <Card> list();

}
