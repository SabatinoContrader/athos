package main.model;

public class Sponsor {

	private long id;
	private long poiID;
	private String name;
	private String description;

	public Sponsor() {

	}

	public Sponsor(long id, long poiID, String name, String description) {

		this.id = id;
		this.poiID = poiID;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPoiID() {
		return poiID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoiID(long poiID) {
		this.poiID = poiID;
	}

}
