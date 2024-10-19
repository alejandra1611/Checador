/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Checador;

import java.time.LocalDateTime;

public class Registro {
    private String nombreEmpleado;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Registro(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.horaEntrada = LocalDateTime.now();
    }

    public void registrarSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return nombreEmpleado + " - Entrada: " + horaEntrada + 
               " | Salida: " + (horaSalida != null ? horaSalida : "No registrado");
    }
}

