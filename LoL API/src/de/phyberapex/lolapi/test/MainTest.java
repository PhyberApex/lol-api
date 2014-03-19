package de.phyberapex.lolapi.test;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.service.ServiceFactory;

public class MainTest {

	public static void main(String[] args) {
		Config.getInstance().setApikey("ec4eb130-867d-47fb-a269-0278c9b692c4");
		ServiceFactory.createChampionService().getAllChampions(Region.EUW);
		ServiceFactory.createGameService().getRecentGames(Region.EUW, 36348289).getGames();
	}

}
