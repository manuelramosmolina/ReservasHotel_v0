package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.util.Date;

public class Reservas {

    private int capacidad;
    private int tamano;

    private Reserva[] coleccionReservas;

    public Reservas(int capacidad){
        if (capacidad<=0)
            throw new IllegalArgumentException("NO. tiene que ser positiva");
        this.coleccionReservas= new Reserva[capacidad];
        this.capacidad=capacidad;
        this.tamano=0;
    }
    public Reserva[] get(){
        return copiaProfundaReservas();
    }

    private Reserva[] copiaProfundaReservas(){
        Reserva[] copia = new Reserva[getCapacidad()];

        for (int i=0; i<getCapacidad(); i++)
            copia[i] = new Reserva(coleccionReservas[i]);

        return copia;
    }

    public int getCapacidad() {

        return capacidad;
    }

    public int getTamano() {

        return tamano;
    }

    public void insertar(Reserva reserva) throws OperationNotSupportedException {
        if (reserva==null)
            throw new NullPointerException("NO. Reserva nula.");
        if (tamano>=getCapacidad())
            throw new OperationNotSupportedException("NO.Esta lleno");


        coleccionReservas[tamano] = new Reserva(reserva);
        tamano++;
    }

    private int buscarIndice(Reserva reserva){
        if (reserva==null)
            throw new NullPointerException("Busqueda nula");

        int indice = -1;

        for (int i=0; i < getTamano() ; i++)
            if (reserva.equals(coleccionReservas[i]))
                indice = i;

        return indice;
    }

    private boolean tamanoSuperado(int indice){
        if (indice > tamano)
            return true;

        return false;
    }

    private boolean capacidadSuperada(int indice){
        if (indice>capacidad)
            return true;

        return false;
    }

    public Reserva buscar(Reserva reserva){
        if (reserva == null)
            throw new NullPointerException("No. es nulo");

        int busqueda = buscarIndice(reserva);

        if (busqueda == -1)
            return null;

        return reserva;
    }

    public void borrar(Reserva reserva)throws OperationNotSupportedException{
        if (reserva==null)
            throw new NullPointerException("ERROR: No se puede borrar un huésped nulo");
        if (buscar(reserva) == null)
            throw new IllegalArgumentException("La reserva no está");

        int indiceBorrado = buscarIndice(reserva);
        coleccionReservas[indiceBorrado] = null;
        desplazarUnaPosicionHaciaIzquierda(indiceBorrado);
        tamano--;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice)throws OperationNotSupportedException{
        if (indice<0 || indice > capacidad)
            throw new OperationNotSupportedException("NO.Fuera del array");

        for (int i = indice; i<getTamano() ; i++)
            coleccionReservas[i] = new Reserva(coleccionReservas[i+1]);

        coleccionReservas[getTamano()] = null;
    }

    public Reserva[] getReservas(Huesped huesped) {
        Reserva[] reservasHuesped = new Reserva[3];

        for (int i = 0; i < capacidad; i++) {
            if (reservasHuesped[i].getHuesped().equals(huesped)) {
                Reserva[] reservas = new Reserva[0];
                reservasHuesped[i++] = reservas[i];
            }
        }
        return reservasHuesped;
    }

    public Reserva[] getReservas(TipoHabitacion tipoHabitacion) {
        Reserva[] reservasTipoHabitacion = new Reserva[3];

        for (int i = 0; i < capacidad; i++) {
            Habitacion[] reservas = new Habitacion[10];
            if (reservas[i].getTipoHabitacion().equals(tipoHabitacion)) {
               // reservasTipoHabitacion[i++] = reservas[i];
            }
        }
        return reservasTipoHabitacion;
    }

    public Reserva[] getReservasFuturas(Habitacion habitacion) {
        Date hoy = new Date();
        Reserva[] futuras = new Reserva[3];

        for (int i = 0; i < capacidad; i++){
            if(futuras[i].getFechaFinReserva().isAfter(null)){
                futuras[i++] = coleccionReservas[i];
            }
        }
        return futuras;
    }



}
