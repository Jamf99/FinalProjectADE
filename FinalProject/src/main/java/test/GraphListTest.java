package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;

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
		assertEquals("[]", graphList.getEdges().toString());
	}
	
}