package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */
	private Tree<K,V> left, right;
	private K key;
	private V value;

	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
 */
	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) { 
		//TODO
	}

	public V search(K key) {
		//TODO
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) {
		//TODO
	}
	
	public Tree<K, V> delete(K key) {
		//TODO
	}

	public K max() {
        //TODO
	}

	public K min() {
		//TODO
	}

	public int size() {
		//TODO
	}

	public void addKeysToCollection(Collection<K> c) {
		left.addKeysToCollection(c);
		c.add(key);
		right.addKeysToCollection(c);
	}
	
	public Tree<K,V> subTree(K fromKey, K toKey) {
		//TODO
	}
	
	public int height() {
		//TODO
	}
	
	public void inorderTraversal(TraversalTask<K,V> p) {
		//TODO
	}
	
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		//TODO
	}
	
}
