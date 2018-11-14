package structures;

import java.util.ArrayList;

public interface InterfaceGraph<V, E> {

	public V getVertex(int v);

	public E getEdge(int e);

	public void addEdge(E e, int v2);

	public void addVetex(V v1);

	public void removeEdge(E e);

	public void removeVertex(V v);

	public ArrayList<V> BFS(V v);

	public ArrayList<V> DFS(V v);

	public ArrayList<E> Dijstra(V v);

	public GraphList<V, E> Kruskal(V v);

	public GraphList<V, E> Prim(V v);

	public ArrayList<E> floydWarshall(V v);

	public boolean IsUndirected();
}
