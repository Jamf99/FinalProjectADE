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

	public V find(V x) {

		return components.get(x).parent;

	}

	public int numberOfDisjointedComponents() {
		return components.values().size();
	}

	public void makeSet(V x) {
		if (!components.containsKey(x)) {
			components.put(x, new DisjointSet<V>(x));
		}
	}

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
