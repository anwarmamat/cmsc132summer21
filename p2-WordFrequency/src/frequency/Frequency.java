/*
* This class counts the word frequency
 */
package frequency;

import java.util.Iterator;

/**
 * @author UMD CS
 * CMSC132 Summer 2021
 */
public class Frequency<E extends Comparable> implements Iterable<E>{
    private Node first;	//starting node
    private Node parent;	//parent of currently processed node
    private int N;	//number of words
    
    /**
     * Linked List Node
     */
    private class Node implements Comparable<Node>{
    	private E key;
    	private int count;
        private Node next;
        /**
         * 	Constructor
         */
        Node(E e){
           key = e;
           count = 1;
           next = null;
        }
        /**
         * 	Constructor
         */
        Node(E e, Node r){
            key = e;
            count = 1;
            next = r;
         }
        
        @Override 
        public String toString(){
        	return "("+key +","+count+")";
        }
		@Override
		public int compareTo(Frequency<E>.Node o) {
			return 0;
		}
		
    }

   /**
    * Inserts a word into linked list
    * @param key to be insterted 
    * @return true if the key is inserted successfully.
    */
    public boolean insert(E key){
		//TODO
    	return true;
	}
    
   /**
    * removes the nodes with given key
    * @param key: 
    * @return the deleted node
    */
    private Node remove(E key){
		//TODO
    	return null;
	}

    /**
     * Inserts a node into correct location in the linked list
     * @param r is the node to be inserted
     * @return true if successful
     */
    private boolean insert(Node r){
		//TODO
    	return true;
	}
    
    
    /**
     * @param k is the key to be searched for
     * @return the node that has the word as its key
     */
    private Node find(E k){
		//TODO
    	return null;
	}
    
    /**
     * @return true all the nodes are sorted, otherwise return false
     * 
     */
    public boolean isValid() {
    	if(first == null || first.next == null)
    		return true;
    	Node c = first;
    	while(c.next != null) {
    		if(c.count < c.next.count || (
    					c.count == c.next.count	&& c.key.compareTo(c.next.key) >= 0 )
    				) {
    			return false;
    		}
    		c = c.next;
    	}
    	return true;
    }
    
    /**
     * 
     * @param key is the key to be searched for
     * @return frequency of the key. Returns -1 if key does not exist
     * 
     */
    public int getCount(E key){
		//TODO
    	return 0;
	}
    /**
     * Returns the first n words and count
     * @param n number of words to be returned
     * @return first n words in (word, count) format
     */
    public String getWords(int n){
		//TODO
    	return null;
	}
    
    
    /**
     * Frequency List iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new FreqIterator();
    }
    
    /**
     * 
     * Frequency List iterator class
     *
     */
    private class FreqIterator implements Iterator<E>{
      @Override
      public boolean hasNext() {
		//TODO
    	  return true;
	}
      @Override
      public E next() {
		//TODO
    	  return null;
	}
    }
}
    
