
import java.util.LinkedList;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private String fecha;
    private int unidadesDisponibles;
    private EstadoPrestamo estadoPrestamo;
    private LinkedList<DetallePrestamo> Detallesprestamos;

    /**
     * Constructor de la clase Libro
     * @param codigo
     * @param isbn
     * @param autor
     * @param titulo
     * @param editorial
     * @param fecha
     * @param unidadesDisponibles
     */
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles, EstadoPrestamo estadoPrestamo) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.unidadesDisponibles = unidadesDisponibles;
        this.estadoPrestamo = estadoPrestamo;
        Detallesprestamos = new LinkedList<>();
    }

    /**
     * Getters y Setters
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public LinkedList<DetallePrestamo> getDetallesprestamos() {
        return Detallesprestamos;
    }

    public void setDetallesprestamos(LinkedList<DetallePrestamo> Detallesprestamos) {
        this.Detallesprestamos = Detallesprestamos;
    }

    /**
     * Metodo que vincula los DetallesPrestamo a un Libro
     * @param detallePrestamo
     */
    public void agregarDetallesPrestamos(DetallePrestamo detallePrestamo) {
        getDetallesprestamos().add(detallePrestamo);
    }
}
