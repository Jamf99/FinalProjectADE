package colas;

public class Queue<V> {

	private int size;
	private NodeQueue<V> root, end;

	public Queue() {
		super();
		size = 0;
		root = null;
	}

	public void add(V v) {
		NodeQueue<V> nuevo;
		// System.out.println("llegue aqui");
		nuevo = new NodeQueue<V>();
		// System.out.println(nuevo);
		nuevo.setValor(v);
		// System.out.println(nuevo.getValor());
		nuevo.setSiguiente(null);

		if (this.isEmpty()) {
			root = nuevo;
			end = nuevo;
			size++;
		} else {

			NodeQueue<V> aux = (NodeQueue<V>) root;
			while (aux != null) {
				if (aux.getSiguiente() == null) {
					aux.setSiguiente(nuevo);
					// System.out.println("llegue aqui");
					end = nuevo;
					size++;
					break;
				}
				aux = (NodeQueue) aux.getSiguiente();

			}
		}
	}

	public void removeFisrt() {
		if (!this.isEmpty()) {
			root = (NodeQueue<V>) root.getSiguiente();
			size--;
		}
	}

	public NodeQueue<V> peek() {
		return root;
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}

	public int size() {
		return size;
	}

}
