import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    public Collection<Estudiante> listaEstudiantes;
    public Collection<Bibliotecario> listaBibliotecarios;
    public Collection<Libro> listaLibros;
    public Collection<Prestamo> listaPrestamos;

    /**
     * Constructor de la clase principal biblioteca
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listaEstudiantes = new LinkedList<>();
        listaBibliotecarios = new LinkedList<>();
        listaLibros = new LinkedList<>();
        listaPrestamos = new LinkedList<>();
    }

    /**
     * Getters y Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Collection<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public Collection<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(Collection<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public Collection<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(Collection<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Collection<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(Collection<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    /**
     * Metodo que agrega un bibliotecario a la lista de bibliotecarios
     * @param bibliotecario
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario){
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            listaBibliotecarios.add(bibliotecario);
        }
    }

    /**
     * Metodo que elimina un bibliotecario de la lista de bibliotecarios
     * @param cedula
     */
    public void eliminarBibliotecario(String cedula){
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                listaBibliotecarios.remove(bibliotecario);
                break;
            }
        }
    }

    /**
     * Metodo que verifica a un bibliotecario
     * @param cedula
     * @return
     */
    public boolean verificarBibliotecario(String cedula){
        boolean centinela = false;
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo que agrega un estudiante a la lista de estudiantes
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante){
        if (!verificarEstudiante(estudiante.getCedula())) {
            listaEstudiantes.add(estudiante);
        }
    }

    /**
     * Metodo que elimina un estudiante de la lista de estudiantes
     * @param cedula
     */
    public void eliminarEstudiante(String cedula){
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                listaEstudiantes.remove(estudiante);
                break;
            }
        }
    }

    /**
     * Metodo que verifica un estudiante
     * @param cedula
     * @return
     */
    public boolean verificarEstudiante(String cedula){
        boolean centinela = false;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo que agrega un libro a la lista de libros
     */
    public void agregarLibro(){
        for (Libro libro : listaLibros){
            listaLibros.add(libro);
        }
    }

    /**
     * Metodo que elimina un libro de la lista de libros
     * @param codigo
     */
    public void eliminarLibro(String codigo){
        for (Libro libro : listaLibros) {
            if (libro.getCodigo().equals(codigo)) {
                listaLibros.remove(libro);
                break;
            }
        }
    }

    /**
     * Metodo que busca un libro en la lista de libros
     * @param codigo
     */
    public void buscarLibro(String codigo){
        for (Libro libro : listaLibros){
            if (libro.getCodigo().equals(codigo)){
                System.out.println("Libro encontrado : " + libro);
                return ;
            }
        }
        System.out.println("Libro no encontrado");
    }

    /**
     * metodo que muestra la cantidad de libros prestados a un estudiante
     * @return
     */
    public int cantidadLibrosPrestados() {
        int totalPrestados = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            totalPrestados += estudiante.getListaPrestamos().size();
        }
        return totalPrestados;
    }

    /**
     * Metodod que crea un prestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param costoPorDia
     */
    public void crearPrestamo (LocalDate fechaPrestamo, LocalDate fechaEntrega, double costoPorDia, Estudiante estudiante, Bibliotecario bibliotecario){
        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaEntrega, costoPorDia, estudiante, bibliotecario);
        listaPrestamos.add(prestamo);
    }


    /**
     * Metodo que muestra la cantidad de prestamos por empleado
     */

    public void mostrarCantidadPrestamosPorEmpleado(){
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            System.out.println("Empleado: " + bibliotecario.getNombre() + ", Cantidad de préstamos: " + bibliotecario.cantidadPrestamos());
        }
    }

    /**
     * Metodo para mostrar datos estudiante con mas prestamos
     */

    public void mostrarDatosEstudianteConMasPrestamos() {
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;

        for (Estudiante estudiante : listaEstudiantes) {
            int cantidadPrestamos = estudiante.getListaPrestamos().size();
            if (cantidadPrestamos > maxPrestamos) {
                maxPrestamos = cantidadPrestamos;
                estudianteConMasPrestamos = estudiante;
            }
        }

        if (estudianteConMasPrestamos != null) {
            System.out.println("Estudiante con más préstamos:");
            System.out.println("Nombre: " + estudianteConMasPrestamos.getNombre());
            System.out.println("Cédula: " + estudianteConMasPrestamos.getCedula());
            System.out.println("Cantidad de préstamos: " + maxPrestamos);
        } else {
            System.out.println("No hay estudiantes registrados.");
        }
    }


    /**
     * Metodo que calcula el total de dinero recaudado
     * @return
     */

    public double totalDineroRecaudado(){
        double totalRecaudado = 0;
        for (Prestamo prestamo : listaPrestamos) {
            totalRecaudado += prestamo.calcularCostoTotal();
        }
        return totalRecaudado;
    }

    /**
     * metodo para calcular el total dinero recaudado a un bibliotecario
     */

    public void totalDineroRecaudadoPorEmpleado() {
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            double totalRecaudado = 0;
            for (Prestamo prestamo : bibliotecario.getListaPrestamos()) {
                totalRecaudado += prestamo.calcularCostoTotal();
            }
            System.out.println("Bibliotecario: " + bibliotecario.getNombre() + ", Total recaudado: " + totalRecaudado);
        }
    }

    /**
     * Metodo para calcular el total de dinero a pagar por empleado
     */

    public void totalDineroAPagarPorEmpleado() {
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            double totalAPagar = 0;

            for (Prestamo prestamo : bibliotecario.getListaPrestamos()) {
                totalAPagar += prestamo.calcularCostoTotal();
            }

            System.out.println("Bibliotecario: " + bibliotecario.getNombre() +
                    ", Total a pagar: " + totalAPagar);
        }
    }
}
