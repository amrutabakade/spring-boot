package com.example.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@Min(value=0, message="must be greater than 0")
	@Max(value=10, message="must be less than 10")
	private int freePasses;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the freePasses
	 */
	public int getFreePasses() {
		return freePasses;
	}
	/**
	 * @param freePasses the freePasses to set
	 */
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
}
