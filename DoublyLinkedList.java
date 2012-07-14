import java.util.Iterator;

public class DoublyLinkedList<Item> {
	private ListNode<Item> head;
	private ListNode<Item> tail;
	private int size;

	public void insertAtHead(Item value) {
		ListNode<Item> newNode = new ListNode<Item>(value);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}

		++size;
	}

	public void insert(Item valueOfNodeToInsertAfter, Item value) {
		ListNode<Item> tempNode = getNode(valueOfNodeToInsertAfter);
		if (tempNode == null) {
			System.out.println("Unable to find Node to insert after.");
			return;
		}

		insert(tempNode, value);
	}

	private void insert(ListNode<Item> node, Item value) {
		ListNode<Item> newNode = new ListNode<Item>(value);

		newNode.next = node.next;
		newNode.previous = node;
		node.next = newNode;

		// for the case when newNode is the last item on the List
		if (newNode.next != null)
			newNode.previous = newNode;
		else
			tail = newNode;

		++size;
	}

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

	private boolean delete(ListNode<Item> node) {
		if (node == head) {			// case when Node to be deleted is the head
			if (head.next == null)	// List of size 1
				head = tail = null;
			else {
				head.next.previous = null;
				head = head.next;
			}
		} else {									// case when Node is in the middle or last element
			node.previous.next = node.next;

			if (node.next != null) {				// case when Node to be deleted is the last element
				node.next.previous = node.previous;
				tail = node.previous;
			}
		}

		--size;
		return true;
	}

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
	public Iterator<Item> reverseIterator() { return new ReverseListIterator(); }

	private class ListIterator implements Iterator<Item> {
		ListNode<Item> currentNode = head;

		public boolean hasNext() { return currentNode.next != null; }
		public void remove() { }
		public Item next() {
			Item tempValue = currentNode.value;
			currentNode = currentNode.next;
			return tempValue;
		}
	}

	private class ReverseListIterator implements Iterator<Item> {
		ListNode<Item> currentNode = tail;

		public boolean hasNext() { return currentNode.previous != null; }
		public void remove() { }
		public Item next() {
			Item tempValue = currentNode.value;
			currentNode = currentNode.previous;
			return tempValue;
		}
	}

	private class ListNode<T> {
		ListNode(Item item) { value = item; }
		Item value;
		ListNode<Item> previous;
		ListNode<Item> next;
	}
}
