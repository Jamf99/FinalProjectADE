package structures;

import java.util.HashSet;

public class DisjointSet<V> extends HashSet<V> {
	/**
	 * Atributo principal vertice del conjunto
	 */
	protected V parent;

	/**
	 * Constructor de la clase DisjoinSet que inicializara el conjunto y agregara al
	 * vertice a este mismo
	 * 
	 * @param x vertice a agregar.
	 */
	public DisjointSet(V x) {
		super();
		parent = x;
		this.add(x);
	}

}
