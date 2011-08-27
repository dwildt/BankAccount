package com.facensa.bank.exception;

public class ContaInexistenteException extends Exception {

	public ContaInexistenteException() {
		super();
	}

	public ContaInexistenteException(String message) {
		super(message);
	}

	public ContaInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContaInexistenteException(Throwable cause) {
		super(cause);
	} 

}
