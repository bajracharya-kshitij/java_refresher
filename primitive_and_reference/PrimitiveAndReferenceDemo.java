public class PrimitiveAndReferenceDemo {

	public static void main(String[] args) {
		//only value of a is copied into b, both can be changed independently
		int a = 10;
		int b = a;

		System.out.println("At the beginning, a = " + a + " and b = " + b);

		updateValueOfB(a, b);

		System.out.println("Back in main function, value of a is still " + a + " and that of b is still " + b);

		System.out.println("\n******\n");

		//Both s1 and s2 reference to a single object, so when one changes, the other also changes
		Shape s1 = new Shape(10);
		Shape s2 = s1;

		System.out.println("At the beginning, s1.length = " + s1.length + " and s2.length = " + s2.length);

		s2.updateLength(20, s1);

		System.out.println("Back in main function, value of s1.length changed to " + s1.length + " and that of s2.length changed to " + s2.length);
	}

	public static void updateValueOfB(int a, int b) {
		System.out.println("Value received in function for a = " + a + " and b = " + b);
		b = 5;
		System.out.println("Value changed in function to b = " + b);
		System.out.println("Value of a in function is still " + a);
	}
}

class Shape {

	int length;

	Shape(int l) {
		this.length = l;
	}

	public void updateLength(int l, Shape s1) {
		System.out.println("Value received in function for s2.length = " + this.length + " and s1.length = " + s1.length);
		this.length = l;
		System.out.println("Value changed in function to s2.length = " + this.length);
		System.out.println("Value changed in function to s1.length = " + s1.length);
	}

}