package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println ("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        }
    }



    public int[] toArray() {
        int[] array = new int[numElementos];
        if(!this.vacio()) {
            array[0] = inicio.getDato();
            Nodo actual = inicio.getSiguiente();
            for (int i = 1; i < numElementos; i++) {
                    array[i] = actual.getDato();
                    actual = actual.getSiguiente();
            }
        }
        return array;
    }


    public int mayor() {
        int mayor = -1;
        if(!this.vacio()){
            mayor = inicio.getDato();
            Nodo actual = inicio.getSiguiente();
            for(int i=1; i<numElementos; i++) {
                if(actual.getDato() > mayor)
                    mayor = actual.getDato();
                actual = actual.getSiguiente();
            }
        }
        return mayor;
    }

    public Conjunto subconjunto(int inferior, int superior) {
        Conjunto subconjunto = new Conjunto();
        if(!this.vacio()){
            int numero = inicio.getDato();
            if(numero >= inferior && numero <= superior)
                subconjunto.insertar(numero);
            Nodo actual = inicio.getSiguiente();
            for(int i=1; i<numElementos; i++){
                if(actual.getDato() >= inferior && actual.getDato() <= superior)
                    subconjunto.insertar(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
        return subconjunto;
    }

    public boolean equals(Conjunto conjunto) {
        boolean iguales = true;
        if(this.numElementos == conjunto.getNumElementos() && !this.vacio() && !conjunto.vacio()) {
                int numero = this.inicio.getDato();
                int numero2 = conjunto.inicio.getDato();
                if(numero != numero2)
                    iguales = false;
                Nodo actual = this.inicio.getSiguiente();
                Nodo actual2 = conjunto.inicio.getSiguiente();
                for(int i=1; i<numElementos && iguales; i++){
                    if(actual.getDato() != actual2.getDato())
                        iguales = false;
                    actual = actual.getSiguiente();
                    actual2 = actual2.getSiguiente();
                }
        }
        else
            iguales = false;
        return iguales;
    }




}
