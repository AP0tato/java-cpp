import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinearCalc {

	private static double lcm = 1;
	private static List<String> vals = new ArrayList<>();
	public static String p1 = "(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]";
	
	public static String parseLinear(List<String> a1)
	{
		List<List<String>> arr = new ArrayList<>();
		Pattern p = Pattern.compile("((\\-|\\+)?( )?[0-9]+(\\.[0-9]+)?[a-z]|(\\-|\\+)?( )?[0-9]+(\\.[0-9]+)?|(\\-|\\+)?( )?[a-z]|\\(|\\)|\\*|\\/|\\=|\\-|\\+)");
		
		for(int i = 0; i < a1.size(); i++)
		{
			List<String> a2 = new ArrayList<>();
			Matcher m = p.matcher(a1.get(i));
			while(m.find()) a2.add(m.group());
			arr.add(a2);
		}
		
		arr = removeSpace(arr);
		
		for(int i = 0; i < arr.size(); i++) arr.set(i, equationInit(arr.get(i)));
		for(int i = 0; i < arr.size(); i++) arr.set(i, rearrange(arr.get(i)));
		for(int i = 0; i < arr.size(); i++) arr.set(i, sort(arr.get(i)));
		
		for(int i = 0; i < arr.size(); i++) vals.add(AlgebraCalc.check(arr.get(i).get(0)));
		
		lcm = Math.abs(Double.parseDouble((vals.get(0))));
		for(int i = 1; i < vals.size(); i++) lcm(lcm, Double.parseDouble(vals.get(i)));
		
		arr = simplify(arr);
		
		boolean add = false;
		
		//Don't hard code it
		double val = Double.parseDouble(AlgebraCalc.check(vals.get(0)));
		double val1 = Double.parseDouble(AlgebraCalc.check(vals.get(1)));
		if(val<0||val1<0) if(!(val<0&&val1<0)) add = true;
		
		List<List<String>> equations = new ArrayList<>();
		
		for(int i = 0; i < arr.get(0).size(); i++)
		{
			List<String> temp = arr.get(i);
			if(add) 
			{
			}
		}
		//Until here
		
		System.out.println(arr);
		return "";
	}
	
	private static List<List<String>> simplify(List<List<String>> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			if(Math.abs(Double.parseDouble(vals.get(i)))!=lcm)
			{
				String var = "";
				for(int j = 0; j < arr.get(i).size(); j++)
				{
					var = "";
					if(Pattern.matches(p1, arr.get(i).get(j))) 
						var = String.valueOf(arr.get(i).get(j).charAt(arr.get(i).get(j).length()-1));
					
					String temp = AlgebraCalc.check(arr.get(i).get(j));
					
					if(!temp.equals("="))
					{
						String val = String.valueOf( Double.parseDouble(temp)*lcm );
						val += var;
						arr.get(i).set(j, val);
					}
				}
			}
		}
		return arr;
	}
	
	private static double lcm(double a, double b)
	{
		if(a==0||b==0) return 0;
		double num1 = Math.abs(a), num2 = Math.abs(b);
		double low = Math.min(num1, num2);
		double high = Math.max(num1, num2);
		double lcm = high;
		while(lcm%low!=0) lcm += high;
		return lcm;
	}
	
	private static List<String> equationInit(List<String> a1)
	{
		List<String> left = new ArrayList<>(), right = new ArrayList<>();
		int eIndex = a1.indexOf("=");
		
		for(int i = 0; i < eIndex; i++) left.add(a1.get(i));
		for(int i = eIndex+1; i < a1.size(); i++) right.add(a1.get(i));
		a1.clear();
		
		left = brackets(left);
		right = brackets(right);
		
		a1.addAll(left);
		a1.add("=");
		a1.addAll(right);
		
		return a1;
	}
	
	private static List<String> brackets(List<String> a1)
	{
		int b1 = Integer.MAX_VALUE;
		int b2 = Integer.MAX_VALUE;
		String var = "";
		
		while(a1.contains("("))
		{
			b1 = a1.lastIndexOf("(")-1;
			for(int i = b1+1; i < a1.size(); i++)
			{
				if(a1.get(i).equals(")")) { b2 = i; break; }
			}
			
			if(Pattern.matches(p1, a1.get(b1))) var = String.valueOf(a1.get(b1).charAt(a1.get(b1).length()));
			
			String tVal = AlgebraCalc.check(a1.get(b1));
			
			List<String> a2 = new ArrayList<>();
			String var2 = "";
			
			for(int i = b1+2; i < b2; i++)
			{	
				if(!Pattern.matches("(\\-|\\+|\\*|\\/)", a1.get(i)))
				{
					if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(i))) var2 = String.valueOf(a1.get(i).charAt(a1.get(i).length()));
					String tVal2 = AlgebraCalc.check(a1.get(i));
					
					tVal2 = String.valueOf(Double.parseDouble(tVal2)*Double.parseDouble(tVal));
				
					tVal2 += var;
					tVal2 += var2;
					
					a2.add(tVal2);
				}
			}
			
			for(int i = b2; i >= b1; i--)
			{
				a1.remove(i);
			}
			
			for(int i = a2.size()-1; i >= 0; i--)
			{
				a1.add(b1, a2.get(i));
			}
		}			
		return a1;
	}

	private static List<String> sort(List<String> a1)
	{
		List<String> nums = new ArrayList<>(), vars = new ArrayList<>();
		
		for(int i = 0; i < a1.size();)
		{
			if(Pattern.matches("((\\-|\\+)?[0-9]+(\\.[0-9]+)?)", a1.get(i))) nums.add(a1.get(i));
			else vars.add(a1.get(i));
			a1.remove(i);
		}
		
		Collections.sort(vars);
		
		for(int i = 0; i < vars.size(); i++) a1.add(vars.get(i));
		
		String s = "";
		for(String i : nums) s+=i;
		s = String.valueOf(Calc.parse(s));
		
		a1.add(s);
		return a1;
	}
	
	private static List<String> rearrange(List<String> a1)
	{
		boolean flip = false;
		for(int i = 0; i < a1.size();)
		{
			if(!flip)
			{
				if(Pattern.matches("((\\-|\\+)?[0-9]+(\\.[0-9]+)?)", a1.get(i)))
				{
					if(Pattern.matches("((\\-)[0-9]+(\\.[0-9]+)?)", a1.get(i))) 
					{ 
						a1.add(a1.get(i).replaceFirst("\\-", "\\+")); 
						a1.remove(i); 
					}
					else 
					{ 
						a1.add(a1.get(i).replaceFirst("(\\+|)", "\\-"));
						a1.remove(i); 
					}
				}
				else if(a1.get(i).equals("=")) { flip=true; i++; }
				else i++;
			}
			else
			{
				if(Pattern.matches("((\\-|\\+)?[0-9]+(\\.[0-9]+)?[a-z])|(\\-|\\+)?[a-z]", a1.get(i)))
				{
					if(Pattern.matches("((\\-)[0-9]*(\\.[0-9]+)?[a-z])", a1.get(i))) 
					{ 
						a1.add(0, a1.get(i).replaceFirst("\\-", "\\+")); 
						a1.remove(i+1); 
					}
					else 
					{ 
						a1.add(0, a1.get(i).replaceFirst("(\\+|)", "-")); 
						a1.remove(i+1); 
					}
				}
				else i++;
			}
		}
		return a1;
	}
	
	private static List<List<String>> removeSpace(List<List<String>> arr)
	{
		for(int i = 0; i < arr.size(); i++)
		{
			for(int j = 0; j < arr.get(i).size(); j++)
			{
				String s1 = "";
				String[] t = arr.get(i).get(j).split(" ");
				for(int k = 0; k < t.length; k++)
				{
					s1 += t[k];
				}
				arr.get(i).remove(j);
				arr.get(i).add(j, s1);
			}
		}
		return arr;
	}
}
