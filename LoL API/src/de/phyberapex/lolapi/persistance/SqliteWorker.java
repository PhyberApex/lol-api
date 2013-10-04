package de.phyberapex.lolapi.persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.info.GameMap;
import de.phyberapex.lolapi.info.GameMode;
import de.phyberapex.lolapi.info.MatchStats;
import de.phyberapex.lolapi.info.QueueType;

public class SqliteWorker implements Runnable {

	private Connection connection = DBHelper.getInstance().getConnection();
	private List<SaveConfiguration> configs;
	private int refreshTimer;
	private long lastRun;
	private boolean gathering = false;
	private APIClient client;

	public SqliteWorker(int refreshTimer, APIClient client,
			SaveConfiguration... configs) {
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
				try {
					gatherData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Could not gather data");
					e.printStackTrace();
				}
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
	}

	private void gatherData() throws IOException {
		try {
			for (SaveConfiguration conf : configs) {
				ArrayList<MatchStats> stats = client.getSummonerService()
						.getLastMatchStatsByName(conf.getParameter());
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO matchstats (game_id, summonername, win, ownChampion_id, ownTeamChampion1_id, ownTeamSummoner1, ownTeamChampion2_id, ownTeamSummoner2, ownTeamChampion3_id, ownTeamSummoner3, ownTeamChampion4_id, ownTeamSummoner4, enemyTeamChampion1_id, enemyTeamSummoner1, enemyTeamChampion2_id, enemyTeamSummoner2, enemyTeamChampion3_id, enemyTeamSummoner3, enemyTeamChampion4_id, enemyTeamSummoner4, enemyTeamChampion5_id, enemyTeamSummoner5, summonerSpell1_id, summonerSpell2_id, ping, amountPremades, ipearned, eloChange, createDate, gamemode, item1_id, item2_id, item3_id, item4_id, item5_id, item6_id, goldEarned, championLevel, dmgDealt, magicDmgDealtToChamps, physicalDmgDealtToChamps, trueDmgDealtToChamps, totalDmgDealtToChamps, largestCrit, largestMultikill, largestKillingSpree, crowdControlDealt, ownJungleMinionsKilled, sightWardsBought, visionWardsBought, wardsKilled, wardsPlaced, physicalDmgTaken, magicDmgTaken, trueDmgTaken, totalDmgTaken, totalHeal, timeSpentDead, deaths, kills, assists, minionsKilled, neutralMinionsKilled, turretsKilled, baracksKilled, queueType, gameMapId, leaver) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for (MatchStats s : stats) {
					// TODO check if game is to check
					boolean checkGame = false;
					switch (conf.getData()) {
					case ARAM_CUSTOM:
						break;
					case ARAM_NORMAL:
						checkGame = s.getQueueType() == QueueType.ARAM_UNRANKED_5x5;
						break;
					case DOM_BOTS:
						checkGame = s.getQueueType() == QueueType.BOT
								&& s.getGameMode() == GameMode.ODIN;
						break;
					case DOM_CUSTOM:
						checkGame = s.getQueueType() == QueueType.NONE && s.getMap() == GameMap.CRYSTAL_SCAR;
						break;
					case DOM_NORMAL:
						checkGame = s.getQueueType() == QueueType.NORMAL
								&& s.getGameMode() == GameMode.ODIN;
						break;
					case SR_BOTS:
						checkGame = s.getQueueType() == QueueType.BOT
								&& s.getMap() == GameMap.SUMMONERS_RIFT;
						break;
					case SR_CUSTOM:
						checkGame = s.getQueueType() == QueueType.NONE
								&& s.getMap() == GameMap.SUMMONERS_RIFT;
						break;
					case SR_NORMAL:
						checkGame = s.getQueueType() == QueueType.NORMAL;
						break;
					case SR_RANKED:
						checkGame = s.getQueueType() == QueueType.RANKED_SOLO_5x5
								|| s.getQueueType() == QueueType.RANKED_TEAM_5x5;
						break;
					case TT_BOTS:
						checkGame = s.getQueueType() == QueueType.BOT
								&& s.getMap() == GameMap.TWISTED_TREELINE;
						break;
					case TT_CUSTOM:
						checkGame = s.getQueueType() == QueueType.NONE
								&& s.getMap() == GameMap.TWISTED_TREELINE;
						break;
					case TT_NORMAL:
						checkGame = s.getQueueType() == QueueType.NORMAL_3x3;
						break;
					case TT_RANKED:
						checkGame = s.getQueueType() == QueueType.RANKED_3x3;
						break;
					}

					if (checkGame && !isGameInDB(s.getGameId())) {
						stmt.setLong(1, s.getGameId());
						stmt.setString(2, s.getSummonerName());
						stmt.setBoolean(3, s.isWin());
						stmt.setInt(4, s.getOwnChamp().getId());
						for (int i = 0; i < s.getOwnTeam().length * 2; i++) {
							int index = Math.round(new Long(i) / 2L);
							if (s.getOwnTeam()[index] != null) {
								stmt.setInt(5 + i, s.getOwnTeam()[index]
										.getChampion().getId());
								i++;
								stmt.setString(5 + i,
										s.getOwnTeam()[index].getSummonerName());
							} else {
								stmt.setInt(5 + i, 0);
								i++;
								stmt.setString(5 + i, "");
							}
						}
						for (int i = 0; i < s.getEnemyTeam().length * 2; i++) {
							int index = Math.round(new Long(i) / 2L);
							if (s.getEnemyTeam()[index] != null) {
								stmt.setInt(13 + i, s.getEnemyTeam()[index]
										.getChampion().getId());
								i++;
								stmt.setString(13 + i, s.getEnemyTeam()[index]
										.getSummonerName());
							} else {
								stmt.setInt(13 + i, 0);
								i++;
								stmt.setString(13 + i, "");
							}
						}
						stmt.setInt(23, s.getSpell1().getId());
						stmt.setInt(24, s.getSpell2().getId());
						stmt.setInt(25, s.getPing());
						stmt.setInt(26, s.getAmountPremade());
						stmt.setInt(27, s.getIpEarned());
						stmt.setInt(28, s.getEloChange());
						stmt.setLong(29, s.getCreateDate().getTime());
						stmt.setString(30, s.getGameMode().toString());
						for (int i = 0; i < s.getItems().length; i++) {
							if (s.getItems()[i] != null) {
								stmt.setInt(31 + i, s.getItems()[i].getId());
							} else {
								stmt.setInt(31 + i, 0);
							}
						}
						stmt.setInt(37, s.getGoldEarned());
						stmt.setInt(38, s.getLevel());
						stmt.setInt(39, s.getDmgDealt());
						stmt.setInt(40, s.getMagicDmgDealtToChamps());
						stmt.setInt(41, s.getPhysicalDmgDealtToChamps());
						stmt.setInt(42, s.getTrueDmgToChamps());
						stmt.setInt(43, s.getTotalDmgDealtToChamps());
						stmt.setInt(44, s.getLargestCrit());
						stmt.setInt(45, s.getLargestMultikill());
						stmt.setInt(46, s.getLargestKillingSpree());
						stmt.setInt(47, s.getCrowdControlDealt());
						stmt.setInt(48, s.getOwnJungleMinionsKilled());
						stmt.setInt(49, s.getSightWardsBought());
						stmt.setInt(50, s.getVisionWardsBought());
						stmt.setInt(51, s.getWardsKilled());
						stmt.setInt(52, s.getWardsPlaced());
						stmt.setInt(53, s.getPhysicalDmgTaken());
						stmt.setInt(54, s.getMagicDmgTaken());
						stmt.setInt(55, s.getTrueDmgTaken());
						stmt.setInt(56, s.getTotalDmgTaken());
						stmt.setInt(57, s.getTotalHeal());
						stmt.setInt(58, s.getTimeSpentDead());
						stmt.setInt(59, s.getDeaths());
						stmt.setInt(60, s.getKills());
						stmt.setInt(61, s.getAssists());
						stmt.setInt(62, s.getMinionsKilled());
						stmt.setInt(63, s.getNeutralMinionsKilled());
						stmt.setInt(64, s.getTurretsKilled());
						stmt.setInt(65, s.getBarracksKilled());
						stmt.setString(66, s.getQueueType().name());
						stmt.setInt(67, s.getMap().getId());
						stmt.setBoolean(68, s.isLeaver());
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
