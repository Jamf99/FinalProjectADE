package structures;
import java.util.HashMap;
import java.util.LinkedHashSet;
public class GraphList<V extends Comparable<V>, E extends Comparable<E>> implements InterfaceGraph<V, E>{
	
	private HashMap<Vertex<V>, LinkedHashSet<Edge<Vertex<V>,E>>> graph;
	private LinkedHashSet<Edge<Vertex<V>,E>> edges;
	
	public GraphList() {
		graph = new HashMap<Vertex<V>, LinkedHashSet<Edge<Vertex<V>,E>>>();
		edges = null;
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
	
	}

	@Override
	public void BFS(Vertex<V> origin, Vertex<V> ending) {
		
	}


}