package com.mitocode.Exception;

public class ModelNotFoundException extends RuntimeException{

	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}
