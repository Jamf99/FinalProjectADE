package structures;

import java.util.ArrayList;

public interface InterfaceGraph<V, E> {

	public V getVertex();

	public E getEdge();

	public void addEdge(E e, V v1, V v2);

	public void addVetex(V v1);

	public void removeEdge(E e);

	public void removeVertex(V v);

	public ArrayList<V> BFS(V v);

	public ArrayList<V> DFS(V v);

	public ArrayList<E> Dijstra(V v);

	public GraphList Kruskal(V v);

	public GraphList Prim(V v);

	public ArrayList<E> floydWarshall(V v);

	public boolean IsUndirected();
}
