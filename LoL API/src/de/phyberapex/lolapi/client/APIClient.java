package de.phyberapex.lolapi.client;

import java.io.IOException;
import java.util.logging.Logger;

import com.gvaneyck.rtmp.LoLRTMPSClient;

import de.phyberapex.lolapi.client.service.ChampionService;
import de.phyberapex.lolapi.client.service.ItemService;
import de.phyberapex.lolapi.client.service.SummonerService;
import de.phyberapex.lolapi.client.service.SummonerSpellService;
import static de.phyberapex.lolapi.base.Constants.*;

public class APIClient extends LoLRTMPSClient {

	private SummonerService summonerService;
	private ChampionService championService;
	private ItemService itemService;
	private SummonerSpellService summonerSpellService;
	private Logger logger = Logger.getLogger(APIClient.class.getName());

	public APIClient() {
		super(parseServer(LOL_LOGIN_INFO.getProperty("SERVER")), LOL_LOGIN_INFO
				.getProperty("CLIENT_VERSION"), LOL_LOGIN_INFO
				.getProperty("LOGINNAME"), LOL_LOGIN_INFO
				.getProperty("PASSWORD"));
		logger.fine("new instance of APIClient created");
		championService = new ChampionService(this);
		itemService = new ItemService(this);
		summonerSpellService = new SummonerSpellService(this);
	}

	public void connectAndLogin() throws IOException {
		super.connectAndLogin();
		summonerService = new SummonerService(this);
	}

	public SummonerService getSummonerService() {
		return this.summonerService;
	}

	public ChampionService getChampionService() {
		return championService;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public SummonerSpellService getSummonerSpellService() {
		return summonerSpellService;
	}
}
