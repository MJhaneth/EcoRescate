package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VentanaPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JLabel etiquetaMensaje;
    private List<JLabel> animales;
    private List<JLabel> basuras;
    private Random random;

    public VentanaPrincipal() {
        setTitle("EcoRescate");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); 
        panelPrincipal.setBackground(new Color(144, 238, 144)); 

        etiquetaMensaje = new JLabel("¡Bienvenido a EcoRescate! Ayuda a salvar el medio ambiente.");
        etiquetaMensaje.setBounds(100, 10, 600, 30);
        etiquetaMensaje.setHorizontalAlignment(JLabel.CENTER);
        etiquetaMensaje.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(etiquetaMensaje);

        JButton botonRescatar = new JButton("Rescatar Animales");
        botonRescatar.setBounds(100, 500, 200, 30);
        botonRescatar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                rescatarAnimal();
            }
        });
        panelPrincipal.add(botonRescatar);

        JButton botonLimpiar = new JButton("Limpiar Basura");
        botonLimpiar.setBounds(500, 500, 200, 30);
        botonLimpiar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                limpiarBasura();
            }
        });
        panelPrincipal.add(botonLimpiar);

        animales = new ArrayList<>();
        basuras = new ArrayList<>();
        random = new Random();
        generarAnimalesYBasura();

        add(panelPrincipal);
    }

    private void generarAnimalesYBasura() {
        // Generar animales
        for (int i = 0; i < 5; i++) {
            JLabel animal = new JLabel(new ImageIcon("C:\\Proyectos\\EcoRescate\\imagenes\\animal.png")); // Ruta al ícono del animal
            animal.setBounds(random.nextInt(700), random.nextInt(400), 50, 50);
            animales.add(animal);
            panelPrincipal.add(animal);
        }

        // Generar basura
        for (int i = 0; i < 5; i++) {
            JLabel basura = new JLabel(new ImageIcon("C:\\Proyectos\\EcoRescate\\imagenes\\basura.png")); // Ruta al ícono de la basura
            basura.setBounds(random.nextInt(700), random.nextInt(400), 50, 50);
            basuras.add(basura);
            panelPrincipal.add(basura);
        }
    }

    private void rescatarAnimal() {
        if (!animales.isEmpty()) {
            JLabel animal = animales.remove(0);
            panelPrincipal.remove(animal);
            panelPrincipal.repaint();
            etiquetaMensaje.setText("¡Has rescatado a un animal en peligro!");
        } else {
            etiquetaMensaje.setText("No hay más animales para rescatar.");
        }
    }

    private void limpiarBasura() {
        if (!basuras.isEmpty()) {
            JLabel basura = basuras.remove(0);
            panelPrincipal.remove(basura);
            panelPrincipal.repaint();
            etiquetaMensaje.setText("¡Has limpiado la basura del bosque!");
        } else {
            etiquetaMensaje.setText("No hay más basura para limpiar.");
        }
    }
}
