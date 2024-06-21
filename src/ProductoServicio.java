import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;
    private Scanner scanner;

    public ProductoServicio() {
        this.listaProductos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        String rutaArchivoCSV = "C:\\Users\\pilo\\Desktop\\ProductosImportados.csv";
        cargarDatosDesdeCSV(rutaArchivoCSV);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void listarProducto() {
        System.out.println("");
        System.out.println("--- Lista de Productos ---");
        System.out.println("");

        for (Producto producto : listaProductos) {
            System.out.println("Nombre del Artículo: " + producto.getArticulo());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Talla: " + producto.getTalla());
            System.out.println("-------------------------------------");
        }
    }

    private void cargarDatosDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            listaProductos.clear();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length != 7) {
                    System.out.println("Error en el formato de la línea: " + linea);
                    continue;
                }

                Producto producto = new Producto();
                producto.setArticulo(datos[0].trim());
                producto.setPrecio(datos[1].trim());
                producto.setDescripcion(datos[2].trim());
                producto.setCodigo(datos[3].trim());
                producto.setTalla(datos[4].trim());
                producto.setMarca(datos[5].trim());
                producto.setColor(datos[6].trim());
                listaProductos.add(producto);

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void editarProducto() {
        System.out.println("");
        System.out.println("--- Editar Producto ---");
        System.out.println("Ingrese el número 1 para editar los datos ingresados del Producto");
        scanner.nextLine();

        System.out.println("Ingrese código del producto:");
        String codigoBuscado = scanner.nextLine();

        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigoBuscado)) {

                System.out.println("1.-El nombre del articulo actual es: " + producto.getArticulo());
                System.out.println("2.-El código del producto: " + producto.getCodigo());
                System.out.println("3.-El color del producto: " + producto.getColor());
                System.out.println("4.-La descripción del producto: " + producto.getDescripcion());
                System.out.println("5.-La marca del producto: " + producto.getMarca());
                System.out.println("6.-El precio del producto: " + producto.getPrecio());
                System.out.println("7.-La talla del producto: " + producto.getTalla());

                System.out.println("Ingrese la opción a editar de los datos del producto:");
                int seleccion = scanner.nextInt();
                scanner.nextLine();

                switch (seleccion) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nuevoArticulo = scanner.nextLine();
                        producto.setArticulo(nuevoArticulo);
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo código del producto: ");
                        String nuevoCodigo = scanner.nextLine();
                        producto.setCodigo(nuevoCodigo);
                        break;
                    case 3:
                        System.out.print("Ingrese el nuevo color del producto: ");
                        String nuevoColor = scanner.nextLine();
                        producto.setColor(nuevoColor);
                        break;
                    case 4:
                        System.out.print("Ingrese la nueva descripción del producto: ");
                        String nuevaDescripcion = scanner.nextLine();
                        producto.setDescripcion(nuevaDescripcion);
                        break;
                    case 5:
                        System.out.print("Ingrese la nueva marca del producto: ");
                        String nuevaMarca = scanner.nextLine();
                        producto.setMarca(nuevaMarca);
                        break;
                    case 6:
                        System.out.print("Ingrese el nuevo precio del producto: ");
                        String nuevoPrecio = scanner.nextLine();
                        producto.setPrecio(nuevoPrecio);
                        break;
                    case 7:
                        System.out.print("Ingrese la nueva talla del producto: ");
                        String nuevaTalla = scanner.nextLine();
                        producto.setTalla(nuevaTalla);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                System.out.println("Producto editado correctamente.");
                System.out.println("");
                break;
            }
        }
    }
}