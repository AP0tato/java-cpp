import java.util.*;

class Algorithms 
{	
	public static void main(String[] args) 
	{
		Stuff.Thing();
	}
}

class Stuff 
{
	public static Scanner in = new Scanner(System.in);
	
	public static void bees() 
	{
		int total = 0, total1 = 0, total2 = 1;
		System.out.println("Enter the generation:");
		int gen = in.nextInt();
		in.close();
		for(int i = 0; i < gen; i++) 
		{
			total = total1 + total2;
			total1 = total2;
			total2 = total;
		}
		total = Math.abs(total);
		System.out.println("The amount of bees in " + gen + " generation(s) is " + total + " bee(s).");
	}
	
	public static void divisionalSums() 
	{
		System.out.println("Enter the length of the list:");
		int len = in.nextInt();
		System.out.println("Enter divisor:");
		int divisor = in.nextInt();
		System.out.println("Enter the numbers:");
		int count = 0;
		int[] ar = new int[len];
		while(count < len) 
		{
			ar[count] = in.nextInt();
			count++;
		}
		in.close();
	    int pairs = 0;
	    for(int i = 0; i < ar.length; i++) 
	    {
	        for(int j = len - 1; j > 0; j--) 
	        {
	            if((ar[i] + ar[j]) % divisor == 0 && j > i) 
	            {
	                pairs++;
	            }
	        }
	    }
	    System.out.println("The amount of pairs that can be divided by " + divisor + " is " + pairs + " pairs.");
	}
	
	public static void divisionalNumbers() 
	{
		System.out.println("Enter range, First number, Last number:");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		System.out.println("Enter divisor:");
		int num3 = in.nextInt();
		in.close();
		int count = 0;
		if(num2 < 0 && num1 > 0) 
		{
			for(int i = num2; i < num1; i++) {if(i % num3 == 0) count++;}
		} 
		else if(num1 == num2) 
		{
			if(num1 % num3 == 0) count++;
		} 
		else 
		{
			for(int i = num1; i < num2; i++) {if(i % num3 == 0) count++;}
		}
		System.out.println("The amount of numbers that are divisible by " + num3 + " from " + num1 + " to " + num2 + " is " + count + ".");
	}
	
	public static void reverseNumbers() 
	{
		int num, reversed = 0;
		System.out.println("Enter number to be reversed:");
		num = in.nextInt();
		while(num != 0) 
		{
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}
		System.out.println("Reversed Number: " + reversed);
	}
	
	public static void compundInterest() 
	{
		double rate, principle, total, interest;
		int time, compound;
		System.out.println("Enter principle:");
		principle = in.nextDouble();
		System.out.println("Enter rate:");
		rate = in.nextDouble();
		System.out.println("Enter time periode(years):");
		time = in.nextInt();
		System.out.println("Enter how many times compounded/year:");
		compound = in.nextInt();
		in.close();
		total = principle;
		interest = principle * (Math.pow((1 + rate/100), (compound * time))) - principle;
		total += interest;
		interest = Math.floor(100.0 * interest) / 100.0;
		total = Math.floor(100.0 * total) / 100.0;
		System.out.println("\nCompound interest after " + time + " years: " + interest);
		System.out.println("Total after " + time + " years: " + total);
	}
	
	public static void simpleInterest() 
	{
		System.out.println("Enter principle:");
		double principle = in.nextDouble();
		System.out.println("Enter rate:");
		double rate = in.nextDouble();
		System.out.println("Enter time periode:");
		double time = in.nextDouble();
		in.close();
		rate /= 100;
		double total = (principle * rate * time) * 10 + principle;
		total = Math.floor(100 * total) / 100.0;
		System.out.println("The total after " + time + " years with a rate of " + rate * 100 + "% is $" + total + ".");
	}
	
