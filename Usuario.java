//UNIVERSIDAD DEL VALLE DE GUATEMALA
//PROGRAMACIÓN ORIENTADA A OBJETOS
// DAHSRTY SECAIRA, MARIO CABRERA, ISABELLA RAMÍREZ, ESTEBAN RAMÍREZ
/**
 * La clase Usuario representa un usuario en un programa de aprendizaje.
 */
class Usuario {
    private String nombre;
    private NivelDificultad nivelDificultad;
    private Tema temaActual;

    /**
     * Constructor para crear un nuevo objeto Usuario con un nombre.
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nuevo nombre para el usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nivel de dificultad actual del usuario.
     * @return El nivel de dificultad actual.
     */
    public NivelDificultad getNivelDificultad() {
        return this.nivelDificultad;
    }

    /**
     * Establece el nivel de dificultad actual del usuario.
     * @param nivelDificultad El nuevo nivel de dificultad para el usuario.
     */
    public void setNivelDificultad(NivelDificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
        System.out.println("Has elegido el nivel de dificultad: " + nivel.getNombre());
    }

    /**
     * Obtiene el tema actual elegido por el usuario.
     * @return El tema actual.
     */
    public Tema getTemaActual() {
        return this.temaActual;
    }

    /**
     * Establece el tema actual elegido por el usuario.
     * @param temaActual El nuevo tema actual elegido por el usuario.
     */
    public void setTemaActual(Tema temaActual) {
        this.temaActual = temaActual;
        System.out.println("Has elegido el tema: " + tema.getNombre());
        tema.mostrarInformacion();
    }

    /**
     * Permite al usuario elegir un nivel de dificultad.
     * @param nivel El nivel de dificultad elegido por el usuario.
     */
    public void elegirNivelDificultad(NivelDificultad nivel) {
        this.nivelDificultad = nivel;
        System.out.println("Has elegido el nivel de dificultad: " + nivel.getNombre());
    }

    /**
     * Permite al usuario elegir un tema.
     * @param tema El tema elegido por el usuario.
     */
    public void elegirTema(Tema tema) {
        this.temaActual = tema;
        System.out.println("Has elegido el tema: " + tema.getNombre());
        tema.mostrarInformacion();
    }
}
