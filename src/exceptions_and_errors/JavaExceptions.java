package exceptions_and_errors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaExceptions {
	/*
	 *  Exception Heirarchy present under java.lang.Object.Throwable
	 *  All exception classes are subtypes of the java.lang.Exception class. 
	 *  The exception class is a subclass of the Throwable class. 
	 *  Other than the exception class there is another subclass called Error 
	 *  which is derived from the Throwable class.
	 */
	public static void main(String[] args) {

		// checked exception: notified by compile time
		try {

			File file = new File("file.txt");
			FileReader fr = new FileReader(file);
		}catch(Exception e) {
			System.out.println("Compile-time Exception Found: "+ e);
		}
		System.out.println("Out of Block\n");

		// unchecked exceptionL notified during run time
		try {

			int arr[] = {1,2,3,4,5};
			int val = arr[6];
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Run-time Exception Thrown: " + e);
		}finally {
			System.out.println("Out of Block\n");
		}

		// errors: not exceptions but beyond control like stack overflow, etc

		// multiple exception catch block
		try {
			int arr[] = {1,2,3,4,5};
			//	int res = arr[7];
			int val = arr[0]/0;
		}catch (ArrayIndexOutOfBoundsException f){
			f.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println(e);
		}finally {
			System.out.println("Out of Block\n");
		}
		
		/*
		 * Throws vs Throw Keywords
		 * Try to understand the difference between throws and throw keywords, 
		 * throws is used to postpone the handling of a checked exception and 
		 * throw is used to invoke an exception explicitly.
		 */

	}

}
