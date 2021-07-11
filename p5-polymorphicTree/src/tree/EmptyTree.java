package tree;

import java.util.Collection;

/**
 * This class is used to represent the empty search tree: a search tree that
 * contains no entries.
 * 
 * This class is a singleton class: since all empty search trees are the same,
 * there is no need for multiple instances of this class. Instead, a single
 * instance of the class is created and made available through the static field
 * SINGLETON.
 * 
 * The constructor is private, preventing other code from mistakenly creating
 * additional instances of the class.
 *  
 */
 public class EmptyTree<K extends Comparable<K>,V> implements Tree<K,V> {
	/**
	 * This static field references the one and only instance of this class.
	 * We won't declare generic types for this one, so the same singleton
	 * can be used for any kind of EmptyTree.
	 */
	private static EmptyTree SINGLETON = new EmptyTree();


	public static  <K extends Comparable<K>, V> EmptyTree<K,V> getInstance() {
		return SINGLETON;
	}

	/**
	 * Constructor is private to enforce it being a singleton
	 *  
	 */
	private EmptyTree() {
		// Nothing to do
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
	
    
	public K max() throws TreeIsEmptyException {
		throw new TreeIsEmptyException();
	}

	public K min() throws TreeIsEmptyException {
		throw new TreeIsEmptyException();
	}

	public int size() {
		//TODO
	}

	public void addKeysToCollection(Collection<K> c) {
		return;
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
