package arrayList_and_linkedList;
public class ArrayList implements ListInterface {
	
	private final int DEFAULT_MAX_ARRAY_LIST = 100000;
	
	private int tail = 0;
	private Object[] arrayList;

	private final int INVALID_POSITION = -1;
	private int currentPosition = INVALID_POSITION;
	
	
	public ArrayList() {
		arrayList = new Object[DEFAULT_MAX_ARRAY_LIST];
	}
	
	public ArrayList(int size) {
		arrayList = new Object[size];
	}
	
	private void moveElementsToAdd(int begin, int end) {
		for ( int i = end ; i >= begin ; i-- ) {
			arrayList[i+1] = arrayList[i];
		}
	}
	
	private void moveElementsToRemove(int begin, int end) {
		for ( int i = begin ; i <= end ; i++ ) {
			arrayList[i-1] = arrayList[i];
		}
	}

	/**
	 * 
	 * This method is used to display the contents of the list. This method accesses the elements of
	 * the list by using the getFirstObject() and getNextObject() methods.
	 * 
	 */
	public void showList() {
		if (isEmpty()) {
			System.out.println("The Array List Is Empty...");
		} else {
			System.out.print("The Array List Contains: {" + getFirstObject());
			Object curObj = getNextObject();
			while (curObj != null) {
				System.out.print(", " + curObj);
				curObj = getNextObject();
			}
			System.out.println("}");
		}
	}
	
	
	
	@Override
	public boolean isEmpty() {
		if (tail == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return tail;
	}

	@Override
	public void add(Object obj) {
		if (tail < arrayList.length) {
			arrayList[tail++] = obj;
		}
	}

	@Override
	public boolean add(Object obj, int index) {
		if ((index <= tail) && (tail < arrayList.length)) {
			moveElementsToAdd(index, tail-1);
			arrayList[index] = obj;
			tail++;
			return true;
		}
		return false;
	}

	@Override
	public void addSorted(Object obj) {
		Comparable compObj = null, compCurElem = null;

		if (obj instanceof Comparable) {
			compObj = (Comparable) obj;
		}
		
		if (isEmpty()) {
			add(obj);
		} else {
			int curIndex = 0;
			
			// find the place to insert the newNode
			for ( curIndex = 0 ; curIndex < tail ; curIndex++ ) {
				if (arrayList[curIndex] instanceof Comparable) {
					compCurElem = (Comparable) arrayList[curIndex];
				}

				if (compCurElem.compareTo(compObj) < 0 ) {
					continue;
				} else {
					break;
				}
			}
				
			if (curIndex < tail) {
				moveElementsToAdd(curIndex, tail);
			}
			arrayList[curIndex] = obj;
			tail++;
		}

	}

	@Override
	public Object getObject(int index) {
		if (index < tail) {
			return arrayList[index];
		}
		return null;
	}

	@Override
	public Object getFirstObject() {
		if (!isEmpty()) {
			currentPosition = 1;
			return arrayList[0];
		}
		return null;
	}

	@Override
	public Object getNextObject() {
		if ((currentPosition != INVALID_POSITION) &&
				(currentPosition < tail)) {
			return arrayList[currentPosition++];
		} else {
			currentPosition = INVALID_POSITION;
		}
		return null;
	}

	@Override
	public boolean remove(int index) {
		if (index < tail) {
			moveElementsToRemove(index+1, tail-1);
			tail--;
			return true;
		}
		return false;
	}

	@Override
	public void removeAll() {
		tail = 0;
		currentPosition = INVALID_POSITION;
	}

}
