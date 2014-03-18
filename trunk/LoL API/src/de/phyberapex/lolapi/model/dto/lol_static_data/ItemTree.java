package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.List;

/**
 * This class represents the DTO "ItemTreeDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class ItemTree {

	private String header;
	private List<String> tags;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
