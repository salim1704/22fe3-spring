package com.qa.intro_project.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Entities require a spring-data package to be included, this example includes the `spring-data-jpa` module
// which also transitively includes the `spring-data-jdbc` module and the `hibernate-core` dependency amongst many
// others. Hibernate is the Object Relational Mapper (ORM) provider which will manage converting our objects from Java
// to SQL and vice-versa.

@Entity // JPA annotation marking this as an entity class
@Table(name = "user") // The optional @Table annotation can be used to specify the table name, a schema and other constraints
public class User {

	@Id // Sets this field as the primary key, required otherwise errors due to no pk
	@Column(name = "id") // The optional @Column annotation can be used to specify the name and other constraints
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generate ID values
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 16, message = "Username must have at least 2 characters, but no more than 16")
	private String username;
	
	@NotNull
	@Email
	private String email;
		
	// JPA requires an empty default constructor, it is ok to have it as protected - Hibernate can still access it
	protected User() {
		super();
	}
	
	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public User(int id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
	
}
