package main.model;

public class Label {

	private int id;
	private String name;
	private String description;
	private int idGame;

	public Label() {

	}

	public Label(int id, String name, String description, int idGame) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.idGame = idGame;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public int getIdGame() {
		return idGame;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public void setName(String name) {
		this.name = name;
	}

}
