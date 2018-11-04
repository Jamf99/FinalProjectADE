package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix<V, E extends Comparable<E>> implements IGraph<V,E> {
	
	boolean undirected;

	private ArrayList[][] edges;
	private HashMap<Integer, V> intToValue;
	private HashMap<V, Integer> valueToint;

	public GraphMatrix(boolean un) {
		intToValue=new HashMap<Integer, V>();
		valueToint=new HashMap<V, Integer> ();
		undirected=un;
		edges=new ArrayList[0][0];	
	}
	
	@Override
	public boolean addEdge(E e, V v1, V v2) {
		if(!valueToint.containsKey(v1)) {
			expandMatrix(v1);
			
		}if(!valueToint.containsKey(v2)) {
			expandMatrix(v2);
		}
	   edges[valueToint.get(v1)][valueToint.get(v2)].add(e);
		
		
	
		return true;
	}
	

	public void expandMatrix(V v) {
		ArrayList<E>[][] aux=new ArrayList[this.edges.length+1][this.edges.length+1] ;
		valueToint.put(v, aux.length-1);
		intToValue.put(aux.length-1, v);
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				aux[i][j]=new ArrayList<E>();
			}
		}
		
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				aux[i][j]=edges[i][j];
			}
		}
		
		edges=aux;	
	}

	public V getValue(int v) {
		return intToValue.get(v);
	}
		
	

	public ArrayList<E>[][] getEdgesArray() {
		return this.edges;
	}


	public int getInteger(V v) throws Exception{
		
		
		if(valueToint.containsKey(v)) {
			return valueToint.get(v);
		}else{
			throw new Exception("El valor no fue encontrado");
		}
			
	}
	@Override
	public ArrayList<V> getValues() {
		
		ArrayList<V> hi=new ArrayList<V> ();
		for (int i = 0; i < edges.length; i++) {
		
				 hi.add(intToValue.get(i));
			
		}
		
		return hi;
	}
	@Override
	public ArrayList<Object[]> getEdges() {
		// TODO Auto-generated method stub
		ArrayList<Object[]> aux=new ArrayList<Object[]>();
		for (int i = 0; i < edges.length; i++) {
			 for (int j = 0; j < edges.length; j++) {
				 if(!edges[i][j].isEmpty()) {
					 aux.add(new Object[]{edges[i][j].get(0),intToValue.get(i),intToValue.get(j)});					 
				 }
			}
			
		}
		return aux;
	}
	
	@Override
	public boolean addVertex(V v) {
	
		if(!valueToint.containsKey(v)) {
			this.expandMatrix(v);
			return true;
		}else
		return false;
	}
	@Override
	public E getLabel(V v1, V v2) {
	
		if(valueToint.containsKey(v1) && valueToint.containsKey(v2)) {
			return (E) edges[valueToint.get(v1)][valueToint.get(v2)].get(0);
		}else
			return null;
		
	}
	@Override
	public ArrayList<V> getNeighbors(V v) {
		// TODO Auto-generated method stub
		ArrayList<V>  aux=new ArrayList<V>();
		int a=valueToint.get(v);
		for (int i = 0; i < edges.length; i++) {
			if(edges[a][i].size()!=0) {
				aux.add(intToValue.get(i));
			}
		}
		
		return aux;
	}
	@Override
	public boolean isThereEdge(V v1, V v2) {
		int i=valueToint.get(v1);
		int j=valueToint.get(v2);
		return !edges[i][j].isEmpty();
	}
	@Override
	public boolean isUndirected() {
		return undirected;
	}
	@Override
	public int getNumberOfVertices() {
		return edges.length;
	}
	@Override
	public IGraph<V, E> transformToMyOpposite() {
		GraphAdyacen<V,E> gl=new GraphAdyacen<>(undirected);
		ArrayList<Object[]> edges=this.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			gl.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		return gl;
	}
	

}