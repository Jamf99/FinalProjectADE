package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import structures.Edge;
import structures.GraphMatrix;
import structures.Vertex;

class GraphMatrixTest extends TestCase {
	
	private GraphMatrix<String, Integer> graphMatrix;
	
	private void stage1() {
		graphMatrix = new GraphMatrix<String, Integer>(true);
	}
	
	@Test
	public void testAddEdge1() {
		stage1();
		assertEquals(0, graphMatrix.getMatrix().length);
	}
	
	private void stage2() {
		graphMatrix = new GraphMatrix<String, Integer>(true);
	}
	
	@Test
	public void testAddEdge2() {
		stage2();
		Vertex<String> vertex1 = new Vertex<String>("A");
		Vertex<String> vertex2 = new Vertex<String>("B");
		Edge<String, Integer> edge = new Edge<String, Integer>("C", 50);
		graphMatrix.addEdge(vertex1, vertex2, edge.getValue());
		assertTrue(graphMatrix.getMatrix().length == 0);
	}
	
	private void stage3() {
		graphMatrix = new GraphMatrix<String, Integer>(true);
	}
	
	@Test
	public void testAddVertex() {
		stage3();
		Vertex<String> vertex1 = new Vertex<String>("A");
		graphMatrix.addVertex(vertex1);
		assertTrue(graphMatrix.getMatrix().length == 1);
	}
	
}
