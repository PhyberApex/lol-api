package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "BlockItemDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class BlockItem {

	private int count;
	private String id;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
