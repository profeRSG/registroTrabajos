package modelo;

/**
 * Clase que representa un trabajo técnico, el cual tiene un nivel técnico y un estado de solución.
 */
public class TrabajoTecnico extends Trabajo { // Declara la clase TrabajoTecnico que extiende de Trabajo
    private boolean solucionado; // Atributo que indica si el trabajo está solucionado
    private double nivelTecnico; // Atributo que almacena el nivel técnico, que se utiliza para la calificación y dificultad

    /**
     * Constructor de TrabajoTecnico.
     * @param titulo Nombre del trabajo.
     * @param nivelTecnico Nivel técnico del trabajo.
     * @param solucionado Indica si el trabajo está solucionado.
     */
    public TrabajoTecnico(String titulo, double nivelTecnico, boolean solucionado) { // Constructor con parámetros para título, nivel técnico y estado solucionado
        super(titulo); // Llama al constructor de la clase padre para asignar el título
        this.nivelTecnico = nivelTecnico; // Asigna el nivel técnico al atributo correspondiente
        this.solucionado = solucionado; // Asigna el estado de solución al atributo correspondiente
    }

    /**
     * Modifica el estado de solución del trabajo.
     * @param solucionado Nuevo estado (true si solucionado, false en caso contrario).
     */
    public void setSolucionado(boolean solucionado) { // Método setter para el estado solucionado
        this.solucionado = solucionado; // Asigna el nuevo valor al atributo solucionado
    }

    /**
     * Indica si el trabajo está solucionado.
     * @return true si está solucionado, false en caso contrario.
     */
    public boolean isSolucionado() { // Método getter para el estado solucionado
        return solucionado; // Retorna el valor del atributo solucionado
    }

    /**
     * Modifica el nivel técnico del trabajo.
     * @param nivelTecnico Nuevo nivel técnico.
     */
    public void setNivelTecnico(double nivelTecnico) { // Método setter para el nivel técnico
        this.nivelTecnico = nivelTecnico; // Asigna el nuevo nivel técnico al atributo correspondiente
    }

    /**
     * Obtiene el nivel técnico del trabajo.
     * @return El nivel técnico.
     */
    public double getNivelTecnico() { // Método getter para el nivel técnico
        return nivelTecnico; // Retorna el valor del atributo nivelTecnico
    }

    /**
     * Calcula la calificación del trabajo técnico.
     * @return El nivel técnico si el trabajo está solucionado, de lo contrario 0.
     */
    @Override
    protected double getCalificacion() { // Implementa el cálculo de la calificación para trabajo técnico
        // Si el trabajo está solucionado, retorna el nivel técnico; si no, retorna 0
        return solucionado ? nivelTecnico : 0;//Se usa un operador ternario para devolver el nivel técnico si está solucionado o 0 en caso contrario.
    }

    /**
     * Obtiene la dificultad del trabajo técnico.
     * @return El nivel técnico, ya que se utiliza como dificultad.
     */
    @Override
    protected double getDificultad() { // Implementa el cálculo de la dificultad para trabajo técnico
        return nivelTecnico; // Retorna el nivel técnico como dificultad
    }
}

