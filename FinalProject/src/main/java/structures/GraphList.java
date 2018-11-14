package structures;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphList<V, E> implements InterfaceGraph<V, E> {
	private boolean directed;
	private HashMap<Integer, V> graphVertex;
	private HashMap<Integer, E> graphEdge;

	@Override
	public V getVertex(int v) {
		return graphVertex.get(v);
	}

	public GraphList(boolean directed) {
		super();
		this.directed = directed;
		graphVertex = new HashMap<Integer, V>();
		graphEdge = new HashMap<Integer, E>();
	}

	@Override
	public E getEdge(int e) {
		return graphEdge.get(e);
	}

	@Override
	public void addEdge(E e, int i) {

		graphEdge.put(i, e);
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