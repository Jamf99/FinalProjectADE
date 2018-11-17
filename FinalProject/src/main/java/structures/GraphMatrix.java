package structures;

import java.util.HashMap;

public class GraphMatrix<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E> {
	private boolean[][] matrix;
	private HashMap<V, Integer> vertex;
	private HashMap<Integer, V> vertex1;
	private int cant;

	public GraphMatrix() {
		super();
		cant = 0;
		matrix = new boolean[cant][cant];
		vertex = new HashMap();
		vertex1 = new HashMap();
	}

	public void expandMatrix(V v) {
		boolean[][] aux = new boolean[cant + 1][cant + 1];
		vertex.put(v, aux.length - 1);
		vertex1.put(aux.length - 1, v);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}

		matrix = aux;
	}

	@Override
	public void addEdge(Vertex<V> v1, Vertex<V> v2, E value) {
		if (!vertex.containsKey(v1)) {
			expandMatrix(v1.getValue());
		}
		if (!vertex.containsKey(v2)) {
			expandMatrix(v2.getValue());
		}
		matrix[vertex.get(v1)][vertex.get(v2)] = true;

	}

	@Override
	public void addVertex(Vertex<V> v1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEdge(Edge<Vertex<V>, E> e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVertex(Vertex<V> v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void BFS(Vertex<V> origin, Vertex<V> ending) {
		// TODO Auto-generated method stub

	}

}
