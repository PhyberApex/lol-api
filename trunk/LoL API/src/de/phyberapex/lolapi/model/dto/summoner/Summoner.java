package de.phyberapex.lolapi.model.dto.summoner;

/**
 * This class represents the DTO "SummonerDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class Summoner {

	/**
	 * Summoner ID.
	 */
	private long id;
	/**
	 * Summoner name.
	 */
	private String name;
	/**
	 * ID of the summoner icon associated with the summoner.
	 */
	private int profileIconId;
	/**
	 * Date summoner was last modified specified as epoch milliseconds.
	 */
	private long revisionDate;
	/**
	 * Summoner level associated with the summoner.
	 */
	private long summonerLevel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public long getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

}
