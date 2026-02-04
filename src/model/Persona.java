/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

// Clase base del sistema
// De aca heredan las demas personas
public abstract class Persona implements Serializable {

    protected int dni;
    protected String nombre;
    protected int edad;

    // Constructor
    public Persona(int dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Devuelve el dni
    public int getDni() {
        return dni;
    }

    // Cambia el dni
    public void setDni(int dni) {
        this.dni = dni;
    }

    // Devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    // Cambia el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve la edad
    public int getEdad() {
        return edad;
    }

    // Cambia la edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Cada tipo de persona muestra sus datos a su manera
    public abstract String mostrarDatos();
}


