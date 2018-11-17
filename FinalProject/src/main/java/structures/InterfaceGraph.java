package structures;

public interface InterfaceGraph<V extends Comparable<V>, E extends Comparable<E>> {

	public void addEdge(Vertex<V> v1, Vertex<V> v2, E value);

	public void addVertex(Vertex<V> v1);

	public void removeEdge(Edge<Vertex<V>,E> e);

	public void removeVertex(Vertex<V> v);
	
	public void BFS(Vertex<V> s);
	
	public void DFS(Vertex<V> s);
	
}
