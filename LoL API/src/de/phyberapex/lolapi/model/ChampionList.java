package de.phyberapex.lolapi.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;

import de.phyberapex.base.FileHelper;

public class ChampionList {

	private static ArrayList<Champion> allChamps = new ArrayList<>();

	static {
		parseJSON();
	}

	public static ArrayList<Champion> getAllChamps() {
		return allChamps;
	}

	private static void parseJSON() {
		File championFolder = new File("champions");
		if (championFolder.isDirectory()) {
			for (File championFile : championFolder.listFiles()) {
				try {
					String championJSON = FileHelper.readFile(
							championFile.getAbsolutePath(),
							StandardCharsets.UTF_8);
					Gson gson = new Gson();
					allChamps.add(gson.fromJson(championJSON, Champion.class));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static Champion getChampionById(int id) {
		Champion returnValue = null;
		for (Champion champ : allChamps) {
			if (champ.getId() == id) {
				returnValue = champ;
			}
		}
		if (returnValue == null) {
			returnValue = new Champion(id, "Champion with id: " + id
					+ " not found.");
		}
		return returnValue;
	}
}
