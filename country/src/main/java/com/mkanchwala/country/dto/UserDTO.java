package com.mkanchwala.country.dto;

import java.util.Date;

import com.mkanchwala.country.beans.Language;

/**
 * @author vtupe
 * date 12:55:32 PM Dec 2, 2016
 */

public class UserDTO {
	
	private String username;
	private String password;
	private String email;
	private String phoneNumber;

	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
