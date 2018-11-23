package model;

import structures.Graph;
import structures.GraphList;
import structures.GraphMatrix;
import structures.InterfaceGraph;

public class Mio {
	
	private InterfaceGraph<String> graph;
	private Graph<String> operator;
	private boolean isMatrix;
	
	public Mio(boolean isMatrix) {
		if(isMatrix) {
			graph = new GraphMatrix<>(false);
		}else {
			graph = new GraphList<>(false);
		}
		operator = new Graph<String>();
		createGraph();
	}

	public InterfaceGraph<String> getGraph() {
		return graph;
	}

	public Graph<String> getOperator() {
		return operator;
	}

	public boolean isMatrix() {
		return isMatrix;
	}
	
	public void createGraph() {
		String v1 = graph.addVertex("Chiminangos");
		String v2 = graph.addVertex("Paso del Comercio");
		String v3 = graph.addVertex("Menga");
		String v4 = graph.addVertex("Torre de Cali");
		String v5 = graph.addVertex("San Bosco");
		String v6 = graph.addVertex("Sucre");
		String v7 = graph.addVertex("Flora industrial");
		String v8 = graph.addVertex("Salomia");
		String v9 = graph.addVertex("Melendez");
		String v10 = graph.addVertex("Unidad deportiva");
		String v11 = graph.addVertex("Manzana del saber");
		String v12 = graph.addVertex("Buitrera");
		String v13 = graph.addVertex("Pampalinda");
		String v14 = graph.addVertex("Refugio");
		String v15 = graph.addVertex("Univalle");
		String v16 = graph.addVertex("Universidades");
		graph.addEdge(v1, v2, 89);
		graph.addEdge(v1, v3, 49);
		graph.addEdge(v2, v3, 25);
		graph.addEdge(v3, v4, 15);
		graph.addEdge(v3, v7, 20);
		graph.addEdge(v4, v5, 17);
		graph.addEdge(v7, v4, 102);
	}
	
}
