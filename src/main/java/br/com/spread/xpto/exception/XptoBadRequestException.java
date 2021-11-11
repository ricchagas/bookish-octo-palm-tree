package br.com.spread.xpto.exception;

public class XptoBadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public XptoBadRequestException(String msg) {
		super(msg);
	}

}
