package structures;

public class Edge<V> implements Comparable<Edge<V>> {
	/**
	 * 
	 */
	private double value;
	private V ending;
	private V start;

	public Edge(V start, V ending, double value) {
		this.start = start;
		this.ending = ending;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public V getEnding() {
		return ending;
	}

	public void setEnding(V ending) {
		this.ending = ending;
	}

	@Override
	public int compareTo(Edge<V> arg0) {

		double thisW = value;
		double argW = arg0.value;
		if (this.equals(arg0)) {

			return 0;
		} else if (thisW <= argW) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Edge)) {
			return false;
		}
		Edge<?> p = (Edge<?>) o;
		if (start.equals(p.start) && ending.equals(p.ending) && value == (p.value)
				|| start.equals(p.ending) && ending.equals(p.start) && value == (p.value)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		int a = (start == null ? 0 : start.hashCode()) ^ (ending == null ? 0 : ending.hashCode());
		return a;
	}

}