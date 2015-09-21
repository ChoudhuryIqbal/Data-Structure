
package arrayList_and_linkedList;
/**
 * 
 * This class is the driver program for
 * <a href="http://comet.lehman.cuny.edu/sfakhouri/teaching/cmp/cmp338/s15/hw/hw3.html">Homework 3</a>
 * of CMP-338
 * in the Spring 2015 semester.
 * 
 * @author Sameh Fakhouri
 *
 */
public class Driver {

	private final static int FIRST_NUMBER = 1;
	private final static int LAST_NUMBER = 100000;

	private final static int FIRST_ODD_NUMBER = FIRST_NUMBER;
	private final static int LAST_ODD_NUMBER = LAST_NUMBER - 1;

	private final static int FIRST_EVEN_NUMBER = FIRST_NUMBER + 1;
	private final static int LAST_EVEN_NUMBER = LAST_NUMBER;

	private final static int NUMBER_OF_TEST_CASES = 10;

	private final static long BYTES_IN_MEGABYTE = 1024L * 1024L;
	
	private static enum ListTypes {ArrayList, LinkedList};
	
	private static enum TestTypes {AddSorted, Add, AddWithIndex, RemoveWithIndex};

	private static long[] runTimes = new long[NUMBER_OF_TEST_CASES];
	
	/**
	 * 
	 * This method is called by the createTestList() method to initialize the test list. The test list could either
	 * be an ArrayList or a LinkedList. In either case, it will implement the ListInterface. 
	 * 
	 * @param 	testList	The testList to be initialized.
	 * @param 	firstNumber	The first number to be added to the list.
	 * @param 	lastNumber	The last number to be added to the list
	 * @param 	increment	The increment to be used by the for loop for each iteration. If the increment is zero, the
	 * 						test list is left empty.
	 * @return	The initialized test list.
	 * @see		createTestList()
	 * 
	 */
	public static ListInterface initializeTestList (ListInterface testList,  int firstNumber, int lastNumber, int increment) {
		testList.removeAll();

		if (increment != 0) {
			for (int i = firstNumber; i <= lastNumber; i += increment) {
				testList.add(new Integer(i));
			}
		}
		return testList;
	}
	
	/**
	 * 
	 * This method is called by the runTestCase() method to obtain a test list. The test list could either 
	 * be an ArrayList or a LinkedList. In either case, it will implement the ListInterface.
	 * 
	 * @param 	listType	The type of list needed. This can either be an ArrayList or a LinkedList.
	 * @param 	firstNumber	The first number to be added to the list.
	 * @param 	lastNumber	The last number to be added to the list
	 * @param 	increment	The increment to be used by the for loop for each iteration. If the increment is zero, the
	 * 						test list is left empty.
	 * @return	The created and initialized test list.
	 * 
	 */
	public static ListInterface createTestList(ListTypes listType, int firstNumber, int lastNumber, int increment) {
		ListInterface testList = null;
		
		switch (listType) {
		case ArrayList:
			ArrayList arrayList = new ArrayList(LAST_NUMBER);
			testList = arrayList;
			break;
		case LinkedList:
			LinkedList linkedList = new LinkedList();
			testList = linkedList;
			break;
		}
		testList = initializeTestList(testList, firstNumber, lastNumber, increment);
		
		return testList;
	}

	/**
	 *
	 * This method is called to display the contents of the test list. The test list could either 
	 * be an ArrayList or a LinkedList. In either case, it will implement the ListInterface.
	 * 
	 * @param 	li	The test list that should be displayed.
	 * 
	 */
	public static void showList(ListInterface li) {
		if (li instanceof ArrayList) {
			ArrayList al = (ArrayList)li;
			al.showList();
		} else if (li instanceof LinkedList) {
			LinkedList ll = (LinkedList)li;
			ll.showList();
		}
	}
	
