/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el
 * apartado 2
 *
 * Paul Brayan Rodríguez Isler, bs0172
 * @version
 */
public class UtilizacionPila {
    public boolean comprobarTexto (ListaEtiquetas lista, String texto) {
        Pila pila = new Pila();
        String texto1[] = texto.split(" ");
        String cima= new String();
        boolean resultado = true;
        for(int i = 0; i < texto1.length; i++){
            if(lista.esApertura(texto1[i]))
                pila.apilar(texto1[i]);
            if(lista.esCierre(texto1[i])){
                cima= pila.desapilar();
                if(lista.emparejados(cima, texto1[i]))
                    resultado=true;
                else
                    pila.apilar(cima);
            }
        }
        if(!pila.vacia()){
            System.out.println("En la pila quedan elementos:");
            mostrarInverso(pila);
            resultado= false;
        }
        return resultado;
    }
    public void mostrarInverso(Pila pila) {
        if(!pila.vacia()) {
            String cima = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(cima);
            pila.apilar(cima);
        }
     }
}

