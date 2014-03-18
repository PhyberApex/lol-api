package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "GroupDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Group {

	private String MaxGroupOwnable;
	private String id;

	public String getMaxGroupOwnable() {
		return MaxGroupOwnable;
	}

	public void setMaxGroupOwnable(String maxGroupOwnable) {
		MaxGroupOwnable = maxGroupOwnable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
