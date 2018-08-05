package id.wisataone.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {
	@Id
	private Long id;
	
	public Long getId() {
		return id;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Index
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@SuppressWarnings("unused")
	private User() {}
	
	public User(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

}
