package main.model;

public class Track {
	
	private long id;
	private String name;
	private long startPoiId;
	private long endPoiId;
	
public Track() {
	
}

public long getId() {
	return id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getStartPoiId() {
	return startPoiId;
}

public void setStartPoiId(long startPoiId) {
	this.startPoiId = startPoiId;
}

public long getEndPoiId() {
	return endPoiId;
}

public void setEndPoiId(long endPoiId) {
	this.endPoiId = endPoiId;
}

public Track(long id, String name, long startPoiId, long endPoiId) {
	
	this.id = id;
	this.name = name;
	this.startPoiId = startPoiId;
	this.endPoiId = endPoiId;
}

}
