package structures;

import java.util.ArrayList;

public class GraphList<V, E> implements InterfaceGraph<V, E> {

	public Edge<E> edge;
	public Vertex<V> vertex;

	@Override
	public V getVertex() {
		return null;
	}

	@Override
	public E getEdge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(E e, V v1, V v2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVetex(V v1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEdge(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVertex(V v) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<V> BFS(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> DFS(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<E> Dijstra(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphList<V, E> Kruskal(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphList<V, E> Prim(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<E> floydWarshall(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean IsUndirected() {
		// TODO Auto-generated method stub
		return false;
	}

}
