package br.com.sw.api.exception;

public class PlanetaExisteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8420248097548475879L;

	public PlanetaExisteException() {}

	public PlanetaExisteException(String message) {
		super(message);
	}

	public PlanetaExisteException(Throwable cause) {
		super(cause);
	}

	public PlanetaExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanetaExisteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
