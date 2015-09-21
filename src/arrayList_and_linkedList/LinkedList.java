package arrayList_and_linkedList;
public class LinkedList implements ListInterface {
	
	
	private LinkedListNode head = null;
	private LinkedListNode tail = null;
	private int listSize;
	
	private LinkedListNode currentNode = null;

	/**
	 * 
	 * This method is used to display the contents of the list. This method accesses the elements of
	 * the list by using the getFirstObject() and getNextObject() methods.
	 * 
	 */
	public void showList() {
		if (isEmpty()) {
			System.out.println("The Linked List Is Empty...");
		} else {
			System.out.print("The Linked List Contains: {" + getFirstObject());
			Object curObj = getNextObject();
			while (curObj != null) {
				System.out.print(", " + curObj);
				curObj = getNextObject();
			}
			System.out.println("}");
		}
	}
	
	public LinkedList() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return listSize;
	}
	
	@Override
	public void add(Object obj) {
		LinkedListNode newNode = new LinkedListNode(obj);
		
		// if the list is empty, the new Node becomes the head
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail = newNode;
		listSize++;
	}

	@Override
	public boolean add(Object obj, int index) {
		
		boolean rc = false;
		LinkedListNode newNode = new LinkedListNode(obj);
		LinkedListNode curNode = head;
		
		// if index is 0, put the new Node at the head of the list
		if (index == 0) {
			if (head == null) {
				tail = newNode;
			}
			newNode.setNext(head);
			head = newNode;
			listSize++;
			rc = true;
		} else if (index == size()) {
			// if the index is equal to the length of the list, attach the new
			// Node to the tail
			add(obj);
			rc = true;
		} else  if (index < size()) {
			// otherwise, if the index is valid, find the right spot to attach
			// the new Node
			for ( int j = 1  ; j < index ; j++ ) {
				curNode = curNode.getNext();
			}
			newNode.setNext(curNode.getNext());
			curNode.setNext(newNode);
			listSize++;
			rc = true;
		}
		return rc;
	}

	@Override
	public void addSorted(Object obj) {
		Comparable compObj = null, compCurElem = null;

		if (obj instanceof Comparable) {
			compObj = (Comparable) obj;
		}

		// if the list is empty, just create a new head
		if (isEmpty()) {
			add(obj);
		} else {
			LinkedListNode curNode = head;
			LinkedListNode prevNode = null;

			// find the place to insert the newNode
			while (curNode != null) {
				if (curNode.getData() instanceof Comparable) {
					compCurElem = (Comparable) curNode.getData();
				}
				
				// if the current element is less than the object
				// being inserted, keep looking
				if (compCurElem.compareTo(compObj) < 0 ) {
					prevNode = curNode;
					curNode = curNode.getNext();
					continue;
				} else {
					break;
				}
			}
			
			// if the new Node replaces the head
			if (curNode == head) {
				// the new Node replaces the head
				LinkedListNode newNode = new LinkedListNode(obj);
				newNode.setNext(head);
				head = newNode;
				listSize++;
				if (tail == null) {
					tail = newNode;
				}
			} else if (prevNode == tail) {
				// the new Node replaces the tail
				// this means it is added to end of the list
				add(obj);
			} else {
				// the new node fits somewhere in the middle
				LinkedListNode newNode = new LinkedListNode(obj);
				prevNode.setNext(newNode);
				newNode.setNext(curNode);
				listSize++;
			}
		}
	}

	@Override
	public Object getObject(int index) {
		Object obj = null;
		LinkedListNode curNode = head;
		
		if (index < size() && !isEmpty()) {
			for ( int i = 0 ; i < index ; i++) {
				curNode = curNode.getNext();
			}
			obj = curNode.getData();
		}

		return obj;
	}

	@Override
	public Object getFirstObject() {
		Object firstObject = null;
		
		if (isEmpty()) {
			currentNode = null;
		} else {
			firstObject = head.getData();
			currentNode = head.getNext();
		}
		return firstObject;
	}

	@Override
	public Object getNextObject() {
		Object nextObject = null;
		
		if (currentNode != null) {
			nextObject = currentNode.getData();
			currentNode = currentNode.getNext();
		}
		
		return nextObject;
	}

	@Override
	public boolean remove(int index) {

		boolean result = false;
		LinkedListNode curNode = head;
		LinkedListNode prevNode = null;
		
		if (index < size()) {
			if (index == 0) {
				// removing the head
				head = head.getNext();
				result = true;
			} else {
				// find the node to remove
				for ( int i = 0 ; i < index ; i++ ) {
					prevNode = curNode;
					curNode = curNode.getNext();
				}
				// remove it
				prevNode.setNext(curNode.getNext());
				if (index == (size() - 1)) {
					tail = prevNode;
				}
				result = true;
			}
			listSize--;
		}			
		
		return result;
	}

	@Override
	public void removeAll() {
		head = null;
		tail = null;
		listSize = 0;
	}
}

