# Gestion de Personas - Java

Proyecto realizado en Java para practicar Programacion Orientada a Objetos y manejo de archivos.

## Descripcion

El sistema permite gestionar personas utilizando un menu por consola.
Se pueden administrar distintos tipos de personas:

- Empleados
- Clientes
- Proveedores

Cada persona se identifica de forma unica por su DNI.

## Funcionalidades (CRUD)

El programa permite realizar las siguientes operaciones:

1. Crear personas (validando que no exista el DNI)
2. Modificar una persona existente
3. Eliminar una persona
4. Listar todas las personas
5. Consultar una persona por DNI

## Persistencia de datos

Al iniciar el programa:
- Se cargan los datos desde un archivo binario (`personas.dat`)

Al finalizar el programa:
- Se guardan los datos en archivo binario
- Se genera un archivo de texto (`personas.txt`)
- Se genera un archivo con solo empleados (`empleados.txt`)
- Se exportan los datos a:
  - CSV (`personas.csv`)
  - JSON (`personas.json`)

## Estructura del proyecto

- `model`: clases Persona, Empleado, Cliente y Proveedor
- `service`: lógica de gestión y CRUD
- `util`: manejo de archivos y exportadores
- `main`: menú principal del programa

## Tecnologías utilizadas

- Java
- Programacion Orientada a Objetos
- Archivos binarios
- Archivos de texto
- CSV
- JSON

## Ejecución

El programa se ejecuta desde la clase `Main` y funciona mediante un menú por consola.
