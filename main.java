import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
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
        Tema estrellas = new Tema("Estrellas", "Las estrellas son enormes esferas de gas caliente que emiten luz y calor a partir de la energía nuclear producida en su núcleo. Nuestro sol es una estrella.");
        Tema galaxias = new Tema("Galaxias", "Las galaxias son vastos sistemas compuestos por polvo, gas y millones de estrellas. Nuestra galaxia, la Vía Láctea, es solo una de las miles de millones de galaxias en el universo.");
        Tema expansionUniverso = new Tema("Expansión del Universo", "La expansión del universo es el fenómeno por el cual el universo se está expandiendo a un ritmo acelerado. Fue propuesto por primera vez por Edwin Hubble en 1929.");

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
         usuario.elegirNivelDificultad();
         usuario.elegirTema(estrellas);

         // El usuario estudia el tema y luego realiza una prueba
         estrellas.getPrueba().iniciarPrueba();
    }
}

