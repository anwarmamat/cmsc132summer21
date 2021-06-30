package functions;

// DO NOT MODIFY
public class Node{
	
	  public Node next;
	  public int value;

      // Recursively generates linked list from array
	  public Node(int[] data) {
		  this(data, 0);
	  }
	  
	  private Node(int[] data, int index) {
		  this.value = data[index];
		  if (data.length - 1 == index) {next = null; return;}
		  this.next = new Node(data, index + 1);
	  }
}
