package com.example.Athos.dto;

public class UserDTO {
	
private int id;
private int role;
private String username;
private String password;
private boolean attivo;

public UserDTO() {}

public UserDTO(int id, int role, String username,String password, boolean attivo) {
	//this();
	this.id = id;
	this.role = role;
	this.username = username;
	this.password=password;
	this.attivo=attivo;
}
public UserDTO(String username, String password) {
	this();
	this.username=username;
	this.password=password;
}

public String getPassword() {
	return password;
}

public boolean isAttivo() {
	return attivo;
}

public void setAttivo(boolean attivo) {
	this.attivo = attivo;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

}
