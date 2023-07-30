import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ProductoServicio productoServicio = new ProductoServicio();
    private ArchivoServicio archivoServicio =new ArchivoServicio();
    private Utilidad utilidad =new Utilidad();


    public Menu() {
        Productos producto1 = new Productos("Jean", "15000", "Es un Jean muy lindo con hermosos detalles","1500", "42", "Levis", "Azul marino");
        productoServicio.addProducto(producto1);
    }

    public void iniciarMenu() {

        int option;
        do {
            mostrarMenuPrincipal();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    utilidad.tiempoEspera("Listando productos", 100);
                    System.out.println("");
                    productoServicio.listarProductos();
                    break;
                case 2:
                    menuEdit();
                    break;
                case 3:
                    String path = archivoServicio.rutaImportarCsv();
                    ArrayList<Productos> listaCargada = archivoServicio.cargarDatos(path);
                    if (!listaCargada.isEmpty()){
                        System.out.println("La lista ha sido cargada con exito");
                    }
                    productoServicio.addListaProductos(listaCargada);
                    break;
                case 4:
                    utilidad.limpiezaPantalla();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
                    break;
            }

        }while (option != 5) ;
        System.out.println("Abandonando el sistema de clientes");
        System.out.println("Acaba de salir del sistema");
    }

    public void mostrarMenuPrincipal(){
        System.out.println("--------------MENÚ PRINCIPAL------------");
        System.out.println("1. Listar productos");
        System.out.println("2. Editar datos");
        System.out.println("3. Importar datos");
        System.out.println("4. Limpiar pantalla");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción: ");
    }

    public void menuEdit(){
        int option;
        System.out.println("Ingrese el número 1 para editar los datos ingresados del Producto");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Ingrese código del producto:");
                    String codProducto= scanner.nextLine();
                    Productos producto = productoServicio.getProductosPorCod(codProducto);
                    if(producto == null) {
                        System.out.println("Codigo no existe, ingrese nuevamente");
                        break;
                    }
                    int opcion;
                    do {
                        System.out.println("1.-El nombre del articulo actual es: "+ producto.getArticulo());
                        System.out.println("2.-El código del producto: "+ producto.getCodigo());
                        System.out.println("3.-El color del producto: "+ producto.getColor());
                        System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
                        System.out.println("5.-La marca del producto: "+ producto.getMarca());
                        System.out.println("6.--El precio del producto: " + producto.getPrecio());
                        System.out.println("7.-La talla del producto: " + producto.getTalla());
                        System.out.println("8.- Volver al menú");
                        System.out.println("Ingrese la opción a editar de los datos del producto: ");

                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del producto ");
                                String newName= scanner.nextLine();
                                producto.setArticulo(newName);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 2:
                                System.out.println("Ingrese nuevo código del producto: ");
                                String codProduct= scanner.nextLine();
                                producto.setCodigo(codProduct);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 3:
                                System.out.println("Ingrese nuevo color del producto: ");
                                String newColor= scanner.nextLine();
                                producto.setColor(newColor);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 4:
                                System.out.println("Ingrese nueva descripción del producto: ");
                                String newDescription= scanner.nextLine();
                                producto.setDescripcion(newDescription);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 5:
                                System.out.println("Ingrese nueva marca del producto: ");
                                String newBrand= scanner.nextLine();
                                producto.setMarca(newBrand);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 6:
                                System.out.println("Ingrese nuevo precio del producto: ");
                                String newPrice= scanner.nextLine();
                                producto.setPrecio(newPrice);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 7:
                                System.out.println("Ingrese nueva talla del producto: ");
                                String newSize= scanner.nextLine();
                                producto.setTalla(newSize);
                                utilidad.tiempoEspera("Editando producto", 100);
                                System.out.println("");
                                System.out.println("Datos cambiados con éxito");
                                break;
                            case 8:
                                System.out.println("Volviendo al menú ");
                                break;
                            default:
                                System.out.println("Ingrese opción válida");
                                break;

                        }
                    }while (opcion != 8);
                    break;
                default:
                    System.out.println("Volviendo a menú");
            }

    }

}