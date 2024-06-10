package collections_java;

import java.util.Comparator;

// custom data type for collection data structures

// for more comparator: https://www.geeksforgeeks.org/comparator-interface-java/

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

public class Student{
	String name;
	int age;

	Student(String name, int age){
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
