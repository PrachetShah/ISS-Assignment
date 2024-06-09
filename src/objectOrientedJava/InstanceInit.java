package objectOrientedJava;

// Instance Initializer Block in Java
public class InstanceInit {
	   int a;
	   {
	      System.out.println("Inside instance initializer block");
	      a = 10;
	   }
	   
	   InstanceInit(){
		   System.out.println("Inside constructor");
	      a = 20;
	   }
	   
	   public static void main(String[] arguments) {
	      InstanceInit test = new InstanceInit();
	      System.out.println("Value of a: " + test.a);
	   }
	}