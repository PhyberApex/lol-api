package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "MetaDataDto" for the lol-static-data API
 * by riot
 * 
 * @author Janis Walliser
 * 
 */

public class MetaData {

	private boolean isRune;
	private String tier;
	private String type;

	public boolean isRune() {
		return isRune;
	}

	public void setRune(boolean isRune) {
		this.isRune = isRune;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
