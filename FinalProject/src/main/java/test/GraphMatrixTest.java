//package test;
//
//import org.junit.jupiter.api.Test;
//
//import junit.framework.TestCase;
//import structures.Edge;
//import structures.GraphMatrix;
//import structures.Vertex;
//
//class GraphMatrixTest extends TestCase {
//	
//	private GraphMatrix<String, Integer> graphMatrix;
//	
//	private void stage1() {
//		graphMatrix = new GraphMatrix<String, Integer>(false);
//	}
//	
//	@Test
//	public void testAddEdge1() {
//		stage1();
//		assertEquals(0, graphMatrix.getMatrix().length);
//	}
//	
//	private void stage2() {
//		graphMatrix = new GraphMatrix<String, Integer>(false);
//	}
//	
//	@Test
//	public void testAddEdge2() {
//		stage2();
//		Vertex<String> vertex1 = new Vertex<String>("A");
//		graphMatrix.addVertex(vertex1);
//		Vertex<String> vertex2 = new Vertex<String>("B");
//		graphMatrix.addVertex(vertex2);
//		Edge<Vertex<String>, Integer> edge = new Edge<Vertex<String>, Integer>(vertex2, 50);
//		graphMatrix.addEdge(vertex1, vertex2, edge.getValue());
//		boolean flag = false;
//		for(int i = 0; i < graphMatrix.getMatrix().length && !flag; i++) {
//			for (int j = 0; j < graphMatrix.getMatrix()[0].length && !flag; j++) {
//				if(graphMatrix.getMatrix()[i][j] != null) {
//					if(graphMatrix.getMatrix()[i][j].compareTo(edge) == 0) {
//						flag = true;
//					}
//				}
//			}
//		}
//		assertTrue(flag);
//	}
//	
//	private void stage3() {
//		graphMatrix = new GraphMatrix<String, Integer>(false);
//	}
//	
//	@Test
//	public void testAddVertex() {
//		stage3();
//		Vertex<String> vertex1 = new Vertex<String>("A");
//		graphMatrix.addVertex(vertex1);
//		assertTrue(graphMatrix.getNumbers().size() == 1);
//	}
//
//	
//	@Test
//	public void testBFS() {
//		stage3();
//		Vertex<String> v1 = new Vertex<String>("A");
//		graphMatrix.addVertex(v1);
//		Vertex<String> v2 = new Vertex<String>("B");
//		graphMatrix.addVertex(v2);
//		Vertex<String> v3 = new Vertex<String>("C");
//		graphMatrix.addVertex(v3);
//		Vertex<String> v4 = new Vertex<String>("D");
//		graphMatrix.addVertex(v4);
//		Edge<Vertex<String>, Integer> edge1 = new Edge<Vertex<String>, Integer>(v2, 50);
//		graphMatrix.addEdge(v1, v2, edge1.getValue());
//		Edge<Vertex<String>, Integer> edge2 = new Edge<Vertex<String>, Integer>(v4, 20);
//		graphMatrix.addEdge(v2, v4, edge2.getValue());
//		Edge<Vertex<String>, Integer> edge3 = new Edge<Vertex<String>, Integer>(v3, 10);
//		graphMatrix.addEdge(v2, v3, edge3.getValue());
//		graphMatrix.BFS(v3);
//		Vertex<String>[] array = new Vertex[4];
//		array[0] = v1;
//		array[1] = v2;
//		array[2] = v3;
//		array[3] = v4;
//		for (int i = 0; i < graphMatrix.getNumbers().size(); i++) {
////			System.out.println(graphMatrix.getVisits()[i].getValue());
//			assertEquals(array[i].getValue(), graphMatrix.getVisits()[i].getValue());
//		}
////		assertArrayEquals(array, );
//	}
//	
//}
