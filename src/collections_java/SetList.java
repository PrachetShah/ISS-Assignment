package collections_java;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetList {

	public static void main(String[] args) {
		// Types of Sets Present: HashSet, TreeSet, EnumSet, LinkedHashSet, SortedSet
		
		/*
		 * The Java HashSet class implements the Set interface, backed by a hash table.
		 * Following are the important points about HashSet − 
		 * 1. This class makes no guarantees as to the iteration order of the set; in particular, it does not 
		 * guarantee that the order will remain constant over time.
		 * 2. This class permits the null element.
		 */
		
		int count[] = {12,2453,1335,143};
		Set<Integer> s = new HashSet<>();
		for(int i: count) {
			s.add(i);
		}
		System.out.println(s);
		
		/*
		 * TreeSet
		 * The Java TreeSet class implements the Set interface. 
		 * Following are the important points about TreeSet − 
		 * 1. The TreeSet class guarantees that the Map will be in ascending key order and backed by a TreeMap.
		 * 2. The Map is sorted according to the natural sort method for the key Class, or by the Comparator 
		 * provided at set creation time, that will depend on which constructor used.
		 * 3. The ordering must be total in order for the Tree to function properly.
		 */
		
		// implementation of TreeSet
		TreeSet<Integer> sortedSet = new TreeSet<>(s);
        System.out.println("The sorted list is:");
        System.out.println(sortedSet);

        System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
        System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
        
        // using custom object with Name Comparator
        Set<Student> students = new TreeSet<Student> (new NameComparator());
        students.add(new Student("Prachet", 21));
        students.add(new Student("John", 12));
        
        System.out.println(students);
        
        // Looping Set with for loop
        for(Student st: students) {
        	System.out.println("Name:"+st.getName()+"\tAge:"+st.getAge());
        }
        
        // Looping Set with Iterator
        Iterator<Student> i = students.iterator();
        while(i.hasNext()){
        	Object entry = i.next();
        	System.out.println(entry);
        }

		// using custom object with Student Comparator which compares name anda age
        Set<Student> studentNew = new TreeSet<Student> (new StudentComparator());
        studentNew.add(new Student("John", 17));
        studentNew.add(new Student("Prachet", 21));
        studentNew.add(new Student("Prachet", 111));
        studentNew.add(new Student("John", 12));
        
        System.out.println(studentNew);
        
        // Looping Set with for loop
        for(Student st: studentNew) {
        	System.out.println("Name:"+st.getName()+"\tAge:"+st.getAge());
        }
        
        // Looping Set with Iterator
        Iterator<Student> iter = studentNew.iterator();
        while(iter.hasNext()){
        	Object entry = iter.next();
        	System.out.println(entry);
        }
	}

}
