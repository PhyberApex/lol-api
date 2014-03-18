package de.phyberapex.lolapi.model.dto.team;

/**
 * This class represents the DTO "MessageOfDayDto" for the lol-static-data API by
 * riot
 * 
 * @author Janis Walliser
 * 
 */

public class MessageOfDay {

	private long createDate;
	private String message;
	private int version;

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
