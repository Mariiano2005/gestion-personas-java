/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// Representa un proveedor
public class Proveedor extends Persona {

    // Nombre de la empresa del proveedor
    private String empresa;

    // Constructor
    public Proveedor(int dni, String nombre, int edad, String empresa) {
        super(dni, nombre, edad);
        this.empresa = empresa;
    }

    // Devuelve el nombre de la empresa
    public String getEmpresa() {
        return empresa;
    }

    // Cambia el nombre de la empresa
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // Muestra los datos del proveedor
    @Override
    public String mostrarDatos() {
        return "Proveedor - DNI: " + dni +
               ", Nombre: " + nombre +
               ", Edad: " + edad +
               ", Empresa: " + empresa;
    }
}

