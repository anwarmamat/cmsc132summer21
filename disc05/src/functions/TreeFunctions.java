package functions;
/*
* You do not have to use recursion, however it is highly encouraged
* that you use it as it would be good practice
*/
public class TreeFunctions {

	private TreeNode root;
	
	public TreeFunctions(TreeNode root) {
		this.root = root;
	}
	/* Returns the largest value in the tree. 
	 * You can assume the tree has no negative values
	 * The tree is not sorted in anyway. 
	 * if the tree is empty/null, return -1
	 * The max of this tree is 9
	 *		5
	 * 	   / \
	 * 	  2	  8
	 *   / \   \
	 *  1  3    9  
	 */
	public int findMax() {
		//TODO
	}
	
	/* Returns true if this tree is symmetric in shape, false otherwise. 
	 * An empty tree is symmetric. 
	 * The data in the nodes doesn't need to match, just the shape.
	 * Examples of symmetric trees:
	 * 		5
	 * 	   / \
	 * 	  2	  8
	 *   / \ / \
	 *  1  3 6  9
	 *  
	 *  	5
	 * 	   / \
	 * 	  2	  8
	 *     \ /  
	 *     3 6 
	 * Example of a non-symmetric tree:
	 *		5
	 * 	   / \
	 * 	  2	  8
	 *   / \   \
	 *  1  3    9  
	 */
	public boolean isSymmetric() {
		//TODO
	}
	/*
	 * Return the lowest common ancestor of these two numbers. 
	 * Return -1 if either of the numbers don't exist in the tree. 
	 * Example:
	 * 		5
	 * 	   / \
	 * 	  2	  8
	 *   / \ / \
	 *  1  3 6  9
	 *  LowestCommonAncestor(1, 3) is 2
	 *  LowestCommonAncestor(1, 6) is 5
	 *  LowestCommonAncestor(1, 2) is 2
	 *  LowestCommonAncestor(2, 8) is 5
	 */
	public int LowestCommonAncestor(int a, int b) {
		//TODO
	}
	
	
	/*
	 * Checks to see if the other tree is a mirror of this tree
	 * unlike isSymmetric(), values *DO* matter
	 * Example:
	 * Tree a:
	 * 		  5
	 * 	   / \
	 * 	  2	  8
	 *       / \
	 *       6  9
	 * Tree b:
	 *  	  5
	 * 	   / \
	 * 	  8	  2
	 *   / \  
	 *  9   6 
	 * returns true
	 * 
	 * But Tree a:
	 * 		  5
	 * 	   / \
	 * 	  3	  2
	 * Tree b:
	 * 		  2
	 * 	   / \
	 * 	  5   3
	 * returns false
	 */
	public boolean mirror(TreeFunctions t) {
		//TODO
	}
}
