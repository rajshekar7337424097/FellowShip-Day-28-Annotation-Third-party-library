package com.bl.gson.addressBook;

import com.google.gson.Gson;

public class ObjToGson {
	public static void main(String[] args) {
		Contact contact = new Contact("Rajashekar", "Reddy", "Hyderabad", "Telengana", "7337424097","rajshekarreddymail.com", "500039");
		
		Gson gson = new Gson();
		String json = gson.toJson(contact);
		System.out.println(json);
	}

}
