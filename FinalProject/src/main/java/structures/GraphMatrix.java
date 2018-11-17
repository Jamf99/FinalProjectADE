package structures;

import java.util.HashSet;

public class GraphMatrix<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E> {
	private Edge<Vertex<V>, Edge<Vertex<V>, E>>[][] graph;
	private HashSet<Vertex<V>> vertexs;
	private int cantidad;
	private HashTable<Vertex<V>, Integer> numbers;

	public GraphMatrix() {
		super();
		graph = new Edge[0][0];
		vertexs = new HashSet<Vertex<V>>();
		numbers = new HashTable<Vertex<V>, Integer>(0);
	}

	public GraphMatrix(int cantidad) {
		super();
		this.cantidad = cantidad;
		graph = new Edge[cantidad][cantidad];
		vertexs = new HashSet<Vertex<V>>();
		numbers = new HashTable<Vertex<V>, Integer>(cantidad);
	}

	public void expandMatrix(V v) {
		Edge<Vertex<V>, Edge<Vertex<V>, E>>[][] aux = new Edge[cantidad + 1][cantidad + 1];
		numbers.put(v, aux.length - 1);
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				aux[i][j] = graph[i][j];
			}
		}
		graph = aux;
	}

	@Override
	public void addEdge(Vertex<V> v1, Vertex<V> v2, E value) {
		Edge<Vertex<V>, E> edge = new Edge<Vertex<V>, E>(v2, value);
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j].getEnding() == v1) {
					graph[i][j].setValue(edge);

				}
			}
		}

	}

	@Override
	public void addVertex(Vertex<V> v) {

	}

	@Override
	public void removeEdge(Edge<Vertex<V>, E> e) {

	}

	@Override
	public void removeVertex(Vertex<V> v) {
		vertexs.remove(v);
	}

	@Override
	public void BFS(Vertex<V> s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DFS(Vertex<V> s) {
		// TODO Auto-generated method stub
		
	}

}