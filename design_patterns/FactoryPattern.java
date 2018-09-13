import java.lang.Math;

interface Shape {

	void calculateArea(double l);
}

class Square implements Shape {

	@Override
	public void calculateArea(double length) {
		double area = length*length;
		System.out.println("The area of the square is " + area);
	}
}

class Circle implements Shape {

	@Override
	public void calculateArea(double radius) {
		double area = Math.PI*radius*radius;
		System.out.println("The area of the circle is " + area);
	}
}

class ShapeFactory {

	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}

class ShapeDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape circle = shapeFactory.getShape("Circle");
		circle.calculateArea(7);

		Shape square = shapeFactory.getShape("SQUARE");
		square.calculateArea(5);
	}
}