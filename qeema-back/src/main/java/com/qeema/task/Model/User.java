package com.qeema.task.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue
	@Column
	private int Id; 
	@Column
	private String Username;
	@Column
	private String password;
	@Column
	private String email;
    @Column(columnDefinition = "boolean default true")
    private boolean active=true;
    @Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    private String roles="ROLE_USER";
    
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}



	public User() {
	}
	
	

	public User(String username, String password, String email) {
		super();
		Username = username;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Registration [Id=" + Id + ", Username=" + Username + ", password=" + password + ", email=" + email
				+ ", active=" + active + ", roles=" + roles + "]";
	}



	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (email ==null)
		return false;
		else 
			return true;
	}

	
	
}
