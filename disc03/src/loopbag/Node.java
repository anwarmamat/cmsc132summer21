package loopbag;

public class Node<E> implements NodeInt<E> {
	
	private NodeInt<E> next;
	private E data;
	
	public Node(E data) {
		this.data = data;
	}

	@Override
	public NodeInt<E> next() {
		return this.next;
	}

	@Override
	public E getData() {
		return this.data;
	}

	@Override
	public void setNext(NodeInt<E> next) {
		this.next = next;
	}

}
