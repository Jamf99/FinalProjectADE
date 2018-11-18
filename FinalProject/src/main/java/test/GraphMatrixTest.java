package test;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import structures.Edge;
import structures.GraphMatrix;
import structures.Vertex;

class GraphMatrixTest extends TestCase {
	
	private GraphMatrix<String, Integer> graphMatrix;
	
	private void stage1() {
		graphMatrix = new GraphMatrix<String, Integer>(false);
	}
	
	@Test
	public void testAddEdge1() {
		stage1();
		assertEquals(0, graphMatrix.getMatrix().length);
	}
	
	private void stage2() {
		graphMatrix = new GraphMatrix<String, Integer>(false);
	}
	
	@Test
	public void testAddEdge2() {
		stage2();
		Vertex<String> vertex1 = new Vertex<String>("A");
		graphMatrix.addVertex(vertex1);
		Vertex<String> vertex2 = new Vertex<String>("B");
		graphMatrix.addVertex(vertex2);
		Edge<Vertex<String>, Integer> edge = new Edge<Vertex<String>, Integer>(vertex2, 50);
		graphMatrix.addEdge(vertex1, vertex2, edge.getValue());
		boolean flag = false;
		for(int i = 0; i < graphMatrix.getMatrix().length && !flag; i++) {
			for (int j = 0; j < graphMatrix.getMatrix()[0].length && !flag; j++) {
				if(graphMatrix.getMatrix()[i][j] != null) {
					if(graphMatrix.getMatrix()[i][j].compareTo(edge) == 0) {
						flag = true;
					}
				}
			}
		}
		assertTrue(flag);
	}
	
	private void stage3() {
		graphMatrix = new GraphMatrix<String, Integer>(true);
	}
	
	@Test
	public void testAddVertex() {
		stage3();
		Vertex<String> vertex1 = new Vertex<String>("A");
		graphMatrix.addVertex(vertex1);
		assertTrue(graphMatrix.getNumbers().size() == 1);
	}
	
}
