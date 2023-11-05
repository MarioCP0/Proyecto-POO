import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario su nombre
        System.out.println("Por favor, introduce tu nombre:");
        String nombreUsuario = scanner.nextLine();

        // Preguntar al usuario su nivel de dificultad
        System.out.println("Por favor, elige un nivel de dificultad: Básico, Intermedio, Avanzado");
        String nivelDificultad = scanner.nextLine();

        // Crear una nueva instancia de InterfazEducativa con los datos del usuario
        InterfazEducativa interfaz = new InterfazEducativa(nombreUsuario, nivelDificultad);
    }
}
