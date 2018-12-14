package main.model;

/**
 * 
 * @author Radek
 *
 */
public class UserType {
	// colonna userTypeId della tabella user_types
	private Integer userTypeId;
	// colonna typeUser della tabella UserType
	private String typeUser;
	
	 public UserType(Integer userTypeId, String type) {
	        this.userTypeId = userTypeId;
	        this.typeUser = type;
	  }
	 
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
}
