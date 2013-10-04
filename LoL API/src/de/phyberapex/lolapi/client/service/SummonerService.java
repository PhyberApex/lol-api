package de.phyberapex.lolapi.client.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gvaneyck.rtmp.encoding.TypedObject;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.info.GameMap;
import de.phyberapex.lolapi.info.GameMode;
import de.phyberapex.lolapi.info.MatchStats;
import de.phyberapex.lolapi.info.QueueType;
import de.phyberapex.lolapi.info.SummonerInfo;
import de.phyberapex.lolapi.model.FellowPlayer;

public class SummonerService extends APIService {

	public SummonerService(APIClient client) {
		super(client);
	}

	public String getSummonerNameBySummonerId(int summonerId) {
		String returnValue = null;
		try {
			int id = client.invoke("summonerService", "getSummonerNames",
					new Object[] { new Object[] { summonerId } });
			TypedObject result = client.getResult(id);
			TypedObject resultData = result.getTO("data").getTO("body");
			returnValue = resultData.getArray("array")[0].toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public HashMap<Integer, String> getSummonerNameBySummonerId(
			Integer... summonerIds) throws IOException {
		if (!client.isConnected()) {
			throw new IOException(
					"Client not connected. This method needs a connected client.");
		}
		HashMap<Integer, String> returnValue = new HashMap<>();
		try {
			int id = client.invoke("summonerService", "getSummonerNames",
					new Object[] { summonerIds });
			TypedObject result = client.getResult(id);
			TypedObject resultData = result.getTO("data").getTO("body");
			for (int i = 0; i < summonerIds.length; i++) {
				returnValue.put(summonerIds[i],
						resultData.getArray("array")[i].toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public SummonerInfo getSummonerInfoByName(String name) throws IOException {
		if (!client.isConnected()) {
			throw new IOException(
					"Client not connected. This method needs a connected client.");
		}
		SummonerInfo returnValue = null;
		int id = client.invoke("summonerService", "getSummonerByName",
				new Object[] { name });
		TypedObject result = client.getResult(id);
		TypedObject resultData = result.getTO("data").getTO("body");
		returnValue = new SummonerInfo(resultData.getInt("summonerLevel"),
				resultData.getInt("acctId"), resultData.getInt("summonerId"),
				resultData.getString("name"));
		return returnValue;
	}

	public ArrayList<MatchStats> getLastMatchStatsByName(String name)
			throws IOException {
		if (!client.isConnected()) {
			throw new IOException(
					"Client not connected. This method needs a connected client.");
		}
		ArrayList<MatchStats> returnValue = new ArrayList<>();
		int id = client.invoke("playerStatsService", "getRecentGames",
				new Object[] { getSummonerInfoByName(name).getAccountId() });
		TypedObject result = client.getResult(id);
		TypedObject toMatchStats = result.getTO("data").getTO("body")
				.getTO("gameStatistics");
		System.out.println(result);
		for (Object o : toMatchStats.getArray("array")) {
			MatchStats stats = parseMatchStats(o);
			stats.setSummonerName(name);
			returnValue.add(stats);
		}
		return returnValue;
	}

	private MatchStats parseMatchStats(Object o) throws IOException {
		MatchStats stats = new MatchStats();
		TypedObject toStats = (TypedObject) o;
		stats.setGameId(toStats.getLong("gameId"));
		stats.setOwnChamp(client.getChampionService().getChampionById(
				toStats.getInt("championId")));
		stats.setPing(toStats.getInt("userServerPing"));
		stats.setGameMode(GameMode.valueOf(toStats.getString("gameMode")));
		stats.setEloChange(toStats.getInt("eloChange"));
		stats.setIpEarned(toStats.getInt("ipEarned"));
		stats.setAmountPremade(toStats.getInt("premadeSize"));
		stats.setCreateDate(toStats.getDate("createDate"));
		stats.setSpell1(client.getSummonerSpellService().getSpellById(
				toStats.getInt("spell1")));
		stats.setSpell2(client.getSummonerSpellService().getSpellById(
				toStats.getInt("spell2")));
		stats.setQueueType(QueueType.valueOf(toStats.getString("queueType")));
		stats.setMap(GameMap.getMapById(toStats.getInt("gameMapId")));
		stats.setLeaver(toStats.getBool("leaver"));
		int ownTeamId = toStats.getInt("teamId");
		int counterOwn = 0;
		int counterEnemy = 0;
		List<Integer> player = new ArrayList<>();
		for (Object oFellowPlayer : toStats.getTO("fellowPlayers").getArray(
				"array")) {
			player.add(((TypedObject) oFellowPlayer).getInt("summonerId"));
		}
		HashMap<Integer, String> summoners = getSummonerNameBySummonerId(player
				.toArray(new Integer[] {}));
		for (Object oFellowPlayer : toStats.getTO("fellowPlayers").getArray(
				"array")) {
			TypedObject toFellowPlayer = (TypedObject) oFellowPlayer;
			if (toFellowPlayer.getInt("teamId") == ownTeamId) {
				stats.getOwnTeam()[counterOwn] = new FellowPlayer(
						summoners.get(toFellowPlayer.getInt("summonerId")),
						client.getChampionService().getChampionById(
								toFellowPlayer.getInt("championId")));
				counterOwn++;
			} else {
				stats.getEnemyTeam()[counterEnemy] = new FellowPlayer(
						summoners.get(toFellowPlayer.getInt("summonerId")),
						client.getChampionService().getChampionById(
								toFellowPlayer.getInt("championId")));
				counterEnemy++;
			}
		}
		for (Object oGameStats : toStats.getTO("statistics").getArray("array")) {
			TypedObject toGameStats = (TypedObject) oGameStats;
			String statType = toGameStats.getString("statType");
			int value = toGameStats.getInt("value");
			switch (statType) {
			case "ASSISTS":
				stats.setAssists(value);
				break;
			case "TRUE_DAMAGE_DEALT_PLAYER":
				stats.setTrueDmgToChamps(value);
				break;
			case "TOTAL_TIME_CROWD_CONTROL_DEALT":
				stats.setCrowdControlDealt(value);
				break;
			case "ITEM3":
				stats.getItems()[3] = client.getItemService()
						.getItemById(value);
				break;
			case "PHYSICAL_DAMAGE_DEALT_TO_CHAMPIONS":
				stats.setPhysicalDmgDealtToChamps(value);
				break;
			case "NEUTRAL_MINIONS_KILLED_YOUR_JUNGLE":
				stats.setOwnJungleMinionsKilled(value);
				break;
			case "ITEM0":
				stats.getItems()[0] = client.getItemService()
						.getItemById(value);
				break;
			case "TRUE_DAMAGE_DEALT_TO_CHAMPIONS":
				stats.setTrueDmgToChamps(value);
				break;
			case "ITEM2":
				stats.getItems()[2] = client.getItemService()
						.getItemById(value);
				break;

			case "TOTAL_DAMAGE_DEALT_TO_CHAMPIONS":
				stats.setTotalDmgDealtToChamps(value);
				break;
			case "PHYSICAL_DAMAGE_TAKEN":
				stats.setPhysicalDmgTaken(value);
				break;
			case "PHYSICAL_DAMAGE_DEALT_PLAYER":
				stats.setPhysicalDmgDealtToChamps(value);
				break;
			case "NUM_DEATHS":
				stats.setDeaths(value);
				break;
			case "ITEM4":
				stats.getItems()[4] = client.getItemService()
						.getItemById(value);
				break;
			case "MINIONS_KILLED":
				stats.setMinionsKilled(value);
				break;
			case "MAGIC_DAMAGE_TAKEN":
				stats.setMagicDmgTaken(value);
				break;
			case "WARD_PLACED":
				stats.setWardsPlaced(value);
				break;
			case "TOTAL_TIME_SPENT_DEAD":
				stats.setTimeSpentDead(value);
				break;
			case "MAGIC_DAMAGE_DEALT_TO_CHAMPIONS":
				stats.setMagicDmgDealtToChamps(value);
				break;
			case "LOSE":
				stats.setWin(false);
				break;
			case "WIN":
				stats.setWin(true);
			case "LARGEST_KILLING_SPREE":
				stats.setLargestKillingSpree(value);
				break;
			case "SIGHT_WARDS_BOUGHT_IN_GAME":
				stats.setSightWardsBought(value);
				break;
			case "TOTAL_HEAL":
				stats.setTotalHeal(value);
				break;
			case "TRUE_DAMAGE_TAKEN":
				stats.setTrueDmgTaken(value);
				break;
			case "CHAMPIONS_KILLED":
				stats.setKills(value);
				break;
			case "LEVEL":
				stats.setLevel(value);
				break;
			case "ITEM1":
				stats.getItems()[1] = client.getItemService()
						.getItemById(value);
				break;
			case "LARGEST_MULTI_KILL":
				stats.setLargestKillingSpree(value);
				break;
			case "TOTAL_DAMAGE_TAKEN":
				stats.setTotalDmgTaken(value);
				break;
			case "TOTAL_DAMAGE_DEALT":
				stats.setDmgDealt(value);
				break;
			case "GOLD_EARNED":
				stats.setGoldEarned(value);
				break;
			case "ITEM5":
				stats.getItems()[5] = client.getItemService()
						.getItemById(value);
				break;
			case "BARRACKS_KILLED":
				stats.setBarracksKilled(value);
				break;
			case "TURRETS_KILLED":
				stats.setTurretsKilled(value);
				break;
			}
		}
		return stats;
	}

	@Override
	public String getName() {
		return "summonerService";
	}

}
