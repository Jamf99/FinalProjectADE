package structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<V> {
	/**
	 * Clase statica para representar las parejas de distancia y vertices para el
	 * metodo de dijktra
	 *
	 * @param <D> valor generico D
	 * @param <L> valor generico L
	 */
	public static class pair<D, L> {

		private D dist;
		private L list;

		public pair(D dist, L list) {
			this.dist = dist;
			this.list = list;
		}

		public D getDist() {
			return dist;
		}

		public L getList() {
			return list;
		}

		@Override
		public int hashCode() {
			return dist.hashCode() ^ list.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof pair))
				return false;
			pair<D, L> pairo = (pair<D, L>) o;
			return this.dist.equals(pairo.getDist()) && this.list.equals(pairo.getList());
		}

	}

	/**
	 * Constructor de la clase Graph
	 */
	public Graph() {

	}

	/**
	 * Metodo prim (MST) que encuentra los caminos mas cortos del grafo y una los
	 * vertices
	 * 
	 * @param graph
	 * @param origin el vertice de origen de inicio de la busqueda de los caminos
	 *               mas cortos.
	 * @return devuelve un grafo que contendra los caminos mas cortos y una a todos
	 *         los vertices
	 */
	public InterfaceGraph<V> prim(InterfaceGraph<V> graph, V origin) throws Exception {

		Set<V> visited = new HashSet<V>();
		InterfaceGraph<V> g = new GraphMatrix<V>(false);
		g.addVertex(origin);
		PriorityQueue<Edge<V>> queue = new PriorityQueue<Edge<V>>(graph.getOutgoingEdges(origin));

		visited.add(origin);
		while (!queue.isEmpty()) {
			Edge<V> min = queue.poll();
			if (!(visited.contains(min.getStart()) && visited.contains(min.getEnding()))) {
				visited.add(min.getEnding());
				g.addEdge(min.getStart(), min.getEnding(), min.getValue());
				queue.addAll(graph.getOutgoingEdges(min.getEnding()));
			}
		}

		return g;
	}

	/**
	 * Metodo dijkstra que me determina el camino mas carto desde un nodo inicial
	 * hasta un nodo final
	 * 
	 * @param graph el grafo que se le va a realizar el metodo.
	 * @param start vertice de inicio
	 * @param end   vertice de llegada
	 * @return retornara la pareja distancia (Contendra la distancia minima de
	 *         llegar del vertice start al vertice end) y lista(contendra el camino
	 *         a recorrer para llegar a ese vertice end)
	 * @throws Exception arrojara excepcion en el caso donde el vertice start o el
	 *                   vertice end no formen parte dle grafo.
	 */
	public pair<Double, List<V>> Dijkstra(InterfaceGraph<V> graph, V start, V end) throws Exception {
		if (!graph.getVertices().contains(start) || !graph.getVertices().contains(end)) {
			throw new Exception("Algunos de los elementos especificados no forman parte del grafo");
		}
		Set<V> Q = new HashSet<V>(graph.getVertices());
		HashMap<V, pair<Double, V>> table = new HashMap<V, pair<Double, V>>(graph.getVertices().size());
		for (V aux : graph.getVertices()) {
			table.put(aux, new pair<Double, V>(Double.POSITIVE_INFINITY, null));
		}
		table.replace(start, new pair<Double, V>(0.0, null));

		while (!Q.isEmpty()) {
			V minV = null;
			double minD = Double.POSITIVE_INFINITY;
			for (V aux : Q) {
				if (table.get(aux).dist <= minD) {
					minV = aux;
					minD = table.get(aux).dist;
				}
			}
			V u = minV;

			Q.remove(minV);

			for (V v : graph.getAdjacentVertices(u)) {
				double alt = table.get(u).dist + graph.getWeight(u, v);
				if (alt < table.get(v).dist) {
					table.get(v).dist = alt;
					table.get(v).list = u;
				}
			}
		}

		ArrayList<V> path = new ArrayList<V>();
		V current1 = end;
		while (current1 != null) {
			path.add(0, current1);
			current1 = table.get(current1).list;
		}

		if (table.get(end).dist == Double.POSITIVE_INFINITY) {
			path = new ArrayList<V>();
		}

		return new pair<Double, List<V>>(table.get(end).dist, path);
	}

	/**
	 * Metodo Breadth First Search del grafo
	 * 
	 * @param g     el grafo donde se realizara el BFS
	 * @param start vertice de inicio.
	 * @return retornara una lista de vertices.
	 */
	public List<V> BFS(InterfaceGraph<V> g, V start) {
		return graphTraversal(g, start, new LinkedList<V>());

	}

	/**
	 * Metodo Depth First Search del grafo
	 * 
	 * @param g     el grafo donde se realizara el DFS
	 * @param start vertice de inicio.
	 * @return retornara una lista de vertices.
	 */
	public List<V> DFS(InterfaceGraph<V> g, V start) {
		return graphTraversal(g, start, new Stack<V>());

	}

	/**
	 * Metodo que construye un grafo a partir del metodo kruskal retorna un grafo
	 * (MST)
	 * 
	 * @param graph grafo de parametro.
	 * @return un grafo que contiene el MST.
	 */
	public InterfaceGraph<V> kruskal(InterfaceGraph<V> graph) {
		UnionFind<V> uf = new UnionFind<V>();
		Set<V> vertices = graph.getVertices();
		for (V aux : vertices) {
			uf.makeSet(aux);
		}
		InterfaceGraph<V> answer = new GraphList<V>(false, vertices);
		Set<Edge<V>> edges = graph.getEdges();
		PriorityQueue<Edge<V>> Q = new PriorityQueue<Edge<V>>(edges);
		while (answer.getEdges().size() < vertices.size() - 1 && !Q.isEmpty()) {
			Edge<V> edge = Q.poll();
			if (!uf.find(edge.getStart()).equals(uf.find(edge.getEnding()))) {
				answer.addEdge(edge.getStart(), edge.getEnding(), edge.getValue());
				uf.union(edge.getStart(), edge.getEnding());
			}
		}
		System.out.println("Componentes no conectados:" + uf.numberOfDisjointedComponents());
		return answer;

	}

	/**
	 * Metodo generico que ejcutara el BFS o el DFS dependiendo de la coleccion que
	 * sea especificada.
	 * 
	 * @param g     el grafo que va a hacer tratado
	 * @param start el vertice de inicio donde sera empezado el metodp
	 * @param x     la coleccion especificada dependiendo de la eleccion de BFS o
	 *              DFS.
	 * @return Una lista que contiene los vertices del grafo. Dependiendo de la
	 *         eleccion de BFS o DFS
	 */
	private List<V> graphTraversal(InterfaceGraph<V> g, V start, Collection<V> x) {
		List<V> list = new ArrayList<V>();
		Hashtable<V, Boolean> marked = new Hashtable<V, Boolean>();
		if (x instanceof Queue) {
			Queue<V> x1 = (Queue<V>) x;
			x1.add(start);
			marked.put(start, true);
			while (!x1.isEmpty()) {
				V current = x1.remove();
				list.add(current);

				List<V> adjacent = g.getAdjacentVertices(current);
				for (int i = 0; i < adjacent.size(); i++) {

					if (!marked.containsKey(adjacent.get(i))) {
						x1.add(adjacent.get(i));
						marked.put(adjacent.get(i), true);
					}
				}
			}

		} else if (x instanceof Stack) {
			Stack<V> x1 = (Stack<V>) x;
			x1.add(start);
			marked.put(start, true);
			while (!x1.isEmpty()) {
				V current = x1.pop();
				list.add(current);

				List<V> adjacent = g.getAdjacentVertices(current);
				for (int i = 0; i < adjacent.size(); i++) {

					if (!marked.containsKey(adjacent.get(i))) {
						x1.add(adjacent.get(i));
						marked.put(adjacent.get(i), true);
					}
				}
			}
		}
		return list;
	}

	/**
	 * Genera una matriz de pesos minimos del grafo, para toda pareja de vertices
	 * especificado en el grafo.
	 * 
	 * @param g grafo que se va a realizar el metodo
	 * @return devuelve una matriz con las distancias mas cortas de todos los
	 *         vertices con todos los vertices.
	 */
	public double[][] FloydWarshall(InterfaceGraph<V> g) {
		double[][] w = g.generateWeightMatrix();
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

}