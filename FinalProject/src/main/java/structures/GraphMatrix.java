package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GraphMatrix<V> implements InterfaceGraph<V> {
	/**
	 * HashMap donde se guandaran los vertices clave vertice, retorno indice.
	 */
	private HashMap<V, Integer> vertices;
	/**
	 * Arreglo de indices de los vertices.
	 */
	private ArrayList<V> indices;
	/**
	 * Matriz numerica donde se guardaran la adyacencia de los vertices del grafo
	 */
	private Number[][] matrix;
	/**
	 * Atributo boolean para determinar si el grafo es dirigido o no dirigido
	 */
	private boolean directed;
	/**
	 * Set de aristas, del grafo
	 */
	private Set<Edge<V>> edges;

	/**
	 * Constructor de la clase GraphMatrix, construye un grafo vacio, y me se puede
	 * determinar si es dirigido o no dirigido.
	 * 
	 * @param directed boolean que determina si el grafo es dirigido o no dirigido.
	 */
	public GraphMatrix(boolean directed) {
		vertices = new HashMap<V, Integer>();
		indices = new ArrayList<V>();
		matrix = new Number[0][0];
		edges = new TreeSet<Edge<V>>();
		this.directed = directed;
	}

	/**
	 * Constructor de la clase GraphMatrix, construye un grafo con los vertices en
	 * un arreglo pero sin las aristas, puede ser el grafo dirigido o no dirigido.
	 * 
	 * @param directed boolean que determina si el grafo es dirigido o no dirigido.
	 * @param objects  arreglo de vertices para la construccion del grafo
	 */
	public GraphMatrix(boolean directed, V[] objects) {
		vertices = new HashMap<V, Integer>();
		indices = new ArrayList<V>();
		matrix = new Number[0][0];
		edges = new TreeSet<Edge<V>>();
		this.directed = directed;
		for (int i = 0; i < objects.length; i++) {
			addVertex(objects[i]);
		}
	}

	/**
	 * Constructor de la clase GraphMatrix construte un grafo con los vertices en un
	 * set pero sin las aristas, puede ser el grafo dirigido o no dirigido.
	 * 
	 * @param directed boolean que me determina si el grafo es dirigido o no
	 * @param objects  set de vertices para la construccion del grafo
	 */
	public GraphMatrix(boolean directed, Set<V> objects) {
		vertices = new HashMap<V, Integer>();
		indices = new ArrayList<V>();
		matrix = new Number[0][0];
		edges = new TreeSet<Edge<V>>();
		this.directed = directed;
		for (V aux : objects) {
			addVertex(aux);
		}
	}

	@Override
	public boolean isDirected() {

		return directed;
	}

	@Override
	public V addVertex(V v) {

		if (!vertices.containsKey(v)) {

			vertices.put(v, indices.size());
			indices.add(v);
			Number[][] aux = new Number[vertices.size()][vertices.size()];
			for (int i = 0; i < aux.length; i++) {
				for (int j = 0; j < aux.length; j++) {
					if (i < matrix.length && j < matrix.length) {
						aux[i][j] = matrix[i][j];
					} else {
						aux[i][j] = null;
					}
				}
			}
			matrix = aux;
		}
		return v;
	}

	@Override
	public void addEdge(V v1, V v2) {
		addEdge(v1, v2, 1);
	}

	@Override
	public void addEdge(V v1, V v2, double w) {

		boolean containsV1 = vertices.containsKey(v1);
		boolean containsV2 = vertices.containsKey(v2);

		if (directed) {
			Edge<V> edge = new Edge<V>(v1, v2, w);
			edges.add(edge);
			if (containsV1 && containsV2) {
				matrix[vertices.get(v1)][vertices.get(v2)] = w;
			} else if (!containsV1 || !containsV2) {
				if (!containsV1 && !containsV2) {
					addVertex(v1);
					addVertex(v2);
					matrix[vertices.get(v1)][vertices.get(v2)] = w;
				} else if (!containsV1) {
					addVertex(v1);
					matrix[vertices.get(v1)][vertices.get(v2)] = w;
				} else {
					addVertex(v2);
					matrix[vertices.get(v1)][vertices.get(v2)] = w;

				}
			}

		} else {
			Edge<V> edge1 = new Edge<V>(v1, v2, w);
			Edge<V> edge2 = new Edge<V>(v2, v1, w);

			edges.add(edge1);
			edges.add(edge2);
			if (containsV1 && containsV2) {
				int iv1 = vertices.get(v1);
				int iv2 = vertices.get(v2);
				matrix[iv1][iv2] = w;
				matrix[iv2][iv1] = w;
			} else if (!containsV1 || !containsV2) {
				if (!containsV1 && !containsV2) {
					addVertex(v1);
					addVertex(v2);
					int iv1 = vertices.get(v1);
					int iv2 = vertices.get(v2);
					matrix[iv1][iv2] = w;
					matrix[iv2][iv1] = w;
				} else if (!containsV1) {
					addVertex(v1);
					int iv1 = vertices.get(v1);
					int iv2 = vertices.get(v2);
					matrix[iv1][iv2] = w;
					matrix[iv2][iv1] = w;
				} else {
					addVertex(v2);
					int iv1 = vertices.get(v1);
					int iv2 = vertices.get(v2);
					matrix[iv1][iv2] = w;
					matrix[iv2][iv1] = w;

				}
			}
		}
	}

	@Override
	public double getWeight(V v1, V v2) throws Exception {

		if (vertices.containsKey(v1) && vertices.containsKey(v2)) {
			try {

				return matrix[vertices.get(v1)][vertices.get(v2)].doubleValue();
			} catch (Exception e) {
				return Double.POSITIVE_INFINITY;
			}
		} else {
			throw new Exception("Por lo menos uno de los vertices especificados no pertenece al grafo");
		}

	}

	@Override
	public boolean edgeExist(V v1, V v2) {

		if (!vertices.containsKey(v1) || !vertices.containsKey(v2)) {
			return false;
		} else {
			if (matrix[vertices.get(v1)][vertices.get(v2)] == null) {
				return false;
			} else {
				return true;
			}
		}

	}

	@Override
	public List<V> getAdjacentVertices(V v) {

		ArrayList<V> list = new ArrayList<V>();
		if (vertices.containsKey(v)) {
			int index = vertices.get(v);
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[index][i] != null) {
					list.add(indices.get(i));
				}
			}
		}

		return list;

	}

	@Override
	public Set<V> getVertices() {

		return vertices.keySet();
	}

	@Override
	public void deleteVertex(V v) {

		if (vertices.containsKey(v)) {
			int index = vertices.get(v);
			for (int i = index + 1; i < indices.size(); i++) {

				int value = vertices.get(indices.get(i));
				value--;
				vertices.replace(indices.get(i), value);
			}
			indices.remove(index);
			vertices.remove(v);

			Number[][] aux = new Number[matrix.length - 1][matrix.length - 1];
			int iAux = 0;
			int jAux = 0;
			boolean finished = false;
			for (int i = 0; i < matrix.length && !finished; i++) {
				for (int j = 0; j < matrix.length && !finished; j++) {
					if (i != index && j != index) {
						aux[iAux][jAux] = matrix[i][j];
						jAux++;
						if (jAux == aux.length) {
							jAux = 0;
							iAux++;
						}
						if (iAux == aux.length) {
							finished = true;
						}
					}
				}
			}
			matrix = aux;

		}
	}

	@Override
	public void deleteEdge(V v1, V v2) {

		if (vertices.containsKey(v1) && vertices.containsKey(v2)) {
			if (directed) {
				matrix[vertices.get(v1)][vertices.get(v2)] = null;
				Edge<V> e = new Edge<V>(v1, v2, 1);
				edges.remove(e);

			} else {
				matrix[vertices.get(v1)][vertices.get(v2)] = null;
				matrix[vertices.get(v2)][vertices.get(v1)] = null;
				Edge<V> e = new Edge<V>(v1, v2, 1);
				Edge<V> e1 = new Edge<V>(v2, v1, 1);
				edges.remove(e);
				edges.remove(e1);
			}
		}
	}

	/**
	 * Metodo que retorna la matriz de adyacencia del grafo.
	 *
	 * 
	 * @return una matriz Number. El tamaño de la matriz es la cantidad de vertices
	 *         que hay en el grafo.
	 */
	public Number[][] getAdjacencyMatriz() {
		return matrix;
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			String line = "";
			for (int j = 0; j < matrix.length; j++) {
				line += matrix[i][j] + " ";
			}
			System.out.println(line);
		}
	}

	@Override
	public Set<Edge<V>> getEdges() {

		return edges;
	}

	@Override
	public List<Edge<V>> getOutgoingEdges(V v) {
		if (vertices.containsKey(v)) {
			ArrayList<Edge<V>> list = new ArrayList<Edge<V>>();
			for (V aux : this.getAdjacentVertices(v)) {
				try {
					list.add(new Edge<V>(v, aux, this.getWeight(v, aux)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		} else {
			return null;
		}
	}

	@Override
	public double[][] generateWeightMatrix() {
		double[][] m = new double[matrix.length][matrix.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (matrix[i][j] != null) {

					m[i][j] = matrix[i][j].doubleValue();
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

	public Number[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Number[][] matrix) {
		this.matrix = matrix;
	}
}
