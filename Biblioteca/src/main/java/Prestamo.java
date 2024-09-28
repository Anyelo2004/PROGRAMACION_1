

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private double costoPorDia;
    private LinkedList<DetallePrestamo> Detallesprestamos;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;

    /**
     * Constructor de la clase Prestamo
     *
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param costoPorDia
     */
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, double costoPorDia, Estudiante estudiante, Bibliotecario bibliotecario) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.costoPorDia = costoPorDia;
        Detallesprestamos = new LinkedList<>();
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
    }

    /**
     * Getters y Setters
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public LinkedList<DetallePrestamo> getDetallesprestamos() {
        return Detallesprestamos;
    }

    public void setDetallesprestamos(LinkedList<DetallePrestamo> Detallesprestamos) {
        this.Detallesprestamos = Detallesprestamos;
    }

    /**
     * Metodo que calcula los dias que el libro fue prestado
     *
     * @return
     */
    public long calcularDiasPrestamo() {
        long diasPrestamo = java.time.Duration.between(fechaPrestamo.atStartOfDay(), fechaEntrega.atStartOfDay()).toDays();
        return diasPrestamo;
    }

    /**
     * Metodod que calcula el costo total
     *
     * @return
     */
    public double calcularCostoTotal() {
        return calcularDiasPrestamo() * costoPorDia;
    }

    /**
     * Metodo que vincula los DetallesPrestamo a un Prestamo
     *
     * @param detallePrestamo
     */
    public void agregarDetallesPrestamos(DetallePrestamo detallePrestamo) {
        getDetallesprestamos().add(detallePrestamo);
    }
}
