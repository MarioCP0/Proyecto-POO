import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterfazEducativa {
    private JFrame frame;
    private JPanel panel;
    private JLabel etiquetaBienvenida;
    private JLabel etiquetaPregunta;
    private ButtonGroup grupoOpciones;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private JRadioButton opcion4;
    private List<String[]> preguntas;

    public InterfazEducativa(String nombreUsuario, String nivelDificultad) {
        // Cargar las preguntas desde el archivo CSV
        preguntas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("preguntas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                preguntas.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear el marco de la ventana
        frame = new JFrame("AstroEducación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear el panel
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        // Crear la etiqueta de bienvenida
        etiquetaBienvenida = new JLabel("¡Bienvenido al AstroEducación, " + nombreUsuario + "!");
        etiquetaBienvenida.setBounds(50, 20, 300, 25);
        panel.add(etiquetaBienvenida);

        // Crear la etiqueta para la pregunta
        etiquetaPregunta = new JLabel("");
        etiquetaPregunta.setBounds(50, 50, 300, 25);
        panel.add(etiquetaPregunta);

        // Crear los botones de opción para las respuestas
        grupoOpciones = new ButtonGroup();
        opcion1 = new JRadioButton("Opción 1");
        opcion1.setBounds(50, 80, 300, 25);
        grupoOpciones.add(opcion1);
        panel.add(opcion1);

        opcion2 = new JRadioButton("Opción 2");
        opcion2.setBounds(50, 110, 300, 25);
        grupoOpciones.add(opcion2);
        panel.add(opcion2);

        opcion3 = new JRadioButton("Opción 3");
        opcion3.setBounds(50, 140, 300, 25);
        grupoOpciones.add(opcion3);
        panel.add(opcion3);

        opcion4 = new JRadioButton("Opción 4");
        opcion4.setBounds(50, 170, 300, 25);
        grupoOpciones.add(opcion4);
        panel.add(opcion4);

        // Buscar la primera pregunta para el nivel de dificultad seleccionado
        for (String[] pregunta : preguntas) {
            if (pregunta[0].equals(nivelDificultad)) {
                etiquetaPregunta.setText(pregunta[2]);
                // Aquí puedes actualizar las opciones de respuesta
                opcion1.setText(pregunta[3]);
                opcion2.setText(pregunta[4]);
                opcion3.setText(pregunta[5]);
                opcion4.setText(pregunta[6]);
                break;  // Esto hará que solo se muestre la primera pregunta que coincida con el nivel de dificultad
            }
        }

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
