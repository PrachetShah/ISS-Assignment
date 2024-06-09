package inbuilt_classes;

import java.util.Arrays;
import java.util.List;

// includes methods present in Arrays in java.util.Arrays
public class ArraysClass {

	public static void main(String[] args) {
		int numArr[] = {4,2,5,25,24,52};
		System.out.print("Before Sorting: ");
		for(int i: numArr) {
			System.out.print(i + " ");
		}
		// sorting array
		Arrays.sort(numArr);
		System.out.print("\nAfter Sorting: ");
		for(int i: numArr) {
			System.out.print(i + " ");
		}
		
		// storing arr as list
		List<Integer> l = Arrays.stream(numArr).boxed().toList();
		System.out.print("\nList: ");
		for(Integer i: l) {
			System.out.print(i+" ");
		}
		
		// binary search in array
		System.out.println("\n" + 5 + " present at index: "+ Arrays.binarySearch(numArr, 5) + " in number array");
		
	}

}
