package com.trupti.exp;

public class ExceptionDemo3 {
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		Runtime rt = Runtime.getRuntime();
		rt.addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Ok, bye bye");
			}
		});
		
		int p = rt.availableProcessors();
		long fm = rt.maxMemory();
		
		System.out.println(p);
		System.out.println(fm);
		
		long st = System.currentTimeMillis();
		
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
		
		Calculator calculator = new Calculator();
		
		try {
			calculator.sum(30, 6);			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		long et = System.currentTimeMillis();
		System.out.println(et - st);
		
		System.out.println(rt.freeMemory());
		
		System.out.println("End");
		
		
	}
	
}
