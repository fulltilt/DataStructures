import java.util.Iterator;

public class LinkedList<Item> implements List<Item> {
	private ListNode<Item> head;
	private int size;
	
	/*
	 * inserts new Item to the head of the List. Needed for this implementation as insert inserts only after a given Node
	 * note: can implement a Linked List with a single insert fxn that would take in a null value as a signal to add at
	 *       the head
	 */
	public void insertAtHead(Item value) {
		ListNode<Item> newNode = new ListNode<Item>(value);
		
		// case when List isn't empty
		if (head != null)
			newNode.next = head;
		
		head = newNode;		// this also handles the case when List is empty
			
		++size;
	}

	/*
	 * insert() that takes in the value of the Node to insert after. Calls private insert() that takes in the Node to insert
	 * after and the value. Calls getNode to find the Node in question. If Node isn't found, new Node isn't added to List
	 */
	public void insert(Item valueOfNodeToInsertAfter, Item value) {
		ListNode<Item> tempNode = getNode(valueOfNodeToInsertAfter);
		
		if (tempNode == null) {
			System.out.println("Unable to find Node to insert after.");
			return;
		}
		
		insert(tempNode, value);
	}

	/*
	 * insert() fxn that takes in a Node and a value of new Node that will be added after Node that's passed in.
	 * handles cases when Node to be inserted is in the middle or to be the last on the List 
	 */
	private void insert(ListNode<Item> node, Item value) {
		ListNode<Item> newNode = new ListNode<Item>(value);
		
		newNode.next = node.next;
		node.next = newNode;
		
		++size;
	}
	
	/*
	 * delete the head ListNode. Return false if the List is empty. (Like insertAtHead(), could probably implement one delete()
	 * function and if I wanted to delete the head, pass in a null value
	 */
	public boolean deleteAtHead() {
		if (size == 0) {
			System.out.println("Unable to delete from an empty List!");
			return false;
		}
		
		head = head.next;
		
		--size;
		return false;
	}

	/*
	 * delete that takes in the Item value. Calls getNode to find the Node to delete and then calls private delete which takes
	 * in the Node to delete
	 */
	public boolean delete(Item value) {
		if (size == 0) {
			System.out.println("Unable to delete from an empty List!");
			return false;
		}
		
		ListNode<Item> tempNode = getNode(value);
		if (tempNode == null) {
			System.out.println("Unable to find Node to delete.");
			return false;
		}
		
		return delete(tempNode); 
	}
	
	/*
	 * delete function that takes in a Node to delete 
	 */
	private boolean delete(ListNode<Item> node) {
		// first, find the Node previous to node
		ListNode<Item> currentNode = head;
		ListNode<Item> previousNode = head;
		
		while (currentNode != null) {
			if (currentNode == node)
				break;
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		previousNode.next = currentNode.next;
		
		--size;
		return true;
	}

	/*
	 * searches the List for a Node with a given value and returns the Node if the values match
	 */
	public ListNode<Item> getNode(Item value) {
		ListNode<Item> currentNode = head;
		
		while (currentNode != null) {
			if (currentNode.value == value)
				return currentNode;
			
			currentNode = currentNode.next;
		}
		
		return null;
	}

	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public Iterator<Item> iterator() { return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item> {
		private ListNode<Item> currentNode = head;
		
		public boolean hasNext() { return currentNode.next != null; }
		public void remove() { }
		public Item next() {
			Item tempValue = currentNode.value;
			currentNode = currentNode.next;
			return tempValue;
		}		
	}
}
