import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Bitwise 
{
	public static void main(String[] args)
	{
		HashMap<Integer, String> bi = new HashMap<Integer, String>();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		n++;
		for(int i = 0; i < n; i++)
		{
			String temp = Integer.toBinaryString(i);
			bi.put(i, temp);
		}

		System.out.println();
	}
}
