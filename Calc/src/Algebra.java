import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algebra {
	public static String simplifiy(String s)
	{
		Pattern p = Pattern.compile(LinearCalc.p1);
		Matcher m = p.matcher(s);
		List<String> arr = new ArrayList<>();
		while(m.find()) arr.add(m.group());
		
		
		
		System.out.println(arr);
		return "";
	}
	
	private static List<String> bracket(List<String> a1) {
		int b1 = Integer.MAX_VALUE;
		int b2 = Integer.MAX_VALUE;
		boolean var = false;
		
		while(a1.contains("("))
		{
			b1 = a1.lastIndexOf("(")-1;
			for(int i = b1+1; i < a1.size(); i++) {if(a1.get(i).equals(")")) { b2 = i; break; }}
			
			if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(b1))) var = true;
			String tVal = AlgebraCalc.check(a1.get(b1));
			if(var) tVal += AlgebraCalc.var;
			
			List<String> a2 = new ArrayList<>();
			boolean var2;
			
			for(int i = b1+2; i < b2; i++)
			{	
				if(!Pattern.matches("(\\-|\\+|\\*|\\/)", a1.get(i)))
				{
					var2 = false;
					if(Pattern.matches("(\\-|\\+|)[0-9]*(\\.[0-9]+)?[a-z]", a1.get(i))) var2 = true;
					String tVal2 = AlgebraCalc.check(a1.get(i));
					
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
}
