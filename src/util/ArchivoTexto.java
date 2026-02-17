/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Persona;
import java.io.BufferedWriter; //escribe texto mas eficientemente
import java.io.FileWriter;  //crea el archivo
import java.util.List; 

// Guarda las personas en un archivo de texto
public class ArchivoTexto {

    // Guarda el listado de personas en un archivo .txt
    public static void guardarPersonas(String nombreArchivo,
                                       List<? extends Persona> personas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo)); //FileWriter rea el archivo // BufferedWriter permite escribir líneas mas rapido

            // Encabezado del archivo
            bw.write("LISTADO DE PERSONAS");
            bw.newLine();
            bw.write("-------------------");
            bw.newLine();

            // Escribe cada persona en el archivo
            for (Persona p : personas) {
                bw.write(p.mostrarDatos());
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("Error archivo texto");
        }
    }
}



