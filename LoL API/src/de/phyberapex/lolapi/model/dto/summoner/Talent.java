package de.phyberapex.lolapi.model.dto.summoner;

/**
 * This class represents the DTO "TalentDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Talent {

	/**
	 * Talent id.
	 */
	private int id;
	/**
	 * Talent name.
	 */
	private String name;
	/**
	 * Talent rank.
	 */
	private int rank;

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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