	/**
	 * 
	 * This method is called by the various test case methods to display the header for the test case along with the column
	 * titles for the run time measurements.
	 * 
	 * @param	title	A String containing the description of the test case.
	 * 
	 */
	public static void showHeader(String title) {
		System.out.println();
		System.out.println();
		System.out.println(title);
		System.out.printf("\t\t%11s\t%11s\t%11s\t%11s\t%11s\t%11s\t%11s\t%11s\t%11s\t%11s\t%14s\t%20s\t%17s\n",
						"Run 1", "Run 2", "Run 3", "Run 4", "Run 5",
						"Run 6", "Run 7", "Run 8", "Run 9", "Run 10",
						"Average", "Standard Deviation", "Memory Usage (MB)");
	}
	
	
	/**
	 * 
	 * This method is used to calculate the amount of memory being used in the JVM currently.
	 * 
	 * @return	a <code>double</code> representing the amount of memory in kilobytes currently allocated in
	 * 			the JVM.
	 */
	public static double memoryUsage() {
		double usedMemory;

		Runtime rt = Runtime.getRuntime();
		usedMemory = (double) (rt.totalMemory() - rt.freeMemory())/BYTES_IN_MEGABYTE;

		// tell Java virtual machine to run the garbage collector
		System.gc();
		System.gc();
		System.gc();
		
		return usedMemory;
	}
	
	
	/**
	 * 
	 * This method is called by the runTestCase() method to check for the end of condition of the for loop.
	 * 
	 * @param 	runCurrentNumber	The current loop counter variable
	 * @param 	runLastNumber		The end number for the for loop
	 * @param 	runIncrement		The increment of the for loop. If the increment is positive, the method
	 * 								checks for runCurrentNumber > runLastNumber. If the increment is negative,
	 * 								the method checks for runCurrentNumber < runLastNumber.
	 * 							
	 * @return						true if for loop should end, or false if the for loop should continue.
	 * 	
	 */
	public static boolean runDone(int runCurrentNumber, int runLastNumber, int runIncrement) {
		boolean answer;
		
		if (runIncrement > 0) {
			answer = runCurrentNumber > runLastNumber;
		} else {
			answer = runCurrentNumber < runLastNumber;
		}
		
		return answer;
	}
	
	/**
	 * 
	 * This method is called by the various test methods to run a particular test case. The type of test and its
	 * specifics are all specified by the parameters. 
	 * 
	 * @param 	testType		The type of test case being run. The choices are:
	 * 							<ol>
	 * 								<li>AddSorted</li>
	 * 								<li>Add</li>
	 * 								<li>AddWithIndex</li>
	 * 								<li>RemoveWithIndex</li>
	 * 							</ol>
	 * @param 	initFirstNumber	When creating a new test list, this parameter specifies the first number
	 * 							to start populating the test list with.
	 * @param 	initLastNumber	When creating a new test list, this parameter specifies the last number
	 * 							to populate the test list with.
	 * @param 	initIncrement	The increment to be used by the for loop for each iteration. If the increment is zero, the
	 * 							test list is left empty.
	 * @param 	runFirstNumber	When running the test case, this parameter specifies the first number used by the test case.
	 * @param 	runLastNumber   When running the test case, this parameter specifies the last number used by the test case.
	 * @param 	runIncrement	When running the test case, this parameter specifies the increment used for the for loop.
	 * 
	 */
	public static void runTestCase(TestTypes testType, 
									int initFirstNumber, int initLastNumber, int initIncrement, 
									int runFirstNumber, int runLastNumber, int runIncrement) {
		ListInterface testList = null;
		long startTime;
		
		for (ListTypes listType : ListTypes.values()) {
			System.out.print(listType + "\t");
			for (int testCase = 0; testCase < NUMBER_OF_TEST_CASES; testCase++) {
				testList = createTestList(listType, initFirstNumber, initLastNumber, initIncrement);

				startTime = System.nanoTime();
				for (int i = runFirstNumber; !runDone(i, runLastNumber, runIncrement) ; i += runIncrement) {
					switch(testType) {
					case AddSorted:
						testList.addSorted(new Integer(i));
						break;
					case Add:
						testList.add(new Integer(i));
						break;
					case AddWithIndex:
						testList.add(new Integer(i), 0);
						break;
					case RemoveWithIndex:
						testList.remove(i);
						break;
					}
				}
				runTimes[testCase] = System.nanoTime() - startTime;
				System.out.printf("%11d\t", runTimes[testCase]);
			}
			System.out.printf("%14.2f\t%20.2f\t%17.2f\n", Statistics.average(runTimes), Statistics.standardDeviation(runTimes), memoryUsage());
//			showList(testList);
			testList = null;
		}
	}
	
