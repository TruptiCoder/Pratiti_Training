package com.trupti.list;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class MyPrinter {
	public static void printName(String name) {
		System.out.println(name);
	}
}

interface Tp {
	public void cp(String name);
}

class DD {
	public void pp(Tp tp) {
		tp.cp("HEllo i am trupti");
	}
}

public class ListDemo3 {

	
	public static void main(String[] args) {
		
		DD dd = new DD();
		dd.pp(MyPrinter::printName);
		
		List<String> ls = new LinkedList<String>();
		
		System.out.println(ls.add("Trupti"));
		System.out.println(ls.add("Shweta"));
		System.out.println(ls.add("Trupti"));
		System.out.println(ls.add("Mayuri"));
		
//		Stream<String> stream =  ls.stream();
//		
//		Consumer<String> consumer = new Consumer<String>() {
//			
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		};
//		
//		// Lambda function
//		stream.forEach(t -> System.out.println(t));
//		
//		// Method reference
//		stream.forEach(System.out::println);
//		
//		ls.forEach(MyPrinter::printName);
		
		
		System.out.println("=================================");
//		Predicate<String> p = t -> t.equals("Trupti");
		
		ls.stream().filter(t -> t.contains("t")).toList().forEach(System.out::println);

		
	}
	
}
