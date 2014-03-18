package de.phyberapex.lolapi.model.dto.summoner;

/**
 * This class represents the DTO "RuneSlotDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class RuneSlot {

	/**
	 * Rune associated with the rune slot.
	 */
	private Rune rune;
	/**
	 * Rune slot ID.
	 */
	private int runeSlotId;

	public Rune getRune() {
		return rune;
	}

	public void setRune(Rune rune) {
		this.rune = rune;
	}

	public int getRuneSlotId() {
		return runeSlotId;
	}

	public void setRuneSlotId(int runeSlotId) {
		this.runeSlotId = runeSlotId;
	}

}
