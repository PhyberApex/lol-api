package de.phyberapex.lolapi.example;

import java.io.IOException;
import java.util.ArrayList;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.client.service.SummonerService;
import de.phyberapex.lolapi.info.MatchStats;
import de.phyberapex.lolapi.persistance.SaveConfiguration;
import de.phyberapex.lolapi.persistance.SaveData;
import de.phyberapex.lolapi.persistance.SqliteWorker;

public class Start {

	private static APIClient client;

	public static void main(String[] args) {
		// Usage of API
		try {
			client = new APIClient();
			client.connectAndLogin();;
			// Usage of summonerservice
			SummonerService sumserv = client.getSummonerService();
			// Usage of getMatchStatsByName
			ArrayList<MatchStats> stats = sumserv
					.getLastMatchStatsByName("Exodragon");
			for (MatchStats stat : stats) {
				System.out.println(stat);
			}
			// Usage of getSummonerInfoByName
			System.out.println("Level of Exodragon: "
					+ sumserv.getSummonerInfoByName("exodragon").getLevel());

			// Usage of persistance to store data
			SaveConfiguration config1 = new SaveConfiguration(
					SaveData.SR_RANKED, "exodragon");
			SaveConfiguration config2 = new SaveConfiguration(
					SaveData.SR_RANKED, "krisniac");
			SqliteWorker worker = new SqliteWorker(10, client, config1, config2);
			new Thread(worker);
			Thread.sleep(20 * 1000);
			worker.stop();

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
