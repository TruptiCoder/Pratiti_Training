package com.trupti.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ListDemo1 {
	
	public static void main(String[] args) {
		
//		ArrayList al = new ArrayList(20); // 20 changes initial size to 20
//		al.add(1);
//		al.add(2);
//		al.add(3);
//		al.add(4);
//		al.add(5);
//		al.add("Hello");
//		System.out.println(al);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		System.out.println(al);
		
		// al.add(8, 8); // This is throw IndexOutOfBounds because 8 th index does not exists yet.
		// System.out.println(al);
		
		al.remove(4);
		System.out.println(al);
		
		al.set(2, 22);
		System.out.println(al);
	 	
		for(int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i) + ", ");
		}
		System.out.println();
		
		for(Object i : al) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		
//		al.remove
		
	}
	
}
