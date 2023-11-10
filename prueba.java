import java.util.List;

/**
 * Clase Pregunta que representa una pregunta de opción múltiple.
 */
public class prueba {
    private String enunciado;
    private List<String> opciones;
    private String respuestaCorrecta;

    /**
     * Constructor de la clase Pregunta.
     *
     * @param enunciado El enunciado de la pregunta.
     * @param opciones Las opciones de respuesta para la pregunta.
     * @param respuestaCorrecta La respuesta correcta para la pregunta.
     */
    public prueba(String enunciado, List<String> opciones, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Obtiene el enunciado de la pregunta.
     *
     * @return El enunciado de la pregunta.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Establece el enunciado de la pregunta.
     *
     * @param enunciado El nuevo enunciado de la pregunta.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Obtiene las opciones de respuesta de la pregunta.
     *
     * @return Las opciones de respuesta de la pregunta.
     */
    public List<String> getOpciones() {
        return opciones;
    }

    /**
     * Establece las opciones de respuesta de la pregunta.
     *
     * @param opciones Las nuevas opciones de respuesta de la pregunta.
     */
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    /**
     * Obtiene la respuesta correcta de la pregunta.
     *
     * @return La respuesta correcta de la pregunta.
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     * Establece la respuesta correcta de la pregunta.
     *
     * @param respuestaCorrecta La nueva respuesta correcta de la pregunta.
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}

