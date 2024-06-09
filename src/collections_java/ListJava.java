package collections_java;

import java.util.ArrayList;
import java.util.List;

public class ListJava {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		// Adding elements to list 1
		list1.add(0, 10);
		list1.add(1, 20);

		// Printing list 1
		System.out.println("list1 : " + list1);

		// Adding elements to list 2
		list2.add(10);
		list2.add(20);
		list2.add(30);

		// Adding all elements of list 2 in list 1
		list1.addAll(1, list2);

		// Printing list 2
		System.out.println("list2 : " + list2);

		// Removes an element from list 1 (from index 1)
		list1.remove(1);

		// Printing list 1
		System.out.println("list1 after removing an element: " + list1);

		// get() method
		System.out.println("list1 using get() : " + list1.get(2));

		// Replacing element
		list1.set(0, 50);
		
		// cannot instantiate List directly, as List is Interface, can instantiate as ArrayList, LinkedList, etc
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Prachet", 21));
		students.add(new Student("Kevin", 15));
		students.add(new Student("Prachet", 21));
		
		// printing all students 
		System.out.println(students.toString());
		// get name of student present at index 0 of List<Student>
		System.out.println(students.get(0).getName());
		System.out.println(students.indexOf(students.get(0)));
		// removing student from index
		students.remove(0);
		System.out.println(students.toString());
		
	}

}
