package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR ("Salir"),
    INSERTAR_HUESPED("Insertar Huesped"),
    BUSCAR_HUESPED("Buscar Huesped"),
    BORRAR_HUESPED("Borrar Huesped"),
    MOSTRAR_HUESPED("Mostrar Huesped"),
    INSERTAR_HABITACION("Insertar Habitaci�n"),
    BUSCAR_HABITACION("Buscar Habitaci�n"),
    BORRAR_HABITACION("Borrar Habitaci�n"),
    MOSTRAR_HABITACIONES("Mostrar Habitaci�n"),
    INSERTAR_RESERVA("Insertar Habitaci�n"),
    ANULAR_RESERVA("Anular Reserva"),
    MOSTRAR_RESERVAS("Mostar Reserva"),
    CONSULTAR_DISPONIBILIDAD("Consultar Disponibilidad");

    private String cadenaAMostrar;

    private Opcion(String cadenaAMostrar){

        this.cadenaAMostrar=cadenaAMostrar;
    }

    @Override
    public String toString() {

        return "Opci�n " + cadenaAMostrar;
    }
}
