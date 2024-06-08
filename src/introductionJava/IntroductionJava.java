package introductionJava;

import java.util.Scanner;

public class IntroductionJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World - Prachet");
		
		// Take input in Java and print
		System.out.print("Enter what to print: ");
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			System.out.println(s.next());
		}
	}

}
