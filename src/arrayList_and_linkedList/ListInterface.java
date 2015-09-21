
package arrayList_and_linkedList;
/**
 * This interface indicates the public methods that need to be implemented for arraylist and linkedlist
 * 
 * 
 * 
 * @author Choudhury iqbal
 *
 */

public interface ListInterface {
	
	/**
	 * This method is called to determine if the list is empty.
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
	 * This method is called to add the specified object to the end of the list.
	 * 
	 * @param 	obj		A reference to the object to be added to the end of the list.
	 * 					All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void add(Object obj);
	
	/**
	 * This method is called to add the specified object to the list at the given index.
	 * 
	 * @param 	obj		A reference to the object to be added to the list. 
	 * 					All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @param 	index 	Indicates the position at which to add the specified object.
	 * 					Using and index = 0, indicates that the object being added should
	 * 					become the <b>head</b> of the list and should succeed even if
	 * 					the list is currently empty.
	 * 
	 * @return 	Returns <b>true</b> if the object was successfully added at the given index.
	 * 			If the given index is invalid, this method returns <b>false</b>, indicating
	 * 			that the specified object was not added to the list.
	 * 
	 * @see		java.lang.Comparable
	 */
	public boolean add(Object obj, int index);

	/**
	 * This method is called to add the specified object to the list in sorted order. More
	 * specifically, the objects preceding the specified object must be "less than" the
	 * specified object, and the objects following the specified object must be "greather
	 * that or equal to" the specified object.
	 * 
	 * @param 	obj 	A reference to the <b>Object</b> being added, in sorted order, 
	 * 					to the list.
	 * 					All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void addSorted(Object obj);
		
	/**
	 * This method is called to retrieve the object at the specified index.
	 * 
	 * @param 	index	Indicates the position from which to retrieve the object.
	 * 
	 * @return	Returns a reference to the <b>Object</b> at the given index, or <b>nullL</b>
	 * 			if the given index is invalid.
	 */
	public Object getObject(int index);
	
	/**
	 * This method is called to obtain the first object in the list. Calling this method initializes
	 * an internal private variable to allow stepping through the list. 
	 * 
	 * @return	Returns a reference to the first <b>Object</b> in the list, or <b>null</b> if
	 * 			the list is empty.
	 * 
	 * @see		#method getNextObject()
	 */
	public Object getFirstObject();
	
	/**
	 * This method is called to obtain the next object in the list. This method should not be called,
	 * unless getFirstObject() has been called. When this method returns <b>null</b> it automatically
	 * ends the stepping through the list.
	 * 	
	 * @return	Returns a reference to the next <b>Object</b> in the list. Or, <b>null</b> if there
	 * 			are no more objects in the list. This method also returns <b>null</b> if getFirstObject()
	 * 			was not called.
	 *  
	 * @see		#method getFirstObject()
	 */
	public Object getNextObject();

	/**
	 * This method is called to remove the object at the specified index
	 * 
	 * @param 	index	Indicates the position from which to remove the object.
	 * 
	 * @return	Returns <b>true</b> if the object was successfully removed from the given index, 
	 * 			or <b>false</b> if the given index is invalid.
	 */
	public boolean remove(int index);
	
	
	/**
	 * This method removes all objects from the list, making the list empty.
	 */
	public void removeAll();
	
}
