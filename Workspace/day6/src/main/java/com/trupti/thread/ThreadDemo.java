package com.trupti.thread;

public class ThreadDemo {
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("main - i: " + i);
				}
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		
		Runnable runnable2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("main - K: " + i);
				}
			}
		};
		
		Thread t2 = new Thread(runnable2);
		t2.start();
		
		System.out.println("End");
	}
	
	public static void t1() {
		tt();
		for(int i = 0; i < 10; i++) {
			System.out.println("t1 i: " + i);
		}
	}
	
	public static void tt() {
		for(int i = 0; i < 10; i++) {
			System.out.println("t2 j: " + i);
		}
	}
	
}
