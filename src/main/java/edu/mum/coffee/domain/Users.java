package edu.mum.coffee.domain;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Users {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName; 
	private String userName;
	private String password;
	private Role role;
	 

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}
	
	public Users() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Users(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
