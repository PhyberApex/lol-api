package de.phyberapex.lolapi.test.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.phyberapex.lolapi.base.Config;
import de.phyberapex.lolapi.model.Region;
import de.phyberapex.lolapi.service.GameService;
import de.phyberapex.lolapi.service.ServiceFactory;
import de.phyberapex.lolapi.service.exception.BadRequestException;
import de.phyberapex.lolapi.service.exception.GameDataNotFoundException;
import de.phyberapex.lolapi.service.exception.InternalServerErrorException;
import de.phyberapex.lolapi.service.exception.InvalidRegionException;
import de.phyberapex.lolapi.service.exception.ServiceUnavailableException;
import de.phyberapex.lolapi.service.exception.UnauthorizedException;

public class GameServiceImplTest {

	private GameService service;

	@Before
	public void testSetup() {
		Config.getInstance().setApikey("ec4eb130-867d-47fb-a269-0278c9b692c4");
		service = ServiceFactory.createGameService();
	}

	@Test
	public void testGetRecentGamesForGames() {
		try {
			if (service.getRecentGames(Region.EUW, 36348289) == null) {
				fail("No games found");
			}
		} catch (BadRequestException | UnauthorizedException
				| GameDataNotFoundException | InternalServerErrorException
				| ServiceUnavailableException | InvalidRegionException e) {
			fail("Exception thrown");
		}
	}

	@Test
	public void testGetRecentGamesForGameDataNotFoundException() {
		try {
			service.getRecentGames(Region.EUW, 2);
			fail("No exception thrown");
		} catch (BadRequestException | UnauthorizedException
				| InternalServerErrorException | ServiceUnavailableException
				| InvalidRegionException e) {
			fail("Wrong exception thrown");
		} catch (GameDataNotFoundException e) {
		}
	}

	@Test
	public void testGetRecentGamesForInvalidRegionException() {
		try {
			service.getRecentGames(Region.TR, 36348289);
			fail("No exception thrown");
		} catch (BadRequestException | UnauthorizedException
				| GameDataNotFoundException | InternalServerErrorException
				| ServiceUnavailableException e) {
			fail("Wrong exception thrown");
		} catch (InvalidRegionException e) {

		}
	}
}
