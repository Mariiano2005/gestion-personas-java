/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Persona;
import model.Empleado;
import model.Cliente;
import model.Proveedor;

import java.io.BufferedWriter; //escribe texto mas eficientemente
import java.io.FileWriter; //crea el archivo
import java.util.List;

// Exporta la lista de personas a un archivo CSV
public class ExportadorCSV {

    // Genera un archivo CSV con todas las personas
    public static void exportar(String nombreArchivo,
                                List<? extends Persona> personas) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));

            // Encabezado del archivo CSV
            bw.write("tipo,dni,nombre,edad,extra");
            bw.newLine();

            // Recorre la lista y escribe cada persona segun su tipo
            for (Persona p : personas) {

                if (p instanceof Empleado) {
                    Empleado e = (Empleado) p;
                    bw.write("Empleado," + e.getDni() + "," + e.getNombre() + "," +
                             e.getEdad() + "," + e.getSueldoBase());

                } else if (p instanceof Cliente) {
                    Cliente c = (Cliente) p;
                    bw.write("Cliente," + c.getDni() + "," + c.getNombre() + "," +
                             c.getEdad() + "," + c.getEmail());

                } else if (p instanceof Proveedor) {
                    Proveedor pr = (Proveedor) p;
                    bw.write("Proveedor," + pr.getDni() + "," + pr.getNombre() + "," +
                             pr.getEdad() + "," + pr.getEmpresa());
                }

                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error exportando CSV");
        }
    }
}



