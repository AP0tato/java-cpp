import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String...args)
	{
		//Scanner in = new Scanner(System.in);
		//String s = in.nextLine();
		//in.close();
		String s = "-10 -(2y - 9) = 4";
		
		String s1 = "10 +1 *(9 - 1) /2";
		
		String s3 = "2x + 5x +3y";
		
		List<String> a1 = new ArrayList<>();
		String s2 = "2x - 3y = -15";
		String s21 = "5x -22 = -y"; //(3, 7)
		a1.add(s2);
		a1.add(s21);
		
		//System.out.println(Algebra.simplifiy(s3));
		//System.out.println(LinearCalc.parseLinear(a1));
		System.out.println(Calc.parse(s1));
		//System.out.println(AlgebraCalc.parseA(s));
	}
}