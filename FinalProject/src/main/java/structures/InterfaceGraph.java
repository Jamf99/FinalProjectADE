package structures;

import java.util.ArrayList;

public interface InterfaceGraph<V, E> {

	public void addEdge(V v1, V v2, int value);

	public void addVertex(V v1);

	public void removeEdge(E e);

	public void removeVertex(V v);

	public boolean IsUndirected();
}
