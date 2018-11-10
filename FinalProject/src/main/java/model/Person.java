package model;

import java.util.ArrayList;

import structures.GraphList;
import structures.InterfaceGraph;

public class Person<V, E> implements InterfaceGraph<V, E>{
	private String ID;
	private boolean discapacitado;

	public Person(String iD, boolean discapacitado) {
		ID = iD;
		this.discapacitado = discapacitado;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isDiscapacitado() {
		return discapacitado;
	}

	public void setDiscapacitado(boolean discapaciteiro) {
		this.discapacitado = discapaciteiro;
	}

	@Override
	public V getVertex() {
		return null;
	}

	@Override
	public E getEdge() {
		return null;
	}

	@Override
	public void addEdge(E e, V v1, V v2) {
		
	}

	@Override
	public void addVetex(V v1) {
		
	}

	@Override
	public void removeEdge(E e) {
		
	}

	@Override
	public void removeVertex(V v) {
		
	}

	@Override
	public ArrayList<V> BFS(V v) {
		return null;
	}

	@Override
	public ArrayList<V> DFS(V v) {
		return null;
	}

	@Override
	public ArrayList<E> Dijstra(V v) {
		return null;
	}

	@Override
	public GraphList<V, E> Kruskal(V v) {
		return null;
	}

	@Override
	public GraphList<V, E> Prim(V v) {
		return null;
	}

	@Override
	public ArrayList<E> floydWarshall(V v) {
		return null;
	}

	@Override
	public boolean IsUndirected() {
		return false;
	}

}
