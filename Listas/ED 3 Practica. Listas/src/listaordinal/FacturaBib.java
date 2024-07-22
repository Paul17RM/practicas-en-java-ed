package listaordinal;

import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new LinkedList<Producto>();
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
        Iterator<Producto> it = listaProductos.iterator();
        while(it.hasNext() && !estaLista){
            Producto producto1 = it.next();
            if(producto1.getDescripcion().equals(producto.getDescripcion())){
                estaLista = true;
                producto1.setUnidades(producto1.getUnidades()+producto.getUnidades());
            }
        }
        if(!estaLista)
            listaProductos.add(producto);
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + dni + ". Fecha: " + fecha);
        Iterator<Producto> it = listaProductos.iterator();
        while(it.hasNext()){
            Producto producto = it.next();
            producto.mostrar();
        }
        System.out.println("IMPORTE TOTAL: " + importeTotal() + "€");
    }

    public float importeTotal() {
        Iterator<Producto> it = listaProductos.iterator();
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
        Iterator<Producto> it = listaProductos.iterator();
        while(it.hasNext() && !estaLista){
            Producto producto1 = it.next();
            if(producto1.getDescripcion().equals(producto.getDescripcion())){
                estaLista = true;
                if(producto.getUnidades() < producto1.getUnidades()) {
                    unidadesBorradas = producto1.getUnidades() - producto.getUnidades();
                    producto1.setUnidades(unidadesBorradas);
                }
                else{
                    unidadesBorradas = producto1.getUnidades();
                    listaProductos.remove(producto1);
                }

            }
        }
        return unidadesBorradas;
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        LinkedList<Producto> lista = new LinkedList<Producto>();
        Iterator<Producto> it = listaProductos.iterator();
        while(it.hasNext()){
            Producto producto = it.next();
            if(producto.getPrecio() > precio)
                lista.add(producto);
        }
        return lista;
    }
}
