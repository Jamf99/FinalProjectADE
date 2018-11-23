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

	public static class pair<L, R> {

		private L left;
		private R right;

		public pair(L left, R right) {
			this.left = left;
			this.right = right;
		}

		public L getLeft() {
			return left;
		}

		public R getRight() {
			return right;
		}

		@Override
		public int hashCode() {
			return left.hashCode() ^ right.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof pair))
				return false;
			pair pairo = (pair) o;
			return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
		}

	}

	public Graph() {

	}

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

	public pair<Double, List<V>> DijkstraAlgorithm(InterfaceGraph<V> graph, V start, V end) throws Exception {
		if (!graph.getVertices().contains(start) || !graph.getVertices().contains(end)) {
			throw new Exception("Some of the specified elements are not part of the Graph");
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
				if (table.get(aux).left <= minD) {
					minV = aux;
					minD = table.get(aux).left;
				}
			}
			V u = minV;

			Q.remove(minV);

			for (V v : graph.getAdjacentVertices(u)) {
				double alt = table.get(u).left + graph.getWeight(u, v);
				if (alt < table.get(v).left) {
					table.get(v).left = alt;
					table.get(v).right = u;
				}
			}
		}

		for (V aux : table.keySet()) {
			System.out.println(aux + " : " + table.get(aux).left + " : " + table.get(aux).right);
		}

		ArrayList<V> path = new ArrayList<V>();
		V current1 = end;
		while (current1 != null) {
			path.add(0, current1);
			current1 = table.get(current1).right;
		}

		if (table.get(end).left == Double.POSITIVE_INFINITY) {
			path = new ArrayList<V>();
		}

		return new pair<Double, List<V>>(table.get(end).left, path);
	}

	public List<V> BFS(Graph<V> g, V start) {
		return graphTraversal(g, start, new LinkedList<V>());

	}

	public List<V> DFS(Graph<V> g, V start) {
		return graphTraversal(g, start, new Stack<V>());

	}

	public InterfaceGraph<V> kruskalAlgorithm(InterfaceGraph<V> graph) {
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
		System.out.println("Not connected components:" + uf.numberOfDisjointedComponents());
		return answer;

	}

	/**
	 * Generic Graph traversal method, will execute BFS or DFS according to the
	 * specified Collection.
	 * 
	 * @param g     The Graph to be traversed.
	 * @param start The origin of the traversal (it is the starting point).
	 * @param x     An implementation of Collection, it can be an implementation of
	 *              Queue or an instance of Stack.
	 * @return A List containing the objects inside g in order of traversal. Will
	 *         depend on specified instance of x. Queue specification uses BFS,
	 *         Stack uses DFS.
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

	public double[][] FloydWarshallAlgorithm(InterfaceGraph<V> g) {
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
