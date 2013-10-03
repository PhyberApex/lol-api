package de.phyberapex.lolapi.client.persistence;

import static de.phyberapex.lolapi.base.Constants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private Connection connection;
	private static DBHelper instance;

	private DBHelper() {
		try {
			Class.forName("org.sqlite.JDBC");
			if (connection == null) {

				System.out.println("Creating Connection to Database...");
				connection = DriverManager.getConnection("jdbc:sqlite:"
						+ SQLITE_FILEPATH);
				if (!connection.isClosed())
					System.out.println("...Connection established");
				initDB();
			}
		} catch (Exception e) {
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			e.printStackTrace();
		}
	}

	public static synchronized DBHelper getInstance() {
		if (instance == null) {
			instance = new DBHelper();
		}
		return instance;
	}

	public void initDB() {
		String sql = "CREATE TABLE IF NOT EXISTS matchstats (game_id, summonername, win, ownChampion_id, ownTeamChampion1_id, ownTeamSummoner1, ownTeamChampion2_id, ownTeamSummoner2, ownTeamChampion3_id, ownTeamSummoner3, ownTeamChampion4_id, ownTeamSummoner4, enemyTeamChampion1_id, enemyTeamSummoner1, enemyTeamChampion2_id, enemyTeamSummoner2, enemyTeamChampion3_id, enemyTeamSummoner3, enemyTeamChampion4_id, enemyTeamSummoner4, enemyTeamChampion5_id, enemyTeamSummoner5, summonerSpell1_id, summonerSpell2_id, ping, amountPremades, ipearned, eloChange, createDate, gamemode, item1_id, item2_id, item3_id, item4_id, item5_id, item6_id, goldEarned, championLevel, dmgDealt, magicDmgDealtToChamps, physicalDmgDealtToChamps, trueDmgDealtToChamps, totalDmgDealtToChamps, largestCrit, largestMultikill, largestKillingSpree, crowdControlDealt, ownJungleMinionsKilled, sightWardsBought, visionWardsBought, wardsKilled, wardsPlaced, physicalDmgTaken, magicDmgTaken, trueDmgTaken, totalDmgTaken, totalHeal, timeSpentDead, deaths, kills, assists, minionsKilled, neutralMinionsKilled, turretsKilled, baracksKilled, queueType, gameMapId, leaver);";
		try {
			connection.createStatement().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

}
