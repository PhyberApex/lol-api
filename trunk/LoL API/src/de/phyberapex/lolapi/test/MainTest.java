package de.phyberapex.lolapi.test;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.service.ServiceFactory;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.GameDataNotFoundException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

public class MainTest {

	public static void main(String[] args) {
		Config.getInstance().setApikey("ec4eb130-867d-47fb-a269-0278c9b692c4");
		try {
			ServiceFactory.createChampionService().getAllChampions(Region.EUW);
		} catch (InvalidRegionException | BadRequestException
				| UnauthorizedException | InternalServerErrorException
				| ServiceUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ServiceFactory.createGameService().getRecentGames(Region.EUW, 36348289).getGames();
		} catch (BadRequestException | UnauthorizedException
				| GameDataNotFoundException | InternalServerErrorException
				| ServiceUnavailableException | InvalidRegionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
