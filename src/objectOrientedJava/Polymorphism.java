package objectOrientedJava;

class Vehicle{
	public void display() {
		System.out.println("Vehicle");
	}
}

class Car extends Vehicle{
	// Run time poly occurs when overriding methods
	@Override
	public void display() {
		System.out.println("Car");
	}
}


public class Polymorphism {
	// method overloading is example of compile time polymorphism
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int add(int a, int b, int c) {
		return a+b+c;
	}
	
	public static int add(int[] a) {
		int result = 0, i;
		for(i=0; i<a.length; i++) {
			result = result + a[i];
		}
		return result;
	}
	
	public static void main(String args[]) {
		int[] a = {1,2,3,4,5,6,7,8};
		System.out.println(add(1,2));
		System.out.println(add(1,2,3));
		System.out.println(add(a));
		
		Car car = new Car();
		car.display();
		
		Vehicle veh = new Vehicle();
		veh.display();
	}
}
