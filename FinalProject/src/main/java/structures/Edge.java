package structures;

public class Edge<V> implements Comparable<Edge<V>> {
	/**
	 * peso de la arista, en este caso es de valor numerico
	 */
	private double value;

	/**
	 * vertice final de la arista
	 */
	private V ending;
	/**
	 * vertice inicial de la arista
	 */
	private V start;

	/**
	 * Constructor de la clase edge
	 * 
	 * @param start  vertice de inicio
	 * @param ending vertice final
	 * @param value  valor de la arista
	 */
	public Edge(V start, V ending, double value) {
		this.start = start;
		this.ending = ending;
		this.value = value;
	}

	/**
	 * get del atributo start
	 * 
	 * @return start
	 */
	public V getStart() {
		return start;
	}

	/**
	 * Set del atributo start
	 * 
	 * @param start
	 */
	public void setStart(V start) {
		this.start = start;
	}

	/**
	 * get del metodo value
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Set del metodo value
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * get del atributo ending
	 * 
	 * @return Ending
	 */
	public V getEnding() {
		return ending;
	}

	/**
	 * set del atributo ending
	 * 
	 * @param ending
	 */
	public void setEnding(V ending) {
		this.ending = ending;
	}

	/**
	 * Metodo que compara las aristas
	 */
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

	/**
	 * Metodo que me determina si la arista tiene el mismo vertice de incio como de
	 * final
	 */
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

	/**
	 * Metodo que devuelve el hashcode del inicio y del final.
	 */
	@Override
	public int hashCode() {
		int a = (start == null ? 0 : start.hashCode()) ^ (ending == null ? 0 : ending.hashCode());
		return a;
	}

}