package Estructuras;

import java.util.ArrayList;

public interface IGraph<V, E> {

	public boolean addEdge(E e, V v1, V v2);

	public boolean addVertex(V v);

	public ArrayList<V> getValues();

	public ArrayList<Object[]> getEdges();

	public E getLabel(V v1,V v2);
	
	public ArrayList<V> getNeighbors(V v);
	
	public boolean isThereEdge(V v1,V v2);
	
	public boolean isUndirected();
	public int getNumberOfVertices();
	public IGraph<V,E> transformToMyOpposite();
}