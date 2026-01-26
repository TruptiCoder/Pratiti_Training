package com.trupti;

public class Halwa {
	private final String gajar;
	private final String milk;
	
	public Halwa(String gajar, String milk) {
		this.gajar = gajar;
		this.milk = milk;
	}
	
	public String eatHalwa() {
		return "Enjoy Halwa " + gajar + " " + milk;
	}
	 
	public static void main(String[] args) {
		Halwa halwa = new Halwa("laal gajar", "cow milk");
		System.out.println(halwa.eatHalwa());
	}
}