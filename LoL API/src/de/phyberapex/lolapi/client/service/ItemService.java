package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.Item;
import de.phyberapex.lolapi.model.ItemList;

public class ItemService extends APIService {

	public ItemService(APIClient client) {
		super(client);
	}

	public List<Item> getAllItems() {
		return ItemList.getAllItems();
	}

	public Item getItemById(int id) {
		return ItemList.getItemById(id);
	}

}