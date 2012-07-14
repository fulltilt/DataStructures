package algorithms.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FifoQueueTestCase {
	private static final Integer VALUE_A = 1;
	private static final Integer VALUE_B = 2;
	private static final Integer VALUE_C = 3;
	protected static Queue<Integer> _queue;

	@Before
	public void createStack() {
		_queue = new ArrayFifoQueue<Integer>();
	}

	@Test
	public void testAccessAnEmptyQueue() {
		assertEquals(0, _queue.getSize());
		assertTrue(_queue.isEmpty());

		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}

	@Test
	public void testEnqueueDequeue() {
		_queue.enqueue(VALUE_B);
		_queue.enqueue(VALUE_A);
		_queue.enqueue(VALUE_C);

		assertEquals(3, _queue.getSize());
		assertFalse(_queue.isEmpty());

		assertSame(VALUE_B, _queue.dequeue());
		assertEquals(2, _queue.getSize());
		assertFalse(_queue.isEmpty());

		assertSame(VALUE_A, _queue.dequeue());
		assertEquals(1, _queue.getSize());
		assertFalse(_queue.isEmpty());

		assertSame(VALUE_C, _queue.dequeue());
		assertEquals(0, _queue.getSize());
		assertTrue(_queue.isEmpty());

		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}

	@Test
	public void testWrapAround() {
		_queue.enqueue(1);
		_queue.enqueue(2);
		_queue.enqueue(3);
		_queue.enqueue(4);
		_queue.enqueue(5);
		_queue.enqueue(6);
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());
		_queue.dequeue();
		_queue.dequeue();
		_queue.dequeue();
		_queue.dequeue();
		_queue.dequeue();
		_queue.dequeue();
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());
		/* front = rear = 6; size = 0 */
		_queue.enqueue(1);
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());
		_queue.enqueue(2);
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());
		_queue.enqueue(3);
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());
		_queue.enqueue(4);
		System.out.println(_queue.getFrontIndex() + " " + _queue.getRearIndex());

		assertEquals(6, _queue.getFrontIndex());
		assertEquals(1, _queue.getRearIndex()); // never 0 because inside enqueue(), rear is set to zero and then incremented
		assertEquals(4, _queue.getSize());
	}

	@Test
	public void testClear() {
		_queue.enqueue(VALUE_A);
		_queue.enqueue(VALUE_B);
		_queue.enqueue(VALUE_C);

		assertFalse(_queue.isEmpty());

		_queue.clear();

		assertEquals(0, _queue.getSize());
		assertTrue(_queue.isEmpty());

		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}
}
