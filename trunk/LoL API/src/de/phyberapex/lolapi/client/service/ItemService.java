package de.phyberapex.lolapi.client.service;

import java.util.List;

import de.phyberapex.lolapi.client.APIClient;
import de.phyberapex.lolapi.model.Item;
import de.phyberapex.lolapi.model.ItemList;

public class ItemService extends APIService {

	private ItemList itemList;

	public ItemService(APIClient client) {
		super(client);
		this.itemList = new ItemList();
	}

	public List<Item> getAllItems() {
		return itemList.getAllItems();
	}

	public Item getItemById(int id) {
		return itemList.getItemById(id);
	}

}