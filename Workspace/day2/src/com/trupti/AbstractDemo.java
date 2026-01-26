package com.trupti;

import java.awt.Toolkit;

public class AbstractDemo {
	public static void main(String[] args) {
		House myHouse = new MyHouse();
		YourHouse yourHouse = new YourHouse();
		displayHouse(myHouse);
		System.out.println("--------------------------------");
		displayHouse(yourHouse);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		int s = t.getScreenResolution();
		System.out.println(s);
		System.out.println(t.getScreenSize());
	}
	
	public static void displayHouse(House house) {
		house.kitchen();
		house.livingRoom();
		house.washRoom();
		
		if(house instanceof YourHouse) {
			YourHouse tc = (YourHouse)house;
			tc.garden();			
		}
		else if (house instanceof MyHouse) {
			MyHouse mc = (MyHouse)house;
			mc.mandir();
		}
	}
}
