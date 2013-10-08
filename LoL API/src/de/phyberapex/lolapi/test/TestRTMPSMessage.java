package de.phyberapex.lolapi.test;

import java.io.IOException;

import org.apache.commons.collections4.MapUtils;

import com.gvaneyck.rtmp.encoding.TypedObject;

import de.phyberapex.lolapi.client.APIClient;

public class TestRTMPSMessage {

	public static void main(String[] args) throws IOException {
		APIClient client = new APIClient();
		client.connectAndLogin();
		String operation = "getAllPublicSummonerDataByAccount";
		String destination = "summonerService";
		Object[] parameter = new Object[] { client.getSummonerService()
				.getSummonerInfoByName("Exodragon").getAccountId() };
		int id = client.invoke(destination, operation, parameter);
		TypedObject result = client.getResult(id);
		System.out.println("Ergebnis als String: " + result);
		MapUtils.debugPrint(System.out, "INHALT",
				result.getTO("data").getTO("body"));
		System.out.println("WHAT: "
				+ result.getTO("data").getTO("body").getTO("spellBook")
						.getTO("bookPages").getArray("array"));
	}

}
