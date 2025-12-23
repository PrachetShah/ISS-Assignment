package collections_java;

import java.util.Comparator;

// custom data type for collection data structures

// for more comparator: https://www.geeksforgeeks.org/comparator-interface-java/
/*
 *  Comparable vs Comparator: https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 *  A comparable object is capable of comparing itself with another object. 
 *  The class itself must implements the java.lang.Comparable interface to compare its instances. 
 *  Uses compareTo() in class itself
 *  
 *  Unlike Comparable, Comparator is external to the element type we are comparing. 
 *  It’s a separate class. We create multiple separate classes (that implement Comparator) 
 *  to compare by different members.Collections class has a second sort() method and it takes Comparator.
 *  Uses compare() and needs a new class
 */

//creating a custom comparator
class AgeComparator implements Comparator<Student>{
	// sorting based on ascending age, for descending add (-) to the comparison
	public int compare(Student c1, Student c2){
		return c1.getAge() - c2.getAge();
	}
}

class NameComparator implements Comparator<Student>{
	// sorting based on ascending name, for descending add (-) to the comparison
	public int compare(Student c1, Student c2){
		return c1.getName().compareTo(c2.getName());
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student c1, Student c2){
		int nameCompare = c1.getName().compareTo(c2.getName());
		int ageCommpare = c1.getAge().compareTo(c2.getAge());
		return (nameCompare==0) ? ageCommpare : nameCompare;
	}
}

public class Student{
	String name;
	Integer age;

	Student(String name, Integer age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
