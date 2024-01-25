package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR ("Salir"),
    INSERTAR_HUESPED("Insertar Huesped"),
    BUSCAR_HUESPED("Buscar Huesped"),
    BORRAR_HUESPED("Borrar Huesped"),
    MOSTRAR_HUESPED("Mostrar Huesped"),
    INSERTAR_HABITACION("Insertar Habitación"),
    BUSCAR_HABITACION("Buscar Habitación"),
    BORRAR_HABITACION("Borrar Habitación"),
    MOSTRAR_HABITACIONES("Mostrar Habitación"),
    INSERTAR_RESERVA("Insertar Habitación"),
    ANULAR_RESERVA("Anular Reserva"),
    MOSTRAR_RESERVAS("Mostar Reserva"),
    CONSULTAR_DISPONIBILIDAD("Consultar Disponibilidad");

    private String cadenaAMostrar;

    private Opcion(String cadenaAMostrar){

        this.cadenaAMostrar=cadenaAMostrar;
    }

    @Override
    public String toString() {

        return "Opción " + cadenaAMostrar;
    }
}
