package tree;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents the polymorphic tree. 
 * The implementation uses classes implementing the Tree interface to represent the
 * actual search tree. Some methods of this class has been implemented for you.
 *  
 */
public class PolymorphicBST<K extends Comparable<K>, V>  {
	Tree<K,V> root = EmptyTree.getInstance();

	/**
	 * Find the value the key is mapped to
	 * 
	 * @param k -
	 *            Search key
	 * @return value k is mapped to, or null if there is no mapping for the key
	 */
	public V get(K k) {
		return root.search(k);
	}

	/**
	 * Update the mapping for the key
	 * 
	 * @param k -
	 *            key value
	 * @param v -
	 *            value the key should be bound to
	 */
	public void put(K k, V v) {
		root = root.insert(k, v);
	}

	/**
	 * Return number of keys bound by this map
	 * 
	 * @return number of keys bound by this map
	 */
	public int size() {
		return root.size();
	}

	/**
	 * Remove any existing binding for a key
	 * 
	 * @param k -
	 *            key to be removed from the map
	 */
	public void remove(K k) {
		root = root.delete(k);
	}

	/**
	 * Return a Set of all the keys in the map
	 * 
	 * @return Set of all the keys in the map
	 */

	public Set<K> keySet() {
		Set<K> result = new HashSet<K>();
		root.addKeysToCollection(result);
		return result;
	}

	/**
	 * Return the minimum key value in the map
	 * 
	 * @return the minimum key value in the map
	 * @throws NoSuchElementException if the map is empty
	 */
	 public K getMin() {
		try {
			return root.min();
		} catch (TreeIsEmptyException e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Return the maximum key value in the map
	 * This has been implemented for you as an example of 
     * handling control flow through exceptions
	 * @return the maximum key value in the map
	 * @throws NoSuchElementException if the map is empty
	 */
	public K getMax() {
		try {
			return root.max();
		} catch (TreeIsEmptyException e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Return a string representation of the tree.  You don't need
	 * to implement this method.
	 */
	public String toString() {
		return root.toString();
	}

	/**
	 * Return subset of TreeMap between the values fromKey-toKey.  It will
	 * include fromKey and toKey if they are found in the original map.
	 * The values for fromKey and toKey do not actually need to be in the map.
	 * You can assume than fromKey is less than or equal to toKey.
	 * 
	 * @return TreeMap consisting of subset of SearchTreeMap
	 */
	public PolymorphicBST<K, V> subMap(K fromKey, K toKey) {
		PolymorphicBST<K, V> sTree = new PolymorphicBST<K, V>( );
		sTree.root = root.subTree(fromKey, toKey);
		return sTree;
	}
	
	/**
	 * Clears the tree by setting the root to EmptyTree
	 */
	public void clear() {
		root = EmptyTree.getInstance();
	}
	
	/**
	 * Returns height of the tree.
	 * @return height of the tree.
	 */
	public int height() {
		return root.height();
	}
	
	/**
	 * Performs an inorder traversal applying the task to eat tree key,value pair.
	 * @param p
	 */
	public void inorderTraversal(TraversalTask<K,V> p) {
		root.inorderTraversal(p);
	}
	
	/**
	 * Performs the specified task on the tree using a right tree, root, left tree
	 * traversal.
	 * @param p object defining task
	 */
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		root.rightRootLeftTraversal(p);
	}
}
