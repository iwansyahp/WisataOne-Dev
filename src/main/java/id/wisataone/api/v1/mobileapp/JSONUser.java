package id.wisataone.api.v1.mobileapp;

import id.wisataone.model.User;

public class JSONUser {
	private User user;
	
	public String getUserName() {
		if (user == null) { return ""; }
		return user.getUserName();
	}
	
	public JSONUser(User user) {
		this.user = user;
	}
}
