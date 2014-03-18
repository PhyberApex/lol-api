package de.phyberapex.lolapi.model.dto.stats;

/**
 * This class represents the DTO "ChampionStatsDto" for the lol-static-data API
 * by riot
 * 
 * @author Janis Walliser
 * 
 */

public class ChampionStats {

	/**
	 * Champion id.
	 */
	private int id;
	/**
	 * Champion name.
	 */
	private String name;
	/**
	 * Aggregated stats associated with the champion.
	 */
	private AggregatedStats stats;

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

	public AggregatedStats getStats() {
		return stats;
	}

	public void setStats(AggregatedStats stats) {
		this.stats = stats;
	}

}
