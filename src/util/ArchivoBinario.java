/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.*;
import java.util.List;

// Maneja el guardado y lectura del archivo binario
public class ArchivoBinario {

    // Guarda la lista en un archivo binario
    public static void guardar(String nombreArchivo, List<?> lista) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            oos.writeObject(lista);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error archivo binario");
        }
    }

    // Lee la lista desde el archivo binario
    @SuppressWarnings("unchecked")
    public static <T> List<T> leer(String nombreArchivo) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(nombreArchivo));
            List<T> lista = (List<T>) ois.readObject();
            ois.close();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}

