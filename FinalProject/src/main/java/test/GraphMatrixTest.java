package test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import structures.Edge;
import structures.GraphMatrix;

class GraphMatrixTest extends TestCase {
	
	GraphMatrix<String> matrix;
	
	private void stage1() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetMatrix1() {
		stage1();
		int[][] number = new int[0][0];
		assertArrayEquals(number, matrix.getMatrix());
	}

	private void stage2() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetMatrix2() {
		stage2();
		assertNotNull(matrix.getMatrix());
	}
	
	private void stage3() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testIsDirected1() {
		stage3();
		assertTrue(matrix.isDirected());
	}

	private void stage4() {
		matrix = new GraphMatrix<String>(false);
	}

	@Test
	public void testIsDirected2() {
		stage4();
		assertFalse(matrix.isDirected());
	}
	
	private void stage5() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testAddVertex() {
		stage5();
		matrix.addVertex("Perro");
		assertTrue(matrix.getVertices().contains("Perro"));
	}
	
	private void stage6() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testAddEdge1() {
		stage6();
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Sapo", "Rata");
		assertFalse(matrix.getEdges().isEmpty());
	}
	
	private void stage8() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testAddEdge2() {
		stage8();
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Sapo", "Rata", 8);
		assertFalse(matrix.getEdges().isEmpty());
	}
	
	private void stage9() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetWeight1() throws Exception {
		stage9();
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Sapo", "Rata", 8.5);
		assertEquals(8.5, matrix.getWeight("Sapo", "Rata"));
	}
	
	private void stage10() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testEdgeExist() {
		stage10();
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Sapo", "Rata");
		assertTrue(matrix.edgeExist("Sapo", "Rata"));
	}
	
	private void stage11() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetAdjacentVertices() {
		stage11();
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Sapo", "Rata");
		assertEquals("Rata", matrix.getAdjacentVertices("Sapo").get(0));
	}
	
	private void stage12() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetVertices() {
		stage12();
		
	}
	
	private void stage13() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testDeleteVertex() {
		stage13();
		matrix.addVertex("Perro");
		matrix.deleteVertex("Perro");
		assertTrue(matrix.getVertices().isEmpty());
	}
	
	private void stage14() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testDeleteEdges() {
		stage14();
		matrix.addVertex("Perro");
		matrix.addVertex("Gato");
		matrix.addEdge("Perro", "Gato");
		matrix.deleteEdge("Perro", "Gato");
		assertTrue(matrix.getEdges().isEmpty());
	}

	private void stage16() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGetEdges() {
		stage16();
		
	}
	
	private void stage17() {
		matrix = new GraphMatrix<String>(false);
	}

	@Test
	public void testGetOutGoingEdges() {
		stage17();
		matrix.addVertex("Perro");
		matrix.addVertex("Gato");
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Perro", "Gato", 5.4);
		matrix.addEdge("Gato", "Sapo", 6.1);
		matrix.addEdge("Perro", "Rata", 2.4);
		double[] nums = {5.4,6.1};
		ArrayList<Edge<String>> list = (ArrayList<Edge<String>>) matrix.getOutgoingEdges("Gato");
		double[] arr = new double[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = matrix.getOutgoingEdges("Gato").get(i).getValue();
		}
		assertArrayEquals(nums, arr, 0);
	}
	
	private void stage18() {
		matrix = new GraphMatrix<String>(true);
	}

	@Test
	public void testGenerateWeightMatrix() {
		stage18();
		matrix.addVertex("Perro");
		matrix.addVertex("Gato");
		matrix.addVertex("Sapo");
		matrix.addVertex("Rata");
		matrix.addEdge("Perro", "Gato", 5.4);
		matrix.addEdge("Gato", "Sapo", 6.1);
		matrix.addEdge("Perro", "Rata", 2.4);
		double[][] nums = matrix.generateWeightMatrix();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(nums[i][j] == Double.POSITIVE_INFINITY) {
					nums[i][j] = -1.0;
				}
			}
		}
		
		double[][] matriz = {{0.0, 5.4, -1.0, 2.4},{-1.0, 0.0, 6.1, -1.0},{-1.0, -1.0, 0.0, -1.0},{-1.0, -1.0, -1.0, 0.0}};
		boolean pass = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(nums[i][j] != matriz[i][j]) {
					pass = false;
				}
			}
		}
		assertTrue(pass);
	}
	
}