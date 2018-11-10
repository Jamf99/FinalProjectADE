package structures;

public class PriorityQueueNode<T extends Comparable<? super T>, E> {

	private E element;

	private T priority;

	private PriorityQueueNode<T, E> nextNode;


	public PriorityQueueNode( T priority, E element ) {
		this.element = element;
		this.priority = priority;
		this.nextNode = null;
	}

	public E getElement( ) {
		return element;
	}

	public T getPriority( ){
		return priority;
	}

	public PriorityQueueNode<T, E> disconectFirst( ) {
		PriorityQueueNode<T, E> p = nextNode;
		nextNode = null;
		return p;
	}

	public PriorityQueueNode<T, E> insertAfter( PriorityQueueNode<T, E> node ) {
		nextNode = node;
		return node;
	}

	public PriorityQueueNode<T, E> getNext( ) {
		return nextNode;
	}

	@Override
	public String toString( ) {
		return "(" + priority.toString( ) + "," + element.toString( ) + ")";
	}
}