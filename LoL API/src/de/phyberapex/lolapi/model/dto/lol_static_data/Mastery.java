package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "MasteryDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class Mastery {

	private List<String> description;
	private int id;
	private Image image;
	private String name;
	private String prereq;
	private int ranks;

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public int getRanks() {
		return ranks;
	}

	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

}
