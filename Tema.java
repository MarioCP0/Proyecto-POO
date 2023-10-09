class Tema {
    private String nombre;
    private String informacion;
    private Prueba prueba;

    public Tema(String nombre, String informacion) {
        this.nombre = nombre;
        this.informacion = informacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return this.informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public Prueba getPrueba() {
        return this.prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public void mostrarInformacion() {
        System.out.println(this.informacion);
    }
}

