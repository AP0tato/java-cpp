import java.util.Scanner;

class Testing
{
	public static void main(String[] args)
	{
		double total = 0, temp = 1;
		int count = 0;
		Scanner in = new Scanner(System.in);
		while(temp != 0)
		{
			temp = in.nextDouble();
			in.nextLine();
			total += temp;
			count++;
		}
		count--;
		System.out.println(total/count);
		in.close();
	}
}