package structures;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix<V, E> implements InterfaceGraph<V, E> {
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

	@Override
	public void addEdge(V v1, V v2, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVertex(V v1) {
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
	public boolean IsUndirected() {
		// TODO Auto-generated method stub
		return false;
	}

}
