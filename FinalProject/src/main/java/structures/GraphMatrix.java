package structures;
import java.util.Hashtable;

public class GraphMatrix<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E> {
	
	private Edge<Vertex<V> ,E>[][] matrix;
	private Hashtable<Vertex<V>, Integer> numbers;
	private boolean isDirected;

	public GraphMatrix(boolean isDirected) {
		this.isDirected = isDirected;
		matrix = new Edge[numbers.size()][numbers.size()];
		numbers = new Hashtable<Vertex<V>, Integer>();
		
	}

	private void expandMatrix() {
		Edge<Vertex<V>, E>[][] aux = new Edge[numbers.size() + 1][numbers.size() + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}
		matrix = aux;
	}
	
	private void comprimeMatrix() {
		Edge<Vertex<V>, E>[][] aux = new Edge[numbers.size() - 1][numbers.size() - 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				aux[i][j] = matrix[i][j];
			}
		}
		matrix = aux;
	}

	@Override
	public void addEdge(Vertex<V> v1, Vertex<V> v2, E value) {
		if(numbers.containsKey(v1) && numbers.containsKey(v2)) {
			Edge<Vertex<V>, E> newEdge = new Edge<Vertex<V>, E>(v2, value);
			if(isDirected) {
				matrix[numbers.get(v1).intValue()][numbers.get(v2).intValue()] = newEdge;
			} else{
				matrix[numbers.get(v1).intValue()][numbers.get(v2).intValue()] = newEdge;
				matrix[numbers.get(v2).intValue()][numbers.get(v1).intValue()] = newEdge;
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
		for(int i = 0; i < matrix.length; i++) {
			
		}
	}

	@Override
	public void removeVertex(Vertex<V> v) {
		numbers.put(v, numbers.size() - 1);
		comprimeMatrix();
	}

	@Override
	public void BFS(Vertex<V> s) {
		Queue<Vertex<V>> queue = new Queue<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[numbers.size()];
		Vertex<V> aux = null;
		if(numbers.containsKey(s)) {
			queue.enqueue(s);
			while(!queue.isEmpty()) {
				boolean flag = false;
				aux = queue.dequeue();
				for(int j = 0; j < visited.length && !flag; j++) {
					if(visited[j] != null) {
						if(visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
						}
					}else if(!flag) {
						visited[j] = aux;
					}
				}
				if(!flag) {
					if(numbers.containsKey(aux)) {
						int pos = numbers.get(aux).intValue();
						for(int i = 0; i < matrix[0].length; i++) {
							if(matrix[pos][i] != null) {
								queue.enqueue(matrix[pos][i].getEnding());
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void DFS(Vertex<V> s) {
		Stack<Vertex<V>> stack = new Stack<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[numbers.size()];
		Vertex<V> aux = null;
		if(numbers.containsKey(s)) {
			stack.push(s);
			while(!stack.isEmpty()) {
				boolean flag = false;
				aux = stack.pop();
				for(int j = 0; j < visited.length && !flag; j++) {
					if(visited[j] != null) {
						if(visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
						}
					}else if(!flag) {
						visited[j] = aux;
					}
				}
				if(!flag) {
					if(numbers.containsKey(aux)) {
						int pos = numbers.get(aux).intValue();
						for(int i = 0; i < matrix[0].length; i++) {
							if(matrix[pos][i] != null) {
								stack.push(matrix[pos][i].getEnding());
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public int[] dijkstra(Vertex<V> origin) {
		return null;
	}

}