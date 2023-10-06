import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NivelDificultad {
    private String nombre;
    private List<Tema> temas;

    public NivelDificultad(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tema> getTemas() {
        return this.temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public void agregarTema(Tema tema) {
        this.temas.add(tema);
    }
}

