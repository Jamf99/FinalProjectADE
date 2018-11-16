package structures;

public class Edge<V, E extends Comparable<E>> implements Comparable<Edge<V,E>>{

	private E value;
	private V ending;

	public Edge(V ending, E value) {
		this.value = value;
		this.ending = ending;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public V getEnding() {
		return ending;
	}

	public void setEnding(V ending) {
		this.ending = ending;
	}

	@Override
	public int compareTo(Edge<V, E> o) {
		return value.compareTo(o.getValue());
	}

}