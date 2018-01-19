package com.project.lookify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.PrePersist;

import javax.persistence.PreUpdate;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	@Column
	@Size(min=5,message="Name must be 5 characters minimum.")
	private String name;

	@Column
	@Size(min=5,message="Artist must be 5 characters minimum.")
	private String artist;

	@Column

	@NotNull

	private int rating;
	
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
	public Song(){}

	public Song(String name,String artist,int rating){

		this.name = name;

		this.artist = artist;

		this.rating = rating;

	}

	public void setName(String name){this.name=name;}

	public String getName(){return name;}



	public void setArtist(String artist){this.artist=artist;}

	public String getArtist(){return artist;}

	

	public void setRating(int rating){this.rating=rating;}

	public int getRating(){return rating;}
	
	
}
