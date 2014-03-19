package de.phyberapex.lolapi.service;

import java.util.List;

import de.phyberapex.lolapi.model.LeagueType;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.league.League;
import de.phyberapex.lolapi.model.dto.league.LeagueItem;

/**
 * This interface represents the league service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface LeagueService extends Service {

	public List<League> getCompleteSummonerLeagues(Region region, long summonerId);

	public List<LeagueItem> getSummonerLeagueEntries(Region region, long summonerId);
	
	public List<League> getTeamLeagues(Region region, long summonerId);

	public List<LeagueItem> getTeamLeagueEntries(Region region, long summonerId);
	
	public League getChallengerLeague(Region region, LeagueType league);

}
