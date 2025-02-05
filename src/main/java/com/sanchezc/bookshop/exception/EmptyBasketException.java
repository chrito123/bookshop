package com.sanchezc.bookshop.exception;

import java.io.Serial;

public class EmptyBasketException extends RuntimeException {
	
	@Serial
	private static final long serialVersionUID = 4221901917564943807L;

	
	
	public EmptyBasketException(String message) {
		super(message);
	}
}
