package de.phyberapex.lolapi.model.dto.summoner;

import java.util.Set;

/**
 * This class represents the DTO "RunePageDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class RunePage {

	/**
	 * Indicates if the page is the current page.
	 */
	private boolean current;
	/**
	 * Rune page ID.
	 */
	private int id;
	/**
	 * Rune page name.
	 */
	private String name;
	/**
	 * Collection of rune slots associated with the rune page.
	 */
	private Set<RuneSlot> slots;
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
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
	public Set<RuneSlot> getSlots() {
		return slots;
	}
	public void setSlots(Set<RuneSlot> slots) {
		this.slots = slots;
	}

}
