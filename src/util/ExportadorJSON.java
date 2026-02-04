/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Persona;
import model.Empleado;
import model.Cliente;
import model.Proveedor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

// Exporta la lista de personas a un archivo JSON
public class ExportadorJSON {

    // Genera un archivo JSON con todas las personas
    public static void exportar(String nombreArchivo,
                                List<? extends Persona> personas) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));

            // Inicio del JSON
            bw.write("[");
            bw.newLine();

            // Recorre la lista de personas
            for (int i = 0; i < personas.size(); i++) {

                Persona p = personas.get(i);

                bw.write("  {");
                bw.newLine();
                bw.write("    \"tipo\": \"" + p.getClass().getSimpleName() + "\",");
                bw.newLine();
                bw.write("    \"dni\": " + p.getDni() + ",");
                bw.newLine();
                bw.write("    \"nombre\": \"" + p.getNombre() + "\",");
                bw.newLine();
                bw.write("    \"edad\": " + p.getEdad());

                // Datos extras segun el tipo de persona
                if (p instanceof Empleado) {
                    Empleado e = (Empleado) p;
                    bw.write(",");
                    bw.newLine();
                    bw.write("    \"sueldo\": " + e.getSueldoBase());

                } else if (p instanceof Cliente) {
                    Cliente c = (Cliente) p;
                    bw.write(",");
                    bw.newLine();
                    bw.write("    \"email\": \"" + c.getEmail() + "\"");

                } else if (p instanceof Proveedor) {
                    Proveedor pr = (Proveedor) p;
                    bw.write(",");
                    bw.newLine();
                    bw.write("    \"empresa\": \"" + pr.getEmpresa() + "\"");
                }

                bw.newLine();
                bw.write("  }");

                // Agrega coma si no es el ultimo elemento
                if (i < personas.size() - 1) {
                    bw.write(",");
                }
                bw.newLine();
            }

            // Fin del JSON
            bw.write("]");
            bw.close();

        } catch (Exception e) {
            System.out.println("Error exportando JSON");
        }
    }
}


