package colas;

public class NodeQueue <V>{


		private V valor;
		private NodeQueue siguiente;

		public NodeQueue() {
			super();
			this.valor = null;

		}

		public V getValor() {
			return valor;
		}

		public void setValor(V valor) {
			this.valor = valor;
		}

		public NodeQueue getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(NodeQueue siguiente) {
			this.siguiente = siguiente;
		}
	}

