package structures;

public interface IStack<T> {

	public void push(T element);
	
	public T pop();
	
	public boolean isEmpty();
	
	public T getTop();
	
}
