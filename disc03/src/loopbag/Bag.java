package loopbag;

public class Bag<E> implements LoopBag<E>{
	private int N; // number of items in the bag
	private NodeInt<E> first;
	private NodeInt<E> last;
	private int capacity;

	public Bag(int capacity){
		first = null;
		last = null;
		N = 0;
		this.capacity = capacity;
	}

	@Override
	public String toString(){ //leave as-is
		NodeInt<E> cur = first;
		StringBuilder s = new StringBuilder();
		while(cur != null){
			s.append(cur.getData());
			s.append(",");
			cur = cur.next();
		}
		return s.toString();
	}

	@Override
	public void insert(E item) {
		//TODO
	}

	@Override
	public int size() {
		//TODO
	}

	@Override
	public int capacity() {
		//TODO
	}

	@Override
	public boolean isEmpty() {
		//TODO
	}

	@Override
	public boolean contains(Object item) {
		//TODO
	}

	@Override
	public void union(LoopBag<E> lb) {
		//TODO
	}

	@Override
	public void intersect(LoopBag<E> lb) {
		//TODO
	}
	
	@Override
	public NodeInt<E> getNode(int index) {
		//TODO
	}

}
