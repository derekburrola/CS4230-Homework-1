package edu.weber.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

public class Contact implements Serializable{

	private String firstName;
	private String lastName;
	private Set<String> phoneNumbers;
	private Address address[] = new Address[2];

	public Contact() {
		this(null,null);
	}

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}

	public void setAddress(Address address, int num) {
		this.address[num] = address;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumbers=" + phoneNumbers
				+ ", address=" + Arrays.toString(address) + "]";
	}
	
	

}
