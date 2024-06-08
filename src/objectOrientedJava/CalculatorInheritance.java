package objectOrientedJava;


// inheritance, use of super keyword

class Basic{
	int result;
	// super class constructor
	Basic(int result){
		this.result = result;
	}
	
	public void addition(int x, int y) {
		int z = x+y;
		System.out.println("Addition is: "+ z);
	}
	
	public void subtraction(int x, int y) {
		int z = x-y;
		System.out.println("Subtraction is: "+ z);
	}
	
	public void display() {
		System.out.println("Basic Calculator Hello!");
	}
}

public class CalculatorInheritance extends Basic{
	
	// subclass constructor invoking superclass constructor
	CalculatorInheritance(int result){
		super(result);
	}
	
	public void multiply(int x, int y) {
		int z = x*y;
		System.out.println("Multiplication is: " + z);
	}
	
	public void display() {
		System.out.println("Advanced Calculator Hello!");
	}
	
	// utilization of super keyword, super cannot be used with static methods
	public void anyMethod() {
		CalculatorInheritance calci = new CalculatorInheritance(10);
		
		// invoking subclass method
		calci.display();
		
		// invoking super class method
		super.display();
	}
	
	public static void main(String args[]) {
		CalculatorInheritance calci = new CalculatorInheritance(5);
		calci.addition(5, 3);
		calci.multiply(5, 3);
		calci.anyMethod();
	}
}
