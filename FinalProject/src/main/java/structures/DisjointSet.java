package structures;

import java.util.HashSet;

public class DisjointSet<V> extends HashSet<V>{
	
	private static final long serialVersionUID = -2115162588983714676L;
	protected V parent;
	
	public DisjointSet(V x){
		super();
		parent=x;
		this.add(x);
	}

}
