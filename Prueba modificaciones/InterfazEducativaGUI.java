import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class InterfazEducativaGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel etiquetaBienvenida;
    private JLabel etiquetaPregunta;
    private ButtonGroup grupoOpciones;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private JRadioButton opcion4;
    private Juego juego;
    private int preguntaActual = 0;
    private List<Pregunta> preguntas;

    public InterfazEducativaGUI(String nombreUsuario, String dificultad, List<Pregunta> preguntas) {
        this.preguntas = preguntas;
        // Inicializamos el juego con la lista de preguntas
        juego = new Juego(preguntas);

        // Configuración de la interfaz gráfica
        frame = new JFrame("CosmoGuía");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        etiquetaBienvenida = new JLabel("¡Bienvenido a CosmoGuía, " + nombreUsuario + "!");
        etiquetaBienvenida.setBounds(50, 20, 300, 25);
        panel.add(etiquetaBienvenida);

        etiquetaPregunta = new JLabel("");
        etiquetaPregunta.setBounds(50, 50, 300, 25);
        panel.add(etiquetaPregunta);

        grupoOpciones = new ButtonGroup();
        opcion1 = new JRadioButton("Opción 1");
        opcion1.setActionCommand("Opción 1");
        opcion1.setBounds(50, 80, 300, 25);
        grupoOpciones.add(opcion1);
        panel.add(opcion1);

        opcion2 = new JRadioButton("Opción 2");
        opcion2.setActionCommand("Opción 2");
        opcion2.setBounds(50, 110, 300, 25);
        grupoOpciones.add(opcion2);
        panel.add(opcion2);

        opcion3 = new JRadioButton("Opción 3");
        opcion3.setActionCommand("Opción 3");
        opcion3.setBounds(50, 140, 300, 25);
        grupoOpciones.add(opcion3);
        panel.add(opcion3);

        opcion4 = new JRadioButton("Opción 4");
        opcion4.setActionCommand("Opción 4");
        opcion4.setBounds(50, 170, 300, 25);
        grupoOpciones.add(opcion4);
        panel.add(opcion4);

        JButton botonResponder = new JButton("Responder");
        botonResponder.setBounds(50, 200, 100, 25);
        panel.add(botonResponder);

        botonResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta();
            }
        });

        mostrarSiguientePregunta();

        frame.setVisible(true);
    }

    private void verificarRespuesta() {
        ButtonModel model = grupoOpciones.getSelection();

        if (model instanceof DefaultButtonModel) {
            JRadioButton respuestaSeleccionada = (JRadioButton) ((DefaultButtonModel) model).getGroup().getElements().nextElement();

            if (respuestaSeleccionada != null) {
                String respuestaUsuario = respuestaSeleccionada.getText();
                juego.verificarRespuesta(respuestaUsuario);
                // Puedes agregar lógica adicional después de verificar la respuesta si es necesario
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, seleccione una respuesta.", "Feedback", JOptionPane.WARNING_MESSAGE);
            }
        }

        mostrarSiguientePregunta();
    }

    private void mostrarSiguientePregunta() {
        if (preguntaActual < preguntas.size() - 1 && preguntaActual < 4) {
            preguntaActual++;
            Pregunta pregunta = preguntas.get(preguntaActual);
    
            etiquetaPregunta.setText("<html>" + pregunta.getEnunciado() + "</html>");
            opcion1.setText(pregunta.getOpciones().get(0));
            opcion2.setText(pregunta.getOpciones().get(1));
            opcion3.setText(pregunta.getOpciones().get(2));
            opcion4.setText(pregunta.getOpciones().get(3));
            grupoOpciones.clearSelection(); 
        } else {
            mostrarNota(); // Corregir para llamar a mostrarNota en lugar de mostrarPuntuacion
            JOptionPane.showMessageDialog(frame, "Has completado todas las preguntas.", "Fin del cuestionario", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        }
    }
    
    
    private void mostrarNota() {
        int respuestasCorrectas = juego.obtenerRespuestasCorrectas();
        int totalPreguntas = 5;
    
        double nota = (double) respuestasCorrectas / totalPreguntas * 100;
    
        JOptionPane.showMessageDialog(frame, "Tu nota final es: " + nota + "%", "Nota Final", JOptionPane.INFORMATION_MESSAGE);
    }
    
}