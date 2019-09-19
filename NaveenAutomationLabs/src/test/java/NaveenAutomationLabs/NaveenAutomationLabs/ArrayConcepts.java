package NaveenAutomationLabs.NaveenAutomationLabs;

public class ArrayConcepts {

	public static void main(String[] args) {
		
		//Object Array
		
		Object ob[] = new Object[5];
		ob[0] = "Tom";
		ob[1] = 25;
		ob[2] = 12.33;
		ob[3] = "1/1/1990";
		ob[4] = "London";
		
		for(int i=0; i<ob.length; i++)
		{
			System.out.println(ob[i]);
		}

	}

}
