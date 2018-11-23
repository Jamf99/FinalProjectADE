package structures;

import java.util.List;
import java.util.Set;

public interface InterfaceGraph<V> {

	public boolean isDirected();

	public void addVertex(V v);

	public void addEdge(V v1, V v2);

	public void addEdge(V v1, V v2, double w);

	public double getWeight(V v1, V v2) throws Exception;

	public boolean edgeExist(V v1, V v2);

	public List<V> getAdjacentVertices(V v);

	public Set<V> getVertices();

	public List<Edge<V>> getOutgoingEdges(V v);

	public void deleteVertex(V v);

	public void deleteEdge(V v1, V v2);

	public Set<Edge<V>> getEdges();

	public double[][] generateWeightMatrix();

}
