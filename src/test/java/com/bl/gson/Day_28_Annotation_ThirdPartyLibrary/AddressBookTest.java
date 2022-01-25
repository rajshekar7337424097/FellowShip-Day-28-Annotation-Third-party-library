package com.bl.gson.Day_28_Annotation_ThirdPartyLibrary;

import org.junit.Test;

import com.bl.gson.addressBook.AddressBook;
import com.bl.gson.addressBook.Contact;

public class AddressBookTest {
	
	@Test
	public void test() {
		Contact[] contactData = {
				new Contact("Rajshekar", "Reddy", "Nandyal", "Andhra pradesh", "9771342097", "500039", "rajshekarreddy@gmail.com"),
				new Contact("Narendhra", "Reddy", "Nandyal", "Andhrapradesh", "8686070553", "500039", "Narendhrareddy@gmail.com")};
		
		AddressBook addressBook = new AddressBook(contactData);
		
		addressBook.readData();
		}
	}


