package de.phyberapex.lolapi.service;

import java.util.ArrayList;
import java.util.List;

import de.phyberapex.lolapi.model.Region;

public class ServiceFactory {

	private static final String BASE_URL = "https://prod.api.pvp.net/api/lol/";

	public static ChampionService createChampionService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.LAN);
		validRegions.add(Region.LAS);
		validRegions.add(Region.NA);
		validRegions.add(Region.OCE);
		ChampionService service = new ChampionServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static GameService createGameService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.LAN);
		validRegions.add(Region.LAS);
		validRegions.add(Region.NA);
		validRegions.add(Region.OCE);
		GameService service = new GameServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static LeagueService createLeagueService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.NA);
		validRegions.add(Region.TR);
		LeagueService service = new LeagueServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static LoLStaticDataService createLoLStaticDataService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.KR);
		validRegions.add(Region.LAN);
		validRegions.add(Region.LAS);
		validRegions.add(Region.NA);
		validRegions.add(Region.OCE);
		validRegions.add(Region.RU);
		validRegions.add(Region.TR);
		LoLStaticDataService service = new LoLStaticDataServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static StatsService createStatsService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.LAN);
		validRegions.add(Region.LAS);
		validRegions.add(Region.NA);
		validRegions.add(Region.OCE);
		StatsService service = new StatsServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static SummonerService createSummonerService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.LAN);
		validRegions.add(Region.LAS);
		validRegions.add(Region.NA);
		validRegions.add(Region.OCE);
		SummonerService service = new SummonerServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
	
	public static TeamService createTeamService() {
		List<Region> validRegions = new ArrayList<>();
		validRegions.add(Region.BR);
		validRegions.add(Region.EUNE);
		validRegions.add(Region.EUW);
		validRegions.add(Region.NA);
		validRegions.add(Region.TR);
		TeamService service = new TeamServiceImpl(BASE_URL,
				validRegions);
		return service;
	}
}
