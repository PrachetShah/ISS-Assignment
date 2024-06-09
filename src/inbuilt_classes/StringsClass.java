package inbuilt_classes;

// some methods of String Class present in java.lang
public class StringsClass {

	public static void main(String[] args) {
		// creating string from char array
		char arr[] = {'h', 'e', 'l', 'l', 'o'};
		String hello = new String(arr);
		System.out.println(hello);
		
		// IMP Note
		// The String class is immutable, so that once it is created a String object cannot be changed. 
		// If there is a necessity to make a lot of modifications to Strings of characters, then you should use 
		// String Buffer & String Builder Classes.
		
		// length of string
		System.out.println("Length: "+ hello.length());
		
		// concatenating strings
		String world = "World";
		String concat = hello.concat(world);
		System.out.println(concat);
		
		// getting char at index
		System.out.println(concat.charAt(5));
		
		// compare to strings lexographically, 0 if strings are equal
		System.out.println(hello.compareTo(concat));
		System.out.println(hello.compareTo("hello"));
		
		// compare with .equals()
		System.out.println(hello.equals("hello"));
		System.out.println(hello.equals("Hello"));
	}

}
