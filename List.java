import java.util.Iterator;

public interface List<Item> extends Iterable<Item> {
	public void insertAtHead(Item value);
	public void insert(Item valueOfNodeToInsertAfter, Item value);
	public boolean deleteAtHead();
	public boolean delete(Item value);
	public ListNode<Item> getNode(Item value);
	public int size();
	public boolean isEmpty();	
	public Iterator<Item> iterator();
	
	class ListNode<Item> {
		ListNode(Item item) { value = item; }
		Item value;
		ListNode<Item> next;
	}	
}