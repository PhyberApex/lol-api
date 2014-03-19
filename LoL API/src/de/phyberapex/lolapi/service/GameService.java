package de.phyberapex.lolapi.service;

import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.model.dto.game.RecentGames;

/**
 * This interface represents the game service from the riot API
 * 
 * @author Janis Walliser
 * 
 */

public interface GameService extends Service {

	public RecentGames getRecentGames(Region region, long summonerId);

}
