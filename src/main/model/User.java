package main.model;

public class User {

	private int id;
	private String username;
	private String password;
	private int role;

	public User() {

	}

	public User(int id, String username, String password, int role) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
