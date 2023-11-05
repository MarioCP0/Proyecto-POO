import java.util.List;
import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private List<String> opciones;
    private int respuestaCorrecta;
    private String nivel;

    public Pregunta(String enunciado, List<String> opciones, int respuestaCorrecta, String nivel) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.nivel = nivel;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getNivel() {
        return nivel;
    }
}
