import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Esta clase representa una ventana de información.
 * La ventana muestra el contenido de un archivo de texto y tiene un botón para cerrar la ventana.
 */

public class VentanaInformacion extends JFrame {
    public VentanaInformacion() {
        setTitle("Información Importante");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelInformacion = new JLabel();
        labelInformacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelInformacion);
        
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botonContinuar);

        botonContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        add(panel);

        setLocationRelativeTo(null);

        setVisible(true);

        String rutaArchivo = "informacion.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            StringBuilder contenidoArchivo = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoArchivo.append(linea).append("<br>");
            }
            labelInformacion.setText("<html>" + contenidoArchivo.toString() + "</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método principal que crea una instancia de la clase VentanaInformacion.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInformacion();
            }
        });
    }
}
