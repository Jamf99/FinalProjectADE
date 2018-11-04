package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GraphAdyacen<V, E extends Comparable<E>> implements IGraph<V,E> {
	
	private boolean undirected;
	
	private HashMap<V,Vertex<V,E>>graph;
	private HashSet<Edge<V,E>>edges;
	
	public GraphAdyacen(boolean un) {
		graph=new HashMap<V,Vertex<V,E>>();
		edges=new HashSet<Edge<V,E>>();
		undirected=un;
	}
	
	@Override
	public boolean addEdge(E e, V v1, V v2) {
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
			return true;
		}
	}

	public Iterator<V> valuesIterator() {
		return graph.keySet().iterator();
	}
	public Iterator<Edge<V,E>> edgeIterator(){
		return edges.iterator();
	}
	/**
	 * 
	 * @param v
	 */
	public Vertex<V, E> getVertex(V v) {
		return graph.get(v);
	}

	@Override
	public ArrayList<V> getValues() {
		ArrayList<V>vers=new ArrayList<V>();
		Iterator<V>it=valuesIterator();
		while(it.hasNext()) {
			vers.add(it.next());
		}
		return vers;
	}

	@Override
	public ArrayList<Object[]> getEdges() {
		ArrayList<Object[]>A=new ArrayList<Object[]>(); 
		Iterator<Edge<V,E>>edgy=edgeIterator();
		while(edgy.hasNext()) {
			Edge<V,E> e=edgy.next();
			Object[] E=new Object[3];
			E[0]=e.getLabel();
			E[1]=e.getOrigin().getValue();
			E[2]=e.getEnding().getValue();
			A.add(E);
		}
		return A;
	}

	@Override
	public boolean addVertex(V v) {
		Vertex<V,E> v11=null;
		// TODO Auto-generated method stub
		if(graph.containsKey(v)) {
			
			return false;
		}else {
			v11=new Vertex<V,E>(v);
			graph.put(v,v11);
			return true;
			
		}
		
	}

	@Override
	public E getLabel(V v1, V v2) {
		if(getVertex(v1)==null || getVertex(v2)==null) {
			return null;
		}
		ArrayList<Edge<V,E>>edges=getVertex(v1).getEdges(getVertex(v2));
		if(edges==null) {
			return null;
		}else {
			return edges.get(0).getLabel();			
		}
	}

	@Override
	public ArrayList<V> getNeighbors(V v) {
		Vertex<V,E>ver=graph.get(v);
		ArrayList<V>neighs=new ArrayList<V>();
		Iterator<Vertex<V,E>>it=ver.neighborIterator();
		while(it.hasNext()) {
			neighs.add(it.next().getValue());
		}
		return neighs;
	}

	@Override
	public boolean isThereEdge(V v1, V v2) {
		Vertex<V,E> vertex1=getVertex(v1);
		Vertex<V,E> vertex2=getVertex(v2);
		ArrayList<Edge<V,E>>edges=vertex1.getEdges(vertex2);
		if(edges!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUndirected() {
		return undirected;
	}

	@Override
	public int getNumberOfVertices() {
		return graph.size();
	}
	@Override
	public IGraph<V,E> transformToMyOpposite() {
		GraphMatrix<V,E> gm=new GraphMatrix<>(undirected);
		ArrayList<Object[]> edges=this.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			gm.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		return gm;
	}

}