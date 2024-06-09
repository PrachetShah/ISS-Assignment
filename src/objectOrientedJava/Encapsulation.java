package objectOrientedJava;

/*
 * To achieve encapsulation in Java −
 * 1. Declare the variables of a class as private.
 * 2. Provide public setter and getter methods to modify and view the variables values.
 */

public class Encapsulation {
	public static void main(String args[]) {
		EncapTest encap = new EncapTest();
	      encap.setName("James");
	      encap.setAge(20);
	      encap.setIdNum("12343ms");

	      System.out.print("Name : " + encap.getName() + "\nAge : " + encap.getAge() + "\nId Num : " + encap.getIdNum());
	      
	      // We can create Read-only classes or Write-only classes by defining only getters or setters in class
	}
}


class EncapTest{
	private String name, IdNum;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNum() {
		return IdNum;
	}
	public void setIdNum(String idNum) {
		IdNum = idNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}