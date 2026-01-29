package com.trupti.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class GenericDemo {
	public <T> T tp(T t) {
		return t;
	}
}

public class ListDemo2 {
	
	public static void main(String[] args) {
		
//		GenericDemo<String> s = new GenericDemo(); // for generic class
		GenericDemo s = new GenericDemo(); // for generic method
		System.out.println("----------" + s.tp("Hello") + "---------------");
		
		String names[] = {"Trupti", "Balbudhe"};
		List<String> namesLs = Arrays.asList(names); // asList return immutable collection
		display(namesLs);
		
//		Object aa[] = namesLs.toArray();
//		System.out.println("+++++++++++++++++++++++++++++");
//		for(Object o : aa) {
//			System.out.println(((String)o).toUpperCase());
//		}
		
		String aa[] = namesLs.toArray(new String[0]);
		System.out.println("+++++++++++++++++++++++++++++");
		for(String o : aa) {
			System.out.println(o.toUpperCase());
		}
		
		List<String> al = new LinkedList<>();
		al.add("Trupti");
		al.add("Hello");
		al.add("Shweta");
		al.add("World");
		System.out.println(al);
		
		al.add(1, "Mayuri");
		
		System.out.println(al);
		
		display(al);
		
	}
	
	public static void display(List<String> al) {
		for(String str : al) {
			al.set(al.indexOf(str), str.toUpperCase());
		}
		Collections.sort(al);
		
		System.out.println("------------Iterator-------------");
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ListIterator<String> lit = al.listIterator();
		
		
	}
	
}
