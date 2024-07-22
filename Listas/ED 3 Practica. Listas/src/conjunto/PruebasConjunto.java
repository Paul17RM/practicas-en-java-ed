package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {
        Conjunto c1 = new Conjunto();
        c1.insertar(4);
        c1.insertar(6);
        c1.insertar(2);
        c1.insertar(4);
        c1.insertar(-2);
        System.out.println("Conjunto de trabajo:");
        c1.mostrar();

        System.out.print("\nEl array contiene: ");
        for(int i=0; i<c1.getNumElementos(); i++)
            System.out.print(c1.toArray()[i] + "  ");

        System.out.println("\nEl mayor elemento es: " + c1.mayor());

        System.out.print("El subconjunto entre 3 y 6 es: ");
        c1.subconjunto(3,6).mostrar();

        Conjunto c2 = new Conjunto();
        c2.insertar(2);
        c2.insertar(4);
        System.out.print("\nUn conjunto es: ");
        c2.mostrar();
        System.out.println("Es igual que el conjunto de trabajo? " + c1.equals(c2));
        c2.insertar(6);
        System.out.print("Un conjunto es: ");
        c2.mostrar();
        System.out.println("Es igual que el conjunto de trabajo? " + c1.equals(c2));

        Conjunto c3 = new Conjunto();
        c3.insertar(4);
        c3.insertar(5);
        Algoritmos al = new Algoritmos();
        System.out.println("La intersección de [ 4  5 ] con el de trabajo es: ");
        al.interseccion(c1, c3).mostrar();
    }

}
