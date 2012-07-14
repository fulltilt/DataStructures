package algorithms.stack;

import java.util.Iterator;

public class IterableStack<Item> implements Iterable<Item> {
	private int MAX_SIZE = 10;
	private Item[] stack;
	private int size;

	public IterableStack() { this(10); }

	@SuppressWarnings("unchecked")
	public IterableStack(int max) {
		MAX_SIZE = max;
		size = 0;
		stack = (Item[]) new Object[MAX_SIZE];
	}

	public Item pop() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();

		return stack[--size];
	}

	public void push(Item item) {
		if (size == MAX_SIZE)
			resize(MAX_SIZE * 2);	// if stack if full and an attempt to push is made, resize the stack size to twice the original

		stack[size++] = item;	// when the stack is full, the size will be equal to the capacity of the stack
	}

	public Item peek() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException();

		return stack[size - 1];
	}

	/*
	 * if an item is attempted to pushed on a full stack, create a new stack that is twice the original size, copy items
	 * from old stack to new stack and have old stack refer to the new one
	 */
	@SuppressWarnings("unchecked")
	public void resize(int newStackCapacity) {
		MAX_SIZE = newStackCapacity;

		Item[] newStack = (Item[])new Object[MAX_SIZE];

		// copy contents from old stack to new stack
		for (int i = 0; i < stack.length; i++)
			newStack[i] = stack[i];

		stack = newStack;	// have old array refer to new, bigger array
	}


	// 1.3.12
	public static IterableStack<String> copy(IterableStack<String> stack) {
		//Iterator<String> iter = stack.iterator();
		IterableStack<String> stackCopy = new IterableStack<String>();

		for (String s : stack)
			stackCopy.push(s);

		return stackCopy;
	}

	public int getSize() { return size; }
	public boolean isEmpty() { return size == 0; }
	public int getStackCapacity() { return MAX_SIZE; }
	public void clear() { size = 0; }

	public Iterator<Item> iterator() { return new StackIterator(); }
	private class StackIterator implements Iterator<Item> {
		private int currentIndex = 0;

		public boolean hasNext() { return currentIndex < size; }
		public void remove()  { }
		public Item next() {
			Item item = stack[currentIndex++];
			return item;
		}
	}

	public static void main(String[] args) {
		IterableStack<Integer> is = new IterableStack<Integer>(5);
		is.pop();
		System.out.println(is.peek());
		is.push(1);
		is.push(2);
		is.push(3);
		is.push(4);
		is.push(5);
		is.push(6);
		System.out.println(is.peek());

		Iterator<Integer> iter = is.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println();

		/*** test of copy() ***/
		IterableStack<String> is2 = new IterableStack<String>(5);
		is2.push("a");
		is2.push("b");
		is2.push("c");
		is2.push("d");
		is2.push("e");
		IterableStack<String> is3 = IterableStack.copy(is2);//new IterableStack<String>(5);

		Iterator<String> iter2 = is3.iterator();
		while (iter2.hasNext())
			System.out.print(iter2.next() + " ");
		System.out.println();
	}
}