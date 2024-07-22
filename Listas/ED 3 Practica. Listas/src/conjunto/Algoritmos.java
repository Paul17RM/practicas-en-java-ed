package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto interseccion = new Conjunto();
        if(!conjunto1.vacio() && !conjunto2.vacio()){
            int[] conj1 = conjunto1.toArray();
            for(int i=0; i<conjunto1.getNumElementos(); i++){
                if(conjunto2.contiene(conj1[i]))
                    interseccion.insertar(conj1[i]);
            }
        }
        return interseccion;
    }


}
