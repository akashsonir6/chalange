//package com.niit.chalange.model;
//
//import java.util.HashMap;
//
//import com.twilio.sdk.TwilioRestClient;
//import com.twilio.sdk.TwilioRestException;
//import com.twilio.sdk.resource.factory.SmsFactory;
//import com.twilio.sdk.resource.instance.Account;
//
//public class HelloTwilio {
//	public static void main (String[] args) throws TwilioRestException{
//		TwilioRestClient client =new TwilioRestClient(System.getenv("TWILIO_ACCOUNT_SID"),System.getenv("TWILIO_AUTH_TOKEN"));
//		
//		Account account = client.getAccount();
//		SmsFactory factory = account.getSmsFactory();
//		HashMap<String, String> message = new HashMap<>();
//		
//		message.put("TO", "+918660717782");
//		message.put("From", "+919148885398");
//		message.put("Body", "Akash");
//		factory.create (message);
//		
//		
//	}
//
//}
