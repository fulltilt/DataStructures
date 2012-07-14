package algorithms.model;

import java.util.*;

public class HashTable {
	private DataItem[] hashArray; 	// array holds hash table
	
	public HashTable(int size) {
		hashArray = new DataItem[size];
		for (int i = 0; i < hashArray.length; i++)
			hashArray[i] = null;
	}
	
	// Linear Probing
	public void insert(DataItem item) {		// assumes table not full
		int key = item.data;				// extract key
		int hashValue = hashFunction(key);	// hash the key until empty cell or -1
		
		while (hashArray[hashValue] != null) {
			++hashValue;					// go to next cell
			hashValue %= hashArray.length;	// wraparound if necessary
		}
		
		hashArray[hashValue] = item;		// insert item
	}
	
	DataItem remove(int key) {
		int hashValue = hashFunction(key);	// hash the key
		
		while (hashArray[hashValue] != null) { 	// until empty cell, found the key?
			if (hashArray[hashValue].data == key) {
				DataItem temp = hashArray[hashValue];	// save item
				hashArray[hashValue] = null;			// delete item
				return temp;							// return item
			}
			
			++hashValue;						// go to next cell
			hashValue %= hashArray.length;		// wraparound if necessary
		}
		
		return null;
	}
	
	DataItem find(int key) {
		int hashValue = hashFunction(key);	// hash the key
		
		while (hashArray[hashValue] != null) { 	// until empty cell, found the key?
			if (hashArray[hashValue].data == key) 
				return hashArray[hashValue];	// return item
			
			++hashValue;						// go to next cell
			hashValue %= hashArray.length;		// wraparound if necessary
		}
		
		return null;
	}
	
	int hashFunction(int key) { return key % hashArray.length; }
	
	void displayTable() {
		System.out.println("Table: ");
		
		for (int i = 0; i < hashArray.length; i++) {
			if (hashArray[i] != null)
				System.out.print(hashArray[i].data + " ");
			else
				System.out.print("** ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(10);
		
		Random intGenerator = new Random();
		for (int i = 0; i < 5; i++) 
			hashTable.insert(new DataItem(intGenerator.nextInt(20) + 1));
		
		hashTable.displayTable();
		
		hashTable.insert(new DataItem(31));
		
		hashTable.displayTable();
		
		DataItem d = hashTable.find(31);
		System.out.println(d.data);
		d = hashTable.find(100);			// 100 is not in hash table so expect to output 'null'
		System.out.println(d);
		
		hashTable.remove(31);
		
		hashTable.displayTable();
	}
}

class DataItem {
	int data;
	DataItem(int d) { data = d; }
}