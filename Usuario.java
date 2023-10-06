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
}

