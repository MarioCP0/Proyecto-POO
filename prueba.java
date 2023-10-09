import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Prueba {
    private List<String> preguntas;
    private List<String> respuestasCorrectas;

    public Prueba(List<String> preguntas, List<String> respuestasCorrectas) {
        this.preguntas = preguntas;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public List<String> getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }

    public List<String> getRespuestasCorrectas() {
        return this.respuestasCorrectas;
    }

    public void setRespuestasCorrectas(List<String> respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

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


