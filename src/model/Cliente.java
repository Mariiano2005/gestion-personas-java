/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// Representa un cliente
public class Cliente extends Persona {

    // Email del cliente
    private String email;

    // Constructor
    public Cliente(int dni, String nombre, int edad, String email) {
        super(dni, nombre, edad);
        this.email = email;
    }

    // Devuelve el email
    public String getEmail() {
        return email;
    }

    // Cambia el email
    public void setEmail(String email) {
        this.email = email;
    }

    // Muestra los datos del cliente
    @Override
    public String mostrarDatos() {
        return "Cliente - DNI: " + dni +
               ", Nombre: " + nombre +
               ", Edad: " + edad +
               ", Email: " + email;
    }
}


