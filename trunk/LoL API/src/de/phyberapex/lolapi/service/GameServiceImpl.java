package de.phyberapex.lolapi.service;

import java.util.List;

import com.google.gson.Gson;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.game.RecentGames;

public class GameServiceImpl extends RiotApiService implements GameService {

	public GameServiceImpl(String baseURL, List<Region> validRegions) {
		super(baseURL, validRegions);
	}

	@Override
	public RecentGames getRecentGames(Region region, long summonerId) {
		RecentGames returnValue = null;
		if (getValidRegions().contains(region)) {

			String requestURL = getBaseURL() + region.toString()
					+ "/v1.3/game/by-summoner/" + summonerId + "/recent?";
			String response = APIRequestHelper.request(requestURL);
			Gson g = new Gson();
			returnValue = g.fromJson(response, RecentGames.class);
		} else {

		}
		return returnValue;
	}

}
