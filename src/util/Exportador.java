/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Empleado;
import model.Persona;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

// Exporta solo los empleados a un archivo de texto
public class Exportador {

    // Genera un archivo con el listado de empleados
    public static void exportarEmpleados(String nombreArchivo,
                                         List<? extends Persona> personas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));

            // Encabezado del archivo
            bw.write("LISTADO DE EMPLEADOS");
            bw.newLine();
            bw.write("--------------------");
            bw.newLine();

            // Recorre la lista y escribe solo los empleados
            for (Persona p : personas) {
                if (p instanceof Empleado) {
                    bw.write(p.mostrarDatos());
                    bw.newLine();
                }
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("Error exportando empleados");
        }
    }
}


