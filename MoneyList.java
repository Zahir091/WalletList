

public class MoneyList {

	/** First node in linked list - dummy node */
	private MoneyNode first = new MoneyNode(null);

	/** Last node in linked list */
	private MoneyNode last = first;

	/** Number of data items in the list. */
	private int length = 0;

	/**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	public int getLength() {
		return length;
	}

	/**
	 * Appends a String data element to this LinkedList.
	 * 
	 * @param data
	 *            the data element to be appended.
	 */
	public void append(Money d) {
		MoneyNode newNode = new MoneyNode(d); //Creating a new list node with whatever the input is
		last.next = newNode; //Making the dummy node point to our new node, next is a pointer instance variable we created in ListNode
		last = newNode; //Setting our last node to be the new Node we created
		length++; //Track of our # of nodes
	} // method append(String)

	/**
	 * Prepends (adds to the beginning) a String data element to this
	 * LinkedList.
	 * 
	 * @param data
	 *            the data element to be prepended.
	 */
	
	public void prepend(Money d) {
		MoneyNode newNode = new MoneyNode(d); //Creating a new list node
		newNode.next = first.next; //Making that new node point to whatever first node is pointing to
		/*
		 *The first node can be pointing to null which means theres no other nodes in here
		 *Or the First node can be pointing to another node which is already in the list*/
		 
		first.next = newNode; //Now we make first(dummy) node point to our newNode b/c we want the dummy node to be the start of the list
		
		if(last == first) //if they are the same reference in the memory
			last = newNode; //Then the last node in our linkedList must be the new node since the dummy node must be first
	} // method append(String)

	/**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	
	// So when you do System.out.print(var) it automatically triggers a toString() method, however here we are overriding it to make it act in our favor to print a whole list
	public String toString() {
		MoneyNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " ";
			p = p.next;
		}
		return returnString;
	}

	/**
	 * Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.
	 * 
	 * @param other
	 *            the object to be compared to this ShortSequenceLinkedList
	 * 
	 * @return <code>true</code> if the parameter object is a
	 *         ShortSequenceLinkedList containing the same numbers at each index
	 *         as this ShortSequenceLinkedList, <code>false</code> otherwise.
	 */
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((MoneyList) other).length)
			return false;

		MoneyNode nodeThis = first;
		MoneyNode nodeOther = ((MoneyList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (nodeThis.data != nodeOther.data)
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals
	
	public String sum() {
		int sb = 0, sc = 0;
		MoneyNode p = first.next;
		while(p!=null) {
			if(p.data instanceof Bill)
				sb += ((Bill)p.data).getValue();
			else 
				sc += ((Coin)p.data).getValue();
			p = p.next;
		}
		sb = sb + sc/100;
		sc = sc%100;
		String ans = sb+"."+sc;
		return ans;	
	}
	
} // class LinkedList