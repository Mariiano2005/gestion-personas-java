/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.*; //Para manejar archivos
import java.util.List;

// Maneja el guardado y lectura del archivo binario
//La serialización se realiza mediante ObjectOutputStream
public class ArchivoBinario {

    // Guarda la lista en un archivo binario
    public static void guardar(String nombreArchivo, List<?> lista) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream( //permite escribir objetos en ese archivo
                    new FileOutputStream(nombreArchivo));    //FileOutputStream crea el archivo
            oos.writeObject(lista);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error archivo binario");
        }
    }

    // Lee la lista desde el archivo binario
    // deserialización
    @SuppressWarnings("unchecked")
    public static <T> List<T> leer(String nombreArchivo) {
        try {
            ObjectInputStream ois = new ObjectInputStream( //ObjectInputStream permite leer objetos
                    new FileInputStream(nombreArchivo));   //FileInputStream abre el archivo
            List<T> lista = (List<T>) ois.readObject();    //readObject() devuelve un Objeto
            ois.close();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}


