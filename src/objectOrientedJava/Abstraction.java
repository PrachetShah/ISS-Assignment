package objectOrientedJava;

/* 
In Java programming, abstraction is achieved using Abstract classes and interfaces.
 1. If a class is declared abstract, it cannot be instantiated
 2. To use an abstract class, you have to inherit it from another class, provide implementations 
 to the abstract methods in it.
 3. If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.
 */
abstract class Employee{
	private String name, loc;
	private int num;

	Employee(String name, String loc, int num){
		System.out.println("Constructing an Employee");
		this.name = name;
		this.loc = loc;
		this.num = num;
	}

	public abstract double computePay();

	public void mailCheck() {
		System.out.println("Mailing a check to " + this.name + " " + this.loc);
	}

	public String toString() {
		return name + ", " + loc + ", " + num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class Salary extends Employee{
	private double salary;

	Salary(String name, String loc, int num, double salary){
		super(name, loc, num);
		this.salary = salary;
	}

	public void mailCheck() {
		System.out.println("Mailing a check to Salary Class");
		System.out.println("Mailing a check to " + getName() + " with salary " + salary);
	}

	public double computePay() {
		System.out.println("Computing salary pay for " + getName());
		return salary/52;
	}
}

public class Abstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Cannot Perform this gives error as it is an abstract class, but we can instantiate a new class inheriting Employee
		Salary s = new Salary("George W.", "Houston, TX", 43, 120000);
		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();
		System.out.println("\n Call mailCheck using Employee reference--");
		e.mailCheck();
		
		System.out.println("\nEmployee e:" + e);
		System.out.println("Employee s:" + s);
		
		System.out.println("Employee e Salary:" + e.computePay());
		System.out.println("Employee s Salary:" + s.computePay());
		
		// You can also create method within an class as abstract to allow child classes to modify it
	}

}
