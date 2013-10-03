package de.phyberapex.lolapi.client;

import java.io.IOException;

import com.gvaneyck.rtmp.LoLRTMPSClient;

import de.phyberapex.lolapi.client.persistence.SaveConfiguration;
import de.phyberapex.lolapi.client.persistence.SqliteWorker;
import de.phyberapex.lolapi.client.service.SummonerService;
import static de.phyberapex.lolapi.base.Constants.*;

public class APIClient extends LoLRTMPSClient {

	private SummonerService summonerService;
	private SqliteWorker gatherer;

	public APIClient() throws IOException {
		super(LOL_SERVER, LOL_CLIENT_VERSION, LOL_LOGIN, LOL_PASSWORD);
			this.connectAndLogin();
		summonerService = new SummonerService(this);
	}

	public APIClient(int refreshTimer, SaveConfiguration... configurations)
			throws IOException {
		this();
		this.gatherer = new SqliteWorker(configurations, refreshTimer, this);
	}

	public SummonerService getSummonerService() {
		return this.summonerService;
	}

	public void refresh() {
		// refresh all the juicy data
	}

	public void startGatheringData() {
		new Thread(gatherer).start();
	}

	public void stopGatheringData() {
		this.gatherer.stop();
	}
}
