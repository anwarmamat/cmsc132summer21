
package loopbag;
public interface LoopBag<E> {
	
	
	
    /**
     * Adds the given item to bag LoopBag. If the bag is full, do not add the 
     * item. Be sure to add it after the last element currently in the bag.
     * @param item the item to add
     */
    void insert(E item);
    
    /**
     * Returns the number of items in this LoopBag.
     * @return the number of items in this LoopBag
     */
    int size();
    
    /**
     * Returns the maximum capacity of this LoopBag.
     * @return the maximum capacity of this LoopBag
     */
    int capacity();

    /**
     * Returns true if this LoopBag is empty; false otherwise.
     * @return true if this LoopBag is empty; false otherwise.
     **/
    boolean isEmpty();
    
    /**
    *   If the bag contains a given item?
    * @return true if bag contains the item. false otherwise
    */
    boolean contains(E item);
    
    /**
    * Creates the union with the given LoopBag and overwrite it on the calling
    * bag. That means the capacity  has to be the calling bag's capacity + the 
    * other bag's capacity. The items in the union bag must be in either one of 
    * the bags. 
    * For example, bag1 has 1,2,3; bag2 has 1,4,5. After calling union bag1 
    * should have 1,2,3,4,5. No duplicate items. Items already in the first bag
    * should not lose their order
    */
    void union(LoopBag<E> lb);
                
    /**
     * creates the intersection with the given LoopBag and overwrite it on the
     * calling bag. The condition is similar to the union method except that
     * the items must appear in both bag. For example, bag1 has 1,2,3; bag2 
     * has 1,4,5. After calling intersect, bag1 should have 1 only. The capacity
     * should not be modified, the existing elements should not lose their order.
     */
    void intersect(LoopBag<E> lb);
    
    /**
     * Returns the node specified by an index.
     * You can assume that the index will always be
     * in the range of [0, capacity-1]
     * returns Null if the element doesn't exist.
     * 
     * @param index zero-based index.
     * @return Reference the the specified node
     */
    NodeInt<E> getNode(int index);

}
