package de.phyberapex.lolapi.info;

public enum GameMap {

	HOWLING_ABYSS(12, "Howling Abyss"), SUMMONERS_RIFT(1, "Summoners Rift"), CRYSTAL_SCAR(1, "Crystal Scar"), TWISTED_TREELINE(1, "Twisted Treeline");

	private int mapId;
	private String name;

	private GameMap(int id, String name) {
		this.mapId = id;
		this.name = name;
	}

	public int getId() {
		return this.mapId;
	}

	public String getName() {
		return this.name;
	}

	public static GameMap getMapById(int id) {
		GameMap returnValue = SUMMONERS_RIFT;
		for (GameMap m : GameMap.values()) {
			if (m.getId() == id) {
				returnValue = m;
			}
		}
		return returnValue;
	}
}
