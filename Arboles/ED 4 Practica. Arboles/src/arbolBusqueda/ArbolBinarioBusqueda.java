package arbolBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertarRec(raiz, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(dato);
		} else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return this.getNumElementos(this.raiz);
	}

	private int getNumElementos(NodoArbol nodo){
		int elementos;
		if(nodo == null)
			elementos = 0;
		else
			elementos = 1 + getNumElementos(nodo.getIzquierdo()) + getNumElementos(nodo.getDerecho());
		return elementos;
	}


	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return this.getNumMenores(clave, this.raiz);
	}

	private int getNumMenores(int clave, NodoArbol nodo){
		int numMenores;
		if(nodo == null)
			numMenores = 0;
		else{
			if(nodo.getDato().getMatricula() < clave)
				numMenores = 1 + getNumMenores(clave, nodo.getIzquierdo()) + getNumMenores(clave, nodo.getDerecho());
			else
				numMenores = getNumMenores(clave, nodo.getIzquierdo()) + getNumMenores(clave, nodo.getDerecho());
		}
		return numMenores;
	}

	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {
		return this.getMenorElemento(this.raiz, raiz.getDato());
	}

	private Alumno getMenorElemento(NodoArbol nodo, Alumno alumno){
		if(nodo != null)
			alumno = getMenorElemento(nodo.getIzquierdo(), nodo.getDato());
		return alumno;
	}

	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que claveMinimo y menor que claveMaximo
	public int getNumIntermedios(int claveMinimo, int claveMaximo) {
		return getNumIntermedios(claveMinimo, claveMaximo, raiz);
	}

	private int getNumIntermedios(int claveMinimo, int claveMaximo, NodoArbol nodo){
		int numIntermedios;
		if(nodo == null)
			numIntermedios = 0;
		else{
			if(nodo.getDato().getMatricula() > claveMinimo && nodo.getDato().getMatricula() < claveMaximo)
				numIntermedios = 1 + getNumIntermedios(claveMinimo, claveMaximo, nodo.getIzquierdo())
						+ getNumIntermedios(claveMinimo, claveMaximo, nodo.getDerecho());
			else
				numIntermedios = getNumIntermedios(claveMinimo, claveMaximo, nodo.getIzquierdo())
						+ getNumIntermedios(claveMinimo, claveMaximo, nodo.getDerecho());
		}
		return numIntermedios;
	}

}
