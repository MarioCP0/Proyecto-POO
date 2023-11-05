import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterfazEducativa {
    private JFrame frame;
    private JPanel panel;
    private JButton botonIniciar;
    private JLabel etiquetaBienvenida;
    private JTextField campoNombre;
    private JComboBox<String> selectorDificultad;
    private List<String[]> preguntas;
    private ButtonGroup grupoOpciones;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private JRadioButton opcion4;

    public InterfazEducativa() {
        // Cargar las preguntas desde el archivo CSV
        preguntas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("astronomia.csv"))) {
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
        etiquetaBienvenida = new JLabel("¡Bienvenido al AstroEducación!");
        etiquetaBienvenida.setBounds(50, 20, 300, 25);
        panel.add(etiquetaBienvenida);

        // Crear el campo de texto para el nombre
        campoNombre = new JTextField(20);
        campoNombre.setBounds(50, 50, 300, 25);
        panel.add(campoNombre);

        // Crear el selector de dificultad
        String[] nivelesDificultad = {"Básico", "Intermedio", "Avanzado"};
        selectorDificultad = new JComboBox<>(nivelesDificultad);
        selectorDificultad.setBounds(50, 80, 300, 25);
        panel.add(selectorDificultad);

        // Crear los botones de opción para las respuestas
        grupoOpciones = new ButtonGroup();
        opcion1 = new JRadioButton("Opción 1");
        opcion1.setBounds(50, 110, 300, 25);
        grupoOpciones.add(opcion1);
        panel.add(opcion1);

        opcion2 = new JRadioButton("Opción 2");
        opcion2.setBounds(50, 140, 300, 25);
        grupoOpciones.add(opcion2);
        panel.add(opcion2);

        opcion3 = new JRadioButton("Opción 3");
        opcion3.setBounds(50, 170, 300, 25);
        grupoOpciones.add(opcion3);
        panel.add(opcion3);

        opcion4 = new JRadioButton("Opción 4");
        opcion4.setBounds(50, 200, 300, 25);
        grupoOpciones.add(opcion4);
        panel.add(opcion4);

        // Crear el botón de inicio
        botonIniciar = new JButton("Iniciar");
        botonIniciar.setBounds(150, 230, 100, 25);
        panel.add(botonIniciar);

        // Agregar un oyente al botón
        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código para iniciar tu programa
                String nombreUsuario = campoNombre.getText();
                String nivelDificultad = (String) selectorDificultad.getSelectedItem();
                System.out.println("¡El programa ha comenzado!");
                System.out.println("Nombre del usuario: " + nombreUsuario);
                System.out.println("Nivel de dificultad: " + nivelDificultad);

                // Buscar y mostrar la pregunta según el nivel de dificultad seleccionado
                for (String[] pregunta : preguntas) {
                    if (pregunta[0].equals(nivelDificultad)) {
                        String enunciado = pregunta[1];
                        String respuestaCorrecta = pregunta[2];
                        String[] opciones = {pregunta[3], pregunta[4], pregunta[5], pregunta[6]};
                        mostrarPregunta(enunciado, opciones, respuestaCorrecta);
                        break; // Mostrar solo la primera pregunta que coincida con el nivel
                    }
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private void mostrarPregunta(String enunciado, String[] opciones, String respuestaCorrecta) {
        // Mostrar la pregunta y opciones en la interfaz gráfica
        JOptionPane.showMessageDialog(frame, enunciado, "Pregunta", JOptionPane.PLAIN_MESSAGE);

        // Crear un arreglo de botones de opción para las respuestas
        JRadioButton[] botonesRespuesta = {opcion1, opcion2, opcion3, opcion4};

        // Asignar las opciones a los botones de opción
        for (int i = 0; i < botonesRespuesta.length; i++) {
            if (i < opciones.length) {
                botonesRespuesta[i].setText(opciones[i]);
                botonesRespuesta[i].setVisible(true);
            } else {
                botonesRespuesta[i].setVisible(false);
            }
        }

        // Mostrar los botones de opción y esperar a que el usuario seleccione una respuesta
        int seleccion = JOptionPane.showOptionDialog(frame, panel, "Elige una respuesta:",
                JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                botonesRespuesta, botonesRespuesta[0]);

        // Verificar si la respuesta seleccionada es correcta
        if (seleccion >= 0 && botonesRespuesta[seleccion].getText().equals(respuestaCorrecta)) {
            JOptionPane.showMessageDialog(frame, "¡Respuesta correcta!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Respuesta incorrecta. La respuesta correcta es: " + respuestaCorrecta, "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazEducativa();
        });
    }
}


