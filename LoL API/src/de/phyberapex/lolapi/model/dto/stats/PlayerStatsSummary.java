package de.phyberapex.lolapi.model.dto.stats;

/**
 * This class represents the DTO "PlayerStatsSummaryDto" for the lol-static-data
 * API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class PlayerStatsSummary {

	/**
	 * Aggregated stats.
	 */
	private AggregatedStats aggregatedStats;
	/**
	 * Number of losses for this queue type. Returned for ranked queue types
	 * only.
	 */
	private int losses;
	/**
	 * Date stats were last modified specified as epoch milliseconds.
	 */
	private long modifyDate;
	/**
	 * Player stats summary type.
	 */
	private StatsSummaryType playerStatsSummeryType;
	/**
	 * Number of wins for this queue type.
	 */
	private int wins;

	public AggregatedStats getAggregatedStats() {
		return aggregatedStats;
	}

	public void setAggregatedStats(AggregatedStats aggregatedStats) {
		this.aggregatedStats = aggregatedStats;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public long getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public StatsSummaryType getPlayerStatsSummeryType() {
		return playerStatsSummeryType;
	}

	public void setPlayerStatsSummeryType(
			StatsSummaryType playerStatsSummeryType) {
		this.playerStatsSummeryType = playerStatsSummeryType;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

}
