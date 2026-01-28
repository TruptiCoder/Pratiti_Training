package com.trupti.pet;

// marker interface
import java.io.Serializable;

public class Dog implements Serializable {
	private transient String name = "Tommy";
	private String breed = "Pomerian";
	private String sound = "Bhow Bhow";
	
	public Dog() {
		
	}

	public Dog(String name, String breed, String sound) {
		super();
		this.name = name;
		this.breed = breed;
		this.sound = sound;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", sound=" + sound + "]";
	}
}
