import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Pregunta> preguntas = new ArrayList<>();
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private int preguntaActual = 0;
    

    public Juego(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
        Collections.shuffle(preguntas);
    }

    public Pregunta obtenerSiguientePregunta() {
        if (preguntaActual < preguntas.size()) {
            return preguntas.get(preguntaActual++);
        }
        return null;  
    }

    public void verificarRespuesta(String respuestaUsuario) {
        if (preguntas.size() > preguntaActual) {
            Pregunta pregunta = preguntas.get(preguntaActual);
            String respuestaCorrecta = pregunta.getRespuestaCorrecta();

        if (respuestaUsuario.equals(respuestaCorrecta)) {
            respuestasCorrectas++;
            // Lógica adicional de respuesta correcta
        } else {
            respuestasIncorrectas++;
            // Lógica adicional de respuesta incorrecta
        }}}
    public int obtenerRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public int obtenerRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }
}
