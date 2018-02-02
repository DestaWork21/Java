package com.project.beltreview.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;
import com.project.beltreview.models.Event;



@Entity
@Table(name="users")
public class User{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	@Email(message="Invalid Email Format! Ex:example@example.com")
	private String email;

	@Size(min=1,max=255, message="First Name must be between 1-255 characters")
	private String firstName;

	@Size(min=1,max=255, message="Last Name must be between 1-255 characters")
	private String lastName;

	@Size(min=8,max=255,message="Password must be between 8-255 characters.")
	private String password;
	@Size(min=1, max=255, message="City must be between 1-255 characters.")
	private String city; 
	@Size(min=2, max=3, message="State must be between 2 characters.")
	private String state;
	@Transient
	@Size(min=8,max=255,message="Password Confirmation must be between 8-255 characters.")	
	private String confirm;

	private boolean admin;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="users_events",
		joinColumns= @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Event> events;
	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public void setCity(String city){
		this.city=city;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getCity(){return city;}
	public String getState(){ return state;}

}