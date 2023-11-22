/**
 * Clase Usuario que representa a un usuario de la aplicación.
 */
public class Usuario {
    private String nombre;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
