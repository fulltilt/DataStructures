public class BinarySearchTree<Item extends Comparable<Item>> {
	private Node<Item> root;

	public boolean insert(Item value) { return recursiveInsert(root, value); }
	private boolean nonrecursiveInsert(Node<Item> node, Item value) {
		if (node == null) {
			root = new Node<Item>(value);
			return true;
		}

		Node<Item> currentNode = root;
		while (currentNode != null) {
			if (value.compareTo(currentNode.value) == 0)
				return false;
			else if (value.compareTo(currentNode.value) < 0) {
				if (currentNode.leftChild == null) {
					currentNode.leftChild = new Node<Item>(value);
					break;
				}
				currentNode = currentNode.leftChild;
			} else {
				if (currentNode.rightChild == null) {
					currentNode.rightChild = new Node<Item>(value);
					break;
				}
				currentNode = currentNode.rightChild;
			}


			/* the following won't work
			 * if (currentNode == null) {
				currentNode = new Node<Item>(value);
				break;
			}*/
		}

		return true;
	}

	private boolean recursiveInsert(Node<Item> node, Item value) {
		if (node == null) {
			root = new Node<Item>(value);
			return true;
		}

		if (value.compareTo(node.value) == 0)
			return false;
		else if (value.compareTo(node.value) < 0) {
			if (node.leftChild == null) {
				node.leftChild = new Node<Item>(value);
				return true;
			}
			return recursiveInsert(node.leftChild, value);
		} else {
			if (node.rightChild == null) {
				node.rightChild = new Node<Item>(value);
				return true;
			}
			return recursiveInsert(node.rightChild, value);
		}
	}

	//public boolean delete(Item item) { return false; }

	public boolean search(Item value) { return recursiveSearch(root, value); }
	private boolean nonrecursiveSearch(Node<Item> node, Item value) {
		Node<Item> currentNode = node;
		while (currentNode != null) {
			if (value.compareTo(currentNode.value) == 0)
				return true;
			else if (value.compareTo(currentNode.value) < 0)
				currentNode = currentNode.leftChild;
			else
				currentNode = currentNode.rightChild;
		}

		return false;
	}

	private boolean recursiveSearch(Node<Item> node, Item value) {
		if (node == null)
			return false;

		if (value.compareTo(node.value) == 0)
			return true;
		else if (value.compareTo(node.value) < 0)
			return recursiveSearch(node.leftChild, value);
		else
			return recursiveSearch(node.rightChild, value);
	}

	public int getSize() { return getSize(root); }
	private int getSize(Node<Item> node) {
		if (node == null)
			return 0;

		return 1 + getSize(node.leftChild) + getSize(node.rightChild);
	}

	public int getHeight() { return getHeight(root); }
	private int getHeight(Node<Item> node) {
		if (node == null)
			return 0;

		return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
	}

	public void print() {
		print(root);
	}

	private void print(Node<Item> node) {
		if (node == null)
			return;

		print(node.leftChild);
		System.out.println(node.value + " ");
		print(node.rightChild);
	}

	private class Node<T> {
		Node(Item item) { value = item; }
		Item value;
		Node<Item> leftChild;
		Node<Item> rightChild;
	}
}
