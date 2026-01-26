package com.trupti.b;

import com.trupti.c.C;

public class B extends C {
//	public B() {
//		System.out.println("Constructor B");
//	}
	
	public B(int i) {
		System.out.println("Constructor B with int value: " + i);
	}
	
	public final void methodB() {
		System.out.println("methodB in class B");
	}
	
	protected void methodBB() {
		System.out.println("methodBB in class B");
	}
}
