package de.phyberapex.lolapi.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.Gson;

import de.phyberapex.base.FileHelper;

public class ItemList {

	private ArrayList<Item> allItems = new ArrayList<>();

	public ItemList() {
		parseJSON();
	}

	public ArrayList<Item> getAllItems() {
		return allItems;
	}

	private void parseJSON() {
		File championFolder = new File("resource/json/items");
		if (championFolder.isDirectory()) {
			for (File championFile : championFolder.listFiles()) {
				try {
					String championJSON = FileHelper.readFile(
							championFile.getAbsolutePath(),
							StandardCharsets.UTF_8);
					Gson gson = new Gson();
					allItems.add(gson.fromJson(championJSON, Item.class));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Item getItemById(int id) {
		Item returnValue = null;
		for (Item item : allItems) {
			if (item.getId() == id) {
				returnValue = item;
			}
		}
		if (returnValue == null) {
			returnValue = new Item(id, "Item with id: " + id + " not found.");
		}
		return returnValue;
	}
}