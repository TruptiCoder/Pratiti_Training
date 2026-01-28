package com.trupti.a;

import com.trupti.b.B;

public class A extends B {
	public A() {
		this(1);
		System.out.println("Constructor A");
	}
	
	public A(int i) {
		super(i);
		System.out.println("Constructor A with int value: " + i);
	}
	
	@Override // MethodB in class B is private so it is not visible to class A
	public void methodB() {
		System.out.println("methodB in class A");
	}
	
	@Override
	protected void methodBB() {
		System.out.println("methodBB in class A");
	}
	
	public void methodA() {
		System.out.println("methodA in class A");
	}
	
	public void methodAA() {
		System.out.println("methodAA in class A");
	}
	
	@Override
	public void methodC() {
		System.out.println("methodC in class A");
	}
}