	/**
	 * 
	 * This test case is for inserting all the odd numbers into an empty list. The odd numbers are added
	 *  using the addSorted(Object obj) method of the ListInterface.
	 *  
	 */
	public static void addSortedOddNumbers() {
		showHeader("Adding odd numbers from " + FIRST_ODD_NUMBER + " to " + LAST_ODD_NUMBER + " using addSorted(Object obj) to an empty list");
		runTestCase(TestTypes.AddSorted, 0, 0, 0, FIRST_ODD_NUMBER, LAST_ODD_NUMBER, 2);
	}
	
	/**
	 * 
	 * This test case is for inserting all the even numbers into a list containing only odd numbers. The even 
	 * numbers are added using the addSorted(Object obj) method of the ListInterface.
	 * 
	 */
	public static void addSortedEvenNumbers() {
		showHeader("Adding even numbers from " + FIRST_EVEN_NUMBER + " to " + LAST_EVEN_NUMBER + " using addSorted(Object obj) to a list containing odd numbers");
		runTestCase(TestTypes.AddSorted, FIRST_ODD_NUMBER, LAST_ODD_NUMBER, 2, FIRST_EVEN_NUMBER, LAST_EVEN_NUMBER, 2);
	}

	/**
	 * 
	 * This test case is for inserting all the numbers into an empty list. The numbers are added using the add(Object obj) 
	 * method of the ListInterface.
	 * 
	 */
	public static void add() {
		showHeader("Adding all numbers from " + FIRST_NUMBER + " to " + LAST_NUMBER + " using add(Object obj) to an empty list");
		runTestCase(TestTypes.Add, 0, 0, 0, FIRST_NUMBER, LAST_NUMBER, 1);
	}

	/**
	 * 
	 * This test case is for inserting all the numbers into an empty list. The numbers are added using the 
	 * add(Object obj, int index) method of the ListInterface.
	 * 
	 */
	public static void addWithIndex() {
		showHeader("Adding all numbers from " + LAST_NUMBER + " to " + FIRST_NUMBER + " using add(Object obj, 0) to an empty list");
		runTestCase(TestTypes.AddWithIndex, 0, 0, 0, LAST_NUMBER, FIRST_NUMBER, -1);
	}

	/**
	 * 
	 * This test case is for removing all the even numbers from a list containing all the numbers.
	 * The numbers are removed starting with the smallest even number and using the
	 * removeObject(int index) method of the ListInterface.
	 * 
	 */
	public static void removeEvenNumbers() {
		showHeader("Removing all the even numbers starting with " +  FIRST_EVEN_NUMBER + ", " + (FIRST_EVEN_NUMBER + 2) + ", ... using remove(int index) from a full list");
		runTestCase(TestTypes.RemoveWithIndex, FIRST_NUMBER, LAST_NUMBER, 1, FIRST_ODD_NUMBER, LAST_ODD_NUMBER, 1);
	}
	
	/**
	 * 
	 * This test case is for removing all the odd numbers from a list containing all the numbers.
	 * The numbers are removed starting with the largest odd number and using the 
	 * removeObject(int index) method of the ListInterface.
	 * 
	 */
	public static void removeOddNumbers() {
		showHeader("Removing all the odd numbers starting with " + LAST_ODD_NUMBER + ",  " + (LAST_ODD_NUMBER - 2) + ", ... using remove(int index) from a full list");
		runTestCase(TestTypes.RemoveWithIndex, FIRST_NUMBER, LAST_NUMBER, 1, LAST_NUMBER - 2, FIRST_NUMBER - 1, -2);
	}
	
	/**
	 * 
	 * The main method executes all the test cases.
	 * 
	 */
	public static void main(String[] args) {
		addSortedOddNumbers();
		addSortedEvenNumbers();
		add();
		addWithIndex();
		removeEvenNumbers();
		removeOddNumbers();
	}
}
