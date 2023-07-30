import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoServicio {
    Scanner scanner = new Scanner(System.in);

    public String rutaImportarCsv() {
        String ruta = "";
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        if (sistemaOperativo.contains("win")) {
            System.out.println("-----------Cargar Datos en Windows-----------");
            System.out.println("Ingresa la ruta en donde se encuentra el archivo  ProductosImportados.csv");
            ruta = scanner.nextLine();
        }
        else {
            System.out.println("----------Cargar Datos en Mac o Linux----------");
            System.out.println("Ingresa la ruta en donde se encuentra el archivo  DBClientes.csv:");
            ruta = scanner.nextLine();
        }

        return ruta;

    }
    public ArrayList<Productos> cargarDatos(String filePath) {
        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        try{
            FileReader fileReader = new FileReader(filePath+"/"+"ProductosImportados.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String productoCsv;
            while ((productoCsv = bufferedReader.readLine())!= null) {
                String[] productoArray = productoCsv.split(",");

                Productos newProducto = new Productos(productoArray[0],productoArray[1], productoArray[2],productoArray[3], productoArray[4], productoArray[5], productoArray[6]);
                listaProductos.add(newProducto);
            }
            bufferedReader.close();
            System.out.println("Se han cargado los datos exitosamente");
        }
        catch(Exception e){
            System.out.println("Error al cargar producto");
        }

    return listaProductos;
    }

}
