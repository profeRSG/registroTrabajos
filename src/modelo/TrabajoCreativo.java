package modelo;

/**
 * Clase que representa un trabajo creativo.
 */
public class TrabajoCreativo extends Trabajo { // Declara la clase TrabajoCreativo que extiende de Trabajo
    private static final double PORCENTAJE_ORIGINALIDAD = 0.9; //Constante que indica el peso aplicado a la originalidad
    private double originalidad; // Atributo para la originalidad del trabajo
    private double calidad; // Atributo para la calidad del trabajo

    /**
     * Constructor de TrabajoCreativo.
     * @param titulo Nombre del trabajo.
     * @param calidad Calidad del trabajo.
     * @param originalidad Originalidad del trabajo.
     */
    public TrabajoCreativo(String titulo, double calidad, double originalidad) { // Constructor con parámetros para título, calidad y originalidad
        super(titulo); // Llama al constructor de la clase padre para asignar el título
        this.calidad = calidad; // Asigna la calidad al atributo correspondiente
        this.originalidad = originalidad; // Asigna la originalidad al atributo correspondiente
    }

    /**
     * Modifica la calidad del trabajo.
     * @param calidad Nueva calidad.
     */
    public void setCalidad(double calidad) { // Método setter para la calidad
        this.calidad = calidad; // Asigna el nuevo valor a la calidad
    }

    /**
     * Obtiene la calidad del trabajo.
     * @return La calidad del trabajo.
     */
    public double getCalidad() { // Método getter para la calidad
        return calidad; // Retorna el valor del atributo calidad
    }

    /**
     * Modifica la originalidad del trabajo.
     * @param originalidad Nueva originalidad.
     */
    public void setOriginalidad(double originalidad) { // Método setter para la originalidad
        this.originalidad = originalidad; // Asigna el nuevo valor al atributo originalidad
    }

    /**
     * Obtiene la originalidad del trabajo.
     * @return La originalidad del trabajo.
     */
    public double getOriginalidad() { // Método getter para la originalidad
        return originalidad; // Retorna el valor del atributo originalidad
    }

    /**
     * Calcula la calificación del trabajo creativo como la media entre calidad y originalidad.
     * @return La media de calidad y originalidad.
     */
    @Override
    protected double getCalificacion() { // Implementa el cálculo de la calificación para trabajo creativo
        // Utiliza el método auxiliar calcularMedia definido en la clase Trabajo
        return calcularMedia(calidad, originalidad);
    }

    /**
     * Calcula la dificultad del trabajo creativo como el 90% de la originalidad.
     * @return El 90% de la originalidad.
     */
    @Override
    protected double getDificultad() { // Implementa el cálculo de la dificultad para trabajo creativo
        return originalidad * PORCENTAJE_ORIGINALIDAD; // Retorna el 90% de la originalidad
    }
}