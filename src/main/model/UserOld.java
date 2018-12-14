package main.model;

public class UserOld {

	private String username;
	private String password;
	private Integer userTypeFK;

	public UserOld() {
	}

	public UserOld(String username, String password, Integer userTypeFK) {
		this.username = username;
		this.password = password;
		this.userTypeFK = userTypeFK;
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

	public Integer getUserTypeFK() {
		return userTypeFK;
	}

	public void setUserTypeFK(Integer userTypeFK) {
		this.userTypeFK = userTypeFK;
	}

}