package com.virtualpairprogrammers.model;

public class Track {

	private int id;
	private String name;
	private int startPoiId;
	private int endPoiId;

	public Track() {

	}

	public Track(int id, String name, int startPoiId, int endPoiId) {

		this.id = id;
		this.name = name;
		this.startPoiId = startPoiId;
		this.endPoiId = endPoiId;
	}

	public int getEndPoiId() {
		return endPoiId;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getStartPoiId() {
		return startPoiId;
	}

	public void setEndPoiId(int endPoiId) {
		this.endPoiId = endPoiId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartPoiId(int startPoiId) {
		this.startPoiId = startPoiId;
	}

}
