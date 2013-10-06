package de.phyberapex.lolapi.model;

public abstract class Entity {

	private int id;
	private String name;

	public Entity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " Name: " + this.name;
	}
}
