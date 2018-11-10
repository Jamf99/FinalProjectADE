package structures;

import java.util.NoSuchElementException;

public class Stack<T> implements IStack<T>{
	
	private int length;

	private Node<T> top;
	
	public Stack() {
		this.length = 0;
	}

	public int getLength() {
		return length;
	}
	
	@Override
	public void push(T element) {
		if(element != null) {
			this.top = new Node<T>(element, top);
			this.length++;
		}
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("The stack is already empty");
		}else {
			T element = top.getElement();
			top = top.getNext();
			length--;
			return element;
		}
	}
	
	@Override
	public T getTop() {
		if(isEmpty()) {
			throw new NoSuchElementException("The stack is already empty");
		}else {
			T element = top.getElement();
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		if(length == 0) {
			return true;
		}
		return false;
	}

}
