package com.trupti.exp;

class A {
	public void tt() {
		System.out.println("salkdjf");
	}
}

public class ExceptionDemo2 {

	String s;
	
	public static void main(String[] args) {
//		ExceptionDemo ed = new ExceptionDemo();
//		String o = new String("Hellow");
//		ed.tp(o);
		
		System.out.println("Start");
		
//		calc(3, 2);
		
		int len = args.length;
		
		try {
			String s = args[0];
			String s2 = args[1];
			Integer.parseInt(s2);
			System.out.println(s + s2);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally Block");
		}
		
		System.out.println("End");
		
	}
	
	public static void calc(int i, int j) {
		int x = i / j;
		System.out.println(x);
	}
	
	public void tp(Object s) {
		A a = (A) s;
		a.tt();
	}
}
