package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements IQueue<T>{

	private int size;
	
	private Node<T> front, last;
	
	public Queue() {
		this.size = 0;
	}
	
	@Override
	public void enqueue(T element) {
		if(front == null) {
			front = new Node<>(element, front);
		}else {
			last.next = new Node<>(element, last);
		}
		last = new Node<>(element, last);
		size++;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is already empty");
		}else {
			T element = front.getElement();
			Node<T> remove = front;
			front = front.getNext();
			remove.next = null;
			if(front == null){
				last = null;
			}
			return element;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is already empty");
		}else {
			T element = front.getElement();
			return element;
		}
	}

	public T getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is already empty");
		}else {
			T element = last.getElement();
			return element;
		}
	}
	
	
}
