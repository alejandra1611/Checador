/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Checador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements Comprobador {
    private ArrayList<Registro> registros;
    private JTextArea areaRegistros;

    public MainFrame() {
        registros = new ArrayList<>();

        // Configuración de la ventana principal
        setTitle("Checador de Entradas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para mostrar registros
        areaRegistros = new JTextArea();
        areaRegistros.setEditable(false);
        add(new JScrollPane(areaRegistros), BorderLayout.CENTER);

        // Panel con botones de acción
        JPanel panelBotones = new JPanel();
        JButton btnEntrada = new JButton("Registrar Entrada");
        JButton btnSalida = new JButton("Registrar Salida");
        
        btnEntrada.addActionListener(e -> mostrarFormularioEntrada());
        btnSalida.addActionListener(e -> registrarSalida(JOptionPane.showInputDialog("Nombre del empleado:")));

        panelBotones.add(btnEntrada);
        panelBotones.add(btnSalida);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Método para mostrar un formulario de entrada
    private void mostrarFormularioEntrada() {
        String nombre = JOptionPane.showInputDialog("Nombre del empleado:");
        registrarEntrada(nombre);
    }

    @Override
    public void registrarEntrada(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            registros.add(new Registro(nombre));
            actualizarAreaRegistros();
        }
    }

    @Override
    public void registrarSalida(String nombre) {
        for (Registro registro : registros) {
            if (registro.toString().contains(nombre) && registro.toString().contains("No registrado")) {
                registro.registrarSalida();
                actualizarAreaRegistros();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró un registro de entrada para: " + nombre);
    }

    // Actualiza el área de texto con los registros actuales
    private void actualizarAreaRegistros() {
        areaRegistros.setText("");
        for (Registro registro : registros) {
            areaRegistros.append(registro + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}

