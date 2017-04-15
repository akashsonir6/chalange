package com.niit.chalange.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class BillingAddress 
{
  @Id
  private String billin_id;
  private String houseno;
  private String country;
  private String city;
  private String pincode;
  private String email;
  private String mono;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="u_id")
  private User user;
  
public BillingAddress() {

	this.billin_id ="BILLIN"+UUID.randomUUID().toString().toString().substring(30).toUpperCase();
}
public String getBillin_id() {
	return billin_id;
}
public void setBillin_id(String billin_id) {
	this.billin_id = billin_id;
}
public String getHouseno() {
	return houseno;
}
public void setHouseno(String houseno) {
	this.houseno = houseno;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMono() {
	return mono;
}
public void setMono(String mono) {
	this.mono = mono;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
  
}
