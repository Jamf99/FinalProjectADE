package structures;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class GraphMatrix<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E> {

	private Edge<Vertex<V>, E>[][] matrix;
	private Hashtable<Vertex<V>, Integer> numbers;
	private Vertex<V>[] visits;
	private boolean isDirected;

	public GraphMatrix(boolean isDirected) {
		this.isDirected = isDirected;
		numbers = new Hashtable<Vertex<V>, Integer>();
		matrix = new Edge[numbers.size()][numbers.size()];
	}

	private void expandMatrix() {
		Edge<Vertex<V>, E>[][] aux = new Edge[numbers.size() + 1][numbers.size() + 1];
		matrix = aux;
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
		if (numbers.containsKey(v1) && numbers.containsKey(v2)) {
			Edge<Vertex<V>, E> newEdge = new Edge<Vertex<V>, E>(v2, value);
			if (isDirected) {
				matrix[numbers.get(v1).intValue()][numbers.get(v2).intValue()] = newEdge;
			} else {
				matrix[numbers.get(v1).intValue()][numbers.get(v2).intValue()] = newEdge;
				matrix[numbers.get(v2).intValue()][numbers.get(v1).intValue()] = newEdge;
			}
		}
	}

	@Override
	public void addVertex(Vertex<V> v) {
		numbers.put(v, numbers.size() + 1);
		expandMatrix();
	}

	@Override
	public void removeEdge(Edge<Vertex<V>, E> e) {
		for (int i = 0; i < matrix.length; i++) {

		}
	}

	@Override
	public void removeVertex(Vertex<V> v) {
		numbers.put(v, numbers.size() - 1);
		comprimeMatrix();
	}

	
	
	@Override
	public void BFS(Vertex<V> s) {
		visits = new Vertex[numbers.size()];
		
		java.util.Queue<Vertex<V>> queue = new LinkedList<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[numbers.size()];
		Vertex<V> aux = null;
		if (numbers.containsKey(s)) {
			queue.add(s);
			while (!queue.isEmpty()) {
				boolean flag = false;
				boolean flag2 = true;
				aux = queue.remove();
				for (int j = 0; j < visited.length && !flag && flag2; j++) {
					if (visited[j] != null) {
						if (visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
							flag2 = false;
						}
					} else if (!flag) {
						visited[j] = aux;
						flag2 = false;
					}
				}
				if (!flag2 && !flag) {
					if (numbers.containsKey(aux)) {
						int pos = numbers.get(aux).intValue();
						for (int i = 0; i < matrix[0].length; i++) {
							if (matrix[pos][i] != null) {
								queue.add(matrix[pos][i].getEnding());
							}
						}
					}
				}
			}
			visits = visited;
		}
	}
	
	public Vertex<V>[] getVisits() {
		return visits;
	}

	@Override
	public void DFS(Vertex<V> s) {
		Stack<Vertex<V>> stack = new Stack<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[numbers.size()];
		Vertex<V> aux = null;
		if (numbers.containsKey(s)) {
			stack.push(s);
			while (!stack.isEmpty()) {
				boolean flag = false;
				boolean flag2 = true;
				aux = stack.pop();
				for (int j = 0; j < visited.length && !flag; j++) {
					if (visited[j] != null) {
						if (visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
							flag2 = false;
						}
					} else if (!flag && !flag2) {
						visited[j] = aux;
						flag = true;
						flag2 = false;
					}
				}
				if (!flag) {
					if (numbers.containsKey(aux)) {
						int pos = numbers.get(aux).intValue();
						for (int i = 0; i < matrix[0].length; i++) {
							if (matrix[pos][i] != null) {
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
		int v = matrix.length;
		boolean[] visited = new boolean[v];
		int[] distance = new int[v];
		distance[0] = 0;
		for (int i = 1; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < v; i++) {
			int minVertex = findMinVertex(distance, visited);
			for (int j = 0; j < v; j++) {
				if ((int) matrix[minVertex][j].getValue() != 0 && !visited[j]
						&& distance[minVertex] != Integer.MAX_VALUE) {
					int newDist = distance[minVertex] + (int) matrix[minVertex][j].getValue();
					if (newDist < distance[j]) {
						distance[j] = newDist;
					}
				}
			}
		}
		return distance;
	}

	private int findMinVertex(int[] distance, boolean visited[]) {
		int minVertex = -1;
		for (int i = 0; i < distance.length; i++) {
			if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public double[][] floydWarshallAlgorithm() {
		double[][] w = generateWeightMatrix();
		for (int k = 0; k < w.length; k++) {
			for (int i = 0; i < w.length; i++) {
				for (int j = 0; j < w.length; j++) {
					if (w[i][j] > w[i][k] + w[k][j]) {
						w[i][j] = w[i][k] + w[k][j];
					}
				}
			}
		}
		return w;
	}

	private double[][] generateWeightMatrix() {
		double[][] m = new double[matrix.length][matrix.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (matrix[i][j] != null) {
					m[i][j] = (int) matrix[i][j].getValue();
				} else {
					m[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
		for (int i = 0; i < m.length; i++) {
			m[i][i] = 0;
		}
		return m;
	}

	public Edge<Vertex<V>, E>[][] getMatrix() {
		return matrix;
	}

	public Hashtable<Vertex<V>, Integer> getNumbers() {
		return numbers;
	}

	
	
}