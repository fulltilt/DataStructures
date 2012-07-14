package algorithms.queue;

/*
 * Implementation of a Queue using arrays
 * The most tricky part of the implementation is dealing with wraparound in the enqueue & dequeue functions
 */
public class ArrayFifoQueue<Item> implements Queue<Item> {
	private Item[] queue;	// queue entries
	private int front = 0;	// position of front element of queue
	private int back = 0;   // position of next free element in queue
	private int size = 0;   // number of elements in queue
	
	/*
	 * no-arg constructor if user doesn't supply a stack size. Default is 10
	 */
	public ArrayFifoQueue() { this(10); }
	
	@SuppressWarnings("unchecked")
	public ArrayFifoQueue(int capacity) { queue = (Item[])new Object[capacity]; } 

	/*
	 * add to end of queue
	 */
	public void enqueue(Item item) {
		if (size == queue.length)
			System.out.println("Unable to insert into queue. Queue is full!");
			
		if (back == queue.length - 1)	// deal with wraparound
			back = 0;

		queue[back++] = item;		// increment rear and insert one more item
		size++;
		
	}

	/*
	 * remove first item in queue
	 */
	public Item dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException();
		
		Item item = queue[front];
		
		if (front == queue.length - 1)	// deal with wraparound
			front = 0;
		else
			++front;
		
		--size;
		return item;
	}
	
	public int getFrontIndex() { return front; }
	public int getRearIndex() { return back; }
	public void clear() { size = 0;	}
	public int getSize() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	/*	@SuppressWarnings("unchecked")
	public void resize(int newQueueCapacity) {
		Item[] newQueue = (Item[])new Object[newQueueCapacity];
		
		// copy contents from old stack to new stack
		for (int i = 0; i < queue.length; i++)
			newQueue[i] = queue[i];
		
		queue = newQueue;	// have old array refer to new, bigger array
	}
*/	
}
