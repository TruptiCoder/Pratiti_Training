package com.trupti.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.trupti.pet.Dog;

public class SerializationDemo {
	public static void main(String[] args) throws IOException {
		Dog dog = new Dog();
		System.out.println(dog);
		dog.setSound("meaw meaw");
		System.out.println(dog);
		
		FileOutputStream fileOutputStream = new FileOutputStream("blanket");
		ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
//		Socket socket = new Socket("192.168.1.85", 5555);
//		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(dog);
		
//		socket.close();
		
//		System.out.println("Dog wrapped in blanket");
	}
}