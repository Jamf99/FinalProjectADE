package exceptions;

public class EmptyQueueException extends Exception {

	public EmptyQueueException() {
		super("The queue is already empty");
	}
	
}