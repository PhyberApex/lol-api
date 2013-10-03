package de.phyberapex.lolapi.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;

import de.phyberapex.base.FileHelper;

public class SummonerSpellList {

	private static ArrayList<SummonerSpell> allSpells = new ArrayList<>();

	static {
		parseJSON();
	}

	public static ArrayList<SummonerSpell> getAllSpells() {
		return allSpells;
	}

	private static void parseJSON() {
		File championFolder = new File("spells");
		if (championFolder.isDirectory()) {
			for (File championFile : championFolder.listFiles()) {
				try {
					String championJSON = FileHelper.readFile(
							championFile.getAbsolutePath(),
							StandardCharsets.UTF_8);
					Gson gson = new Gson();
					allSpells.add(gson.fromJson(championJSON,
							SummonerSpell.class));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static SummonerSpell getSpellById(int id) {
		SummonerSpell returnValue = null;
		for (SummonerSpell spell : allSpells) {
			if (spell.getId() == id) {
				returnValue = spell;
			}
		}
		if (returnValue == null) {
			returnValue = new SummonerSpell(id, "Summonerspell with id: " + id
					+ " not found.");
		}
		return returnValue;
	}
}
