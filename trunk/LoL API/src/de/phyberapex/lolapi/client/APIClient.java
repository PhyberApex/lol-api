package de.phyberapex.lolapi.client;

import java.io.IOException;

import com.gvaneyck.rtmp.LoLRTMPSClient;

import de.phyberapex.lolapi.client.service.SummonerService;
import static de.phyberapex.lolapi.base.Constants.*;

public class APIClient extends LoLRTMPSClient {

	private SummonerService summonerService;

	public APIClient() {
		super(parseServer(LOL_LOGIN_INFO.getProperty("SERVER")), LOL_LOGIN_INFO
				.getProperty("LOL_CLIENT_VERSION"), LOL_LOGIN_INFO
				.getProperty("LOGINNAME"), LOL_LOGIN_INFO
				.getProperty("LOL_PASSWORD"));
	}

	public void connectAndLogin() throws IOException {
		super.connectAndLogin();
		summonerService = new SummonerService(this);
	}

	public SummonerService getSummonerService() {
		return this.summonerService;
	}
}
