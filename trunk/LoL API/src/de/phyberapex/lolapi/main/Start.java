package de.phyberapex.lolapi.main;

import java.io.IOException;
import java.util.ArrayList;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.client.persistence.SaveConfiguration;
import de.phyberapex.lolapi.client.persistence.SaveData;
import de.phyberapex.lolapi.info.MatchStats;

public class Start {

	public static void main(String[] args) {
		// Usage of API to get Data
		// try {
		// APIClient client = new APIClient();
		// ArrayList<MatchStats> stats = client.getSummonerService()
		// .getLastMatchStatsByName("exodragon");
		// System.out.println(stats.get(0));
		// client.getSummonerService().getSummonerNameBySummonerId(32073390);
		//
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		// Usage of API to store data
		SaveConfiguration config1 = new SaveConfiguration(SaveData.SR_RANKED,
				"exodragon");
		SaveConfiguration config2 = new SaveConfiguration(SaveData.SR_RANKED,
				"krisniac");
		try {
			APIClient client2 = new APIClient(10, config1, config2);
			client2.startGatheringData();
			Thread.sleep(60 * 1000);
			client2.stopGatheringData();
			client2.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
