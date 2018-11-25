package structures;

import java.util.List;
import java.util.Set;

public interface InterfaceGraph<V> {
	/**
	 * Metodo que agrega un vertice al grafo, siempre y cuando este vertice no forme
	 * parte del grafo
	 * 
	 * @param v vertice a agregar en el grafo
	 */
	public V addVertex(V v);

	/**
	 * Metodo que agrega una arista al grafo, siempre y cuando esa arista no forme parte ya del grafo.
	 * 
	 * @param v1 vertice incial
	 * @param v2 vertice final
	 */
	public void addEdge(V v1, V v2);

	/**
	 * Metodo que agrega una arista al grafo con el peso de esta, siempre y cuando esta no forme parte ya del grafo.
	 * 
	 * @param v1 vertice inicial
	 * @param v2 vertice final
	 * @param w  value de la arista
	 */
	public void addEdge(V v1, V v2, double w);

	/**
	 * Lista<Edge<V>> que contiene todas las aristas que provienen del vertice v.
	 * 
	 * @param v vertice que se va a analizar.
	 * @return Lista de aristas que provienen del vertice v.
	 */
	public List<Edge<V>> getOutgoingEdges(V v);

	/**
	 * metodo que elimina el vertice v del grafo
	 * 
	 * @param v vertice a eliminar
	 */
	public void deleteVertex(V v);

	/**
	 * Retorna una List<V> que contiene todos los vertices adyacentes al vertice
	 * especificado.
	 * 
	 * @param v el vertice objetivo.
	 * @return List<V> que contiene todos los vertices adyacentes al especificado.
	 *         Ademas la lista sera vacia si el vertice v no forma parte del grafo o
	 *         es parte del grafo pero no contiene vertices de adyacencia.
	 */
	public List<V> getAdjacentVertices(V v);

	/**
	 * retorna un un Set<V> que contiene los vertices del grafo
	 * 
	 * @return devuelve un set<V> que contiene todos los vertices del grafo.
	 */
	public Set<V> getVertices();

	/**
	 * retorna un un Set<Edge<V>> que contiene las aristas del grafo
	 * 
	 * @return devuelve un set<Edge<V>> que contiene todos las aristas del grafo.
	 */
	public Set<Edge<V>> getEdges();

	/**
	 * Metodo que elimina una arista del grafo.
	 * 
	 * @param v1 vertice A de inicio
	 * @param v2 Vertice B de final
	 */
	public void deleteEdge(V v1, V v2);

	public double getWeight(V v1, V v2) throws Exception;

	/**
	 * Metodo que me determina si el grafo es dirigido o no dirigido.
	 * 
	 * @return devuelve true si el grafo es dirigido, de lo contrario retorna false
	 */
	public boolean isDirected();

	/**
	 * Metodo me determina si existe un edge entre 2 vertex
	 * 
	 * @param v1 vertice de inicio
	 * @param v2 vertice final
	 * @return devuelve true si existe un arista que cumpla la condicion, false en
	 *         caso contrario
	 */
	public boolean edgeExist(V v1, V v2);

	/**
	 * Matriz de pesos de las aristas.
	 * 
	 * @return retorna los pesos del grafo
	 */
	public double[][] generateWeightMatrix();

}
