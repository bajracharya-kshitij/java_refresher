import static java.lang.Math.*;
import java.lang.System.*;
import java.util.ArrayList;

/**
* These classes demonstrate the Open Closed Principle. The abstract class Shape is open for extension but closed for modification.
*/

abstract class Shape {

	public abstract double Area();
}

/* The public keyword has been removed in order to have all the classes in the same file. 
Using public keyword would require each class to be defined in its own file*/

class Circle extends Shape {

	public double radius;

	Circle(double r) {
		this.radius = r;
	}

	@Override
	public double Area() {
		return Math.PI*this.radius*this.radius;
	}

}

class Rectangle extends Shape {

	public double width;
	public double height;

	Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double Area() {
		return this.width*this.height;
	}
}

public class ShapeCalculator {

	public static void main(String[] args) {

		Shape circle = new Circle(5);
		Shape rectangle = new Rectangle(10,5);
		ArrayList<Shape> shapes = new ArrayList();
		shapes.add(circle);
		shapes.add(rectangle); 
		double totalArea = Area(shapes);
		System.out.println("The area of the circle is " + circle.Area());
		System.out.println("The area of the reactangle is " + rectangle.Area());
		System.out.println("The total area is " + totalArea);
	}

	public static double Area(ArrayList<Shape> shapes) {
		double area = 0;

		for (Shape shape : shapes) {
			area += shape.Area();
		}
		return area;
	}
}