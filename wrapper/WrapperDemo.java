import java.util.ArrayList;

class AutoBoxing {

	public static void main(String[] args) {
		int n = 5;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(n);
		if(numbers.get(0) instanceof Integer) {
			System.out.println("instance of Integer");
		}
	}

}

class UnBoxing {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		int n = numbers.get(0);
		System.out.println(n);
		// Results in error
		// System.out.println(n instanceof Integer);
	}

}