package de.phyberapex.lolapi.model.dto.stats;

import java.util.List;

/**
 * This class represents the DTO "RankedStatsDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class RankedStats {

	/**
	 * Collection of aggregated stats summarized by champion.
	 */
	private List<ChampionStats> champions;
	/**
	 * Date stats were last modified specified as epoch milliseconds.
	 */
	private long modifyDate;
	/**
	 * Summoner ID.
	 */
	private long summonerId;

	public List<ChampionStats> getChampions() {
		return champions;
	}

	public void setChampions(List<ChampionStats> champions) {
		this.champions = champions;
	}

	public long getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

}
