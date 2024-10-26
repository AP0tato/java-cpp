import java.util.*;

public class Hashmaps2 
{
	public static void main(String[] args)
	{
		Account acc = new Account();
		acc.Stuff();
	}
}

class Account
{
	HashMap<String, String> dict = new HashMap<>();
	HashMap<String, String> user_data_temp = new HashMap<>();
	@SuppressWarnings("rawtypes")
	ArrayList<HashMap> user_data = new ArrayList<HashMap>();
	Scanner in = new Scanner(System.in);
	boolean running = true, running1 = true;
	int count = 1;
	
	public void Stuff()
	{
		while(running)
		{
			System.out.println("[1] Make an Account\n[2] Open an Existing Account\n[3] Display Existing Accounts\n[4] Quit");
			int option = in.nextInt();
			System.out.println("");
			if(option == 1)
			{
				System.out.println("Enter Username, Password:");
				String temp = in.next();
				String temp1 = in.next().strip();
				dict.put(temp, temp1);
				System.out.println("");
			}
			else if(option == 2)
			{
				System.out.println("Enter Username:");
				String temp = in.next();
				System.out.println("");
				if(!dict.containsKey(temp))
				{
					System.out.println("Error, Account not Found");
					System.out.println("");
				}
				else
				{
					System.out.println("Enter Password:");
					String temp1 = in.next().strip();
					System.out.println("");
					if(temp1.equals(dict.get(temp)))
					{
						DisplayAccountData(temp);
					}
					else
					{
						System.out.println("Incorrect Password\n");
						System.out.println("");
					}
				}
			}
			else if(option == 3)
			{
				for(String i : dict.keySet())
				{
					System.out.println("Account " + count + ":\n  Username: " + i + "\n  Password: " + dict.get(i) + "\n");
					count++;
				}
			}
			else
			{
				running = false;
			}
			count = 1;
		}
	}

	public void DisplayAccountData(String user)
	{
		while(running1)
		{
			System.out.println("[1]Show Account Info\n[2] Go Back");
			int option = in.nextInt();
			System.out.println("");
			if(option == 1)
			{
			}
			else
			{
				running1 = false;
			}
		}
	}
}