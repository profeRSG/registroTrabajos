package tests;

import modelo.Trabajo;
import modelo.TrabajoCreativo;
import modelo.TrabajoTecnico;
import persistencia.RegistroTrabajos;

/**
 * Clase principal para probar la funcionalidad de la gestión de trabajos.
 */
public class Main { // Declara la clase Main
    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) { // Método main, punto de entrada del programa
        RegistroTrabajos.resetearRegistro(); // Reinicia el registro borrando cualquier contenido previo en el archivo

        Trabajo tecnico1 = new TrabajoTecnico("Trabajo 1", 5, true); // Crea un objeto TrabajoTecnico con título "Trabajo 1", nivel 5 y marcado como solucionado
        Trabajo creativo1 = new TrabajoCreativo("Trabajo 2", 9, 8); // Crea un objeto TrabajoCreativo con título "Trabajo 2", calidad 9 y originalidad 8

        RegistroTrabajos.agregarTrabajo(tecnico1); // Agrega el trabajo técnico al registro
        RegistroTrabajos.agregarTrabajo(creativo1); // Agrega el trabajo creativo al registro
        System.out.println(tecnico1.getNotaFinal());
        System.out.println(creativo1.getNotaFinal());
        Trabajo mejorTrabajo = RegistroTrabajos.getTrabajoMejor(); // Obtiene el trabajo con la mayor nota final del registro
        System.out.println(mejorTrabajo.getTitulo()); // Imprime el título del mejor trabajo en la consola
    }
}