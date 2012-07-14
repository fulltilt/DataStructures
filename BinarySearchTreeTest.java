import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTestCase {
    private BinarySearchTree<String> tree;

	@Before
    public void setUp() throws Exception {
		tree = new BinarySearchTree<String>();
        tree.insert("I");
        tree.insert("L");
        tree.insert("D");
        tree.insert("M");
        tree.insert("F");
        tree.insert("P");
        tree.insert("K");
        tree.insert("H");
        tree.insert("A");
        tree.print();
    }

	@Test
    public void testSearch() {
		assertEquals(true, tree.search("A"));
        assertEquals(true, tree.search("D"));
        assertEquals(true, tree.search("F"));
        assertEquals(true, tree.search("H"));
        assertEquals(true, tree.search("I"));
        assertEquals(true, tree.search("K"));
        assertEquals(true, tree.search("L"));
        assertEquals(true, tree.search("M"));
        assertEquals(true, tree.search("P"));
        assertEquals(false, tree.search("UNKNOWN"));
    }

	@Test
	public void testSize() {
		assertEquals(9, tree.getSize());
	}

	@Test
	public void testHeight() {
		assertEquals(4, tree.getHeight());
	}

/*
    @Test
    @SuppressWarnings("unchecked")
    public void testDeleteLeafTreeNode() {
        TreeNode deleted = tree.delete(h.getValue());
        assertNotNull(deleted);
        assertEquals(h.getValue(), deleted.getValue());

        f.setRightChild(null);
        assertEquals(root, tree.getRoot());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testDeleteTreeNodeWithOneChild() {
        TreeNode deleted = tree.delete(m.getValue());
        assertNotNull(deleted);
        assertEquals(m.getValue(), deleted.getValue());

        l.setRightChild(p);
        assertEquals(root, tree.getRoot());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testDeleteTreeNodeWithTwoChildren() {
        TreeNode deleted = tree.delete(i.getValue());
        assertNotNull(deleted);
        assertEquals(i.getValue(), deleted.getValue());

        i.setValue(k.getValue());
        l.setLeftChild(null);
        assertEquals(root, tree.getRoot());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testDeleteRootTreeNodeUntilTreeIsEmpty() {
        while (tree.getRoot() != null) {
            Object key = tree.getRoot().getValue();
            TreeNode deleted = tree.delete(key);
            assertNotNull(deleted);
            assertEquals(key, deleted.getValue());
        }
    }
*/
}