class SortingDemo {

	public static void main(String[] args) {
		// int[] numbers = {40,9,635,1,999,72,1056,3,19,4056,2};
		int[] numbers = new int[50];       
    	//Generates 50 Random Numbers in the range 1 -1000
	    for(int i = 0; i < numbers.length; i++) {
	      numbers[i] = (int)(Math.random()*1000 + 1);
	    }
		printNumbers("Original Numbers", numbers);
		bubbleSort(numbers);
		optimizedBubbleSort(numbers);
		selectionSort(numbers);
		optimizedSelectionSort(numbers);
	}

	static void printNumbers(String title, int[] numbers) {
		System.out.println("*******");
		System.out.println(title + ":");
		for(int n : numbers) {
			System.out.print(n + "  ");
		}
		System.out.println("");
	}

	static void bubbleSort(int[] numbers) {
		long startTime = System.nanoTime();
		for(int i=0; i<numbers.length-1;i++) {
			for(int j=0; j<numbers.length-i-1;j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		long endTime = System.nanoTime();
		printNumbers("After bubble sort", numbers);
		System.out.println("Total time taken = " + (endTime - startTime) + "ns");
	}

	static void optimizedBubbleSort(int[] numbers) {
		long startTime = System.nanoTime();
		boolean swapped;
		for(int i=0; i<numbers.length-1;i++) {
			swapped = false;
			for(int j=0; j<numbers.length-i-1;j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swapped = true;
				}
			}

			if(!swapped) {
				break;
			}
		}
		long endTime = System.nanoTime();
		printNumbers("After optimized bubble sort", numbers);
		System.out.println("Total time taken = " + (endTime - startTime) + "ns");
	}

	static void selectionSort(int[] numbers) {
		long startTime = System.nanoTime();
		for(int i=0; i<numbers.length-1;i++) {
			int min_index = i;
			for(int j=i+1; j<numbers.length;j++) {
				if(numbers[j] < numbers[min_index]) {
					min_index = j;
				}
			}
			int temp = numbers[min_index];
			numbers[min_index] = numbers[i];
			numbers[i] = temp;
		}
		long endTime = System.nanoTime();
		printNumbers("After selection sort", numbers);
		System.out.println("Total time taken = " + (endTime - startTime) + "ns");
	}

	static void optimizedSelectionSort(int[] numbers) {
		long startTime = System.nanoTime();
		boolean swapped;
		for(int i=0; i<numbers.length-1;i++) {
			swapped = false;
			int min_index = i;
			for(int j=i+1; j<numbers.length;j++) {
				if(numbers[j] < numbers[min_index]) {
					min_index = j;
					swapped = true;
				}
			}
			int temp = numbers[min_index];
			numbers[min_index] = numbers[i];
			numbers[i] = temp;

			if(!swapped) {
				break;
			}
		}
		long endTime = System.nanoTime();
		printNumbers("After optimized selection sort", numbers);
		System.out.println("Total time taken = " + (endTime - startTime) + "ns");
	}
}