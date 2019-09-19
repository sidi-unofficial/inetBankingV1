package InterfaceConcept;

public class HSBCBank implements USBank {
	
	public void credit()
	{
		System.out.println("HSBC Bank -- Credit");
	}

	public void debit()
	{
		System.out.println("HSBC Bank -- Debit");
	}
	
	public void moneyTransfer()
	{
		System.out.println("HSBC Bank -- moneyTransfer");
	}
	
	public void educationLoan()
	{
		System.out.println("HSBC Bank -- educationLoan");
	}
	
	public void carLoan()
	{
		System.out.println("HSBC Bank -- carLoan");
	}
}
