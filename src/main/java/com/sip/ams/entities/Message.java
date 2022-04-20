package com.sip.ams.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "email cant be empty")
    @Column(name = "email")
    private String email;
    
    @NotBlank(message = "titre is mandatory")
    @Column(name = "titre")
    private String titre;
    
    @NotBlank(message = "description is mandatory")
    @Column(name = "description")
    private String description;
    
    @Column(name = "dateTime")
    private Date DateTime;

    public Message() {}
    
    
	public Message(long id, String name,
			 String email,
			String titre,
			 String description, Date DateTime ) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.titre = titre;
		this.description = description;
		this.DateTime = DateTime;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDateTime() {
		return DateTime;
	}


	public void setDateTime(Date DateTime) {
		this.DateTime = DateTime;
	}
    
}
