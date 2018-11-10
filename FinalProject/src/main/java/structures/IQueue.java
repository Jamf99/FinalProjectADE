package structures;

public interface IQueue<T>{

	public void enqueue(T element);	
	
	public T dequeue();
	
	public int size();
	
	public boolean isEmpty();
	
	public T getFront();
	
}
