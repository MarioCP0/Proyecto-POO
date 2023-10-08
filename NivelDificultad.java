//UNIVERSIDAD DEL VALLE DE GUATEMALA
//PROGRAMACIÓN ORIENTADA A OBJETOS
// DAHSRTY SECAIRA, MARIO CABRERA, ISABELLA RAMÍREZ, ESTEBAN RAMÍREZ
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase NivelDificultad representa un nivel de dificultad en un programa de aprendizaje.
 */
class NivelDificultad {
    private String nombre;
    private List<Tema> temas;

    /**
     * Constructor para crear un nuevo objeto NivelDificultad con un nombre dado.
     * @param nombre El nombre del nivel de dificultad.
     */
    public NivelDificultad(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del nivel de dificultad.
     * @return El nombre del nivel de dificultad.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del nivel de dificultad.
     * @param nombre El nuevo nombre para el nivel de dificultad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de temas asociados a este nivel de dificultad.
     * @return La lista de temas.
     */
    public List<Tema> getTemas() {
        return this.temas;
    }

    /**
     * Establece la lista de temas asociados a este nivel de dificultad.
     * @param temas La nueva lista de temas.
     */
    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    /**
     * Agrega un tema a la lista de temas asociados a este nivel de dificultad.
     * @param tema El tema a agregar.
     */
    public void agregarTema(Tema tema) {
        this.temas.add(tema);
    }
}
