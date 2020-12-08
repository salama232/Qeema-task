package com.qeema.task.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Login  {
	@Id
	@Column
	@GeneratedValue
	private int Session_Id; 
	@Column
	private String email;
	
	public Login() {
		super();
	}
	
	public int getSession_Id() {
		return Session_Id;
	}
	public void setSession_Id(int session_Id) {
		Session_Id = session_Id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
