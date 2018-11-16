package structures;

public class Vertex<V extends Comparable<V>> {

	private V value;
	
	public Vertex(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}

}