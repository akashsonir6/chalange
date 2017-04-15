package com.niit.chalange.model;

public class Password {
	public static void main(String[] args){
		String result= makePassword(6);
		System.out.println(result);
	}

	// generate password
	public static String makePassword(int length){
		String password="";
		for (int i=0; i < length - 2; i++){
			password = password + randomCharacter("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		}
		
		String randomDigit = randomCharacter("6565656");
		password=InsertAtrandom(password, randomDigit);
		String randomSymbol = randomCharacter("6565656");
		password=InsertAtrandom(password, randomSymbol);
		return password;
	}
	//get random char from string
	public static String randomCharacter(String character){
		int n = character.length();
		int r= (int)(n * Math.random());
		return character.substring(r, r + 1);
	}
	//Insert one string into another at a random position
	public static String InsertAtrandom(String str, String toInsert){
		int n= str.length();
		int r=(int)((n + 1) * Math.random());
		return str.substring(0,r) + toInsert +str.substring(r);
		
	}
}
