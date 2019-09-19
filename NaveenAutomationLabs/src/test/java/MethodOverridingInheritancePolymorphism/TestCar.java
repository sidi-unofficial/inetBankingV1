package MethodOverridingInheritancePolymorphism;

public class TestCar {

	public static void main(String[] args) {
		
		//Static or Compile Time Polymorphism
		
		BMW b = new BMW();
		
		b.start();
		b.stop();
		b.refuel();
		b.theftSafety();
		b.engine();
		
		System.out.println("***********");
		
		Car c = new Car();
		c.start(); 
		c.stop();
		c.refuel(); 

		System.out.println("***********");
		
		Car c1 = new BMW();
		c1.start();
		c1.stop();
		c1.refuel(); 
	}

}
