import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación.
 */
public class main {
    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce tu nombre:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Por favor, elige un nivel de dificultad: Básico, Intermedio, Avanzado");
        String nivelDificultad = scanner.nextLine();

        InterfazEducativa interfaz = new InterfazEducativa(nombreUsuario, nivelDificultad);
    }
}
