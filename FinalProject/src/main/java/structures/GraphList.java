package structures;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class GraphList<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E>{
	
	private HashMap<Vertex<V>, LinkedHashSet<Edge<Vertex<V>,E>>> graph;
	private LinkedHashSet<Edge<Vertex<V>,E>> edges;
	private Vertex<V>[] visits;
	
	public GraphList() {
		graph = new HashMap<Vertex<V>, LinkedHashSet<Edge<Vertex<V>,E>>>();
		edges = new LinkedHashSet<Edge<Vertex<V>, E>>();
	}
	
	@Override
	public void addEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
		Edge<Vertex<V>,E> edge = new Edge<Vertex<V>, E>(v2, edgeValue);
		if(graph.containsKey(v1)){
            graph.get(v1).add(edge);
        }else{
            edges = new LinkedHashSet<Edge<Vertex<V>, E>>();
            edges.add(edge);
            graph.put(v1, edges);
        }
        if(graph.containsKey(v2)){
            graph.get(v2).add(edge);
        }else{
            edges = new LinkedHashSet<Edge<Vertex<V>, E>>();
            edges.add(edge);
            graph.put(v2, edges);
        }
	}

	@Override
	public void addVertex(Vertex<V> v1) {
		if(!graph.containsKey(v1)) {
			graph.put(v1, edges);
		}
	}

	public void removeEdge(Edge<Vertex<V>,E> e) {
		
	}

	public void removeVertex(Vertex<V> v) {
		if(graph.containsKey(v)) {
			graph.remove(v);
		}
	}
	
	

	@Override
	public void BFS(Vertex<V> s) {
		visits = new Vertex[graph.size()];
		Queue<Vertex<V>> queue = new LinkedList<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[graph.size()];
		Vertex<V> aux = null;
		if(graph.containsKey(s)) {
			queue.add(s);
			while(!queue.isEmpty()) {
				boolean flag = false;
				boolean flag2 = true;
				aux = queue.remove();
				for(int j = 0; j < visited.length && !flag; j++) {
					if(visited[j] != null) {
						if(visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
							flag2 = false;
						}
					}else if(!flag) {
						visited[j] = aux;
						flag2 = false;
					}
				}
				if(!flag && !flag2) {
					LinkedHashSet<Edge<Vertex<V>,E>> aux2 = graph.get(aux);
					for(Edge<Vertex<V>, E> edges : aux2) {
						queue.remove(edges.getEnding());
					}
				}
			}
		}
		visits = visited;
	}
	
	@Override
	public void DFS(Vertex<V> s) {
		visits = new Vertex[graph.size()];
		Stack<Vertex<V>> stack = new Stack<Vertex<V>>();
		Vertex<V>[] visited = new Vertex[graph.size()];
		Vertex<V> aux = null;
		if(graph.containsKey(s)) {
			stack.push(s);
			while(!stack.isEmpty()) {
				boolean flag = false;
				boolean flag2 = true;
				aux = stack.pop();
				for(int j = 0; j < visited.length && !flag; j++) {
					if(visited[j] != null) {
						if(visited[j].getValue().compareTo(aux.getValue()) == 0) {
							flag = true;
							flag2 = false;
						}
					}else if(!flag && !flag2) {
						visited[j] = aux;
						flag2 = false;
					}
				}
				if(!flag) {
					LinkedHashSet<Edge<Vertex<V>,E>> aux2 = graph.get(aux);
					for(Edge<Vertex<V>, E> edges : aux2) {
						stack.push(edges.getEnding());
					}
				}
			}
		}
	}
	
	@Override
	public int[] dijkstra(Vertex<V> origin) {
		PriorityQueue<Vertex<V>> queue = new PriorityQueue<Vertex<V>>();
		int[] distances = new int[graph.size()+1];
		Hashtable<Integer, Vertex<V>> pairs = new Hashtable<Integer, Vertex<V>>();
		
		Vertex<V>[] visited = new Vertex[graph.size()];
		for(int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE; 
		}
		Vertex<V> aux = null;
		queue.add(origin);
		while(!queue.isEmpty()) {
			aux = queue.poll();
//			int weight = aux.ge
		}
		return distances;
	}

	public HashMap<Vertex<V>, LinkedHashSet<Edge<Vertex<V>, E>>> getGraph() {
		return graph;
	}

	public LinkedHashSet<Edge<Vertex<V>, E>> getEdges() {
		return edges;
	}

	public Vertex<V>[] getVisits() {
		return visits;
	}

}