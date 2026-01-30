package com.trupti.thread;

//public class CoffeeMachine implements Runnable {
public class CoffeeMachine extends Thread {
	
	public CoffeeMachine() {
		start();
	}
	
	public CoffeeMachine(String name) {
		super(name);
		start();
	}

	@Override
	public void run() {
		drink();
	}
	
	public synchronized void drink() {
		for(int i = 0; i < 10; i++) {
			String tname = Thread.currentThread().getName();
			System.out.println(i + " sip taken by " + tname);
		}
		
	}
}
