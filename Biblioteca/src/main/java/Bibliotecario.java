

import java.util.Collection;
import java.util.LinkedList;

    public class Bibliotecario extends Persona{
        private double salario;
        public Collection<Prestamo> listaPrestamos;

        /**
         * Constructor de la clase Bibliotecario
         * @param nombre
         * @param cedula
         * @param telefono
         * @param correo
         * @param salario
         */
        public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario){
            super(nombre,cedula,telefono,correo);
            this.salario = salario;
            listaPrestamos = new LinkedList<>();
        }

        /**
         * Getters y Setters
         * @return
         */
        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public Collection<Prestamo> getListaPrestamos() {
            return listaPrestamos;
        }

        public void setListaPrestamos(Collection<Prestamo> listaPrestamos) {
            this.listaPrestamos = listaPrestamos;
        }

        /**
         * Metodo que muestra la cantidad de prestamos que tiene un empleado
         * @return
         */
        public int cantidadPrestamos() {
            return listaPrestamos.size();
        }
    }