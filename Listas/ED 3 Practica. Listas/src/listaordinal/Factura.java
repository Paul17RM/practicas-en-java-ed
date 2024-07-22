package listaordinal;

import javax.swing.event.ListDataEvent;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        boolean estaLista = false;
        Iterador it = listaProductos.getIterador();
        while(it.hasNext() && !estaLista){
            Producto producto1 = it.next();
            if((producto1.getDescripcion().equals(producto.getDescripcion())) &&
                    producto1.getPrecio() == producto.getPrecio()){
                estaLista = true;
                producto1.setUnidades(producto1.getUnidades()+producto.getUnidades());
            }
        }
        if(!estaLista)
            listaProductos.insertar(producto);
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + dni + ". Fecha: " + fecha);
        listaProductos.mostrar();
        System.out.println("IMPORTE TOTAL: " + importeTotal() + "€");
    }

    public float importeTotal() {
        Iterador it = listaProductos.getIterador();
        float total = 0.0f;
        while(it.hasNext()){
            Producto producto = it.next();
            total = producto.getPrecio() * producto.getUnidades() + total;
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        int unidadesBorradas = 0;
        boolean estaLista = false;
        Iterador it = listaProductos.getIterador();
        while(it.hasNext() && !estaLista){
            Producto producto1 = it.next();
            if((producto1.getDescripcion().equals(producto.getDescripcion())) &&
                    producto1.getPrecio() == producto.getPrecio()){
                estaLista = true;
                if(producto.getUnidades() < producto1.getUnidades()) {
                    unidadesBorradas = producto1.getUnidades() - producto.getUnidades();
                    producto1.setUnidades(unidadesBorradas);
                }
                else{
                    unidadesBorradas = producto1.getUnidades();
                    listaProductos.borrar(producto1);
                }

            }
        }
        return unidadesBorradas;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal lista = new ListaOrdinal();
        Iterador it = listaProductos.getIterador();
        while(it.hasNext()){
            Producto producto = it.next();
            if(producto.getPrecio() > precio)
                lista.insertar(producto);
        }
        return lista;
    }
}
