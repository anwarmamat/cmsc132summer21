package functions;
//DO NOT TOUCH THIS CLASS
public class TreeNode{
	TreeNode left;
	TreeNode right;
	int data;
	
	public TreeNode(int data) {
		this.data = data;
	}
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public static String inOrder(TreeNode a) {
		if(a == null) return "";
		else return inOrder(a.left).trim() + " " + a.data + " " + inOrder(a.right).trim();
	}
}
