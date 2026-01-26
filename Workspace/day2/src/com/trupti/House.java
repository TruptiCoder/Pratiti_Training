package com.trupti;

public abstract class House {
	
	public House() {
		System.out.println("House object is created");
	}
	
	public void livingRoom() {
		System.out.println("Sofa");
	}
	
	public void kitchen() {
		System.out.println("Kitchen");
	}
	
	 public abstract void washRoom();
}