package com.trupti;

public class OverloadingDemo implements OverloadingI {
	public OverloadingDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public OverloadingDemo(int x) {
		
	}
	
	@Override
	public void over1() {
		
	}
	
	@Override
	public void over1(byte w) {
		System.out.println("byte wala " + w);
	}
	
	@Override
	public int over1(int x) {
		System.out.println("int wala " + x);
		return 0;
	}
}
