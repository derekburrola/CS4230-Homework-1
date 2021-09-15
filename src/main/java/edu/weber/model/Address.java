package edu.weber.model;

import java.io.Serializable;



public class Address implements Serializable {
	
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String addressType;
	
	public Address() {
		this(null,null,null,null);
	}
	
	public Address(String address1, String city, String state, String zipCode) {
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Address(String address1, String address2, String city, String state, String zipCode) {
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	
	@SuppressWarnings("unused")
	private enum AddressTypes{
		HOME, BUSSINESS
	} 
}
