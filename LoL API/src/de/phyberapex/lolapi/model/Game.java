package de.phyberapex.lolapi.model;

import java.util.List;

/**
 * This class represents the DTO "GameDto" for the game API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Game {

	/**
	 * Champion ID associated with game.
	 */
	private int championId;
	/**
	 * Date that end game data was recorded, specified as epoch milliseconds.
	 */
	private long createDate;
	/**
	 * Other players associated with the game.
	 */
	private List<Player> fellowPlayers;
	/**
	 * Game ID.
	 */
	private long gameId;
	/**
	 * Game mode.
	 */
	private GameMode gameMode;
	/**
	 * Game type.
	 */
	private GameType gameType;
	/**
	 * Invalid flag.
	 */
	private boolean invalid;
	/**
	 * Level.
	 */
	private int level;
	/**
	 * Map ID.
	 */
	private int mapId;
	/**
	 * ID of first summoner spell.
	 */
	private int spell1;
	/**
	 * ID of second summoner spell.
	 */
	private int spell2;
	/**
	 * Statistics associated with the game for this summoner.
	 */
	private RawStats stats;
	/**
	 * Game sub-type.
	 */
	private SubType subType;
	/**
	 * Team ID associated with game. Team ID 100 is blue team. Team ID 200 is
	 * purple team.
	 */
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public List<Player> getFellowPlayers() {
		return fellowPlayers;
	}

	public void setFellowPlayers(List<Player> fellowPlayers) {
		this.fellowPlayers = fellowPlayers;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public boolean isInvalid() {
		return invalid;
	}

	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getSpell1() {
		return spell1;
	}

	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}

	public int getSpell2() {
		return spell2;
	}

	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}

	public RawStats getStats() {
		return stats;
	}

	public void setStats(RawStats stats) {
		this.stats = stats;
	}

	public SubType getSubType() {
		return subType;
	}

	public void setSubType(SubType subType) {
		this.subType = subType;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
}
