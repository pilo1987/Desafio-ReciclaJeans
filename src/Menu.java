import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ProductoServicio productoServicio;
    private ArchivoServicio archivoServicio;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.productoServicio = new ProductoServicio();
        this.archivoServicio = new ArchivoServicio(this.scanner);
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Listar Producto");
            System.out.println("2. Editar Datos");
            System.out.println("3. Importar Datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    productoServicio.listarProducto();
                    Utilidad.tiempoEspera(2000);
                    break;

                case 2:
                    productoServicio.editarProducto();
                    Utilidad.tiempoEspera(2000);
                    break;

                case 3:
                    archivoServicio.cargarDatos();
                    break;

                case 4:
                    System.out.println("Abandonando el Sistema . . . ");
                    Utilidad.tiempoEspera(3000);
                    System.out.println("Acaba de salir del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida (1-4).");
                    Utilidad.tiempoEspera(2000);
                    break;
            }

        } while (opcion != 4);
        scanner.close();
    }
}