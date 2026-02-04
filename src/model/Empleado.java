/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// Representa un empleado
public class Empleado extends Persona implements Pagable {

    private double sueldoBase;

    // Constructor
    public Empleado(int dni, String nombre, int edad, double sueldoBase) {
        super(dni, nombre, edad);
        this.sueldoBase = sueldoBase;
    }

    // Devuelve el sueldo
    public double getSueldoBase() {
        return sueldoBase;
    }

    // Calcula el pago del empleado
    @Override
    public double calcularPago() {
        return sueldoBase;
    }

    // Muestra los datos del empleado
    @Override
    public String mostrarDatos() {
        return "Empleado - DNI: " + dni +
               ", Nombre: " + nombre +
               ", Edad: " + edad +
               ", Sueldo: $" + sueldoBase;
    }
}


