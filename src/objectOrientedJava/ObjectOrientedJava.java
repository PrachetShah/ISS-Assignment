/*
 * This included implementation of Java OOPs Concepts, utilising String and Array Data Structures in Java
 * 
 * Main OOPs concepts include
 * Object, Class, Inheritance, Polymorphism, Abstraction, Encapsulation
 * 
 *  Other Java concepts of Interfaces, Packages also mentioned in this file
 */

package objectOrientedJava;

import java.util.Scanner;

class Student{
	// instance variable
	private String name;
	
	// no-args Constructor
	Student(){
		// local variable
		String defaultName = "John Doe";
		this.name = defaultName;
	}
	
	// parametrized Constructor
	Student(String name){
		this.name = name;
	}
	
	// Getters and Setters of Variables of Class
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class ObjectOrientedJava {

	public static void main(String[] args) {	
		System.out.println("OOPs in Java");
		Student one = new Student("First Name");
		System.out.println(one.getName());
		one.setName("Second");
		System.out.println(one.getName());
	}

}
