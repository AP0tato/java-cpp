import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlgebraCalc extends Calc{
	
	public static char var = ' ';
	
	public static float parseA(String s)
	{
		List<String> arr = new ArrayList<>();
		List<String> ar =  new ArrayList<>();
		List<String> ar1 = new ArrayList<>();
		
		Pattern p = Pattern.compile("((\\-|\\+)?( )?[0-9]+(\\.[0-9]+)?[a-z]|(\\-|\\+)?( )?[0-9]+(\\.[0-9]+)?|\\(|\\)|\\*|\\/|\\=|\\-|\\+)");
		Matcher m = p.matcher(s);

		while(m.find())
		{
			arr.add(m.group());
		}
		
		for(String i : arr) { if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", i)) { var = i.charAt(i.length()-1); break; } }
		
		//Remove space from sign and number
		for(int i = 0; i < arr.size(); i++)
		{
			String s1 = "";
			String[] t = arr.get(i).split(" ");
			for(int j = 0; j < t.length; j++)
			{
				s1 += t[j];
			}
			arr.remove(i);
			arr.add(i, s1);
		}
		
		arr = brackets(arr);
		arr = div(arr);
		
		int eIndex = arr.indexOf("=");

		//Moving all variables to one list
		for(int i = eIndex+1; i < arr.size();)
		{
			if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", arr.get(i)))
			{
				if(Pattern.matches("(\\-)[0-9]*(\\.[0-9]+)?[a-z]", arr.get(i))) ar1.add(arr.get(i).replaceFirst("\\-", "\\+"));
				else ar1.add(arr.get(i).replaceFirst("(\\+|)", "-"));
			}
			else ar.add(arr.get(i));
			arr.remove(i);
		}
		
		//Start moving all numbers to one list
		for(int i = 0; i < arr.size();)
		{
			if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?", arr.get(i))) 
			{
				if(Pattern.matches("(\\-)[0-9]*(\\.[0-9]+)?", arr.get(i))) ar.add(arr.get(i).replaceFirst("\\-", "\\+"));
				else ar.add(arr.get(i).replaceFirst("(\\+|)", "-"));
			}
			else ar1.add(arr.get(i));
			arr.remove(i);
		}
		ar1.remove("=");

		String s1 = "";
		for(String i : ar) s1+=i;
		
		//Get coefficient and add to list
		List<String> nums = new ArrayList<>();
		for(int i = 0; i < ar1.size(); i++)
		{
			if(Pattern.matches("(\\+)?[a-z]", ar1.get(i))) nums.add("+1");
			else if(Pattern.matches("(\\-)[a-z]", ar1.get(i))) nums.add("-1");
			else 
			{
				String temp = "";
				for(int j = 0; j < ar1.get(i).length()-1; j++)
				{
					temp += ar1.get(i).charAt(j);
				}
				nums.add(temp);
			}
		}
		
		double val = parse(s1);
		s1 = "";
		
		for(String i : nums) s1+=i;
		double valVar = parse(s1);
		
		return (float) (val/valVar);
	}
	
	public static List<String> brackets(List<String> a1)
	{
		int b1 = Integer.MAX_VALUE;
		int b2 = Integer.MAX_VALUE;
		boolean var = false;
		
		while(a1.contains("("))
		{
			b1 = a1.lastIndexOf("(")-1;
			for(int i = b1+1; i < a1.size(); i++) {if(a1.get(i).equals(")")) { b2 = i; break; }}
			
			if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(b1))) var = true;
			String tVal = check(a1.get(b1));
			if(var) tVal += AlgebraCalc.var;
			
			List<String> a2 = new ArrayList<>();
			boolean var2;
			
			for(int i = b1+2; i < b2; i++)
			{	
				if(!Pattern.matches("(\\-|\\+|\\*|\\/)", a1.get(i)))
				{
					var2 = false;
					if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(i))) var2 = true;
					String tVal2 = check(a1.get(i));
					
					tVal2 = String.valueOf(Double.parseDouble(tVal2)*Double.parseDouble(tVal));
				
					if(var) tVal2 += AlgebraCalc.var;
					if(var2) tVal2 += AlgebraCalc.var;
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
	
	private static List<String> div(List<String> a1)
	{
		while(a1.contains("*")||a1.contains("/"))
		{
			int mi = Integer.MAX_VALUE;
			int di = Integer.MAX_VALUE;
			
			if(a1.contains("*")) mi = a1.indexOf("*")-1;
			if(a1.contains("/")) di = a1.indexOf("/")-1;
			
			if(mi < di) a1 = mul(a1);
			else
			{
				boolean var = false;
				
				if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(di))||Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(di+2))) var = true;
				
				String val = check(a1.get(di));
				String val2 = check(a1.get(di+2));
				
				String f = String.valueOf( Double.parseDouble(val)/Double.parseDouble(val2));
				
				if(var) f += AlgebraCalc.var;
				
				a1.remove(di);
				a1.remove(di);
				a1.remove(di);
				
				a1.add(di, f);
			}
		}
		return a1;
	}
	
	private static List<String> mul(List<String> a1)
	{
		boolean var = false;
		
		int mi = a1.indexOf("*")-1;
		
		if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(mi))||Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(mi))) var = true;
		
		String val= String.valueOf(Double.parseDouble(check(a1.get(mi))) * Double.parseDouble(check(a1.get(mi+2))));

		if(var) val += String.valueOf(AlgebraCalc.var);
		
		a1.remove(mi);
		a1.remove(mi);
		a1.remove(mi);
		
		a1.add(mi, val);
		
		return a1;
	}
	
	public static String check(String s)
	{
		String val = "";
		
		if(Pattern.matches("((\\-|\\+|)?[a-z])|(\\-|\\+)", s)) 
		{
			if(Pattern.matches("((\\-)[a-z]|(\\-))", s)) return String.valueOf(-1);
			else return String.valueOf(1);
		}
		else if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", s)) 
		{
			for(int j = 0; j < s.length()-1; j++) val += s.charAt(j); 
			return val;
		}
		else return s;
	}
}
