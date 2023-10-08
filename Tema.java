//UNIVERSIDAD DEL VALLE DE GUATEMALA
//PROGRAMACIÓN ORIENTADA A OBJETOS
// DAHSRTY SECAIRA, MARIO CABRERA, ISABELLA RAMÍREZ, ESTEBAN RAMÍREZ
/**
 * La clase Tema representa un tema de aprendizaje con un nombre, información y una prueba asociada.
 */
class Tema {
    private String nombre;
    private String informacion;
    private Prueba prueba;

    /**
     * Constructor para crear un nuevo objeto Tema con un nombre y una descripción.
     * @param nombre El nombre del tema.
     * @param informacion La descripción o información sobre el tema.
     */
    public Tema(String nombre, String informacion) {
        this.nombre = nombre;
        this.informacion = informacion;
    }

    /**
     * Obtiene el nombre del tema.
     * @return El nombre del tema.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del tema.
     * @param nombre El nuevo nombre para el tema.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la información del tema.
     * @return La información o descripción del tema.
     */
    public String getInformacion() {
        return this.informacion;
    }

    /**
     * Establece la información del tema.
     * @param informacion La nueva información o descripción del tema.
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * Obtiene la prueba asociada al tema.
     * @return La prueba asociada al tema.
     */
    public Prueba getPrueba() {
        return this.prueba;
    }

    /**
     * Establece la prueba asociada al tema.
     * @param prueba La nueva prueba asociada al tema.
     */
    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    /**
     * Muestra la información o descripción del tema en la consola.
     */
    public void mostrarInformacion() {
        System.out.println(this.informacion);
    }
}
