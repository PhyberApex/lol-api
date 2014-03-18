package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "SkinDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Skin {

	private String id;
	private String name;
	private int num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
