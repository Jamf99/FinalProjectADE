package structures;

import java.util.HashMap;

public class UnionFind<V> {
	/**
	 * HashMap de vertice conjunto que contendra los conjuntos
	 */
	private HashMap<V, DisjointSet<V>> components;

	public UnionFind() {
		components = new HashMap<V, DisjointSet<V>>();

	}

	/**
	 * Metodo que encuentra el vertice dentro del conjunto al cual pertenece
	 * 
	 * @param x vertice a encontrar
	 * @return retornar el vertice
	 */
	public V find(V x) {

		return components.get(x).parent;

	}

	/**
	 * Cantidad de conjuntos disjuntos que hay.
	 * 
	 * @return devuelve un numero entero con la cantidad de conjuntos disjuntos que
	 *         hay.
	 */
	public int numberOfDisjointedComponents() {
		return components.values().size();
	}

	/**
	 * Metodo que me crea un nuevo conjunto si el vertice no pertenecia antes a
	 * alguno.
	 * 
	 * @param x -
	 */
	public void makeSet(V x) {
		if (!components.containsKey(x)) {
			components.put(x, new DisjointSet<V>(x));
		}
	}

	/**
	 * Metodo que me permitira unir 2 vertices en un solo conjunto
	 * 
	 * @param x vertice a unir
	 * @param y vertice a unir
	 */
	public void union(V x, V y) {
		V x1 = find(x);
		V x2 = find(y);
		if (!x1.equals(x2)) {
			DisjointSet<V> c1 = components.get(x1);
			DisjointSet<V> c2 = components.get(x2);
			if (c1.size() >= c2.size()) {
				for (V aux : c2) {
					c1.add(aux);
					components.replace(aux, c1);
				}

			} else {
				for (V aux : c1) {
					c2.add(aux);
					components.replace(aux, c2);
				}

			}
		}
	}

}
