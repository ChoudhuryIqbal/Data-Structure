package linear_and_Binary_Search;

/**
 * This program will make a linear search and binarysearch method 
 * and show its implementation to find our some numbers and 
 * also list their respective time to retrive the numbers
 * @author Choudhury_Iqbal
 *
 */




public class Search {
	public static void main (String [] args){
		long startTime, endTime, duration;
		double data[] = new double[11];
		int test[] = new int[10000000];
		//populate our array with fillarray method
		fillArray(test, 10000000);
		//creating an array of the number we are looking for
		int keys[] = {500,10000,100000,1000000,5000000,7000000,10000000};
		int keyIndex = 0;
		
		while(keyIndex < keys.length){
			int tries = 0;
			System.out.println("Binary Search for "+ keys[keyIndex]);	
			
			while(tries < 10){
				
				System.out.print("Trial"+" "+(tries+1)+"\t");
				duration=-1;
				tries ++;
			}
			System.out.print("Average " + "\t");
			System.out.println("\t"  +"     Standard Deviation " );
		
			for (int i=0;i<10;i++){
				startTime = System.nanoTime();
				int x = binarySearchRecursive(keys[keyIndex], test, 0, test.length - 1);
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				data[i]=duration;
				System.out.print(duration+"" +"\t");
			}
			Statistics results = new Statistics(data);
			System.out.print( "  "+"\t"+results.getMean());
			System.out.println("" +"\t"+"\t"+results.getStdDev() );
			System.out.println();
			System.out.println();
			System.out.println("Linear Search for "+ keys[keyIndex]);
			tries = 0;
			while(tries < 10){ 
				
				System.out.print("Trial"+" "+(tries+1)+"\t"+"\t");
				
				tries ++;
			}
			
			results = new Statistics(data);
			System.out.print("Average " + "\t");
			System.out.println("\t"+"\t"+"Standard Deviation " );
			for (int j=0;j<10;j++){
				startTime = System.nanoTime();
				int x = linearSearchIterative(keys[keyIndex], test, 0);
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				
				data[j] = duration;
				System.out.print(duration+"    "+"\t");
				
				tries ++;
				
			}
			System.out.print( "  "+"\t"+results.getMean());
			System.out.println("          " +results.getStdDev() );
			System.out.println();
			System.out.println();
			keyIndex ++;
			
		}		
	}
	
	//Binary search algorithm applying recursion technique 
	//used prinltln statement to see the implementation Later I commented it
	
	public static int binarySearchRecursive(int key, int list[], int min, int max){
		//System.out.print(key + "\t" + min + "\t" + max);
		if(max < min){
			return -1;
		}
		else{
			int mid = min + ((max - min) / 2);
			//System.out.println("\t" + mid +"\t" + list[mid]);
			if(list[mid] < key){
				return binarySearchRecursive(key, list, mid + 1, max);
			}
			else if(list[mid] > key){
				return binarySearchRecursive(key, list, min, mid - 1);
			}
			else{
				return mid;
			}
		}		
	}
	
	//Linear search algorithm applying iteration.
	
	public static int linearSearchIterative(int key, int list[], int start){
		while(start < list.length){
			//System.out.println(start + "\t" + list[start]);
			if(list[start] == key){
				return start;
			}
			else{
				start++;
			}
		}		
		return -1;
	}
	
	//Function to populate the array
	public static void fillArray(int test[], int length){
		int index = 0;
		while(index < length){
			test[index] = index;
			index ++;
		}
	}
}