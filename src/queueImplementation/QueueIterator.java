package queueImplementation;
import java.util.Iterator;


public class QueueIterator<E> implements Iterator<E> {

	private E[] entries;
	private QueueInterface<E> theQueue;
	private int index = 0;
	
	public QueueIterator(E[] entries, QueueInterface<E> theQueue) {
		this.entries = entries;
		this.theQueue = theQueue;
	}
	
	
	@Override
	public boolean hasNext() {
		return index < entries.length;
	}

	@Override
	public E next() {
		return entries[index++];
	}

	@Override
	public void remove() {
		theQueue.remove(index - 1);
	}

}
