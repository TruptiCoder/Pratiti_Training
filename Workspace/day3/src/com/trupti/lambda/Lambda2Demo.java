package com.trupti.lambda;

interface Display {
	String show(String s);
}

class DisplayApp {
	
	void display(String name, Display display) {
		String msg = display.show(name);
		System.out.println(msg);
	}
	
}

public class Lambda2Demo {
	public static void main(String[] args) {
		DisplayApp app = new DisplayApp();
		
		Display display = new Display() {
			
			@Override
			public String show(String s) {
				return "Welcom " + s;
			}
		};
		
//		Display display2 = s -> System.out.println("Welcome " + s);
		Display display2 = s -> "Welcome " + s;
		
		app.display("Trupti", display2);
	}
}
