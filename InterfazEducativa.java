import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase InterfazEducativa que representa la interfaz gráfica de usuario para una aplicación educativa.
 */

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
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private List<String[]> preguntas;
    private int preguntaActual = 0; 

    /**
     * Constructor de la clase InterfazEducativa.
     * @param nombreUsuario El nombre del usuario.
     * @param nivelDificultad El nivel de dificultad seleccionado por el usuario.
     */

    public InterfazEducativa(String nombreUsuario, String nivelDificultad) {
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
        Collections.shuffle(preguntas);


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
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        etiquetaPregunta = new JLabel("");
        scrollPane.setViewportView(etiquetaPregunta);

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

    /**
     * Método para verificar la respuesta seleccionada por el usuario.
     */
    private void verificarRespuesta() {
    String[] pregunta = preguntas.get(preguntaActual);
    String respuestaCorrecta = pregunta[7]; 

    ButtonModel model = grupoOpciones.getSelection();
    
    if (model instanceof DefaultButtonModel) {
        JRadioButton respuestaSeleccionada = (JRadioButton) ((DefaultButtonModel) model).getGroup().getElements().nextElement();

        if (respuestaSeleccionada != null) {
            String respuestaUsuario = respuestaSeleccionada.getText();
            if (respuestaUsuario.equals(respuestaCorrecta)) {
                respuestasCorrectas++; 
                JOptionPane.showMessageDialog(frame, "¡Respuesta correcta!", "Feedback", JOptionPane.INFORMATION_MESSAGE);
            } else {
                respuestasIncorrectas++; 
                JOptionPane.showMessageDialog(frame, "Respuesta incorrecta. La respuesta correcta es: " + respuestaCorrecta, "Feedback", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, seleccione una respuesta.", "Feedback", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    mostrarSiguientePregunta();
}
    /**
     * Método para mostrar la puntuación final al usuario.
     */
    private void mostrarPuntuacion() {
        JOptionPane.showMessageDialog(frame, "Puntuación final:\nRespuestas correctas: " + respuestasCorrectas + "\nRespuestas incorrectas: " + respuestasIncorrectas, "Puntuación", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para mostrar la siguiente pregunta o finalizar el cuestionario.
     */
    private void mostrarSiguientePregunta() {
        if (preguntaActual < preguntas.size() - 1 && preguntaActual < 4) {
            preguntaActual++;
            String[] pregunta = preguntas.get(preguntaActual);

            etiquetaPregunta.setText("<html>" + pregunta[2] + "</html>");
            opcion1.setText(pregunta[3]);
            opcion2.setText(pregunta[4]);
            opcion3.setText(pregunta[5]);
            opcion4.setText(pregunta[6]);
            grupoOpciones.clearSelection(); 
        } else {
            mostrarPuntuacion();
            JOptionPane.showMessageDialog(frame, "Has completado todas las preguntas.", "Fin del cuestionario", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); 
        }
    }
}