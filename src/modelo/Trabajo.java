package modelo;

import java.io.Serializable;

/**
 * Clase abstracta que representa un trabajo general.
 * Define atributos comunes y métodos para calcular la nota final.
 */
public abstract class Trabajo implements Serializable { // Declara la clase abstracta que implementa Serializable para permitir su almacenamiento en un archivo binario
    private String titulo; // Atributo que almacena el título del trabajo

    /**
     * Constructor de la clase Trabajo.
     * @param titulo Nombre del trabajo.
     */
    public Trabajo(String titulo) { // Constructor que recibe el título como parámetro
        this.titulo = titulo; // Asigna el título al campo de la instancia
    }

    /**
     * Obtiene el título del trabajo.
     * @return El título del trabajo.
     */
    public String getTitulo() { // Método getter para el título
        return titulo; // Retorna el valor del atributo título
    }

    /**
     * Modifica el título del trabajo.
     * @param titulo Nuevo título del trabajo.
     */
    public void setTitulo(String titulo) { // Método setter para el título
        this.titulo = titulo; // Asigna el nuevo título al atributo de la instancia
    }

    /**
     * Calcula la nota final del trabajo como la media entre la calificación y la dificultad, redondeada.
     * @return La nota final redondeada.
     */
    public int getNotaFinal() { // Método que calcula la nota final del trabajo
        // Llama al método calcularMedia con la calificación y dificultad, redondea el resultado y lo convierte a entero
        return (int) Math.round(calcularMedia(getCalificacion(), getDificultad()));
    }

    /**
     * Obtiene la calificación del trabajo.
     * @return La calificación del trabajo.
     */
    protected abstract double getCalificacion(); // Método abstracto que cada subclase debe implementar para calcular la calificación

    /**
     * Obtiene la dificultad del trabajo.
     * @return La dificultad del trabajo.
     */
    protected abstract double getDificultad(); // Método abstracto que cada subclase debe implementar para calcular la dificultad

    /**
     * Método auxiliar para calcular la media de dos números.
     * @param a Primer número.
     * @param b Segundo número.
     * @return La media de los dos números.
     */
    protected static double calcularMedia(double a, double b) { // Método estático que calcula la media
        //Es protegido, ya que es un método auxiliar, pero no puede ser privado porque es utilizado en las
        //clases hijas. El método se ha implementado para evitar duplicidad de código.
        return (a + b) / 2; // Suma los dos números y divide el resultado entre 2
    }
}








