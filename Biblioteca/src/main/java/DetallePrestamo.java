
import java.time.temporal.ChronoUnit;
/**
 * Clase detallePrestamo es lo que va contener prestamo adentro
 */
public class DetallePrestamo {

    private double subtotal;
    private int cantidad;
    private Libro libro;
    private Prestamo prestamo;

    /**
     * Metodo cosntructor de la clase
     * @param cantidad
     * @param libro
     */
    public DetallePrestamo(int cantidad, Libro libro) {
        this.libro=libro;
        this.cantidad = cantidad;
        this.subtotal=0;

    }
    /**
     * Metodos getters y setters de la clase
     * @return
     */
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Metodo utilizado por la clase para calcular la diferencia entre dias y tomarlo como un dato long
     * para con el calcular el subtotal de cada libro
     * @return
     */
    public long calcularDiferenciaDias(){
        long diferencia=ChronoUnit.DAYS.between(prestamo.getFechaPrestamo(), prestamo.getFechaEntrega());
        return diferencia;
    }
    /**
     * Metodo para calcular el subtotal de cada libro teniendo en cuenta la diferencia en dias y el costo de cada dia de prestamo y su cantidad
     * @return
     */
    public long calcularSubtotal(){
        long diferencia=calcularDiferenciaDias();
        long subtotal=(long)prestamo.costoDia*diferencia;
        if(cantidad>1){
            subtotal*=cantidad;
        }
        return subtotal;
    }
    /**
     * Metodo necesesario a la hora de crear cualquier prestamo haciendo ajustes internos
     */
    public void ajustesNecesario(){
        int nuevoStock=libro.getStock() - cantidad;
        libro.setStock(nuevoStock);
        if(libro.getStock()==0){
            libro.setEstado(Estado.NO_DISPONIBLE);
        }else if(libro.getStock()>0){
            libro.setEstado(Estado.DISPONIBLE);
        }else if(libro.getStock()<cantidad){
            System.out.println("La cantidad excede el stock por lo tanto no se puede crear el prestamo");
        }

    }
    /**
     * Metodo toString de la clase
     */
    @Override
    public String toString() {
        return "DetallePrestamo [subtotal=" + subtotal + ", cantidad=" + cantidad + ", libro=" + libro + ", prestamo="
                + prestamo + "]";
    }




}