package main.model;

public class Role {
	private int id;
	private String description;
	private int code;

	public Role() {
	}

	public Role(int id, String description, int code) {

		this.id = id;
		this.description = description;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.code = code;
	}

}