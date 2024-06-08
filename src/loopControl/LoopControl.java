/*
 * This file contains implementations of loops, decision controls, and constructors utilizing variables
 */

package loopControl;

import java.util.Arrays;
import java.util.List;

// New Class Employee for showcasing methods
class Employee{
	private String name;
	private int age;
	// default customer
	Employee(){
		System.out.println("Default Constructor Called");
		this.name = "default name";
		this.age = 10;
	}
	// parametrized constructor
	Employee(String name, int age){
		System.out.println("Parametrized or Arg Constructor Called");
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// @Override annotation indicates that the child class method is over-writing its base class method
	@Override
	public String toString() {
		return "[" + this.name + ", " + this.age + "]";
	}
}


public class LoopControl {
	
	public static void main(String[] args) {
		// The final keyword is a non-access modifier used for classes, attributes and methods, which makes them non-changeable (impossible to inherit or override).
		final int loopInterval = 5;
		String firstName = "Prachet";
		String lastName = "Shah";
		
        //	Example of FOR Loop
		for(int i=0; i<loopInterval; i++) {
			// Example of Conditional Statement
			if(i%2 == 0) {
				System.out.println("Even Number: "+ Integer.toString(i));
			}else {
				System.out.println(Integer.toString(i) + " : " + firstName + " " + lastName);
			}
			
			if(i==3) {
				System.out.println();
				break;
			}
		}
		
		// Example of Switch Case
		switch(firstName) {
			case "ISS":
				System.out.println("Name Found");
				break;
			default:
				System.out.println("Name Not Found");
		}
		
		// Example of For Each loop for expressions
		List<Integer> ages = Arrays.asList(10, 20, 30, 40, 50);
		for(Integer age: ages) {
			System.out.print(Integer.toString(age) + ", ");
		}
		System.out.println("\n\n");
		
		Employee defaultEmployee = new Employee();
		Employee knownEmployee = new Employee(firstName, 21);
		System.out.println(defaultEmployee);
		System.out.println(knownEmployee);
		
		int x = 0;
		while(true) {
			x++;
			System.out.print(x + ", ");
			if(x == 5) {
				break;
			}
		}
	}	

}
