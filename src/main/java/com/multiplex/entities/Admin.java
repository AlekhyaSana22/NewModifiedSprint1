package com.multiplex.entities;

import java.util.Objects;

import javax.persistence.*;
@Entity
public class Admin {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	public long adminId;
	
	@Column(name="user_name")
	public String userName;
	
	@Column(name="email_Id")
	public String emailId;
	
	@Column(name="password")
	public String password;
	public Admin() {}

	public Admin(long adminId, String userName, String emailId, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}
	
	

	public long getAdminId() {
		return adminId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", emailId=" + emailId + ", password="
				+ password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminId, emailId, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return adminId == other.adminId && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	
	

}
