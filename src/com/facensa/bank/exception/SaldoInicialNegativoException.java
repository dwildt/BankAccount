package com.facensa.bank.exception;

public class SaldoInicialNegativoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInicialNegativoException() {
		super();
	}

	public SaldoInicialNegativoException(String message) {
		super(message);
	}

	public SaldoInicialNegativoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaldoInicialNegativoException(Throwable cause) {
		super(cause);
	}

}
