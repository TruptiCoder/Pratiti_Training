package com.trupti.deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.nau.pet.Dog;

public class DeserializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("blanket");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		System.out.println(obj);
		Dog dog = (Dog)obj;
		System.out.println(dog);
		dog.setSound("BHOOOOOOOW BHOOOOOOOOOW");
		System.out.println(dog);
	}
}
