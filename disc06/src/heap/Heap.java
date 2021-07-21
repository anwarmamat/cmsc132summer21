package heap;
import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list;
    
	public Heap() {
		list = new ArrayList<E>();
	}

	//insert an item into the heap
	public void insert(E item) {
		//TODO
	}
	
	public int size() {
		return list.size();
	}

	//remove the root element from the heap and replace it with the last element in the list
	//be sure to sink the replacing element appropriately
	public E remove() {
		//TODO
	}

	//this returns the first element in the list 
	//if it exists
	public E top() {
		return list.size() > 0 ? list.get(0) : null;
	}
	
	//empties the list
	public void clear() {
		list = new ArrayList<E>();
	}
	
	//search through the heap and find if an element exists
	public boolean contains(Object o) {
		//TODO
	}
	
	//these next three methods return the index that is the parent
	//or left/right child of the index. 
	private int getParentIdx(int i) {
		//TODO
	}

	private int getLeftChildIdx(int i) {
		//TODO
	}

	private int getRightChildIdx(int i) {
		//TODO
	}
	
	//for debugging purposes
	public String toString() {
		return list.toString();
	}
}
