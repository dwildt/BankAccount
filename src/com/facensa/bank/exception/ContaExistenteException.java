package com.facensa.bank.exception;

public class ContaExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaExistenteException() {
		super();
	}

	public ContaExistenteException(String message) {
		super(message);
	}

	public ContaExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContaExistenteException(Throwable cause) {
		super(cause);
	}

}
