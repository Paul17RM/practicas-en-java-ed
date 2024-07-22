import java.util.Stack;

/**
 * Clase UtilizacionStack, para desarrollar los ejercicios propuestos en el apartado 3
 * Paul Brayan Rodríguez Isler, bs0172
 * @version
 */
public class UtilizacionStack {

    public boolean comprobarLineaStack (ListaEtiquetas lista, String texto) {
        Stack <String> pila = new Stack<>();
        String texto1[] = texto.split(" ");
        String cima= new String();
        boolean resultado=true;
        for(int i = 0; i < texto1.length; i++){
            if(lista.esApertura(texto1[i]))
                pila.push(texto1[i]);
            if(lista.esCierre(texto1[i])){
                cima = pila.pop();
                if(lista.emparejados(cima, texto1[i]))
                    resultado = true;
                else
                    pila.push(cima);
            }
        }
        if(!pila.empty()){
            System.out.println("En la pila quedan elementos: ");
            mostrarInverso(pila);
            resultado = false;
        }
        return resultado;
    }

    public void mostrar (Stack <String> pila)  {
        if(!pila.empty()){
            String cima = pila.pop();
            System.out.println(cima);
            mostrar(pila);
            pila.push(cima);
        }
    }
    public void mostrarInverso (Stack <String> pila) {
        if(!pila.empty()){
            String cima = pila.pop();
            mostrarInverso(pila);
            System.out.println(cima);
            pila.push(cima);
        }
    }
}
