package structures;

public class PriorityQueue<T extends Comparable<? super T>, E> implements IPriorityQueue<T, E> {

	private PriorityQueueNode<T, E> first;

	private PriorityQueueNode<T, E> last;

	private int weight;

	public PriorityQueue() {
		first = null;
		last = null;
		weight = 0;
	}

	public int getWeight() {
		return weight;
	}

	public E takeElement() throws EmptyQueueException {
		if( first == null )
			throw new EmptyQueueException();
		else
		{
			PriorityQueueNode<T, E> p = first;
			first = first.disconectFirst();
			if( first == null )
				last = null;
			weight--;
			return p.getElement();
		}
	}

	public void insert(T priority, E element) {
		PriorityQueueNode<T, E> node = new PriorityQueueNode<T, E>(priority, element);
		if(first == null) {
			first = node;
			last = node;
		}
		else if(first.getPriority().compareTo( priority ) < 0) {
			node.insertAfter(first);
			first = node;
		}
		else {
			boolean inserted = false;
			for(PriorityQueueNode<T, E> p = first; !inserted && p.getNext() != null; p = p.getNext()) {
				if(p.getNext().getPriority().compareTo(priority) < 0) {
					node.insertAfter(p.getNext());
					p.insertAfter(node);
					inserted = true;
				}
			}
			if(!inserted) {
				last = last.insertAfter(node);
			}
		}
		weight++;
	}

	public PriorityQueueNode<T, E> getFirst() {
		return first;
	} 
	
	public PriorityQueueNode<T, E> getLast() {
		return last;
	}

	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public String toString( ) {
		String resp = "[" + weight + "]:";
		for(PriorityQueueNode<T, E> p = first; p != null; p = p.getNext()) {
			resp += "->" + p.toString();
		}
		return resp;
	}

}
