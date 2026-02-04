/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

// Interfaz con las operaciones basicas del CRUD
public interface Crud<T> {

    // Agrega un objeto
    void agregar(T obj);

    // Busca un objeto por su DNI
    T buscar(int dni);

    // Elimina un objeto
    boolean eliminar(int dni);

    // Modifica un objeto
    boolean modificar(T obj);

    // Devuelve la lista completa
    List<T> listar();
}