	public static void duplicates() 
	{
		int j = 1, n, count = 0, k;
		int[] arr;
		System.out.println("Enter size:");
		n = in.nextInt();
		System.out.println("Enter duplicate number to find:");
		k = in.nextInt();
		arr = new int[n];
		System.out.println("Enter numbers:");
		for(int i = 0; i < n; i++) 
		{
			arr[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(arr);
		for(int i = 0; i < n - 1; i++)
		{
			if((arr[i] == arr[j]) && (arr[i] == k && arr[j] == k)) count++;
			j++;
		}
		count++;
		if(count > 1) 
		{
			System.out.println("There are " + count + " duplicate numbers.");
		}
		else
		{
			System.out.println("There are no duplicate numbers of " + k + ".");
		}
	}
	
	public static void advancedCalculator()
	{
		double num1 = 0, num2 = 0, total = 0, prev;
		char op;
		while(true) 
		{
			if(num1 == ' ')
			{
				num1 = total;
			}
			num1 = in.nextDouble();
			op = in.next().charAt(0);
			num2 = in.nextInt();
			
			switch(op)
			{
			case '+':
				total = num1 + num2;
				break;
			case '-':
				total = num1 - num2;
				break;
			case '*':
				total = num1 * num2;
				break;
			case '/':
				total = num1 / num2;
				break;
			case '^':
				total = 1;
				for(int i = 0; i < num2; i++) {
					total *= num1;
				}
				break;
			default:
				System.out.println("Unidentifiable operator, try again.");
				break;
			}
			prev = total;
			System.out.println(prev);
		}
	}
	
	@SuppressWarnings("unused")
	public static void isPrime() 
	{
		int num;
		System.out.println("Enter number to check:");
		num = in.nextInt();
		in.close();
		for(int i = 2; i < num; i++)
		{
			if(num % i == 0) 
			{
				System.out.println(num + " is not prime.");
				break;
			}
			else 
			{
				System.out.println(num + " is prime.");
				break;
			}
		}
	}
	
	public static int thing()
	{
		int count = 0;
		for(int i = 0; i <= 6; i++)
		{
			for(int j = 0; j <= 6; j++)
			{
				
				count++;
			}
		}
		return count;
	}
	
	public static void patternThing()
	{
		System.out.println("Enter Length of Pattern:");
		int n = in.nextInt();
		System.out.println("Enter character/string to repeat:");
		String c = in.next();
		String c1 = c;
		System.out.println("");
		for(int i = 0; i < n; i++)
		{
			System.out.println(c);
			c += c1;
		}
	}
	
	public static void thingy()
	{
		System.out.println("Enter width:");
		int h = in.nextInt();
		System.out.println("Enter height:");
		int w = in.nextInt();
		System.out.println("Enter character/string to repeat:");
		String c = in.next();
		System.out.println("");
		String[][] arr = new String[w][h];
		for(int i = 0; i < w; i++)
		{
			for(int j = 0; j < h; j++)
			{
				arr[i][j] = c;
			}
		}
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static void Thing()
	{
		System.out.println("Enter Length of Pattern:");
		int n = in.nextInt();
		n++;
		System.out.println("Enter character/string to repeat:");
		String c = in.next();
		String c1 = "";
		for(int i = n; i > 0; i--)
		{	
			for(int j = 0; j < i; j++)
			{
				c1 += " ";
			}
			for(int j = 0; j < n - i; j++)
			{
				c1 += c;
			}
			System.out.println(c1);
			c1 = "";
		}
	}
	
	public static void Re()
	{
		System.out.println("Enter Base of Pattern:");
		int n = in.nextInt();
		n++;
		System.out.println("Enter character/string to repeat:");
		String c = in.next();
		String c1 = "";
		for(int i = n; i > 0; i--)
		{	
			for(int j = 0; j < i; j++)
			{
				c1 += " ";
			}
			for(int j = 0; j < n - i; j++)
			{
				c1 += c + c;
			}
			System.out.println(c1);
			c1 = "";
		}
	}
	
	public static void Ree()
	{
		System.out.println("Enter Width of Pattern:");
		int n = in.nextInt();
		n++;
		n /= 2;
		System.out.println("Enter character/string to repeat:");
		String c = in.next();
		String c1 = "";
		for(int i = n; i > 0; i--)
		{	
			for(int j = 0; j < i; j++)
			{
				c1 += " ";
			}
			for(int j = 0; j < n - i; j++)
			{
				c1 += c + c;
			}
			System.out.println(c1);
			c1 = "";
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < i; j++)
			{
				c1 += " ";
			}
			for(int j = 0; j < n - i; j++)
			{
				c1 += c + c;
			}
			System.out.println(c1);
			c1 = "";
		}
	}
}