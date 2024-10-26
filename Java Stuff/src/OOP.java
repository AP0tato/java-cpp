import java.util.ArrayList;
import java.util.List;

public class OOP {
	public static void main(String[] args)
	{
	}
}

abstract class Shape
{
	List<Double> sides = new ArrayList<>();
	Shape(List<Double> sides)
	{
		this.sides = sides;
	}
	public String print()
	{
		String string = "Sides: ";
		for(double i : sides)
		{
			string += String.valueOf(i)+" ";
		}
		return string;
	}
	abstract double area();
	double perimeter()
	{
		double total = 0;
		for(double i : this.sides) total += i;
		return total;
	}
}

class Square extends Shape
{
	Square(List<Double> arr)
	{
		super(arr);
	}

	@Override
	double area() {
		double total = 1;
		for(double i : this.sides) total *= i;
		return total;
	}
	
	public boolean isSquare()
	{
		return (
				sides.get(0)==sides.get(1)&&
				sides.get(1)==sides.get(2)&&
				sides.get(2)==sides.get(3)
				);
	}
	
	@Override
	public String print()
	{
		return String.format(
				"Square:\n"
				+ "- Sides: %.2f, %.2f, %.2f, %.2f"
				+ "\n- Area: %.2f"
				+ "\n- Perimeter: %.2f"
				+ "\n- Is A Square: %s", 
				sides.get(0), sides.get(1), sides.get(2), sides.get(3), area(), perimeter(), isSquare()
				);
	}

}

class Triangle extends Shape
{
	
	Triangle(List<Double> arr)
	{
		super(arr);
	}
	
	public boolean isTriangle()
	{
		return (
				sides.get(0)+sides.get(1)>sides.get(2) &&
				sides.get(1)+sides.get(2)>sides.get(0) &&
				sides.get(0)+sides.get(2)>sides.get(1)
				);
	}
	
	@Override
	public String print()
	{
		return String.format(
				"Triangle:\n"
				+ "- Sides: %.2f, %.2f, %.2f"
				+ "\n- Area: %.2f"
				+ "\n- Perimeter: %.2f"
				+ "\n- Is A Real Triangle: %s", 
				sides.get(0), sides.get(1), sides.get(2), area(), perimeter(), isTriangle()
				);
	}

	@Override
	double area() {
		double s = perimeter()/2;
		return Math.sqrt(s*(s-sides.get(0))*(s-sides.get(1))*(s-sides.get(2)));
	}
	
}
