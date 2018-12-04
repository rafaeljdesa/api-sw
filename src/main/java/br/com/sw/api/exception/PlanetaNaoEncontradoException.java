package br.com.sw.api.exception;

public class PlanetaNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1343844612146968262L;

	public PlanetaNaoEncontradoException() {
	}

	public PlanetaNaoEncontradoException(String message) {
		super(message);
	}

	public PlanetaNaoEncontradoException(Throwable cause) {
		super(cause);
	}

	public PlanetaNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanetaNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
