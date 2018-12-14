package main.model;

public class User {
	
	private long id;
	private String username;
	private String password;
	private long role;
	
public User() {

}

public long getId() {
	return id;
}


public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public long getRole() {
	return role;
}

public void setRole(long role) {
	this.role = role;
}

public User(long id, String username, String password, long role) {
	
	this.id = id;
	this.username = username;
	this.password = password;
	this.role = role;
}

}
