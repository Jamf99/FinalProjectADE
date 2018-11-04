package Estructuras;

public class UnionFind{
	private int[] parent;
	public UnionFind(int numberVertices) {
		parent=new int[numberVertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i]=i;
		}
	}
	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
	public void unite(int x, int y) {
		parent[find(x)] = find(y);
	}
}
