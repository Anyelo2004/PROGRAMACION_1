import java.time.LocalDate;

public class DetallePrestamo {
    private double costo;
    private int cantidad;
    private Libro libro;


    /**
     * Constructor de la clase DetallePrestamo
     * @param costo
     * @param cantidad
     */
    public DetallePrestamo(Libro libro, double costo, int cantidad) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.libro = libro;
    }

    /**
     * Getters y Setters
     */
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}