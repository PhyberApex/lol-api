package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "SpellVarsDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class SpellVars {

	private Object coeff;
	private String dyn;
	private String key;
	private String link;

	public Object getCoeff() {
		return coeff;
	}

	public void setCoeff(Object coeff) {
		this.coeff = coeff;
	}

	public String getDyn() {
		return dyn;
	}

	public void setDyn(String dyn) {
		this.dyn = dyn;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
