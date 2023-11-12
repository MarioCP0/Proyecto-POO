import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInformacion extends JFrame {
    public VentanaInformacion() {
        // Configuracion de ventana
        setTitle("Información Importante");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea un panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Agrega el texto
        JLabel labelInformacion = new JLabel();
        labelInformacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelInformacion);
        
        // Agrega un botón para cerrar la ventana
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botonContinuar);

        // Agrega un ActionListener para cerrar la ventana
        botonContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana de información
            }
        });

        // Agrega el panel a la ventana
        add(panel);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // visible la ventana de información
        setVisible(true);

        String rutaArchivo = "informacion.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            StringBuilder contenidoArchivo = new StringBuilder();
            String linea;
            // Lee cada línea del archivo txt
            while ((linea = br.readLine()) != null) {
                // Agrega cada línea al contenido del archivo
                contenidoArchivo.append(linea).append("<br>");
            }
            // Establece el contenido de la interfaz con el contenido del archivo
            labelInformacion.setText("<html>" + contenidoArchivo.toString() + "</html>");
        } catch (IOException e) {
        // si el archivo no se encuentra lo ignora
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana de información
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInformacion();
            }
        });
    }
}
