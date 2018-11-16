package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import auxiliarDataStructures.Edge;

public class Vertex<V, E extends Comparable<E>> {
	
	private ArrayList<Vertex<V,E>> cycleAncestors;
	private Vertex<V,E> ancestor;
	private V value;
	private int color;
	private double d;
	private HashMap<Vertex<V,E>,ArrayList<Edge<V,E>>> edges;
	/**
	 * 
	 * @param v
	 */
	public Vertex(V v) {
		cycleAncestors=new ArrayList<Vertex<V,E>>();
		edges=new HashMap<Vertex<V,E>,ArrayList<Edge<V,E>>>();
		ancestor=null;
		d=Double.MAX_VALUE;
		value=v;
	}
	public int getColor() {
		return this.color;
	}
	public void setColor(int color) {
		this.color=color;
	}
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Iterator<Vertex<V,E>> neighborIterator() {
		return edges.keySet().iterator();
	}

	/**
	 * 
	 * @param v
	 */
	public ArrayList<Edge<V,E>> getEdges(Vertex<V,E> v) {
		return edges.get(v);
	}

	public boolean containsEdge(E e, Vertex<V, E> v22) {
		if(!edges.containsKey(v22))return false;
		ArrayList<Edge<V, E>>edgy=edges.get(v22);
		boolean contains=false;
		for (int i = 0; i < edgy.size() && !contains; i++) {
			if(edgy.get(i).getLabel().equals(e)) {
				return true;
			}
		}
		return contains;
	}
	/**
	 * <pre>: this does not contain edge1
	 * @param edge1
	 * @param ver
	 */
	public void addEdge(Edge<V, E> edge1, Vertex<V, E> ver) {
		ArrayList<Edge<V, E>>ed=null;
		if(edges.containsKey(ver)){
			ed=edges.get(ver);
			ed.add(edge1);
		}else{
			ed=new ArrayList<Edge<V, E>>();
			ed.add(edge1);
			edges.put(ver,ed);
		}
	}
	public Vertex<V, E> getAncestor() {
		return ancestor;
	}
	public void setAncestor(Vertex<V, E> ancestor) {
		this.ancestor = ancestor;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public void addCycleAncestor(Vertex<V,E> v) {
		cycleAncestors.add(v);
	}
	public ArrayList<Vertex<V,E>> getCycleAncestors(){
		return cycleAncestors;
	}
	
}