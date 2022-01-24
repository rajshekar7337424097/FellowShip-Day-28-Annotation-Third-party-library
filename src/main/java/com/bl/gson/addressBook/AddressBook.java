package com.bl.gson.addressBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
	
	private static String CONTACT_FILE_PATH = "addressBook.txt";
	static List<Contact> addressBook;
	
	public AddressBook(Contact[] contactData) {
		addressBook = Arrays.asList(contactData);
		boolean isExit = false;
		
		System.out.println("Welcome to addressBook system");
		
		Scanner scanner = new Scanner(System.in);
		while(!isExit) {
			System.out.println("Select the option from below");
			
			if (addressBook.isEmpty()) {
				System.out.println("1.Add contact\n" + "2.show contact\n7.Exit");
			} else {
				System.out.println("1. Add contact" + "\n2. Display contact\n3. Edit contact\n4. Delete contact\n 5.search\n6.Number of Contacts \n7.Exit");
			}
			
			String option = scanner.next();
			
			switch(option) {
			case "1":
				addContact(scanner);
				break;
			case "2":
				showContact();
				break;
			case "3":
				editContact(scanner);
				break;
			case "4":
				deleteContact(scanner);
				break;
			case "5":
				searchCity(scanner);
				break;
			case "6":
				if (!addressBook.isEmpty()) {
					numOfContacts(scanner);
				} else {
					System.out.println("No contacts");
				}
				break;
			case "7":
				isExit = true;
				if (!addressBook.isEmpty()) {
					sortedAddressBook();
					System.out.println("Sorted by city");
					sortedAddressBookwithCity();
					
				} else {
					System.out.println("No more Contacts. please add Contact to addressBook");
				}
				break;
				
			default:
					System.out.println("Invalid option choosed.");
					break;
			}
		}
		scanner.close();
	}

	private void sortedAddressBookwithCity() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getCity);
		addressBook.stream().sorted(nameComparator).forEach(System.out::println);
	}

	private void sortedAddressBook() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getFirstName);
		addressBook.stream().sorted(nameComparator).forEach(System.out::println);
	}

	private void numOfContacts(Scanner scanner) {
		System.out.println("Number of contacts by using State");
		String state = scanner.nextLine();
		
		long count = addressBook.stream().filter(contacts -> contacts.getState().equalsIgnoreCase(state)).count();
		System.out.println("Number of Contacts :" + count);
	}

	private void searchCity(Scanner scanner) {
		System.out.println("Search the name by using city :");
		String city = scanner.nextLine();
		
		addressBook.stream().filter(contacts -> contacts.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
		;
	}

	private void addContact(Scanner scanner) {
		Contact contact = new Contact();
		boolean exist = false;
		
		System.out.println("Enter first Name :");
		String firstName = scanner.nextLine();
		contact.setFirstName(validateFirstName(firstName, scanner));
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstName())) {
				System.out.println("Name is already exist");
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("Enter last Name :");
			String lastName = scanner.nextLine();
			contact.setLastName(validateLastName(lastName, scanner));
			
			System.out.println("Enter city:");
			String city = scanner.nextLine();
			contact.setCity(validateCity(city, scanner));
			
			System.out.println("Enter state :");
			String state = scanner.nextLine();
			contact.setState(validateState(state, scanner));
			
			System.out.println("Enter Zip code :");
			String zip = scanner.nextLine();
			contact.setEmail(validateZipcode(zip, scanner));
			
			System.out.println("Enter EmailId :");
			String email = scanner.nextLine();
			contact.setEmail(validateEmail(email, scanner));
			
			System.out.println("Enter phoneNumber :");
			String phone = scanner.nextLine();
			contact.setPhoneNumber(validatePhone(phone, scanner));
			
			addressBook.add(contact);
			System.out.println("contact has been saved.");
		} else {
			System.out.println("Contact Name is already exist. please try again");
		}
	}

	private String validateFirstName(String firstName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(firstName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid first name, please try again");
			firstName = scanner.nextLine();
			inputMatcher = regex.matcher(firstName);
		}
		return firstName;
	}

	private String validateLastName(String lastName, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(lastName);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Last name, please try again");
			lastName = scanner.nextLine();
			inputMatcher = regex.matcher(lastName);
		}
		return lastName;
	}

	private String validateCity(String city, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(city);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid city, please try again");
			city = scanner.nextLine();
			inputMatcher = regex.matcher(city);
		}
		return city;
	}

	private String validateState(String state, Scanner scanner) {
		String resultPattern = "^[A-Z]{1}[a-z]{2,}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(state);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid State, please try again");
			state = scanner.nextLine();
			inputMatcher = regex.matcher(state);
		}
		return state;
	}

	private String validateZipcode(String zip, Scanner scanner) {
		String resultPattern = "^[0-9]{0,6}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(zip);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Zip code, please try again");
			zip = scanner.nextLine();
			inputMatcher = regex.matcher(zip);
		}
		return zip;
	}

	private String validateEmail(String email, Scanner scanner) {
		String resultPattern = "^[a-z.]{2,30}@{1}[a-z]{3,10}.[a-z]{3}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(email);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Email, please try again");
			email = scanner.nextLine();
			inputMatcher = regex.matcher(email);
		}
		return email;
	}

	private String validatePhone(String phone, Scanner scanner) {
		String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(phone);

		while (!inputMatcher.matches()) {
			System.out.println("Error: Invalid Phone number, please try again");
			phone = scanner.nextLine();
			inputMatcher = regex.matcher(phone);
		}
		return phone;
	}

	private void showContact() {
		if (addressBook.isEmpty()) {
			System.out.println("Addressbook is empty.");
		} else {
				for (Contact contact : addressBook) {
					System.out.println(contact);
				}
		}
		
	}

	private void editContact(Scanner scanner) {
		System.out.println("Which contact you want to edit? (enter the first name");
		String firstName = scanner.nextLine();
		
		Contact editContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstName())) {
				editContact = addressBook.get(i);
			}
		}
		if(editContact == null) {
			System.out.println("No Contact found with name" + firstName + ".");
		}else {
			editContactDetails(editContact, scanner);
		}
		
	}

	private void editContactDetails(Contact editContact, Scanner scanner) {
		System.out.println("Enter First Name:");
		String firstName = scanner.nextLine();
		editContact.setFirstName(validateFirstName(firstName, scanner));
		
		System.out.println("Enter Last Name :");
		String lastName = scanner.nextLine();
		editContact.setLastName(validateLastName(lastName, scanner));
		
		System.out.println("Enter city:");
		String city = scanner.nextLine();
		editContact.setCity(validateCity(city, scanner));
		
		System.out.println("Enter State :");
		String state = scanner.nextLine();
		editContact.setState(validateState(state, scanner));
		
		System.out.println("Enter zip code");
		String zip = scanner.nextLine();
		editContact.setZipCode(validateZipcode(zip, scanner));
		
		System.out.println("Enter phone number:");
		String phone = scanner.nextLine();
		editContact.setPhoneNumber(validatePhone(phone, scanner));
		
		System.out.println("Enter Email:");
		String email = scanner.nextLine();
		editContact.setEmail(validateEmail(email, scanner));
		
		System.out.println("Contact has been edited.");
	}

	private void deleteContact(Scanner scanner) {
		System.out.println("Which contact you want to delete?(Enter the first name)");
		String firstName = scanner.nextLine();
		
		Contact deleteContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstName())) {
				deleteContact = addressBook.remove(i);
			}
		}
		if (deleteContact == null) {
			System.out.println("No Contact found with name" +firstName);
		} else {
			System.out.println(deleteContact.getFirstName()+"contact has been removed from your addressBook.");
		}
	}
	
	public void writeData() {
		StringBuffer buffer = new StringBuffer();
		addressBook.forEach(cont -> buffer.append(cont + "\n"));
		try {
			System.out.println("data is written into file is completed");
			Files.write(Paths.get(CONTACT_FILE_PATH), buffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readData() {
		try {
			Files.lines(Paths.get(CONTACT_FILE_PATH)).map(line -> line.trim()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
