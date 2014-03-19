package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.phyberapex.lolapi.model.LeagueType;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.league.League;
import de.phyberapex.lolapi.model.dto.league.LeagueItem;
import de.phyberapex.lolapi.service.exception.RequestException;

public class LeagueServiceImpl extends RiotApiService implements LeagueService {

	public LeagueServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public List<League> getCompleteSummonerLeagues(Region region,
			long summonerId) {
		List<League> returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v2.3/league/by-summoner/" + summonerId + "?";
			try {
				String response = APIRequestHelper.request(requestURL);
				Gson g = new Gson();
				returnValue = g.fromJson(response,
						new TypeToken<List<League>>() {
						}.getType());
			} catch (RequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}
		return returnValue;
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
