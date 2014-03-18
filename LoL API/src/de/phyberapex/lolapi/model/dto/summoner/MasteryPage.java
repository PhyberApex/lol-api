package de.phyberapex.lolapi.model.dto.summoner;

import java.util.List;

/**
 * This class represents the DTO "MasteryPageDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class MasteryPage {

	/**
	 * Indicates if the mastery page is the current mastery page.
	 */
	private boolean current;
	/**
	 * Mastery page ID.
	 */
	private long id;
	/**
	 * Mastery page name.
	 */
	private String name;
	/**
	 * Collection of mastery page talents associated with the mastery page.
	 */
	private List<Talent> talents;
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
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
	public List<Talent> getTalents() {
		return talents;
	}
	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}

}
