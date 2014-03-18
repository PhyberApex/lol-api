package de.phyberapex.lolapi.model.dto.summoner;

import java.util.Set;

/**
 * This class represents the DTO "RunePagesDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class RunePages {
	
	/**
	 * Collection of rune pages associated with the summoner.
	 */
	private Set<RunePage> pages;
	/**
	 * Summoner ID.
	 */
	private long summonerId;
	public Set<RunePage> getPages() {
		return pages;
	}
	public void setPages(Set<RunePage> pages) {
		this.pages = pages;
	}
	public long getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

}
