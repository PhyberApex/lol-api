package de.phyberapex.lolapi.client;

import java.io.IOException;

import com.gvaneyck.rtmp.LoLRTMPSClient;

import de.phyberapex.lolapi.client.service.SummonerService;
import de.phyberapex.lolapi.persistance.SaveConfiguration;
import de.phyberapex.lolapi.persistance.SqliteWorker;
import static de.phyberapex.lolapi.base.Constants.*;

public class APIClient extends LoLRTMPSClient {

	private SummonerService summonerService;

	public APIClient() throws IOException {
		super(LOL_SERVER, LOL_CLIENT_VERSION, LOL_LOGIN, LOL_PASSWORD);
		this.connectAndLogin();
		summonerService = new SummonerService(this);
	}

	public SummonerService getSummonerService() {
		return this.summonerService;
	}
}
