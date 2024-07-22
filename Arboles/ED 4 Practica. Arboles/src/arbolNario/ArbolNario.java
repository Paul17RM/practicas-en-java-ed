package arbolNario;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		this.mostrarProfundidadRecursivo(this.raiz);
		System.out.println();
	}

	private void mostrarProfundidadRecursivo(NodoArbolNario nodo){
		if(nodo != null){
			System.out.print(nodo.getDato() + " ");
			IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
			while(it.hasNext())
				mostrarProfundidadRecursivo(it.next());
		}
	}


	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		PilaNodosArbolNario pila = new PilaNodosArbolNario();
		System.out.print("Profundidad Iterativo: ");
		if(raiz != null){
			pila.apilar(raiz);
			while(!pila.vacia()){
				NodoArbolNario nodo = pila.desapilar();
				System.out.print(nodo.getDato() + " ");
				IteradorAtrasListaNodosArbolNario it = nodo.getHijos().getIteradorAtras();
				while(it.hasPrevious()) {
					pila.apilar(it.previous());
				}
			}
		}
		System.out.println();
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		ColaNodosArbolNario cola = new ColaNodosArbolNario();
		System.out.print("Amplitud: ");
		if(raiz != null){
			cola.encolar(raiz);
			while(!cola.vacia()){
				NodoArbolNario nodo = cola.desencolar();
				System.out.print(nodo.getDato() + " ");
				IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
				while(it.hasNext()) {
					cola.encolar(it.next());
				}
			}
		}
		System.out.println();
	}
}