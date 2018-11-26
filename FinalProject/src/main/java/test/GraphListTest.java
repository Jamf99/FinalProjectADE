package test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import structures.Edge;
import structures.GraphList;

class GraphListTest extends TestCase {

	private GraphList<String> graphList;

	private void stage1() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testIsDirected1() {
		stage1();
		assertTrue(graphList.isDirected());
	}
	
	private void stage2() {
		graphList = new GraphList<String>(false);
	}
	
	@Test
	public void testIsDirected2() {
		stage2();
		assertFalse(graphList.isDirected());
	}
	
	private void stage3() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testAddVertex1() {
		stage3();
		assertTrue(graphList.getVertices().isEmpty());
	}

	private void stage4() {
		graphList = new GraphList<String>(true);
	}

	@Test
	public void testAddVertex2() {
		stage4();
		graphList.addVertex("Perro");
		assertTrue(graphList.getVertices().contains("Perro"));
	}
	
	private void stage5() {
		graphList = new GraphList<String>(true);
	}

	@Test
	public void testAddEdge1() {
		stage5();
		assertTrue(graphList.getEdges().isEmpty());
	}

	private void stage6() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testAddEdge2() {
		stage6();
		graphList.addVertex("Perro");
		graphList.addVertex("Sapo");
		graphList.addEdge("Perro", "Sapo", 8.5);
		assertFalse(graphList.getEdges().isEmpty());
	}
	
	private void stage7() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testGetWeight() throws Exception {
		stage7();
		graphList.addVertex("Perro");
		graphList.addVertex("Sapo");
		graphList.addEdge("Perro", "Sapo", 8.5);
		assertEquals(8.5, graphList.getWeight("Perro", "Sapo"));
	}
	
	private void stage8() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testEdgeExist() {
		stage8();
		graphList.addVertex("Perro");
		graphList.addVertex("Sapo");
		graphList.addEdge("Perro", "Sapo");
		assertTrue(graphList.edgeExist("Perro", "Sapo"));
	}
	
	private void stage9() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testGetAdyacentVertex() {
		stage9();
		graphList.addVertex("Perro");
		graphList.addVertex("Sapo");
		graphList.addEdge("Perro", "Sapo");
		assertEquals("Sapo", graphList.getAdjacentVertices("Perro").get(0));
	}
	
	private void stage10() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testGetVertices() {
		stage10();
		
	}
	
	private void stage11() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testDeleteVertex() {
		stage11();
		graphList.addVertex("Perro");
		graphList.deleteVertex("Perro");
		assertFalse(graphList.getVertices().contains("Perro"));
	}
	
	private void stage12() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testDeleteEdge() {
		stage12();
		graphList.addVertex("Perro");
		graphList.addVertex("Sapo");
		graphList.addEdge("Perro", "Sapo");
		graphList.deleteEdge("Perro", "Sapo");
		assertFalse(graphList.edgeExist("Perro", "Sapo"));
	}
	
	private void stage13() {
		graphList = new GraphList<String>(true);
	}
	
	@Test
	public void testGetEdges() {
		stage13();
		
	}
	
	private void stage14() {
		graphList = new GraphList<String>(false);
	}
	
	@Test
	public void testGetOutgoingEdges() {
		stage14();
		graphList.addVertex("Perro");
		graphList.addVertex("Gato");
		graphList.addVertex("Sapo");
		graphList.addVertex("Rata");
		graphList.addEdge("Perro", "Gato", 5.4);
		graphList.addEdge("Gato", "Sapo", 6.1);
		graphList.addEdge("Perro", "Rata", 2.4);
		double[] nums = {6.1,5.4};
		ArrayList<Edge<String>> list = (ArrayList<Edge<String>>) graphList.getOutgoingEdges("Gato");
		double[] arr = new double[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = graphList.getOutgoingEdges("Gato").get(i).getValue();
		}
		assertArrayEquals(nums, arr, 0);
	}
	
	private void stage15() {
		graphList = new GraphList<String>(false);
	}
	
	@Test
	public void testGenerateWeightMatrix() {
		stage15();
		graphList.addVertex("Perro");
		graphList.addVertex("Gato");
		graphList.addVertex("Sapo");
		graphList.addVertex("Rata");
		graphList.addEdge("Perro", "Gato", 2.4);
		graphList.addEdge("Gato", "Sapo", 5.4);
		graphList.addEdge("Perro", "Rata", 6.1);
		double[][] nums = graphList.generateWeightMatrix();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i][j] == Double.POSITIVE_INFINITY) {
					nums[i][j] = -1.0;
				}
				System.out.print(nums[i][j] + "\t");
			}
			System.out.println();
		}
		double[][] matriz = { { 0.0, 5.4, -1.0, 2.4 }, {5.4, 0.0, -1.0, -1.0}, {-1.0, -1.0, 0.0, 6.1},
				{2.4, -1.0, 6.1, 0.0} };
		boolean pass = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i][j] != matriz[i][j]) {
					pass = false;
				}
			}
		}
		assertTrue(pass);
	}
	
}