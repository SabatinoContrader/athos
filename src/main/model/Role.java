package main.model;

public class Role {
	private int id;
	private String description;
	private int code;
	
public Role() {
}

public int getId() {
	return id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}

public Role(int id, String description, int code) {
	
	this.id = id;
	this.description = description;
	this.code = code;
}

}