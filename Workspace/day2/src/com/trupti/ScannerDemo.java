package com.trupti;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = scanner.next();
		System.out.print("Enter City: ");
		String city = scanner.next();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		System.out.print("Enter email: ");
		String email = scanner.next();
		System.out.printf("The name is %s, city is %s, email is %s and age is %d", name, city, email, age);
		
		scanner.close();
	}
}
