package br.com.sw.api.exception;

public class SwapiConnectionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -383316429966331221L;

	public SwapiConnectionException() {}

	public SwapiConnectionException(String message) {
		super(message);
	}

	public SwapiConnectionException(Throwable cause) {
		super(cause);
	}

	public SwapiConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public SwapiConnectionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
