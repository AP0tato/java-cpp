import java.math.BigInteger;
import java.util.Scanner;

public class Testing3 
{
	public static void main(String... args)
	{
		BigInteger num;
		BigInteger num1;
		int num2 = 0;
		String t2 = "0";
		String t1 = "";
		Scanner in = new Scanner(System.in);
		String temp = "";
		while(!temp.equalsIgnoreCase("quit")||!t1.equalsIgnoreCase("quit")||!t2.equalsIgnoreCase("quit"))
		{
			temp = in.next();
			t1 = in.next();
			if(t1.equals("^")) num2 = in.nextInt();
			else t2 = in.next();
			num = new BigInteger(temp);
			num1 = new BigInteger(t2);
			
			switch(t1)
			{
				case "x":
					System.out.println(num.multiply(num1));
					break;
				case "/":
					System.out.println(num.divide(num1));
					break;
				case "^":
					System.out.println(num.pow(num2));
					break;
				case "+":
					System.out.println(num.add(num1));
					break;
				case "-":
					System.out.println(num.subtract(num1));
					break;
				default:
					break;
			}
		}
		in.close();
	}
}