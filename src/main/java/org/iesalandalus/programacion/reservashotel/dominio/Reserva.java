package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Locale;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.SimpleTimeZone;

public class Reserva {

    private final int MAX_NUMERO_MESES_RESERVA=5;
    private final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public final String FORMATO_FECHA_RESERVA="dd/MM/yyyy";
    public final String FORMATO_FECHA_HORA_RESERVA="dd/MM/yyyy hh:mm";


    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime checkIn;
    private LocalDateTime checkout;

    private double precio;
    private int numeroPersonas;


    public Reserva(Huesped huesped, Habitacion habitacion, Regimen regimen, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, int numeroPersonas) {

        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        this.checkIn=null;
        this.checkout=null;
        setNumeroPersonas(numeroPersonas);
        this.precio=0.0;

    }

    public Reserva(Reserva reserva){

        setHuesped(reserva.getHuesped());
        setHabitacion(reserva.getHabitacion());
        setRegimen(reserva.getRegimen());
        setFechaInicioReserva(reserva.getFechaInicioReserva());
        setFechaFinReserva(reserva.getFechaFinReserva());
        setCheckIn(reserva.getCheckIn());
        setCheckout(reserva.getCheckout());
        setNumeroPersonas(reserva.getNumeroPersonas());
        setPrecio(reserva.getPrecio());


    }



    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {

        this.habitacion = habitacion;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {

        if(fechaInicioReserva==null)
            throw new NullPointerException("Fecha nula");
        if(fechaInicioReserva.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Fecha no válida, anterior.");
        if(fechaInicioReserva.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Fecha no válida, posterior.");

        this.fechaInicioReserva = fechaInicioReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if(fechaFinReserva==null)
            throw new NullPointerException("Fecha nula");
        if(fechaFinReserva.isBefore(fechaInicioReserva))
            throw new IllegalArgumentException("Fecha no válida.");

        this.fechaFinReserva = fechaFinReserva;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        if (checkout.isBefore(checkIn))
            throw new IllegalArgumentException("Check Out no válido");

        this.checkout = checkout;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {
        int diasReservados;
        diasReservados = Period.between(fechaInicioReserva,fechaFinReserva).getDays();
        this.precio = diasReservados;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {

        if (numeroPersonas>getTipohabitacion().getNumeroMaximoPersonas())
            throw new IllegalArgumentException("El numero de personas supera las plazas de la habitación");
        this.numeroPersonas = numeroPersonas;
    }

    private TipoHabitacion getTipohabitacion() {

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(habitacion, reserva.habitacion) && Objects.equals(fechaInicioReserva, reserva.fechaInicioReserva) && Objects.equals(checkIn, reserva.checkIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, fechaInicioReserva, checkIn);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "huesped=" + huesped +
                ", habitacion=" + habitacion +
                ", regimen=" + regimen +
                ", fechaInicioReserva=" + fechaInicioReserva +
                ", fechaFinReserva=" + fechaFinReserva +
                ", checkIn=" + checkIn +
                ", checkout=" + checkout +
                ", precio=" + precio +
                ", numeroPersonas=" + numeroPersonas +
                '}';
    }
}
