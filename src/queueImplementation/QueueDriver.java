package queueImplementation;

import java.util.Iterator;

public class QueueDriver {

	public static void main (String[] args) {
		Queue<String> sQueue = new Queue<String>();
		
		// add several items to the queue
		try {
			sQueue.add("choudhury");
			sQueue.add("iqbal");
			sQueue.add("Is");
			sQueue.add("learning");
			sQueue.add("data structure");
			sQueue.add("During");
			sQueue.add("Spring");
			sQueue.add("2015");
		} catch (Exception e) {
			System.out.println("An Exception occured: " + e.getMessage());
			// when I catch an exception, I will exit my program
			System.exit(-1);
		}

		// get an iterator and go through the queue
		Iterator<String> it = sQueue.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
			
			// remove the item "During"
			if (s.equals("During")) {
				it.remove();
			}
		}
		System.out.println();

		// get an iterator again and go through the queue
		// this time the "During" is not there
		it = sQueue.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.print(s + " ");
		}
		System.out.println();

	}
}
