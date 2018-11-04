package Estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Estructuras.Vertex;

public class MinHeap<V,E extends Comparable<E>>{
	private HashMap<Vertex<V,E>,Integer> vertexSet;
	private Vertex<V,E>[] A;
	private int heapSize;
	public MinHeap(ArrayList<Vertex<V,E>> G){
		A=new Vertex[G.size()];
		heapSize=G.size()-1;
		vertexSet=new HashMap<Vertex<V,E>,Integer>();
		for (int i = 0; i < A.length; i++) {
			A[i]=G.get(i);
			vertexSet.put(G.get(i),i);
		}
		buildHeap();
	}
	public Vertex<V,E> extractMin() {
		Vertex<V,E> min=A[0];
		vertexSet.remove(min);
		A[0]=A[heapSize];
		heapSize--;
		minHeapify(0);
		return min;
	}
	private void minHeapify(int i) {
		int l=2*i+1;
		int r=2*i+2;
		int smallest=-1;
		if(l<=heapSize && A[l].getD()<A[i].getD()){
			smallest=l;
		}else{
			smallest=i;
		}
		if(r<=heapSize && A[r].getD()<A[smallest].getD()){
			smallest=r;
		}
		if(smallest!=i){
			vertexSet.replace(A[i],smallest);
			vertexSet.replace(A[smallest],i);
			Vertex<V,E> temp=A[i];
			A[i]=A[smallest];
			A[smallest]=temp;
			minHeapify(smallest);
		}
	}
	public boolean contains(Vertex<V,E> o) {
		return vertexSet.containsKey(o);
	}
	public void decreaseKey(Vertex<V,E> v,double d){
		int i=vertexSet.get(v);
		A[i].setD(d);
		int parent=(int) Math.ceil((i/2.0)-1);
		while(i>0 && A[parent].getD()>A[i].getD()){
			vertexSet.replace(A[parent],i);
			vertexSet.replace(A[i],parent);
			Vertex temp=A[parent];
			A[parent]=A[i];
			A[i]=temp;
			i=parent;
			parent=(int) Math.ceil((parent/2.0)-1);
		}
	}
	private void buildHeap(){
		for (int i = (A.length/2)-1; i >= 0; i--) {
			minHeapify(i);
		}
	}
	public boolean isEmpty() {
		return heapSize==-1;
	}
}