package queueImplementation;
/**
 * This class represents a node to be used in a Linked List
 * 
 * @author Sameh Fakhouri
 *
 */

public class LinkedListNode {

	private Object data;
	private LinkedListNode next;

	
	/**
	 * Constructor that for the Node class
	 * 
	 * @param	data	This is the data <b>Object</b> held by the LinkedListNode.
	 */
	public LinkedListNode(Object data) {
		super();
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Constructor that for the Node class
	 * 
	 * @param	data	This is the data <b>Object</b> held by the Node.
	 * @param	next	This is the pointer to the next LinkedListNode in the Linked List.
	 */
	public LinkedListNode(Object data, LinkedListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	/**
	 * Getter method to obtain a reference to the <b>Object</b> held by the LinkedListNode.
	 * 
	 * @return	The <b>Object</b> held by the Node.
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * Setter method to set the reference to the <b>Object</b> held by the LinkedListNode.
	 * 
	 * @param	data	The reference to the <b>Object</b> to be held by the LinkedListNode.
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	/**
	 * Getter method to obtain a reference to the next LinkedListNode in the Linked List.
	 * 
	 * @return	The next LinkedListNode in the Linked List.
	 */
	public LinkedListNode getNext() {
		return next;
	}
	
	/**
	 * Setter method to set the reference to the next LinkedListNode in the Linked List.
	 * 
	 * @param	next	The reference to the next LinkedListNode in the Linked List.
	 */
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
