package com.hi;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calc {
	
	public double parse(String s)
	{
		List<String> arr = new ArrayList<>();
		
		//Split expression into tokens/pieces
		Pattern p = Pattern.compile("((\\-|\\+)?[0-9]+(\\.[0-9]+)?|\\(|\\)|\\+|\\-|\\*|\\/|\\^)");
		
		Matcher m = p.matcher(s);
		while(m.find())
		{
			arr.add(m.group());
		}
		
		float total = brackets(arr);
		
		//System.out.println(total);
		
		return total;
	}
	
	//Solve whole equation starting with brackets
	private static float brackets(List<String> a1)
	{
		List<String> a2 = new ArrayList<>();
		while(a1.contains("("))
		{
			int i1 = a1.lastIndexOf("(");
			int i2 = 0;
			
			for(int i = i1; !a1.get(i).equals(")"); i++) i2 = i;
			i2++;
			
			System.out.println("a1: "+a1);
			System.out.println("a2: "+a2+"\n");
			
			for(int i = i1+1; i < i2; i++)
			{
				a2.add(a1.get(i));
			}
			
			for(int i = i2; i >= i1; i--)
			{
				a1.remove(i);
			}
			
			System.out.println("a1: "+a1);
			System.out.println("a2: "+a2+"\n");
			
			a2 = exp(a2);
			a2 = dm(a2);
			
			System.out.println("a1: "+a1);
			System.out.println("a2: "+a2+"\n");
			
			a1.add(i1, String.valueOf(sa(a2)));
			
			a2.clear();
		}
		
		a1 = exp(a1);
		a1 = dm(a1);
		return sa(a1);
	}
	
	//Solve exponents
	private static List<String> exp(List<String> a1)
	{
		boolean t = a1.contains("^");
		
		while(t)
		{
			t = a1.contains("^");
			int i = -1;
			
			if(t)
			{
				i = a1.indexOf("^")-1;
				float val = (float) Math.pow(Double.parseDouble(a1.get(i)), Double.parseDouble(a1.get(i+2)));
				
				a1.remove(i);
				a1.remove(i);
				a1.remove(i);
				
				a1.add(i, String.valueOf(val));
			}
		}
		return a1;
	}
	
	//Addition and Subtraction in order from left to right
	private static float sa(List<String> a1)
	{
		float v1 = 0;
		boolean sub = false;
		
		for(int i = 0; i < a1.size(); i++)
		{	
			if(a1.get(i).equals("-")) sub = true;
			else if(a1.get(i).equals("+")) sub = false;
			else 
			{
				if(sub) v1 -= Float.parseFloat(a1.get(i));
				else v1 += Float.parseFloat(a1.get(i));
			}
		}
		return v1;
	}
	
	//Division and Multiplication in order from left to right
	private static List<String> dm(List<String> a1)
	{
		boolean mul = a1.contains("*"), div = a1.contains("/");
		
		while(mul||div)
		{
			mul = a1.contains("*"); 
			div = a1.contains("/");
			
			if(mul||div)
			{
				int mindex = Integer.MAX_VALUE;
				int dindex = Integer.MAX_VALUE;
				
				if(mul) mindex = a1.indexOf("*");
				if(div) dindex = a1.indexOf("/");
			
				if(mindex<dindex) 
				{
					int mi1 = mindex-1;
					float val = (float) (Double.parseDouble(a1.get(mi1)) * Double.parseDouble(a1.get(mi1+2)));
				
					a1.remove(mi1);
					a1.remove(mi1);
					a1.remove(mi1);
					
					a1.add(mi1, String.valueOf(val));
				}
				else
				{
					int mi1 = dindex-1;
					float val = (float) (Double.parseDouble(a1.get(mi1)) / Double.parseDouble(a1.get(mi1+2)));
				
					a1.remove(mi1);
					a1.remove(mi1);
					a1.remove(mi1);
					
					a1.add(mi1, String.valueOf(val));
				}
			}
		}
		
		return a1;
	}
}
