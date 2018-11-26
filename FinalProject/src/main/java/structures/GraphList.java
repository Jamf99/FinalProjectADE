package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class GraphList<V> implements InterfaceGraph<V> {
	/**
	 * Mapa que contendra el vertice y sus vecinos
	 */
	private Map<V, Map<V, Number>> container;
	/**
	 * Set que contendra las aristas del grafo
	 */
	private Set<Edge<V>> edges;
	/**
	 * atributo que me determina si el grafo es dirigido
	 */
	private boolean directed;

	/**
	 * Constructor de la clase GraphList, se construye el grafo vacio y se determina
	 * si es dirigido o no es dirigido.
	 * 
	 * @param directed -
	 */
	public GraphList(boolean directed) {
		this.directed = directed;
		container = new HashMap<V, Map<V, Number>>();
		edges = new TreeSet<Edge<V>>();

	}

	/**
	 * Constructor de la clase GraphList, construye un grafo con los vertices en un
	 * arreglo pero sin las aristas, puede ser el grafo dirigido o no dirigido.
	 * 
	 * @param directed boolean que determina si el grafo es dirigido o no dirigido.
	 * @param objects  arreglo de vertices para la construccion del grafo
	 */
	public GraphList(boolean directed, V[] objects) {
		this.directed = directed;
		edges = new TreeSet<Edge<V>>();
		container = new HashMap<V, Map<V, Number>>();
		for (int i = 0; i < objects.length; i++) {
			addVertex(objects[i]);
		}
	}

	/**
	 * Constructor de la clase GraphList construte un grafo con los vertices en un
	 * set pero sin las aristas, puede ser el grafo dirigido o no dirigido.
	 * 
	 * @param directed boolean que me determina si el grafo es dirigido o no
	 * @param objects  set de vertices para la construccion del grafo
	 */
	public GraphList(boolean directed, Set<V> objects) {
		this.directed = directed;
		edges = new TreeSet<Edge<V>>();
		container = new HashMap<V, Map<V, Number>>();
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
		container.put(v, new HashMap<V, Number>());
		return v;

	}

	@Override
	public void addEdge(V v1, V v2) {

		addEdge(v1, v2, 1);

	}

	@Override
	public void addEdge(V v1, V v2, double w) {
		if (directed) {
			Edge<V> edge = new Edge<V>(v1, v2, w);
			edges.add(edge);
			boolean containsV1 = container.containsKey(v1);
			boolean containsV2 = container.containsKey(v2);
			if (!containsV1 || !containsV2) {
				if (!containsV1 && !containsV2) {
					addVertex(v1);
					addVertex(v2);
					container.get(v1).put(v2, w);
				} else {
					if (!containsV1) {
						addVertex(v1);
						container.get(v1).put(v2, w);
					} else {
						addVertex(v2);
						container.get(v1).put(v2, w);
					}
				}
			} else {
				container.get(v1).put(v2, w);
			}
		} else {
			Edge<V> edge1 = new Edge<V>(v1, v2, w);
			Edge<V> edge2 = new Edge<V>(v2, v1, w);
			edges.add(edge1);
			edges.add(edge2);
			boolean containsV1 = container.containsKey(v1);
			boolean containsV2 = container.containsKey(v2);
			if (!containsV1 || !containsV2) {
				if (!containsV1 && !containsV2) {
					addVertex(v1);
					addVertex(v2);
					container.get(v1).put(v2, w);
					container.get(v2).put(v1, w);
				} else {
					if (!containsV1) {
						addVertex(v1);
						container.get(v1).put(v2, w);
						container.get(v2).put(v1, w);
					} else {
						addVertex(v2);
						container.get(v1).put(v2, w);
						container.get(v2).put(v1, w);
					}
				}
			} else {
				container.get(v1).put(v2, w);
				container.get(v2).put(v1, w);
			}
		}

	}

	@Override
	public double getWeight(V v1, V v2) throws Exception {

		if (container.containsKey(v1) && container.containsKey(v2)) {
			try {
				return container.get(v1).get(v2).doubleValue();

			} catch (Exception e) {
				// TODO: handle exception
				return Double.POSITIVE_INFINITY;
			}
		} else {
			throw new Exception("Por lo menos uno de los vertices especificados no pertenece al grafo");
		}
	}

	@Override
	public boolean edgeExist(V v1, V v2) {

		if (!container.containsKey(v1) || !container.containsKey(v2)) {
			return false;
		} else {
			return container.get(v1).containsKey(v2);
		}
	}

	@Override
	public List<V> getAdjacentVertices(V v) {

		ArrayList<V> list = new ArrayList<V>();
		if (!container.containsKey(v)) {
			return list;
		} else {
			Set<V> set = container.get(v).keySet();
			for (V adjacent : set) {
				list.add(adjacent);
			}
			return list;
		}
	}

	@Override
	public Set<V> getVertices() {

		return container.keySet();
	}

	@Override
	public void deleteVertex(V v) {

		container.remove(v);
		for (Entry<V, Map<V, Number>> entry : container.entrySet()) {
			Map<V, Number> aux = entry.getValue();
			aux.remove(v);
		}

	}

	@Override
	public void deleteEdge(V v1, V v2) {

		if (container.containsKey(v1) && container.containsKey(v2)) {

			if (directed) {
				container.get(v1).remove(v2);
				Edge<V> e = new Edge<V>(v1, v2, 1);
				edges.remove(e);
			} else {
				container.get(v1).remove(v2);
				container.get(v2).remove(v1);
				Edge<V> e = new Edge<V>(v1, v2, 1);
				Edge<V> e1 = new Edge<V>(v2, v1, 1);
				edges.remove(e);
				edges.remove(e1);
			}
		}
	}

	@Override
	public Set<Edge<V>> getEdges() {

		return edges;
	}

	@Override
	public List<Edge<V>> getOutgoingEdges(V v) {

		if (container.containsKey(v)) {
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
		Set<V> vertices = getVertices();
		double[][] m = new double[vertices.size()][vertices.size()];
		HashMap<V, Integer> indices = new HashMap<V, Integer>();
		int index = 0;
		for (V aux : vertices) {
			indices.put(aux, index);
			index++;
		}
		for (V aux : vertices) {
			int index2 = indices.get(aux);
			for (Edge<V> e : getOutgoingEdges(aux)) {
				m[index2][indices.get(e.getEnding())] = e.getValue();
			}
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					m[i][j] = Double.POSITIVE_INFINITY;

				}
			}
		}
		for (int i = 0; i < m.length; i++) {
			m[i][i] = 0;
		}
		return m;

	}

}
