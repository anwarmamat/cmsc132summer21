
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root;
    private class Node{
    	
    	final static boolean RED = true;
    	final static boolean BLACK = false;
    	
        private Key key;
        private Value value;
        private boolean color;
        private Node left, right;
        public Node(Key k, Value v, boolean c){
            key = k;
            value = v;
            color = c;
        }
    }
    RedBlackTree(){
        root = null;
    }
    RedBlackTree(Node r){
        this.root = r;
    }
    
    private boolean isRed (Node nod) {
    	return (nod != null) && nod.color;
    }
    
    public void put(Key key, Value val){
        if(val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        if (root != null) root.color = Node.BLACK;
        //dumpToGraphViz();
    }
    
    private Node put(Node x, Key key, Value val){
        if(x == null) { return new Node(key,val, Node.RED);}
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {x.left = put(x.left, key, val);}
        else if (cmp > 0) {x.right = put(x.right, key, val);}
        else {x.value = val;}
        
        
        //Red-Black Tree Code
        if(isRed(x.right) && !isRed(x.left)) x = leftRotate(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rightRotate(x);
        if(isRed(x.right) && isRed(x.left)) colorFlip(x);
        
        return x;
        
    }
    
    private Node leftRotate(Node n) {
    	assert isRed(n.right);
    	
    	Node x = n.right;
    	n.right = x.left;
    	x.left = n;
    	x.color = n.color;
    	n.color = Node.RED;
    	return x;	
    }
    
    private Node rightRotate(Node n) {
    	assert isRed(n.left);
    	
    	Node x = n.left;
    	n.left = x.right;
    	x.right = n;
    	x.color = n.color;
    	n.color = Node.RED;
    	return x;	
    }
    
    private void colorFlip(Node n) {
    	assert !isRed(n);
    	assert isRed(n.right);
    	assert isRed(n.left);
    	
    	n.color = Node.RED;
    	n.left.color = Node.BLACK;
    	n.right.color = Node.BLACK;
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.value;
    }
    
    
    public void delete(Key key){
        root = delete(root, key);
    }
    
    public Value value(){
        return root.value;
    }
    public String info(){
        return root.key + "/" + root.value;
    }
    public boolean isRootRed() {
    	return root.color;
    }
    
    public RedBlackTree<Key,Value> getLeft(){
        return new RedBlackTree(root.left);
    }
    public RedBlackTree<Key, Value> getRight(){
        return new RedBlackTree(root.right);
    }
    
    private Node delete(Node x, Key k){
        if(x == null) return null;
        int cmp = k.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, k);
        else if (cmp > 0) x.right = delete(x.right, k);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
           
    }
    public void deleteMin(){
        deleteMin(root);
    }
    
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        //System.out.println("Key=" + x.key  + "\tValue=" + x.value);
        return x;
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    
    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }
    
    public Key min(){
        if(isEmpty()) return null;
        return min(root).key;
    }
    
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    
    public Key max(){
        if(isEmpty()) return null;
        return max(root).key;
    }
    
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    
    public int size(){
        return size(root);
    }
    
    private int size(Node x){
        if(x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    private int height(Node r){
        if(r == null) return -1;
        return 1 + Math.max(height(r.left), height(r.right));
    }
    public int height(){
        
        return height(root);
    }
    public boolean contains(Key key){
        return get(key) == null;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node r){
        if(r == null) return;
        System.out.print(r.key+",");
        preOrder(r.left);
        preOrder(r.right);
    }
    
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node r){
        if(r == null) return;
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.key+",");
    }
    
     public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node r){
        if(r == null) return;
        inOrder(r.left);
        System.out.print(r.key+",");
        inOrder(r.right);
    }
    
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node r){
        if( r == null) return;
        Queue<Node> q = new LinkedList();
        q.offer(r);
        while(!q.isEmpty()){
            Node t = q.poll();//pop
            System.out.print("<"+t.key+","+t.value+">");
            if(t.left != null) q.offer(t.left);
            if(t.right != null) q.offer(t.right);
        }
    }
    
    public static void insertIntoTree(RBTreeView<Integer,String> btv,
    		RedBlackTree<Integer, String> redBlackTree, int key, String value) {
    	redBlackTree.put(key, value);
        try {
			Thread.sleep(0); //This can be increased to see the tree building itself
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        btv.refresh();
    }
    
    public static void main(String[] args) {
        RedBlackTree<Integer, String> redBlackTree = new RedBlackTree<Integer, String>();
        RBTreeView<Integer,String> btv = new RBTreeView<Integer,String>(redBlackTree, 400, 400);
        String inp;
        
        insertIntoTree(btv, redBlackTree, 3, "Three");
        insertIntoTree(btv, redBlackTree, 4, "Four");
        insertIntoTree(btv, redBlackTree, 7, "Seven");
        insertIntoTree(btv, redBlackTree, 2, "Two");
        insertIntoTree(btv, redBlackTree, 1, "One");
        insertIntoTree(btv, redBlackTree, 5, "Five");
        //insertIntoTree(btv, redBlackTree, 6, "Six");
        
       
        System.out.println("done.");
        redBlackTree.preOrder();
        System.out.println("");
        redBlackTree.inOrder();
        System.out.println("");
        redBlackTree.postOrder();
        System.out.println("");
        
     }
       
}
