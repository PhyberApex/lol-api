package de.phyberapex.lolapi.client.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.info.MatchStats;

public class SqliteWorker implements Runnable {

	private Connection connection = DBHelper.getInstance().getConnection();
	private List<SaveConfiguration> configs;
	private int refreshTimer;
	private long lastRun;
	private boolean gathering = false;
	private APIClient client;

	public SqliteWorker(SaveConfiguration[] configs, int refreshTimer,
			APIClient client) {
		this.refreshTimer = refreshTimer;
		this.configs = Arrays.asList(configs);
		this.client = client;
	}

	@Override
	public void run() {
		gathering = true;
		double diffInMinutes = refreshTimer + 1;
		while (this.gathering) {
			if (diffInMinutes > refreshTimer) {
				gatherData();
				lastRun = System.currentTimeMillis();
			} else {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			long currMilis = System.currentTimeMillis();
			diffInMinutes = new Double((currMilis - lastRun)) / 1000 / 60;
		}
		System.out.println("DONE GATHERING!");
	}

	private void gatherData() {
		try {
			for (SaveConfiguration conf : configs) {
				ArrayList<MatchStats> stats = client.getSummonerService()
						.getLastMatchStatsByName(conf.getParameter());
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO matchstats (game_id, summonername, win, ownChampion_id, ownTeamChampion1_id, ownTeamSummoner1, ownTeamChampion2_id, ownTeamSummoner2, ownTeamChampion3_id, ownTeamSummoner3, ownTeamChampion4_id, ownTeamSummoner4, enemyTeamChampion1_id, enemyTeamSummoner1, enemyTeamChampion2_id, enemyTeamSummoner2, enemyTeamChampion3_id, enemyTeamSummoner3, enemyTeamChampion4_id, enemyTeamSummoner4, enemyTeamChampion5_id, enemyTeamSummoner5, summonerSpell1_id, summonerSpell2_id, ping, amountPremades, ipearned, eloChange, createDate, gamemode, item1_id, item2_id, item3_id, item4_id, item5_id, item6_id, goldEarned, championLevel, dmgDealt, magicDmgDealtToChamps, physicalDmgDealtToChamps, trueDmgDealtToChamps, totalDmgDealtToChamps, largestCrit, largestMultikill, largestKillingSpree, crowdControlDealt, ownJungleMinionsKilled, sightWardsBought, visionWardsBought, wardsKilled, wardsPlaced, physicalDmgTaken, magicDmgTaken, trueDmgTaken, totalDmgTaken, totalHeal, timeSpentDead, deaths, kills, assists, minionsKilled, neutralMinionsKilled, turretsKilled, baracksKilled, queueType, gameMapId, leaver) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for (MatchStats s : stats) {
					// TODO check if game is to check
					boolean checkGame = true;
					if (checkGame && !isGameInDB(s.getGameId())) {
						stmt.setLong(1, s.getGameId());
						stmt.setString(2, s.getSummonerName());
						stmt.setBoolean(3, s.isWin());
						stmt.setInt(4, s.getOwnChamp().getId());
						for (int i = 0; i < s.getOwnTeam().length * 2; i++) {
							int index = Math.round(new Long(i)/2L);
							if (s.getOwnTeam()[index] != null) {
								stmt.setInt(5 + i, s.getOwnTeam()[index]
										.getChampion().getId());
								i++;
								stmt.setString(5 + i,
										s.getOwnTeam()[index].getSummonerName());
							} else {
								stmt.setInt(5 + i, 0);
								i++;
							}
						}
						for (int i = 0; i < s.getEnemyTeam().length * 2; i++) {
							int index = Math.round(new Long(i)/2L);
							if (s.getEnemyTeam()[index] != null) {
								stmt.setInt(9 + i, s.getEnemyTeam()[index]
										.getChampion().getId());
								i++;
								stmt.setString(9 + i,
										s.getEnemyTeam()[index].getSummonerName());
							} else {
								stmt.setInt(9 + i, 0);
								i++;
							}
						}
						stmt.setInt(14, s.getSpell1().getId());
						stmt.setInt(15, s.getSpell2().getId());
						stmt.setInt(16, s.getPing());
						stmt.setInt(17, s.getAmountPremade());
						stmt.setInt(18, s.getIpEarned());
						stmt.setInt(19, s.getEloChange());
						stmt.setLong(20, s.getCreateDate().getTime());
						stmt.setString(21, s.getGameMode().toString());
						for (int i = 0; i < s.getItems().length; i++) {
							if (s.getItems()[i] != null) {
								stmt.setInt(22 + i, s.getItems()[i].getId());
							} else {
								stmt.setInt(22 + i, 0);
							}
						}
						stmt.setInt(28, s.getGoldEarned());
						stmt.setInt(29, s.getLevel());
						stmt.setInt(30, s.getDmgDealt());
						stmt.setInt(31, s.getMagicDmgDealtToChamps());
						stmt.setInt(32, s.getPhysicalDmgDealtToChamps());
						stmt.setInt(33, s.getTrueDmgToChamps());
						stmt.setInt(34, s.getTotalDmgDealtToChamps());
						stmt.setInt(35, s.getLargestCrit());
						stmt.setInt(36, s.getLargestMultikill());
						stmt.setInt(37, s.getLargestKillingSpree());
						stmt.setInt(38, s.getCrowdControlDealt());
						stmt.setInt(39, s.getOwnJungleMinionsKilled());
						stmt.setInt(40, s.getSightWardsBought());
						stmt.setInt(41, s.getVisionWardsBought());
						stmt.setInt(42, s.getWardsKilled());
						stmt.setInt(43, s.getWardsPlaced());
						stmt.setInt(44, s.getPhysicalDmgTaken());
						stmt.setInt(45, s.getMagicDmgTaken());
						stmt.setInt(46, s.getTrueDmgTaken());
						stmt.setInt(47, s.getTotalDmgTaken());
						stmt.setInt(48, s.getTotalHeal());
						stmt.setInt(49, s.getTimeSpentDead());
						stmt.setInt(50, s.getDeaths());
						stmt.setInt(51, s.getKills());
						stmt.setInt(52, s.getAssists());
						stmt.setInt(53, s.getMinionsKilled());
						stmt.setInt(54, s.getNeutralMinionsKilled());
						stmt.setInt(55, s.getTurretsKilled());
						stmt.setInt(56, s.getBarracksKilled());
						stmt.setString(57, s.getQueueType().name());
						stmt.setInt(58, s.getMap().getId());
						stmt.setBoolean(59, s.isLeaver());
						stmt.execute();
					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isGameInDB(long gameId) throws SQLException {
		boolean returnValue = false;
		ResultSet rs;
		rs = connection.createStatement().executeQuery(
				"SELECT game_id FROM matchstats WHERE game_id = " + gameId
						+ ";");
		if (rs.next()) {
			returnValue = true;
		}
		return returnValue;
	}

	public void stop() {
		this.gathering = false;
	}

}
