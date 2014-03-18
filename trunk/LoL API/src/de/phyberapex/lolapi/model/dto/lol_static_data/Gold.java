package de.phyberapex.lolapi.model.dto.lol_static_data;

/**
 * This class represents the DTO "GoldDto" for the lol-static-data API by riot
 * 
 * @author Janis Walliser
 * 
 */

public class Gold {

	private int base;
	private boolean purchasable;
	private int sell;
	private int total;

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
