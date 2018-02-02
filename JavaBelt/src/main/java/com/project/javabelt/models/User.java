package com.project.javabelt.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import com.project.javabelt.models.Subscription;



@Entity
@Table(name="users")
public class User{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	@Size(min=1,max=255, message="First Name must be between 1-255 characters")
	private String firstName;

	@Size(min=1,max=255, message="Last Name must be between 1-255 characters")
	private String lastName;

	@Email(message="Invalid Email Format! Ex:example@example.com")
	private String email;

	private boolean status; 
	@Size(min=8,max=255,message="Password must be between 8-255 characters.")
	private String password;

	@Transient
	@Size(min=8,max=255,message="Password Confirmation must be between 8-255 characters.")	
	private String confirm;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subscription_id")
    private Subscription subscription;
	
	
	private Date dueDate;	
	
	public void setDueDate(Date dueDate) {
		this.dueDate=dueDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setId(long id) {
		this.id = id;
	}
			
	private boolean admin;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
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
	
	// Setters and Getters go here
	public void setEmail(String email){
		this.email=email;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setConfirm(String confirm){
		this.confirm=confirm;
	}
	public void setAdmin(boolean admin){this.admin=admin;}

	public String getEmail(){
		return email;}
	public String getFirstName(){
		return firstName;}
	public String getLastName(){
		return lastName;
	}

	public String getPassword(){
		return password;
	}
	public String getConfirm(){
		return confirm;
	}

	public boolean isAdmin(){
		return admin;
	}
	
	

	
	public void setSubscription(Subscription subscription){
		this.subscription=subscription;
	}
	public Subscription getSubscription(){
		return subscription;
	}

	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
		
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
}