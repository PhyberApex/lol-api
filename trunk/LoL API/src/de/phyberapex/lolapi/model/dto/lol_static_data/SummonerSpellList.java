package de.phyberapex.lolapi.model.dto.lol_static_data;

import java.util.Map;

/**
 * This class represents the DTO "SummonerSpellListDto" for the lol-static-data
 * API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class SummonerSpellList {

	private Map<String, SummonerSpell> data;
	private String type;
	private String version;

	public Map<String, SummonerSpell> getData() {
		return data;
	}

	public void setData(Map<String, SummonerSpell> data) {
		this.data = data;
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
