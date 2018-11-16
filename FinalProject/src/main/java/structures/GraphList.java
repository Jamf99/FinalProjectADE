package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class GraphList<V, E> implements InterfaceGraph<V, E> {
	private boolean directed;
	private HashMap<V, Hashtable<V, Integer>> adyacentList;
	private Hashtable<V, Integer> edges;
	
	public GraphList(boolean directed) {
		this.directed = directed;
		adyacentList = new HashMap<V, Hashtable<V, Integer>>();
	}
	
	@Override
	public void addEdge(V v1, V v2, int value) {
		if(adyacentList.containsKey(v1)){
            adyacentList.get(v1).put(v2, value);
        }else{
            edges = new Hashtable<V, Integer>();
            edges.put(v2, value);
            adyacentList.put(v1, edges);
        }
        if(adyacentList.containsKey(v2)){
            adyacentList.get(v2).put(v1, value);
        }else{
            edges = new Hashtable<V, Integer>();
            edges.put(v1, value);
            adyacentList.put(v2, edges);
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
	public ArrayList<V> BFS(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> DFS(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<E> Dijstra(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphList<V, E> Kruskal(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphList<V, E> Prim(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<E> floydWarshall(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean IsUndirected() {
		// TODO Auto-generated method stub
		return false;
	}



}