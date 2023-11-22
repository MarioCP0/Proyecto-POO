import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese la dificultad (Basico/Intermedio/Avanzado): ");
        String dificultad = scanner.nextLine();

        // Luego puedes usar estos datos para iniciar la interfaz gráfica
        iniciarInterfaz(nombreUsuario, dificultad);
    }

    private static void iniciarInterfaz(String nombreUsuario, String dificultad) {
        List<Pregunta> preguntas = LectorDePreguntas.leerPreguntasDesdeArchivo("preguntas.csv");

        // Verifica que las preguntas se carguen correctamente antes de iniciar la interfaz
        if (preguntas.isEmpty()) {
            System.out.println("Error al cargar las preguntas. Verifique el archivo CSV.");
        } else {
            new InterfazEducativaGUI(nombreUsuario, dificultad, preguntas);
        }
    }
}
