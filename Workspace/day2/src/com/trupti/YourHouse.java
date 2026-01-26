package com.trupti;

public class YourHouse extends House {
	
	public YourHouse() {
		System.out.println("YourHouse is created");
	}

	@Override
	public void washRoom() {
		System.out.println("Washroom with Jakuzzi");
		
	}

	public void garden() {
		System.out.println("Big Garden");
	}
	
}
