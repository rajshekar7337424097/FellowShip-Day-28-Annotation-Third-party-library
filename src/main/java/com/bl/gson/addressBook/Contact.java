package com.bl.gson.addressBook;

public class Contact {
	private String firstName, lastName, city, state, phoneNumber, zipCode, email;

	public Contact(String firstName, String lastName, String city, String state, String phoneNumber, String zipCode,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.email = email;
	}

	public Contact() {

	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", "
				+ "lastName=" + lastName + ","
				+ " city=" + city + ","
				+ " state=" + state
				+ ", phoneNumber=" + phoneNumber + ", "
				+ "zipCode=" + zipCode + ", "
				+ "email=" + email + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
