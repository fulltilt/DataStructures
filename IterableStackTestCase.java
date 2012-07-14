package algorithms.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IterableStackTestCase {
    protected static final Integer VALUE_A = 1;
    protected static final Integer VALUE_B = 2;
    protected static final Integer VALUE_C = 3;
	protected static IterableStack<Integer> stack;

    @Before
    public void createStack() {
		stack = new IterableStack<Integer>();
    }

    @Test
    public void testPushAndPop() {
    	stack.push(VALUE_B);
        stack.push(VALUE_A);
        stack.push(VALUE_C);

        assertEquals(3, stack.getSize());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_C, stack.pop());
        assertEquals(2, stack.getSize());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_A, stack.pop());
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_B, stack.pop());
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testCantPopFromAnEmptyStack() {
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    @Test
    public void testPeek() {
        stack.push(VALUE_C);
        stack.push(VALUE_A);
        assertEquals(2, stack.getSize());

        assertSame(VALUE_A, stack.peek());
        assertEquals(2, stack.getSize());
    }

	@Test
    public void testResize() {
    	assertEquals(10, stack.getStackCapacity());

    	stack.push(1);
    	stack.push(1);
    	stack.push(3);
    	stack.push(4);
    	stack.push(5);
    	stack.push(6);
    	stack.push(7);
    	stack.push(8);
    	stack.push(9);
    	stack.push(10);
    	stack.push(11);

    	assertEquals(20, stack.getStackCapacity());
    }

    @Test
    public void testCantPeekIntoAnEmptyStack() {
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());

        try {
            stack.peek();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    @Test
    public void testClear() {
        stack.push(VALUE_A);
        stack.push(VALUE_B);
        stack.push(VALUE_C);

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }
}
