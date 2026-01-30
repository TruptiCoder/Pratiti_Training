package com.trupti.thread;

public class ThreadDemo2 {
	
	public static void main(String[] args) {
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Killed :D");
		}));
		
		CoffeeMachine machine = new CoffeeMachine("Trupti");
		CoffeeMachine machine1 = new CoffeeMachine("Gauri");
		
//		Thread trupti = new Thread(machine, "Trupti");
//		Thread gauri = new Thread(machine, "Gauri");
//		
//		trupti.start();
//		gauri.start();
		
	}
	
}
