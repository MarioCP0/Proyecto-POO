//UNIVERSIDAD DEL VALLE DE GUATEMALA
//PROGRAMACIÓN ORIENTADA A OBJETOS
// DAHSRTY SECAIRA, MARIO CABRERA, ISABELLA RAMÍREZ, ESTEBAN RAMÍREZ
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Prueba representa una prueba de preguntas y respuestas.
 */
class Prueba {
    private List<String> preguntas;
    private List<String> respuestasCorrectas;

    /**
     * Constructor para crear una nueva prueba con una lista de preguntas y respuestas correctas.
     * @param preguntas Lista de preguntas de la prueba.
     * @param respuestasCorrectas Lista de respuestas correctas correspondientes a las preguntas.
     */
    public Prueba(List<String> preguntas, List<String> respuestasCorrectas) {
        this.preguntas = preguntas;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    /**
     * Obtiene la lista de preguntas de la prueba.
     * @return Lista de preguntas de la prueba.
     */
    public List<String> getPreguntas() {
        return this.preguntas;
    }

    /**
     * Establece la lista de preguntas de la prueba.
     * @param preguntas Nueva lista de preguntas de la prueba.
     */
    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * Obtiene la lista de respuestas correctas correspondientes a las preguntas de la prueba.
     * @return Lista de respuestas correctas.
     */
    public List<String> getRespuestasCorrectas() {
        return this.respuestasCorrectas;
    }

    /**
     * Establece la lista de respuestas correctas de la prueba.
     * @param respuestasCorrectas Nueva lista de respuestas correctas.
     */
    public void setRespuestasCorrectas(List<String> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    /**
     * Inicia la prueba, presenta las preguntas al usuario y calcula su puntuación.
     */
    public void iniciarPrueba() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
    
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println(preguntas.get(i));
            String respuestaUsuario = scanner.nextLine();
    
            if (respuestaUsuario.equalsIgnoreCase(respuestasCorrectas.get(i))) {
                score++;
            }
        }
    
        System.out.println("Tu puntuación es: " + score + "/" + preguntas.size());
    }
}
