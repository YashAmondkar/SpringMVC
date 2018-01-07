package com.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDetails {

	@NotEmpty
	@Size(min=1,max=20)
	@Pattern(regexp="^[0-9]+$")
	private String userId;
		
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String firstName;
	
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String lastName;
	
	@NotEmpty
	@Email
	private String emailId;
	
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String city;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNumber;
	
    private String password;
    
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
