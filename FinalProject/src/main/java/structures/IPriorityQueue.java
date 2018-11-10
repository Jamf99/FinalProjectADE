package structures;

import exceptions.EmptyQueueException;

public interface IPriorityQueue<T extends Comparable<? super T>, E> {

	int getWeight();

	E takeElement() throws EmptyQueueException;

	void insert(T priority, E element);

	PriorityQueueNode<T, E> getFirst();

	PriorityQueueNode<T, E> getLast();

	boolean isEmpty();

}
