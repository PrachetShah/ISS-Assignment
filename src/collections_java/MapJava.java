package collections_java;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapJava {
	/*
	 * The Map interface maps unique keys to values. A key is an object that you use to retrieve a value at a later date.
	 * 1. Given a key and a value, you can store the value in a Map object. After the value is stored, you can retrieve it by using its key.
	 * 2. Several methods throw a NoSuchElementException when no items exist in the invoking map.
	 * 3. A ClassCastException is thrown when an object is incompatible with the elements in a map.
	 * 4. A NullPointerException is thrown if an attempt is made to use a null object and null is not allowed in the map.
	 * 5. A NullPointerException is thrown if an attempt is made to use a null object and null is not allowed in the map.
	 */
	public static void main(String[] args) {
		// Implementation of HashMap
		Map<String, Integer> map1 = new HashMap<>();
		
		// putting value
		map1.put("Prachet", 21);
		map1.put("Kevin", 15);
		map1.put("John Doe", 100);
		System.out.println("Map Is: " + map1);
		
		// containsValue & containsKey
		System.out.println("\nContains Key 'Prachet': " + map1.containsKey("Prachet"));
		System.out.println("Contains Value '150': " + map1.containsValue(150));
		
		// getting value
		System.out.println("Value with Key Prachet is: " + map1.get("Prachet"));
		
		// remove with key k
		map1.remove("John Doe");
		
		//-----------------------------------------------------------------------------------------------------
		
		// Implementation of TreeMap
		Map<String, Integer> map2 = new TreeMap<String, Integer>();
		
		// putAll method to put all values of Map in another map
		map2.putAll(map1);
		map2.put("Alpha", 1000);
		System.out.println("\nTreeMap: " + map2);
		
		// getting all keys of map
		Set<String> keys = map2.keySet();
		System.out.println("\nKeys of Map: " + keys);
		
		// getting all Values of map
		Collection<Integer> values = map2.values();
		System.out.println("\nValues of Map: " + values);
		
		// getting size of map
		System.out.println("\nSize of map:" + map2.size());
		
		//-----------------------------------------------------------------------------------------------------
		
		// Looping Map using Map.Entry
		System.out.println("\nLooping Using Map Entry");
		//creating an iterator
		Iterator<Map.Entry<String, Integer>> i = map2.entrySet().iterator();
		while(i.hasNext()) {
			// to get a single entry in map, we use Map.Entry to store it
			Map.Entry<String, Integer> entry = i.next();
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
		}
		
		// Looping using KeySet
		System.out.println("\nLooping Using KeySet");
		for(String key: keys) {
			System.out.println("Key: " + key + "\tValue: " + map2.get(key));
		}
		
		// Looping using forEach loop
		System.out.println("\nLooping Using ForEach");
		map2.forEach((k,v) -> System.out.println("Key = " + k + "\tValue = " + v)); 
		
		//-----------------------------------------------------------------------------------------------------
		// custom object Student
		Map<Integer, Student> students = new HashMap<>();
		students.put(1, new Student("Prachet", 21));
		students.put(2, new Student("Kevin", 15));
		System.out.println("\n"+students);
		
		// Creating Iterator to Loop
		Iterator<Map.Entry<Integer, Student>> iter = students.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, Student> entry = iter.next();
			System.out.println("Key: " + entry.getKey() + "\tValue: " + entry.getValue());
			System.out.println("Name: " + entry.getValue().getName() + "\tAge: " + entry.getValue().getAge());
		}
	}

}
