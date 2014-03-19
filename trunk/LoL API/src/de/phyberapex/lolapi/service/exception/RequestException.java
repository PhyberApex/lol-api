package de.phyberapex.lolapi.service.exception;

public class RequestException extends ServiceException {

	private int errorCode;
	private static final long serialVersionUID = 1L;

	public RequestException(int status) {
		this.errorCode = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
