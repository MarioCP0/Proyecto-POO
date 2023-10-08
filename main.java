//UNIVERSIDAD DEL VALLE DE GUATEMALA
//PROGRAMACIÓN ORIENTADA A OBJETOS
// DAHSRTY SECAIRA, MARIO CABRERA, ISABELLA RAMÍREZ, ESTEBAN RAMÍREZ
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta es la clase principal que contiene el método principal `main`.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario su nombre
        System.out.println("Por favor, introduce tu nombre:");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nombreUsuario);

        // Crear los niveles de dificultad
        NivelDificultad basico = new NivelDificultad("Básico");
        NivelDificultad intermedio = new NivelDificultad("Intermedio");
        NivelDificultad avanzado = new NivelDificultad("Avanzado");

        // Crear los temas
        Tema estrellas = new Tema("Estrellas", "Información sobre estrellas...");
        Tema galaxias = new Tema("Galaxias", "Información sobre galaxias...");
        Tema expansionUniverso = new Tema("Expansión del Universo", "Información sobre la expansión del universo...");

        // Asignar los temas a los niveles de dificultad
        basico.getTemas().add(estrellas);
        intermedio.getTemas().add(galaxias);
        avanzado.getTemas().add(expansionUniverso);

        // Crear las pruebas
        List<String> preguntasEstrellas = new ArrayList<>();
        preguntasEstrellas.add("Pregunta 1");
        preguntasEstrellas.add("Pregunta 2");

        List<String> respuestasEstrellas = new ArrayList<>();
        respuestasEstrellas.add("Respuesta 1");
        respuestasEstrellas.add("Respuesta 2");

        Prueba pruebaEstrellas = new Prueba(preguntasEstrellas, respuestasEstrellas);

        // Asignar la prueba al tema
        estrellas.setPrueba(pruebaEstrellas);

         // Crear un usuario
        usuario = new Usuario("Juan");

         // El usuario elige un nivel de dificultad y un tema
         usuario.elegirNivelDificultad(basico);
         usuario.elegirTema(estrellas);

         // El usuario estudia el tema y luego realiza una prueba
         estrellas.getPrueba().iniciarPrueba();
    }
}
