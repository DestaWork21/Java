package com.project.DriversLicense.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity

@Table(name="persons")

public class Person {

    @Id

    @GeneratedValue
	// Member variables and annotations go here.
    private Long id;
	@Column
	@Size(min=2, max=255)
    private String firstName;
	@Column
	@Size(min=2,max=255)
    private String lastName;

    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy="person", fetch=FetchType.LAZY)

    private License license;

    public Person() {      

    }
  
    public Person(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = new Date();
        this.updatedAt = new Date();

	}
	// Setters and Getters go here
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId(){return id;}

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


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {

		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}

	@PrePersist
	public void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	public void onUpdate(){
		this.updatedAt = new Date();
	}

}


