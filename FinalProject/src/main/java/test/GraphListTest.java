package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import structures.Edge;
import structures.GraphList;
import structures.Vertex;

class GraphListTest extends TestCase {

	private GraphList<String, Integer> graphList;

	private void stage1() {
		graphList = new GraphList<String, Integer>();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testAddVertex1() {
		stage1();
		assertNull(graphList.getGraph().get(0));
	}

	private void stage2() {
		graphList = new GraphList<String, Integer>();
	}

	@Test
	public void testAddVertex2() {
		stage2();
		Vertex<String> vertex = new Vertex<String>("A");
		graphList.addVertex(vertex);
		assertTrue(graphList.getGraph().containsKey(vertex));
	}

	private void stage3() {
		graphList = new GraphList<String, Integer>();
	}

	@Test
	public void testAddEdge1() {
		stage3();
		assertTrue(graphList.getEdges().isEmpty());
	}

	private void stage4() {
		graphList = new GraphList<String, Integer>();
	}
	
	@Test
	public void testAddEdge2() {
		stage4();
		Vertex<String> vertex1 = new Vertex<String>("A");
		graphList.addVertex(vertex1);
		Vertex<String> vertex2 = new Vertex<String>("B");
		graphList.addVertex(vertex2);
		Edge<Vertex<String>, Integer> edge = new Edge<Vertex<String>, Integer>(vertex2, 31);
		graphList.addEdge(vertex1, vertex2, edge.getValue());
		assertFalse(graphList.getEdges().isEmpty());
	}
	
	private void stage5() {
		graphList = new GraphList<String, Integer>();
	}
	
	@Test
	public void testRemoveVertex() {
		stage5();
		Vertex<String> vertex = new Vertex<String>("A");
		graphList.addVertex(vertex);
		graphList.removeVertex(vertex);
		assertFalse(graphList.getGraph().containsKey(vertex));
	}
	
}