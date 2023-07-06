package br.com.alura.screenmatch.exceptions;

public class InvalidYearException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public InvalidYearException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
