package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.LeagueType;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.league.League;
import de.phyberapex.lolapi.model.dto.league.LeagueItem;

public class LeagueServiceImpl extends RiotApiService implements LeagueService {

	public LeagueServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public List<League> getCompleteSummonerLeagues(Region region,
			long summonerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeagueItem> getSummonerLeagueEntries(Region region,
			long summonerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<League> getTeamLeagues(Region region, long summonerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeagueItem> getTeamLeagueEntries(Region region, long summonerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public League getChallengerLeague(Region region, LeagueType league) {
		// TODO Auto-generated method stub
		return null;
	}

}
