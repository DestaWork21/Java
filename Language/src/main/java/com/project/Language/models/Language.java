package com.project.Language.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Language{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	
	@Size(min=2, max=20,message="language must be between 2-20")
	private String language;

	@Size(min=2, max=20,message="createdby must be between 2-20")
	private String creator;

	@Min(1)
	private int version;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
	
	public Language(){
		
	}
	public Language(String language, String creator, int version){
		this.language = language;
		this.creator = creator;
		this.version=version;
	}

	@PrePersist
	public void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate(){
		this.updatedAt = new Date();
	}
	
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
	public void setLanguage(String language){
		this.language=language;
	}
	public String getLanguage(){
		return language;
	}
	public void setCreator(String creator){
		this.creator=creator;
	}
	public String getCreator(){
		return creator;
	}
	public void setVersion(int version){
		this.version=version;
	}
	public int getVersion(){
		return version;
	}	
	
	
}
