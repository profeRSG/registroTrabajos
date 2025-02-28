package persistencia;

import modelo.Trabajo;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que gestiona el almacenamiento y recuperación de objetos Trabajo en un archivo.
 */
public class RegistroTrabajos { // Declara la clase RegistroTrabajos para gestionar el registro de trabajos
    private static final String PATH = "trabajos.data"; // Define la ruta del archivo donde se almacenan los trabajos



    /**
     * Agrega un objeto Trabajo al archivo.
     * @param trabajo El objeto Trabajo que se desea agregar.
     */
    public static void agregarTrabajo(Trabajo trabajo) { // Método para agregar un trabajo al registro
        List<Trabajo> trabajos = obtenerTrabajos(); // Recupera la lista actual de trabajos almacenados
        trabajos.add(trabajo); // Añade el nuevo trabajo a la lista
        guardarTrabajos(trabajos); // Guarda la lista actualizada en el archivo
    }

    /*
     * - Cuando se utiliza ObjectOutputStream, este escribe un encabezado al inicio del archivo para definir la estructura
     *   de los objetos serializados. Este encabezado es necesario para la correcta interpretación de los datos al leerlos.
     *
     * - Sin embargo, cada nueva escritura con ObjectOutputStream añade un encabezado, lo que hace que el archivo no sea legible de manera incremental.
     *
     * - Para evitar este problema, en este código se ha optado por una estrategia en la que siempre se lee y se reescribe
     *   la lista completa de objetos en cada operación de guardado. De este modo, se sobrescribe el archivo por completo
     *   cada vez que se guarda un nuevo trabajo, asegurando que el formato del archivo es válido.
     *
     * - Como alternativa, se podría implementar una clase personalizada (como AppendingObjectOutputStream) que evite reescribir
     *   el encabezado en escrituras adicionales.
     */


    /**
     * Retorna el objeto Trabajo con la mayor nota final del archivo.
     * @return El Trabajo con la mejor nota final, o null si no hay trabajos.
     */
    public static Trabajo getTrabajoMejor() { // Método para obtener el mejor trabajo almacenado
        List<Trabajo> trabajos = obtenerTrabajos(); // Recupera la lista de trabajos almacenados
        Trabajo mejorTrabajo = null;//Si no hay elementos en la lista o está vacía, el resultado será null
        if (trabajos != null && !trabajos.isEmpty()) {//Si la lista no es null y no está vacía

            // Se asume que el primer trabajo es el que tiene la mayor nota final inicialmente
            mejorTrabajo = trabajos.get(0);

            // Se recorre cada trabajo en la lista
            for (int i = 1; i < trabajos.size(); i++) { // Comienza desde 1 porque el primero ya está asignado
                Trabajo trabajo = trabajos.get(i);

                // Se compara la nota final del trabajo actual con la del trabajo que se tiene como mejor
                if (trabajo!=null && trabajo.getNotaFinal() > mejorTrabajo.getNotaFinal()) {
                    // Si se encuentra un trabajo con una nota final mayor, se actualiza la variable 'mejor'
                    mejorTrabajo = trabajo;
                }
            }
        }
        return mejorTrabajo;//Se devuelve el trabajo con la nota final más alta
    }

    /**
     * Resetea el registro, eliminando todos los trabajos almacenados.
     */
    public static void resetearRegistro() { // Método para limpiar el archivo y reiniciar el registro
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) { // Abre un ObjectOutputStream que sobrescribe el archivo
            // Al crear un nuevo ObjectOutputStream se escribe un nuevo encabezado, vaciando el archivo
        } catch (IOException e) { // Captura excepciones de IO
            e.printStackTrace(); // Imprime la traza del error
        }
    }

    /**
     * Método auxiliar utilizado para recuperar
     * la lista de objetos Trabajo almacenados en el archivo.
     * @return Una lista de objetos Trabajo.
     */
    private static List<Trabajo> obtenerTrabajos() { // Método para leer todos los trabajos del archivo
        List<Trabajo> trabajos = new LinkedList<Trabajo>(); // lista vacía de trabajos
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) { // Abre un ObjectInputStream para leer el archivo
            trabajos = (List<Trabajo>) ois.readObject();// Se lee la lista completa de trabajos almacenados en el archivo.
        } catch (EOFException ignored) { // Captura la excepción que indica el fin del archivo
            // Fin del archivo alcanzado, se termina la lectura. Se devolverá la lista vacía
        } catch (IOException | ClassNotFoundException e) { // Captura otras excepciones posibles
            e.printStackTrace(); // Imprime la traza del error
        }
        return trabajos; // Retorna la lista completa de trabajos
    }

    /**
     * Método auxiliar utilizado para guardar la lista de objetos Trabajo en el archivo.
     * @param trabajos La lista de trabajos a almacenar.
     */
    private static void guardarTrabajos(List<Trabajo> trabajos) { // Método para guardar la lista de trabajos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) { // Abre un ObjectOutputStream que sobrescribe el archivo
                oos.writeObject(trabajos); // Escribe el objeto trabajos en el archivo
        } catch (IOException e) { // Captura excepciones de IO
            e.printStackTrace(); // Imprime la traza del error
        }
    }
}



