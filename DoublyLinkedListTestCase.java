import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class DoublyLinkedListTestCase {
	protected static final String VALUE_A = "A";
	protected static final String VALUE_B = "B";
	protected static final String VALUE_C = "C";
	protected static DoublyLinkedList<String> list;

	@Before
	public void createList() {
		list = new DoublyLinkedList<String>();
	}

	@Test
	public void testInsertIntoEmptyList() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.insertAtHead(VALUE_A);

		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
	}

	@Test
	public void testInsertBetweenElements() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_B);
		list.insert(VALUE_A, VALUE_C);

		assertEquals(3, list.size());

		Iterator<String> iter = list.iterator();
		assertEquals("A", iter.next());
		assertEquals("C", iter.next());
		assertEquals("B", iter.next());
	}

	@Test
	public void testInsertBeforeFirstElement() {
		list.insertAtHead(VALUE_A);
		list.insertAtHead(VALUE_B);


		assertEquals(2, list.size());
		Iterator<String> iter = list.iterator();
		assertEquals("B", iter.next());
		assertEquals("A", iter.next());
	}

	@Test
	public void testInsertAfterLastElement() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_B);

		assertEquals(2, list.size());
		Iterator<String> iter = list.iterator();
		assertEquals("A", iter.next());
		assertEquals("B", iter.next());
	}

	@Test
	public void testDeleteOnlyElement() {
		list.insertAtHead(VALUE_A);

		assertEquals(1, list.size());

		Iterator<String> iter = list.iterator();
		assertSame(VALUE_A, iter.next());

		list.delete(VALUE_A);
		assertEquals(0, list.size());
	}

	@Test
	public void testDeleteFromEmptyList() {
		assertFalse(list.delete(null));
	}

	@Test
	public void testDeleteFirstElement() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_B);
		list.insert(VALUE_B, VALUE_C);

		assertEquals(3, list.size());
		Iterator<String> iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_B, iter.next());
		assertSame(VALUE_C, iter.next());

		list.delete(VALUE_A);

		assertEquals(2, list.size());
		iter = list.iterator();
		assertSame(VALUE_B, iter.next());
		assertSame(VALUE_C, iter.next());
	}

	@Test
	public void testDeleteLastElement() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_B);
		list.insert(VALUE_B, VALUE_C);

		assertEquals(3, list.size());
		Iterator<String> iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_B, iter.next());
		assertSame(VALUE_C, iter.next());

		list.delete(VALUE_C);

		assertEquals(2, list.size());
		iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_B, iter.next());
	}

	@Test
	public void testDeleteMiddleElement() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_C);
		list.insert(VALUE_C, VALUE_B);

		assertEquals(3, list.size());
		Iterator<String> iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_C, iter.next());
		assertSame(VALUE_B, iter.next());

		list.delete(VALUE_C);

		assertEquals(2, list.size());
		iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_B, iter.next());
	}

	@Test
	public void iterateBackwards() {
		list.insertAtHead(VALUE_A);
		list.insert(VALUE_A, VALUE_B);
		list.insert(VALUE_B, VALUE_C);

		assertEquals(3, list.size());
		Iterator<String> iter = list.iterator();
		assertSame(VALUE_A, iter.next());
		assertSame(VALUE_B, iter.next());
		assertSame(VALUE_C, iter.next());

		iter = list.reverseIterator();
		assertEquals("C", iter.next());
		assertEquals("B", iter.next());
		assertEquals("A", iter.next());
	}
}
