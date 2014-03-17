package de.phyberapex.lolapi.model.dto.game;

/**
 * This class represents the DTO "PlayerDto" for the game API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Player {

	/**
	 * Champion id associated with player.
	 */
	private int championId;
	/**
	 * Summoner id associated with player.
	 */
	private long summonerId;
	/**
	 * Team id associated with player.
	 */
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
}
