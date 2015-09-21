package compare_among_bubbleSort_selectionSort_and_insertionSort;
import java.util.Random;

public class Sorting {
	public static void main(String [] args){
		System.out.println("Sorting Using Bubble Sort");
		performTests(10000, 0);
		performTests(100000, 0);
		System.out.println("Sorting Using Selection Sort");
		performTests(10000, 1);
		performTests(100000, 1);
		System.out.println("Sorting Using Insertion Sort");
		performTests(10000, 2);
		performTests(100000, 2);
		
	}
	
	public static void performTests(int length, int algorithm){
		long startTime, endTime, duration;
		int tries = 0;
		double data[] = new double[10];
		
		System.out.println("List of " + length + " Identical Numbers");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			int list[] = generateIdenticalNumbers(length);
			startTime = System.nanoTime();
			if(algorithm == 0){
				bubbleSort(list);
			}else if(algorithm == 1){
				selectionSort(list);
			}else{
				insertionSort(list);
			}			
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("List of " + length + " Random Numbers");
		System.out.println("Trial\tDuration");		
		while(tries < 10){
			int list[] = generateRandomNumbers(length);
			startTime = System.nanoTime();
			if(algorithm == 0){
				bubbleSort(list);
			}else if(algorithm == 1){
				selectionSort(list);
			}else{
				insertionSort(list);
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("List of " + length + " Increasing Numbers");
		System.out.println("Trial\tDuration");		
		while(tries < 10){
			int list[] = generateIncreasingNumbers(length);
			startTime = System.nanoTime();
			if(algorithm == 0){
				bubbleSort(list);
			}else if(algorithm == 1){
				selectionSort(list);
			}else{
				insertionSort(list);
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("List of " + length + " Decreasing Numbers");
		System.out.println("Trial\tDuration");	
		while(tries < 10){
			int list[] = generateDecreasingNumbers(length);
			startTime = System.nanoTime();
			if(algorithm == 0){
				bubbleSort(list);
			}else if(algorithm == 1){
				selectionSort(list);
			}else{
				insertionSort(list);
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);
		
		tries = 0;
		System.out.println("List of " + length + " Increasing and Random Numbers");
		System.out.println("Trial\tDuration");		
		while(tries < 10){
			int list[] = generateNumbers(length);
			startTime = System.nanoTime();
			if(algorithm == 0){
				bubbleSort(list);
			}else if(algorithm == 1){
				selectionSort(list);
			}else{
				insertionSort(list);
			}
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println(tries + "\t" + duration);
			data[tries] = duration;
			tries ++;
		}
		displayStatistics(data);		
	}
	
	public static void displayStatistics(double [] data){
		Statistics results = new Statistics(data);
		System.out.println("Average: " + results.getMean());
		System.out.println("Standard Deviation: " + results.getStdDev() + "\n");
	}
	
	
	/*Display the Array After eah Iteration*/
	private static void printArray(int [] list){
		for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println("\n");
	}

	/* Bubble Sort Algorithm*/	
	public static void bubbleSort(int list[]){
		int arrayLength = list.length;
		
		int k;
		for (int m = arrayLength; m >= 0; m--){
			for( int i = 0; i < arrayLength - 1; i++){
				k = i + 1;
				if( list[i] > list[k]){
					swapNumbers(i, k, list);
				}
			}
			//printArray(list);
		}		
	}
	
	private static void swapNumbers(int i, int j, int [] list){
		int temp;		
		temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/*Selection Sort Algorithm*/
	public static void selectionSort(int [] list){
		 
		for (int i = 0; i < list.length - 1; i++){
			int index = i;
			for( int k = i; k < list.length; k++){
				if(list[k] < list[index]){
					index = k;
				}
			}
			int smallNumber = list[index];
			list[index] = list[i];
			list[i] = smallNumber;
			//printArray(list);
		}
	}
	
	/*Insertion Sort Algorithm*/
	public static void insertionSort(int [] list){
		
		int temp;
		for (int i = 1; i < list.length; i++){
			for( int j = i; j > 0; j--){
				if (list[j] < list[j - 1]){
					temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;	
				}
			}
			//printArray(list);
		}		
	}
	
	/* Generate an array with the given length and populate with 5*/
	public static int [] generateIdenticalNumbers(int length){
		int list[] = new int[length];
		
		for (int i = 0; i < length; i++){
			list[i] = 5;
		}
		return list;
	}
	
	/* Generate an array with the given length and populate with numbers in increasing order*/
	public static int [] generateIncreasingNumbers(int length){
		int list[] = new int[length];
		
		for (int i = 0; i < length; i++){
			list[i] = i;
		}
		return list;
	}
	
	/* Generate an array with the given length and populate with numbers in decreasing order*/
	public static int [] generateDecreasingNumbers(int length){
		int list[] = new int[length];
		
		for (int i = length - 1; i >= 0; i--){
			list[length - i - 1] = i;
		}
		return list;
	}
	
	/* Generate an array with the given length and populate with random numbers*/
	public static int [] generateRandomNumbers(int length){
		int list[] = new int[length];
		
		for (int i = 0; i < length; i++){
			Random random = new Random();
			list[i] = random.nextInt(length);
		}
		return list;
	}
	
	/* Generate an array with the given length and populate with Increasing and Random Numbers*/
	public static int [] generateNumbers(int length){
		int list[] = new int[length];
		
		int i = 0;
		for (i = 0; i < length - 100; i++){
			list[i] = i;
		}
		
		for (int j = 0; j < 100; j++){
			Random random = new Random();
			list[j + i] = random.nextInt(length);
		}
		return list;
	}
	
	
}
