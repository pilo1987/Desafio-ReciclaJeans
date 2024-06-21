import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoServicio {
    public Scanner scanner;

    public ArchivoServicio(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cargarDatos() {
        System.out.println("--- Cargar Datos ---");
        Utilidad.tiempoEspera(2000);

        System.out.println("Ingresa la ruta donde se encuentra el archivo (Ej. C:\\Users\\TuUsuario\\Desktop\\ProductosImportados.csv): ");
        String rutaEsperada = "C:\\Users\\pilo\\Desktop\\ProductosImportados.csv";
        String rutaArchivo = scanner.nextLine().trim();

        if (rutaArchivo.equals(rutaEsperada)) {
            try (BufferedReader br = new BufferedReader(new FileReader(rutaEsperada))) {
                String linea;
                System.out.println("");
                System.out.println("--- Contenido del archivo CSV ---");
                System.out.println("");
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            }
        }
    }
}
