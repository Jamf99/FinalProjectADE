package structures;
import java.util.HashMap;
import java.util.Hashtable;


public class GraphList<V, E extends Comparable<E>> implements InterfaceGraph<V, E> {
	private boolean directed;
	private HashMap<V, Hashtable<V, Integer>> adyacentList;
	private Hashtable<V, Integer> edges;
	
	public GraphList(boolean directed) {
		this.directed = directed;
		adyacentList = new HashMap<V, Hashtable<V, Integer>>();
	}
	
	@Override
	public void addEdge(V v1, V v2, int value) {
		Vertex<V,E> v11=null;
		Vertex<V,E> v22=null;
		if(graph.containsKey(v1)) {
			v11=graph.get(v1);
		}else {
			v11=new Vertex<V,E>(v1);
			graph.put(v1,v11);
		}
		if(graph.containsKey(v2)) {
			v22=graph.get(v2);
		}else {
			v22=new Vertex<V,E>(v2);	
			graph.put(v2,v22);
		}
		if(v11.containsEdge(e,v22)) {
			return false;
		}else {
			Edge<V,E> edge1=new Edge<V,E>(e,v11,v22);
			v11.addEdge(edge1,v22);
			edges.add(edge1);
			if(undirected) {
				Edge<V,E> edge2=new Edge<V,E>(e,v22,v11);
				v22.addEdge(edge2,v11);				
			}
	}

	@Override
	public void addVertex(V v1) {
		edges = new Hashtable<V, Integer>();
		adyacentList.put(v1, edges);
	}
	
	@Override
	public void removeEdge(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeVertex(V v) {
		adyacentList.remove(v);
	}

	@Override
	public boolean IsUndirected() {
		// TODO Auto-generated method stub
		return false;
	}



}