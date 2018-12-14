package main.model;

public class Sponsor {
	
	private long id;
	private long poiID;
	private String name;
	private String description;
	
public Sponsor() {

}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id=id;
}

public long getPoiID() {
	return poiID;
}

public void setPoiID(long poiID) {
	this.poiID = poiID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Sponsor(long id, long poiID, String name, String description) {

	this.id = id;
	this.poiID = poiID;
	this.name = name;
	this.description = description;
}


}
