package com.trupti.exp;

public class Calculator {
	public void sum(int i, int j) throws BahutBadaNumberException {
		if(i > 10) 
			throw new BahutBadaNumberException(i);
		
		System.out.println(i + j);
	}
}
