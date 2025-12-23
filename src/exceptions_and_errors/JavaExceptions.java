package exceptions_and_errors;

import java.io.File;
import java.io.FileReader;

public class JavaExceptions {
	/*
	 * Throws vs Throw Keywords
	 * Try to understand the difference between throws and throw keywords, 
	 * throws is used to postpone the handling of a checked exception and 
	 * throw is used to invoke an exception explicitly.
	 */
	class InsufficientFundsException extends Exception{}
	class NewException extends Exception{}
//	class RemoteException extends Exception{}
	public double deposit(double amount) throws InsufficientFundsException, NewException{
		if(amount > 1000) {
			throw new InsufficientFundsException();
		}else if(amount == 0){
			throw new NewException();
		}else {
			return amount;
		}
	}
	
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
			fr.close();
		}catch(Exception e) {
			System.out.println("Compile-time Exception Found: "+ e);
		}
		System.out.println("Out of Block\n");

		// unchecked exceptionL notified during run time
		try {

			int arr[] = {1,2,3,4,5};
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
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
			System.out.println(val);
		}catch (ArrayIndexOutOfBoundsException f){
			f.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println(e);
		}finally {
			System.out.println("Out of Block\n");
		}
		
		// throwing custom exception
		JavaExceptions j = new JavaExceptions();
		try {
			j.deposit(1500);
			j.deposit(0);
		}catch(InsufficientFundsException i) {
			System.out.println(i);
		}catch(Exception r) {
			System.out.println(r);
		}finally {
			System.out.println("Completed");
		}

	}

}
