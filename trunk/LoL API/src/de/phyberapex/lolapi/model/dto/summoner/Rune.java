package de.phyberapex.lolapi.model.dto.summoner;

/**
 * This class represents the DTO "RuneDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Rune {

	/**
	 * Rune description.
	 */
	private String description;
	/**
	 * Rune ID.
	 */
	private int id;
	/**
	 * Rune name.
	 */
	private String name;
	/**
	 * Rune tier.
	 */
	private int tier;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

}
