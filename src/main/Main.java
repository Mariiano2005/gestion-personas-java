/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import util.ExportadorCSV;
import util.ExportadorJSON;

import model.*;
import service.GestorPersonas;
import util.ArchivoBinario;
import util.ArchivoTexto;
import util.Exportador;

import java.util.List;
import java.util.Scanner;

// Clase principal del programa
public class Main {

    // Nombre del archivo binario donde se guardan las personas
    private static final String ARCHIVO = "personas.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Gestor que maneja la lista de personas
        GestorPersonas<Persona> gestor = new GestorPersonas<Persona>();

        // 1 - Cargar desde archivo (deserializar)
        List<Persona> lista = ArchivoBinario.leer(ARCHIVO);
        if (lista != null) {
            for (Persona p : lista) {
                gestor.agregar(p);
            }
        }

        int opcion;

        // 2 - Menu en ciclo hasta que el usuario salga
        do {
            System.out.println("\n1 Crear");
            System.out.println("2 Modificar");
            System.out.println("3 Eliminar");
            System.out.println("4 Listar");
            System.out.println("5 Consultar");
            System.out.println("0 Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crear(sc, gestor);
                    break;
                case 2:
                    modificar(sc, gestor);
                    break;
                case 3:
                    eliminar(sc, gestor);
                    break;
                case 4:
                    listar(gestor);
                    break;
                case 5:
                    consultar(sc, gestor);
                    break;
            }

        } while (opcion != 0);

        // 3 - Guardar al finalizar (serializar y exportar archivos)
        ArchivoBinario.guardar(ARCHIVO, gestor.listar());
        ArchivoTexto.guardarPersonas("personas.txt", gestor.listar());
        Exportador.exportarEmpleados("empleados.txt", gestor.listar());
        ExportadorCSV.exportar("personas.csv", gestor.listar());
        ExportadorJSON.exportar("personas.json", gestor.listar());

        sc.close();
    }

    // ===================== CRUD =====================

    // Crea una nueva persona
    private static void crear(Scanner sc, GestorPersonas<Persona> gestor) {

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        // Verifica que no exista una persona con ese DNI
        if (gestor.buscar(dni) != null) {
            System.out.println("Ya existe");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("1 Empleado / 2 Cliente / 3 Proveedor");
        int tipo = sc.nextInt();
        sc.nextLine();

        Persona p = null;

        if (tipo == 1) {
            System.out.print("Sueldo: ");
            double sueldo = sc.nextDouble();
            p = new Empleado(dni, nombre, edad, sueldo);

        } else if (tipo == 2) {
            System.out.print("Email: ");
            String email = sc.nextLine();
            p = new Cliente(dni, nombre, edad, email);

        } else if (tipo == 3) {
            System.out.print("Empresa: ");
            String emp = sc.nextLine();
            p = new Proveedor(dni, nombre, edad, emp);
        }

        // Agrega la persona a la lista
        if (p != null) {
            gestor.agregar(p);
            System.out.println("Creado");
        }
    }

    // Modifica una persona existente
    private static void modificar(Scanner sc, GestorPersonas<Persona> gestor) {

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        // Busca la persona por DNI
        Persona p = gestor.buscar(dni);
        if (p == null) {
            System.out.println("No encontrado");
            return;
        }

        System.out.print("Nuevo nombre: ");
        p.setNombre(sc.nextLine());

        System.out.print("Nueva edad: ");
        p.setEdad(sc.nextInt());
        sc.nextLine();

        System.out.println("Modificado");
    }

    // Elimina una persona
    private static void eliminar(Scanner sc, GestorPersonas<Persona> gestor) {

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        // Busca y elimina la persona
        Persona p = gestor.buscar(dni);
        if (p != null) {
            gestor.eliminar(dni);
            System.out.println("Eliminado");
        }
    }

    // Muestra todas las personas
    private static void listar(GestorPersonas<Persona> gestor) {
        for (Persona p : gestor.listar()) {
            System.out.println(p.mostrarDatos());
        }
    }

    // Consulta una persona por DNI
    private static void consultar(Scanner sc, GestorPersonas<Persona> gestor) {

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        Persona p = gestor.buscar(dni);
        if (p != null) {
            System.out.println(p.mostrarDatos());
        } else {
            System.out.println("No encontrado");
        }
    }
}

