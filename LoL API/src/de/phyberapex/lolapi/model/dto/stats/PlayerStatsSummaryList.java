package de.phyberapex.lolapi.model.dto.stats;

import java.util.List;

/**
 * This class represents the DTO "PlayerStatsSummaryListDto" for the
 * lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class PlayerStatsSummaryList {

	/**
	 * Collection of player stats summaries associated with the summoner.
	 */
	private List<PlayerStatsSummary> playerStatsSummaries;
	/**
	 * Summoner ID.
	 */
	private long summonerId;

	public List<PlayerStatsSummary> getPlayerStatsSummaries() {
		return playerStatsSummaries;
	}

	public void setPlayerStatsSummaries(
			List<PlayerStatsSummary> playerStatsSummaries) {
		this.playerStatsSummaries = playerStatsSummaries;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

}
