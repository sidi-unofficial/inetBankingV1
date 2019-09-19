package InterfaceConcept;

public interface USBank {
	
	int min_bal = 100;
	
	public void credit();
	
	public void debit();
	
	public void moneyTransfer();
	
	
	//1. Only Method Declaration
	//2. No Method body -- Only method prototype
	//3. In Interface we can declare variables -- Variables are by default static in nature
	//4. Variables value will not be changed -- Variables are final/constant in nature
	//5. No static methods in Interface
	//6. No main method in interface
	//7. We cannot create object of interface.. To access variables from interface directly access it with Interface name
	//8. Interface is abstract in nature

}
