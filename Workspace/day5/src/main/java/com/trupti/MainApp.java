package com.trupti;

import java.util.Arrays;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("Hello maven");
		
		
		
		Integer a[] = new Integer[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		
		List<Integer> l =  Arrays.asList(a);
		l.forEach(aa -> System.out.println(aa));

	}
}
