import java.util.Scanner;

class Usuario {
    private String nombre;
    private NivelDificultad nivelDificultad;
    private Tema temaActual;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelDificultad getNivelDificultad() {
        return this.nivelDificultad;
    }

    public void setNivelDificultad(NivelDificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public Tema getTemaActual() {
        return this.temaActual;
    }

    public void setTemaActual(Tema temaActual) {
        this.temaActual = temaActual;
    }

        public void elegirNivelDificultad(NivelDificultad nivel) {
            this.nivelDificultad = nivel;
            System.out.println("Has elegido el nivel de dificultad: " + nivel.getNombre());
        }

        public void elegirTema(Tema tema) {
            this.temaActual = tema;
            System.out.println("Has elegido el tema: " + tema.getNombre());
            tema.mostrarInformacion();
        }

        public void elegirNivelDificultad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, elige un nivel de dificultad: Básico, Intermedio, Avanzado");
        String nivel = scanner.nextLine();

        switch (nivel.toLowerCase()) {
            case "Básico":
                this.nivelDificultad = new NivelDificultad("Básico");
                break;
            case "Intermedio":
                this.nivelDificultad = new NivelDificultad("Intermedio");
                break;
            case "Avanzado":
                this.nivelDificultad = new NivelDificultad("Avanzado");
                break;
            default:
                System.out.println("No se reconoció el nivel de dificultad. Por favor, intenta de nuevo.");
                elegirNivelDificultad();
                break;
        }

        System.out.println("Has elegido el nivel de dificultad: " + nivel);
    }
    }


