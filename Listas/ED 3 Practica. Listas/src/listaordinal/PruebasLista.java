package listaordinal;

import java.util.Iterator;

public class PruebasLista {
    public static void main(String[] args) {
        Producto mesaEscritorio = new Producto("Mesa escritorio", 185, 2);
        Producto sillaOficina = new Producto("Silla oficina", 95.9f, 3);
        Producto mesaCocina = new Producto("Mesa cocina", 125, 1);
        Producto sillonReclinable = new Producto("Sillón reclinable", 230, 2);

        ListaOrdinal lista = new ListaOrdinal();
        lista.insertar(mesaEscritorio);
        lista.insertar(sillaOficina);
        lista.insertar(mesaCocina);
        lista.insertar(sillonReclinable);
        System.out.println("---------- PRODUCTOS EN LA LISTA -----------");
        lista.mostrar();

        lista.borrar(sillaOficina);
        System.out.println("Después de borrar las sillas de oficina: ");
        lista.mostrar();

        Factura f1 = new Factura("12345678B", "17/03/2021");
        f1.añadirProducto(mesaEscritorio);
        f1.añadirProducto(sillaOficina);
        f1.añadirProducto(mesaCocina);
        f1.añadirProducto(sillonReclinable);
        Producto sillaOficina1 = new Producto("Silla oficina", 95.9f, 1);
        f1.añadirProducto(sillaOficina1);
        f1.mostrar();

        Producto sillaOficina2 = new Producto("Silla oficina", 95.9f, 2);
        Producto sillonReclinable1 = new Producto("Sillón reclinable", 230, 3);
        System.out.println("\nSe han eliminado " +
                (f1.eliminarProducto(sillaOficina2) + f1.eliminarProducto(sillonReclinable1)) + " unidades");
        f1.mostrar();

        System.out.println("\nSe han obtenido " + f1.mayoresPrecios(100).getNumElementos() +
                " productos con precio mayor a 100€ por unidad");
        f1.mayoresPrecios(100).mostrar();

        FacturaBib fbib = new FacturaBib("88888888A", "08/08/2008");
        Producto armario = new Producto("Armario", 385, 5);
        Producto cama = new Producto("Cama", 255, 3);
        Producto cama1 = new Producto("Cama", 255, 2);
        Producto armario1 = new Producto("Armario", 385, 1);
        fbib.añadirProducto(armario);
        fbib.añadirProducto(cama);
        fbib.añadirProducto(cama1);
        fbib.eliminarProducto(armario1);
        fbib.mostrar();
        System.out.println("\nSe han obtenido " + fbib.mayoresPrecios(250).size() +
                " productos con precio mayor a 250€ por unidad");
        Iterator<Producto> it = fbib.mayoresPrecios(250).iterator();
        while(it.hasNext())
            it.next().mostrar();
    }
}
