package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.Map;

/**
 * This class represents the DTO "MasteryListDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryList {

	private Map<String, Mastery> data;
	private MasteryTree tree;
	private String type;
	private String version;

	public Map<String, Mastery> getData() {
		return data;
	}

	public void setData(Map<String, Mastery> data) {
		this.data = data;
	}

	public MasteryTree getTree() {
		return tree;
	}

	public void setTree(MasteryTree tree) {
		this.tree = tree;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
