package algorithms.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTestCase {
    private BinaryTree tree;

	@Before
    public void setUp() throws Exception {
		tree = new BinaryTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(8);
		tree.insert(2);
		tree.insert(7);
		tree.insert(9);
		tree.insert(10);
		tree.insert(1);
		tree.insert(3);
    }

	@Test
    public void testSearch() {
		assertEquals(true, tree.find(5));
        assertEquals(true, tree.find(4));
        assertEquals(true, tree.find(8));
        assertEquals(true, tree.find(2));
        assertEquals(true, tree.find(7));
        assertEquals(true, tree.find(9));
        assertEquals(true, tree.find(1));
        assertEquals(true, tree.find(3));
        assertEquals(true, tree.find(10));
        assertEquals(false, tree.find(11));
    }

	@Test
	public void testSize() {
		assertEquals(9, tree.getSize());
	}

	@Test
	public void testHeight() {
		assertEquals(4, tree.getHeight());
	}

    @Test
    public void testHashPathSum() {
    	assertTrue(tree.hasPathSum(14));
    	assertFalse(tree.hasPathSum(140));
    }

	@Test
	public void testIsTreeEqual() {
		BinaryTree bst2 = new BinaryTree();
		bst2.insert(5);
		bst2.insert(4);
		bst2.insert(8);
		bst2.insert(2);
		bst2.insert(7);
		bst2.insert(9);
		bst2.insert(10);
		bst2.insert(1);
		bst2.insert(3);
		assertTrue(tree.isTreeEqual(bst2.getRoot()));
	}
	
	@Test
    public void testPrintPaths() {
		System.out.println("\nprintPaths()");
		tree.printPaths();
    }
	
	@Test
    public void testPrintByLevel() {
		System.out.println("\nprintByLevel()");
		tree.printByLevel();
    }
	
	@Test
	public void testMirror() {
		System.out.println("\nmirror()");
		tree.mirror();
	}
}