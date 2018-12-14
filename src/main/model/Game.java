package main.model;

public class Game {
	
	private long id;
	private String name;
	private long gamerId;
	private String location;
	private long labelId;
	private String help;

public Game() {
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

public long getGamerId() {
	return gamerId;
}

public void setGamerId(long gamerId) {
	this.gamerId = gamerId;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public long getLabelId() {
	return labelId;
}

public void setLabelId(long labelId) {
	this.labelId = labelId;
}

public String getHelp() {
	return help;
}

public void setHelp(String help) {
	this.help = help;
}

public Game(long id, String name, long gamerId, String location, long labelId, String help) {
	
	this.id = id;
	this.name = name;
	this.gamerId = gamerId;
	this.location = location;
	this.labelId = labelId;
	this.help = help;
}


}
