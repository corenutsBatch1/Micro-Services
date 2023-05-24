package com.feuji.userservice.dto;

import java.util.Optional;

import com.feuji.commonmodel.Role;
import com.feuji.commonmodel.User;

public class User2 {

	private Long id;

	private String name;

	private String email;

	private String password;

	private String phoneNumber;

	private String status;

	private Role role;

	private User user;

	public User getUser() {
		return this.user;
	}

	public void setUser(User2 user2) {
	    this.user = new User();
	    Optional.ofNullable(user2.getName()).ifPresent(this.user::setName);
	    Optional.ofNullable(user2.getEmail()).ifPresent(this.user::setEmail);
	    Optional.ofNullable(user2.getPassword()).ifPresent(this.user::setPassword);
	    Optional.ofNullable(user2.getPhoneNumber()).ifPresent(this.user::setPhoneNumber);
	    Optional.ofNullable(user2.getRole()).ifPresent(this.user::setRole);
	    this.user.setStatus("active");
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User2(Long id, String name, String email, String password, String phoneNumber, String status, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.role = role;
	}

	public User2() {
	}
}
