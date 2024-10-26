import java.util.ArrayList;
import java.util.HashMap;

public class Hashmaps 
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) 
	{
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();	
		HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();
		ArrayList<HashMap> ar = new ArrayList<HashMap>();
		for(int i = 0; i < 10; i++)
		{
			dict.put(i, i + 1);
		}
		
		for(int i = 10; i > 0; i--)
		{
			arr.put(i, i - 1);
		}
		
		ar.add(dict);
		ar.add(arr);
		System.out.println(ar);
	}
}