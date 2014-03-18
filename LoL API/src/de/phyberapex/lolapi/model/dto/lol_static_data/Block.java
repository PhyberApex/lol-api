package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "BlockDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Block {

	private List<BlockItem> items;
	private String type;

	public List<BlockItem> getItems() {
		return items;
	}

	public void setItems(List<BlockItem> items) {
		this.items = items;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
