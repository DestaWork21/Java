package com.project.beltreview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.project.beltreview.models.User;

@Entity
@Table(name="events")
public class Event{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.
	
    @Size(min=1, max=255, message="Name must be between 1- 255 characters")
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Size(min=1, max=255, message="Name must be between 1- 255 characters")
    private String city;
    @Size(min=1, max=255, message="Name must be between 1- 255 characters")
    private String state;
    
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="users_events",
		joinColumns=@JoinColumn(name="event_id"),
		inverseJoinColumns = @JoinColumn(name= "user_id")
	)
    private List<User> users;
    
    @OneToMany(mappedBy="event", fetch=FetchType.LAZY)
    private List<Message> messages;

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
	
	public Event(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public String getName(){
        return name;
    }
    public Date getDate(){return date;}
    public String getCity(){return city;}
    public String getState(){return state;}

    public void setUsers(List<User> users){
        this.users=users;
    }
    public void setMessages(List<Message> messages){
        this.messages=messages;
    }
    public List<Message> getMessages(){return messages;}
    public List<User> getUsers(){ return users;}
}
