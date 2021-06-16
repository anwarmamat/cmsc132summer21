package loopbag;

/**
 * Interface for a linked list node
 * 
 * @author Dept of Computer Science, UMCP
 * 
 * @param <E> Data type for the data stored inside the node
 */
public interface NodeInt<E> {
	/**
	 * Returns the next node in the list, if any.
	 * @return Reference to the next node in the list, or null if none.
	 */
	public NodeInt<E> next();
	
	/**
	 * Sets the next node
	 * @param next Next node to reference.
	 */
	public void setNext(NodeInt<E> next);
	
	/**
	 * Retrieve the data stored in the node. 
	 * @return Data stored in the node.
	 */
	public E getData();

}
