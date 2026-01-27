package com.trupti.exp;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExceptionDemo {
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		try (FileReader fr = new FileReader("abc.txt"); BufferedReader br = new BufferedReader(fr)) {
			
			String s = br.readLine();
			
			System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("End");
	}
}
