package com.trupti.exp;

public class BahutBadaNumberException extends RuntimeException {

	public BahutBadaNumberException(int i) {
		super("Yeh number jyada bada hai " + i);
	}
	
	public BahutBadaNumberException() {
		// TODO Auto-generated constructor stub
	}
}
