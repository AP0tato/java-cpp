import java.util.regex.*;
import java.util.*;

public class RegX 
{
	public static void main(String[] args)
	{
		Regex_Test email = new Regex_Test(), domain = new Regex_Test(), name = new Regex_Test();
		email.checker("^[a-zA-Z0-9]+@[a-zA-Z]+\\.\\D{3}$");
		domain.checker("^[a-zA-Z0-9]+\\.\\D{3}$");
		name.checker("^M[rs|r|s|me]|Dr\\. [A-Z][a-z]+$");
	}
}

class Regex_Test
{
	public void checker(String Regex_Pattern)
	{
		@SuppressWarnings("resource")
		Scanner In = new Scanner(System.in);
		String Test_String = In.nextLine();
		Pattern p = Pattern.compile(Regex_Pattern);
		Matcher m = p.matcher(Test_String);
		if(m.find())
		{
			System.out.println("It Matches.");
		}
		else
		{
			System.out.println("It Doesn't Match");
		}
	}
}
