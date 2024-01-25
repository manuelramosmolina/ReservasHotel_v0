package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

import javax.naming.OperationNotSupportedException;

public class Habitaciones {

    private int capacidad;
    private int tamano;

    private Habitacion[] coleccionHabitaciones;

    public Habitaciones(int capacidad){
        if (capacidad<=0)
            throw new IllegalArgumentException("capacidad no puede ser negativa");
        this.coleccionHabitaciones= new Habitacion[capacidad];
        this.capacidad=capacidad;
        this.tamano=0;
    }
    public Habitacion[] get(){

        return copiaProfundaHabitaciones();
    }

    private Habitacion[] copiaProfundaHabitaciones(){
        Habitacion[] copia = new Habitacion[getCapacidad()];

        for (int i=0; i<getCapacidad(); i++)
            copia[i] = new Habitacion(coleccionHabitaciones[i]);

        return copia;
    }

    public Habitacion[] getTipoHabitacion
    () {
        return copiaProfundaHabitaciones();
    }

    public int getTamano() {

        return tamano;
    }

    public int getCapacidad() {

        return capacidad;
    }

    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion==null)
            throw new NullPointerException("habitacion nula");
        if (tamano>=getCapacidad())
            throw new OperationNotSupportedException("El array esta lleno");

        coleccionHabitaciones[tamano] = new Habitacion(habitacion);
        tamano++;
    }

    private int buscarIndice(Habitacion habitacion){
        if (habitacion==null)
            throw new NullPointerException("busca habitacion!=null");

        int indice = -1;

        for (int i=0; i < getTamano() ; i++)
            if (habitacion.equals(coleccionHabitaciones[i]))
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

    public Habitacion buscar(Habitacion habitacion){
        if (habitacion == null)
            throw new NullPointerException("no pued ser nulllllllllo!!!!");

        int busqueda = buscarIndice(habitacion);

        if (busqueda == -1)
            return null;

        return habitacion;
    }

    public void borrar(Habitacion habitacion)throws OperationNotSupportedException{
        if (habitacion==null)
            throw new NullPointerException("ERROR: No se puede borrar un hu?sped nulo");
        if (buscar(habitacion) == null)
            throw new IllegalArgumentException("el habitacion no est? en el array");

        int indiceBorrado = buscarIndice(habitacion);
        coleccionHabitaciones[indiceBorrado] = null;
        desplazarUnaPosicionHaciaIzquierda(indiceBorrado);
        tamano--;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice)throws OperationNotSupportedException{
        if (indice<0 || indice > capacidad)
            throw new OperationNotSupportedException("No se puede, fuera array");

        for (int i = indice; i<getTamano() ; i++)
            coleccionHabitaciones[i] = new Habitacion(coleccionHabitaciones[i+1]);

        coleccionHabitaciones[getTamano()] = null;
    }


}
