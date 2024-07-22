/**
 * Clase UtilizacionCola, para desarrollar los ejercicios propuestos en el
 * apartado 4
 *
 * Paul Brayan Rodríguez Isler, bs0172
 */
public class UtilizacionCola {

    public Cola leerTexto(ListaEtiquetas lista, String texto) {
        Cola cola = new Cola();
        String texto1[] = texto.split(" ");
        for(int i = 0; i < texto1.length; i++)
            if(lista.esEtiqueta(texto1[i]))
                cola.encolar(texto1[i]);
        return cola;
    }


    public boolean comprobarHtml(Cola cola, ListaEtiquetas lista) {
        Pila pila = new Pila();
        String nodo = new String();
        String cima = new String();
        boolean resultado = true;
        for(int i = 0; i < cola.getNumElementos(); i++){
            nodo = cola.desencolar();
            if(lista.esApertura(nodo))
                pila.apilar(nodo);
            if(lista.esCierre(nodo)){
                cima = pila.desapilar();
                if(lista.emparejados(cima, nodo))
                    resultado = true;
                else
                    pila.apilar(cima);
            }
            cola.encolar(nodo);
        }
        if(!pila.vacia()){
            System.out.println("En la pila quedan elementos: ");
            pila.mostrar();
            resultado = false;
        }
        return resultado;

    }
}
