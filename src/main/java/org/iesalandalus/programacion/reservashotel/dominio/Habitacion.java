package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    public static final double MIN_PRECIO_HABITACION = 40;
    public static final double MAX_PRECIO_HABITACION = 150;
    public static final int MIN_NUMERO_PUERTA = 1;
    public static final int MAX_NUMERO_PUERTA = 45;
    public static final int MIN_NUMERO_PLANTA = 1;
    public static final int MAX_NUMERO_PLANTA = 3;
    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;


    public Habitacion(int planta, int puerta, double precio, String descripcion) {
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        this.identificador = planta + "-" + puerta;
    }

    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion, String descripcion) {

    }

    public Habitacion habitacion;

    public Habitacion(Habitacion coleccionHabitaciones) {

    }


    public String getIdentificador() {
        return identificador;
    }

    private void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


    public int getPlanta() {
        return planta;
    }

    private void setPlanta(int planta) {
        if (planta < 1 || planta > MAX_NUMERO_PLANTA) {
            throw new IllegalArgumentException("Número de planta no válido");

        }
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }


    public double getPrecio() {
        return precio;
    }

    private TipoHabitacion setPrecio(double precio) {

        if (precio < MIN_PRECIO_HABITACION || precio > MAX_PRECIO_HABITACION) {
            throw new IllegalArgumentException("Precio no válido");
        }
        this.precio = precio;

        return null;
    }
        private TipoHabitacion setPuerta ( int puerta) {

            if (puerta < 1 || puerta > MAX_NUMERO_PUERTA) {
                throw new IllegalArgumentException("Número de puerta no válido");

            }
            return null;
        }



        public TipoHabitacion getTipoHabitacion () {
            return tipoHabitacion;
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Habitacion that = (Habitacion) o;
            return planta == that.planta && puerta == that.puerta && Double.compare(precio, that.precio) == 0 && Objects.equals(identificador, that.identificador) && tipoHabitacion == that.tipoHabitacion && Objects.equals(habitacion, that.habitacion);
        }

        @Override
        public int hashCode () {

            return super.hashCode();
        }

        @Override
        public String toString () {
            return "Habitacion{" +
                    "identificador='" + identificador + '\'' +
                    ", planta=" + planta +
                    ", puerta=" + puerta +
                    ", precio=" + precio +
                    ", tipoHabitacion=" + tipoHabitacion +
                    ", habitacion=" + habitacion +
                    '}';
        }



}








