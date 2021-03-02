package com.sysnthesis.springboot.rest.example.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=4, message="Name should have atleast 4 characters")
	private String firstName;
	
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String lastName;
	
	@NotNull
	@NotBlank(message = "Email is mandatory")
	private String  emailAddress;
	
	
	@NotNull
	@NotBlank(message = "Street is mandatory")
	private String street;
	
	@NotNull
	@NotBlank(message = "City is mandatory")
	private String city;
	
	@NotNull
	@NotBlank(message = "State Code is mandatory")
	private String provinceState;
	
	@NotNull
	@NotBlank(message = "Country is mandatory")
	private String country;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Contact(Long id, String firstName, String lastName,
			 String emailAddress,
			 String street,
			 String city,
			 String provinceState,
			 String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.street = street;
		this.city = city;
		this.provinceState = provinceState;
		this.country = country;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceState() {
		return provinceState;
	}

	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
