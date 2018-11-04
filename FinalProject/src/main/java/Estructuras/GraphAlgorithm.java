package Estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import Estructuras.MinHeap;
import Estructuras.ObjComparator;
import Estructuras.CommutativePair;
import Estructuras.UnionFind;

public class GraphAlgorithm<V,E extends Comparable<E>> {


	public IGraph<V,E> bfs(IGraph<V,E> g,V value) {
		GraphAdyacen<V,E> bfsTree=new GraphAdyacen<V,E>(g.isUndirected());
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			bfsTree.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		LinkedList<Vertex<V,E>>queue=new LinkedList<Vertex<V,E>>();
		Vertex<V,E> init=bfsTree.getVertex(value);
		init.setColor(1);
		queue.addFirst(init);
		while(!queue.isEmpty()) {
			Vertex<V,E> u=queue.removeLast();
			Iterator<Vertex<V,E>> it=u.neighborIterator();
			while(it.hasNext()) {
				Vertex<V,E> v=it.next();
				if(v.getColor()==0) {
					v.setAncestor(u);
					v.setColor(1);
					queue.addFirst(v);
				}
			}
		}
		return bfsTree;
	}

	public IGraph<V,E> dfs(IGraph<V, E> g) {
		GraphAdyacen<V,E> dfsTree=new GraphAdyacen<V,E>(g.isUndirected());
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {

			dfsTree.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		Iterator<V>it=dfsTree.valuesIterator();
		while(it.hasNext()) {
			V v = it.next();

			Vertex<V,E> init=dfsTree.getVertex(v);
			if(init.getColor()==0) {
				auxDFS(init);
			}
		}
		return dfsTree;
	}

	private void auxDFS(Vertex<V, E> u) {
		u.setColor(1);
		Iterator<Vertex<V,E>>it=u.neighborIterator();
		while(it.hasNext()) {
			Vertex v = it.next();
			Vertex<V,E> w=v;
			if(w.getColor()==0) {

				w.setAncestor(u);
				auxDFS(w);
			}else if(w.getColor() == 1 && u.getAncestor() != w){
				System.out.println(u.getValue() + " cicloancestro de " + w.getValue());
				w.addCycleAncestor(u);
			}
		}
		u.setColor(2);
	}

	public IGraph<V,E> dijkstra(IGraph<V, E> g,V v) {
	
		GraphAdyacen<V,E>dijkstraTree=new GraphAdyacen<V,E>(g.isUndirected());
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			dijkstraTree.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		ArrayList<Vertex<V,E>>vertices=new ArrayList<Vertex<V,E>>();
		ArrayList<V>values=dijkstraTree.getValues();
		for (int i = 0; i < values.size(); i++) {
			vertices.add(dijkstraTree.getVertex(values.get(i)));
		}
		dijkstraTree.getVertex(v).setD(0);
		MinHeap<V,E>priorityQueue=new MinHeap<V,E>(vertices);
		while(!priorityQueue.isEmpty()) {
			Vertex<V,E> u=priorityQueue.extractMin();
			Iterator<Vertex<V,E>> it=u.neighborIterator();
			while(it.hasNext()) {
				Vertex<V,E> w=it.next();
				E lab=u.getEdges(w).get(0).getLabel();
				if((Double.valueOf(lab.toString()))+u.getD()<w.getD()) {
					w.setAncestor(u);
					priorityQueue.decreaseKey(w,Double.valueOf(lab.toString())+u.getD());
				}
			}
		}
		return dijkstraTree;
	}


	public HashMap<CommutativePair<V,V>,Double> floydWarshall(IGraph<V, E> g) {
		ArrayList<V>values=g.getValues();
		HashMap<CommutativePair<V,V>,Double>matrix=new HashMap<>();
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.size(); j++) {
				CommutativePair<V,V>pair=new CommutativePair<>(values.get(i),values.get(j));
				if(!matrix.containsKey(pair)) {
					E label=g.getLabel(values.get(i),values.get(j));
					double val=0;
					if(label==null) {
						if(!values.get(i).equals(values.get(j))) {
							val=Double.MAX_VALUE;
						}
					}else {
						val=Double.parseDouble(label.toString());
					}
					matrix.put(pair,val);
				}
			}
		}
		for (int k = 0; k < values.size(); k++) {
			for (int i = 0; i < values.size(); i++) {
				for (int j = 0; j < values.size(); j++) {
					if(i!=j && k!=i && k!=j) {
						CommutativePair<V,V>pair1=new CommutativePair<>(values.get(i),values.get(j));
						CommutativePair<V,V>pair2=new CommutativePair<>(values.get(i),values.get(k));
						CommutativePair<V,V>pair3=new CommutativePair<>(values.get(k),values.get(j));
						Double dis1=matrix.get(pair1);
						Double dis2=matrix.get(pair2);
						Double dis3=matrix.get(pair3);
						if(dis1>dis2+dis3) {
							matrix.replace(pair1,dis2+dis3);
						}
					}
				}
			}
		}
		return matrix;
	}

	public IGraph<V,E> kruskal(IGraph<V, E> g) {
		GraphAdyacen<V,E>MSTKruskal=new GraphAdyacen<V,E>(g.isUndirected());
		ArrayList<Object[]> ed=g.getEdges();
		HashMap<V,Integer>valToInt=new HashMap<V,Integer>();
		Collections.sort(ed,new ObjComparator<E>());
		int actVal=0;
		UnionFind uf=new UnionFind(g.getNumberOfVertices());
		for (int i = 0; i < ed.size(); i++) {
			V a=(V) ed.get(i)[1];
			V b=(V) ed.get(i)[2];
			int aa=0;
			int bb=0;
			if(!valToInt.containsKey(a)) {
				valToInt.put(a,actVal);
				aa=actVal;
				actVal++;
			}else {
				aa=valToInt.get(a);
			}
			if(!valToInt.containsKey(b)) {
				valToInt.put(b,actVal);
				bb=actVal;
				actVal++;
			}else {
				bb=valToInt.get(b);
			}
			if(uf.find(aa)!=uf.find(bb)) {
				MSTKruskal.addEdge((E)ed.get(i)[0],(V)ed.get(i)[1],(V)ed.get(i)[2]);	
				uf.unite(aa,bb);
			}
		}
		return MSTKruskal;
	}


	public IGraph<V,E> prim(IGraph<V, E> g,V v) {

		GraphAdyacen<V,E>MSTPrim=new GraphAdyacen<V,E>(g.isUndirected());
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			MSTPrim.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		ArrayList<Vertex<V,E>>vertices=new ArrayList<Vertex<V,E>>();
		ArrayList<V>values=MSTPrim.getValues();
		for (int i = 0; i < values.size(); i++) {
			vertices.add(MSTPrim.getVertex(values.get(i)));
		}
		MSTPrim.getVertex(v).setD(0);		
		MinHeap<V,E>priorityQueue=new MinHeap<V,E>(vertices);
		while(!priorityQueue.isEmpty()) {
			Vertex<V,E> u=priorityQueue.extractMin();
			Iterator<Vertex<V,E>> it=u.neighborIterator();
			while(it.hasNext()) {
				Vertex<V,E> w=it.next();
				E lab=u.getEdges(w).get(0).getLabel();
				if(priorityQueue.contains(w)&&Double.valueOf(lab.toString())<w.getD()) {
					w.setAncestor(u);
					priorityQueue.decreaseKey(w,Double.valueOf(lab.toString()));
				}
			}
		}
		return MSTPrim;
	}

}