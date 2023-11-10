import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private List<String[]> preguntas;
    private int preguntaActual = 0; // Índice de la pregunta actual

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
        Collections.shuffle(preguntas);


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
        opcion1.setActionCommand("Opción 1"); // Configura el ActionCommand
        opcion1.setBounds(50, 80, 300, 25);
        grupoOpciones.add(opcion1);
        panel.add(opcion1);

        opcion2 = new JRadioButton("Opción 2");
        opcion2.setActionCommand("Opción 2"); // Configura el ActionCommand
        opcion2.setBounds(50, 110, 300, 25);
        grupoOpciones.add(opcion2);
        panel.add(opcion2);

        opcion3 = new JRadioButton("Opción 3");
        opcion3.setActionCommand("Opción 3"); // Configura el ActionCommand
        opcion3.setBounds(50, 140, 300, 25);
        grupoOpciones.add(opcion3);
        panel.add(opcion3);

        opcion4 = new JRadioButton("Opción 4");
        opcion4.setActionCommand("Opción 4"); // Configura el ActionCommand
        opcion4.setBounds(50, 170, 300, 25);
        grupoOpciones.add(opcion4);
        panel.add(opcion4);

        // Crear un botón para enviar la respuesta
        JButton botonResponder = new JButton("Responder");
        botonResponder.setBounds(50, 200, 100, 25);
        panel.add(botonResponder);

        // Agregar un ActionListener al botón para manejar la respuesta del usuario
        botonResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta();
            }
        });

        // Mostrar la primera pregunta del nivel de dificultad seleccionado
        mostrarSiguientePregunta();

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private void verificarRespuesta() {
    String[] pregunta = preguntas.get(preguntaActual);
    String respuestaCorrecta = pregunta[7]; // La respuesta correcta se encuentra en el campo 7

    // Obtener el modelo del botón seleccionado por el usuario
    ButtonModel model = grupoOpciones.getSelection();
    
    if (model instanceof DefaultButtonModel) {
        // Obtener el botón de radio del modelo
        JRadioButton respuestaSeleccionada = (JRadioButton) ((DefaultButtonModel) model).getGroup().getElements().nextElement();

        if (respuestaSeleccionada != null) {
            String respuestaUsuario = respuestaSeleccionada.getText();
            if (respuestaUsuario.equals(respuestaCorrecta)) {
                respuestasCorrectas++; // Incrementa el contador de respuestas correctas
                JOptionPane.showMessageDialog(frame, "¡Respuesta correcta!", "Feedback", JOptionPane.INFORMATION_MESSAGE);
            } else {
                respuestasIncorrectas++; // Incrementa el contador de respuestas incorrectas
                JOptionPane.showMessageDialog(frame, "Respuesta incorrecta. La respuesta correcta es: " + respuestaCorrecta, "Feedback", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, seleccione una respuesta.", "Feedback", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Mostrar la siguiente pregunta
    mostrarSiguientePregunta();
}
    
    // Mostrar puntuacion
    private void mostrarPuntuacion() {
        JOptionPane.showMessageDialog(frame, "Puntuación final:\nRespuestas correctas: " + respuestasCorrectas + "\nRespuestas incorrectas: " + respuestasIncorrectas, "Puntuación", JOptionPane.INFORMATION_MESSAGE);
    }


    private void mostrarSiguientePregunta() {
        if (preguntaActual < preguntas.size() - 1 && preguntaActual<4) {
            preguntaActual++;
            String[] pregunta = preguntas.get(preguntaActual);
            etiquetaPregunta.setText(pregunta[2]);
            opcion1.setText(pregunta[3]);
            opcion2.setText(pregunta[4]);
            opcion3.setText(pregunta[5]);
            opcion4.setText(pregunta[6]);
            grupoOpciones.clearSelection(); // Limpiar la selección de respuestas
        } else {
            mostrarPuntuacion();
            JOptionPane.showMessageDialog(frame, "Has completado todas las preguntas.", "Fin del cuestionario", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); // Cierra la ventana después de completar todas las preguntas
        }
    }
}