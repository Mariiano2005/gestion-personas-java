/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Persona;
import java.util.ArrayList;
import java.util.List;

// Clase que se encarga de manejar la lista de personas
public class GestorPersonas<T extends Persona> implements Crud<T> {

    // Lista donde se guardan las personas
    private List<T> personas;

    // Constructor
    public GestorPersonas() {
        personas = new ArrayList<T>();
    }

    // Agrega una persona a la lista
    @Override
    public void agregar(T obj) {
        personas.add(obj);
    }

    // Busca una persona por su DNI
    @Override
    public T buscar(int dni) {
        for (T p : personas) {
            if (p.getDni() == dni) {
                return p;
            }
        }
        return null;
    }

    // Elimina una persona usando el DNI
    @Override
    public boolean eliminar(int dni) {
        T p = buscar(dni);
        if (p != null) {
            personas.remove(p);
            return true;
        }
        return false;
    }

    // Modifica una persona existente
    @Override
    public boolean modificar(T obj) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni() == obj.getDni()) {
                personas.set(i, obj);
                return true;
            }
        }
        return false;
    }

    // Devuelve la lista completa
    @Override
    public List<T> listar() {
        return personas;
    }
}


