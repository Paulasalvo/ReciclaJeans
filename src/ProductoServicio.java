import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Productos> listaProductos = new ArrayList<Productos>();
    private Productos producto1 = new Productos("Jean\n", "15000\n", "Es un Jean muy lindo con hermosos detalles","1500", "42", "Levis", "Azul marino");

    public ProductoServicio(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public ProductoServicio(){

    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("La lista se encuentra vacía");
            return;
        }
        for (Productos productos: listaProductos) {
            System.out.println(productos.toString());
        }
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addProducto(Productos productos){
        listaProductos.add(productos);
    }
    public Productos getProductosPorCod (String codProductos) {
        for (Productos productos: listaProductos) {
            if (productos.getCodigo().equals(codProductos)) {
                return productos;
            }
        }
        return null;
    }
    public void addListaProductos(ArrayList<Productos> newlistaProductos) {
        this.listaProductos.addAll(newlistaProductos);
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "listaProductos=" + listaProductos +
                '}';
    }
}
