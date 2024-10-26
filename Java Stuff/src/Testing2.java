import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing2 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		List<Long> arr = new ArrayList<>();
		for(int i = 0; i < 10; i++) arr.add(in.nextLong());
		arr = sort(arr);
		System.out.println(arr);
		in.close();
	}
	
	static List<Long> sort(List<Long> arr)
	{
		for(short i = 0; i < arr.size(); i++)
		{
			arr = helper(arr);
		}
		return arr;
	}
	private static List<Long> helper(List<Long> arr)
	{
		for(int i = 0; i < arr.size()-1; i++)
		{
			long temp = arr.get(i);
			long temp1 = arr.get(i+1);
			if(temp>temp1)
			{
				arr.set(i+1, temp);
				arr.set(i, temp1);
			}
		}
		return arr;
	}
}
