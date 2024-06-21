public class Utilidad {
    public Utilidad() {
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void tiempoEspera(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.err.println("Error al esperar: " + e.getMessage());
        }
    }
}