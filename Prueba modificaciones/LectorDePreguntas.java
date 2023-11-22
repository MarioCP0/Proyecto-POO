import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorDePreguntas {
    public static List<Pregunta> leerPreguntasDesdeArchivo(String rutaArchivo) {
        List<Pregunta> preguntas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nivelDificultad = campos[0];
                String enunciado = campos[2];
                List<String> opciones = Arrays.asList(campos[3], campos[4], campos[5], campos[6]);
                String respuestaCorrecta = campos[7];

                Pregunta pregunta = new Pregunta(enunciado, opciones, respuestaCorrecta);
                preguntas.add(pregunta);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores más robusto según tus necesidades
        }

        return preguntas;
    }
}
