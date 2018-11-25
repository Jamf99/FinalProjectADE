package structures;

import java.util.HashSet;

public class DisjointSet<V> extends HashSet<V> {

	protected V parent;

	public DisjointSet(V x) {
		super();
		parent = x;
		this.add(x);
	}

}
