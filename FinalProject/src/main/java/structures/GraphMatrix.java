package structures;
import java.util.Hashtable;

public class GraphMatrix<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E> {
	
	private Edge<Vertex<V> ,E>[][] matrix;
	private Hashtable<Vertex<V>, Integer> numbers;

	public GraphMatrix() {
		matrix = new Edge[numbers.size()][numbers.size()];
		numbers = new Hashtable<Vertex<V>, Integer>();
	}

	public void expandMatrix() {
		Edge<Vertex<V>, E>[][] aux = new Edge[numbers.size() + 1][numbers.size() + 1];
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}
		matrix = aux;
	}

	@Override
	public void addEdge(Vertex<V> v1, Vertex<V> v2, E value) {
		if(numbers.containsKey(v1) && numbers.containsKey(v2)) {
			Edge<Vertex<V>, E> newEdge = new Edge<Vertex<V>, E>(v2, value);
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix.length; j++) {
					matrix[]
				}
			}
		}
	}

	@Override
	public void addVertex(Vertex<V> v) {
		numbers.put(v, numbers.size()+1);
		expandMatrix();
	}

	@Override
	public void removeEdge(Edge<Vertex<V>, E> e) {

	}

	@Override
	public void removeVertex(Vertex<V> v) {
	
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