package de.phyberapex.lolapi.model;

/**
 * This class represents the DTO "ChampionDto" for the champion API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Champion {

	/**
	 * Indicates if the champion is active.
	 */
	private boolean active;
	/**
	 * Champion attack rank.
	 */
	private int attackRank;
	/**
	 * Bot enabled flag (for custom games).
	 */
	private boolean botEnabled;
	/**
	 * Bot Match Made enabled flag (for Co-op vs. AI games).
	 */
	private boolean botMmEnabled;
	/**
	 * Champion defense rank.
	 */
	private int defenseRank;
	/**
	 * Champion difficulty rank.
	 */
	private int difficultyRank;
	/**
	 * Indicates if the champion is free to play. Free to play champions are
	 * rotated periodically.
	 */
	private boolean freeToPlay;
	/**
	 * Champion ID.
	 */
	private long id;
	/**
	 * Champion magic rank.
	 */
	private int magicRank;
	/**
	 * Champion name.
	 */
	private String name;
	/**
	 * Ranked play enabled flag.
	 */
	private boolean rankedPlayEnabled;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAttackRank() {
		return attackRank;
	}

	public void setAttackRank(int attackRank) {
		this.attackRank = attackRank;
	}

	public boolean isBotEnabled() {
		return botEnabled;
	}

	public void setBotEnabled(boolean botEnabled) {
		this.botEnabled = botEnabled;
	}

	public boolean isBotMmEnabled() {
		return botMmEnabled;
	}

	public void setBotMmEnabled(boolean botMmEnabled) {
		this.botMmEnabled = botMmEnabled;
	}

	public int getDefenseRank() {
		return defenseRank;
	}

	public void setDefenseRank(int defenseRank) {
		this.defenseRank = defenseRank;
	}

	public int getDifficultyRank() {
		return difficultyRank;
	}

	public void setDifficultyRank(int difficultyRank) {
		this.difficultyRank = difficultyRank;
	}

	public boolean isFreeToPlay() {
		return freeToPlay;
	}

	public void setFreeToPlay(boolean freeToPlay) {
		this.freeToPlay = freeToPlay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMagicRank() {
		return magicRank;
	}

	public void setMagicRank(int magicRank) {
		this.magicRank = magicRank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}

	public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
		this.rankedPlayEnabled = rankedPlayEnabled;
	}

}
