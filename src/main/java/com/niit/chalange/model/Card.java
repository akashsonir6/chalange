package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Card 
{
	@Id
	private String card_id;
	private String card_number;
	private String card_holdername;
	private String card_expidate;
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	public Card() {
		this.card_id ="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCard_holdername() {
		return card_holdername;
	}
	public void setCard_holdername(String card_holdername) {
		this.card_holdername = card_holdername;
	}
	public String getCard_expidate() {
		return card_expidate;
	}
	public void setCard_expidate(String card_expidate) {
		this.card_expidate = card_expidate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    	
   
}
