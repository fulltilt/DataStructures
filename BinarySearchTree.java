import java.util.*;

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

    public void nonRecursivePreorder() {
        nonRecursivePreorder(root);
    }
    private void nonRecursivePreorder(Node root) {
        /*
         * visual what's going on with the recursive solution. It uses stacks so simulate this process
         * using stacks. The trick to this algorithm is for every node you visit, push the right child
         * and then push the left child (assuming these nodes aren't null)
         */
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.empty()) {
            Node currentNode = stack.pop();
            System.out.println(currentNode.value);
            if (currentNode.rightChild != null)
                stack.push(currentNode.rightChild);
            if (currentNode.leftChild != null)
                stack.push(currentNode.leftChild);
        }
    }   
    
    public Node findLowestCommonAncestor(int val1, int val2) { return findLowestCommonAncestor(root, val1, val2); }
    private Node findLowestCommonAncestor(Node node, int val1, int val2) {
        /*
         * algorithm doesn't work for binary trees as this takes advantage of special property of BST's
         */
        if (node == null)
            return null;
            
        while (node != null) {    
            if (node.value > val1 && node.value > val2)
                node = node.leftChild;
            else if (node.value < val1 && node.value < val2)
                node = node.rightChild;
            else 
                return node;
        }
    }
        
    publ    ic int getSize() { return getSize(root); }
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
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(20);
        bst.insert(8);
        bst.insert(22);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);
    }
}
