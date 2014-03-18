package de.phyberapex.lolapi.model.dto.summoner;

import java.util.Set;

/**
 * This class represents the DTO "MasteryPagesDto" for the lol-static-data API
 * by riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryPages {

	/**
	 * Collection of mastery pages associated with the summoner.
	 */
	private Set<MasteryPage> pages;
	/**
	 * Summoner ID.
	 */
	private long summonerId;
	public Set<MasteryPage> getPages() {
		return pages;
	}
	public void setPages(Set<MasteryPage> pages) {
		this.pages = pages;
	}
	public long getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

}
