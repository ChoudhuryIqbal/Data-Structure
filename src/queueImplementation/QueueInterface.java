package queueImplementation;
import java.util.NoSuchElementException;

/**
 * 
 * Generic interface for a FIFO queue. 
 * 
 * 
 *
 * @param	<E>		The type of Object that the queue will accept.
 * 
 */

public interface QueueInterface<E> extends Iterable<E> {

	/**
	 * This method is called to determine if the queue is empty.
	 * 
	 * @return 	Returns <b>true</b> if the list is empty, otherwise it returns <b>false</b>. 
	 */
	public boolean isEmpty();
	
	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of <b>Object</b>s that are currently in the list.
	 */
	public int size();

	/**
	 * 
	 * Inserts the specified element into this queue if it is possible to do so immediately without 
	 * violating capacity restrictions, returning true upon success and throwing an IllegalStateException 
	 * if no space is currently available.
	 * 
	 * @param 	e	The element to add.
	 * 
	 * @return	<code>true</code> if the element was successfully added.
	 * 
	 * @throws 	IllegalStateException	If the element cannot be added at this time due to capacity restrictions.
	 * @throws 	ClassCastException		If the class of the specified element prevents it from being added to this queue.
	 * @throws 	NullPointerException	If the specified element is null and this queue does not permit null elements.
	 * 
	 */
	public boolean add(E e) throws IllegalStateException, ClassCastException, NullPointerException;
	
	/**
	 * 
	 * Retrieves, but does not remove, the head of this queue.
	 * 
	 * @return	The head of the queue.
	 * 
	 * @throws NoSuchElementException	If the queue is empty.
	 * 
	 */
	public E element() throws NoSuchElementException;	
	
	/**
	 * 
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return	The head of the queue.
	 * 
	 * @throws NoSuchElementException	If the queue is empty.
	 * 
	 */
	public E remove() throws NoSuchElementException;
	
	/**
	 * 
	 * Retrieves and removes the element at the specified index.
	 * 
	 * @param	index	The index of the element to be removed.
	 * 
	 * @return	The element at the specified index.
	 * 
	 * @throws NoSuchElementException	If the queue is empty.
	 * 
	 */
	public E remove(int index) throws NoSuchElementException;

	/**
	 * 
	 * Removes all elements from the queue.
	 * 
	 */
	public void removeAll();
}
