package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

import javax.naming.OperationNotSupportedException;

public class Huespedes {

    private int capacidad;
    private int tamano;

    private Huesped[] coleccionHuespedes;

    public Huespedes(int capacidad){
        if (capacidad<=0)
            throw new IllegalArgumentException("capacidad no puede ser negativa");
        this.coleccionHuespedes= new Huesped[capacidad];
        this.capacidad=capacidad;
        this.tamano=0;
    }
    public Huesped[] get(){

        return copiaProfundaHuespedes();
    }

    private Huesped[] copiaProfundaHuespedes(){
        Huesped[] copia = new Huesped[getCapacidad()];

        for (int i=0; i<getCapacidad(); i++)
            copia[i] = new Huesped(coleccionHuespedes[i]);

        return copia;
    }
    public int getTamano() {

        return tamano;
    }
    public int getCapacidad() {

        return capacidad;
    }

    public void insertar(Huesped huesped) throws OperationNotSupportedException {
        if (huesped==null)
            throw new NullPointerException("huesped != null");
        if (tamano>=getCapacidad())
            throw new OperationNotSupportedException("El array esta lleno");
        //TODO: ya est?

        coleccionHuespedes[tamano] = new Huesped(huesped);
        tamano++;
    }

    private int buscarIndice(Huesped huesped){
        if (huesped==null)
            throw new NullPointerException("busca huesped!=null");

        int indice = -1;

        for (int i=0; i < getTamano() ; i++)
            if (huesped.equals(coleccionHuespedes[i]))
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

    public Huesped buscar(Huesped huesped){
        if (huesped == null)
            throw new NullPointerException("no pued ser nulllllllllo!!!!");

        int busqueda = buscarIndice(huesped);

        if (busqueda == -1)
            return null;

        return huesped;
    }

    public void borrar(Huesped huesped)throws OperationNotSupportedException{
        if (huesped==null)
            throw new NullPointerException("ERROR: No se puede borrar un hu?sped nulo");
        if (buscar(huesped) == null)
            throw new IllegalArgumentException("el huesped no est? en el array");

        int indiceBorrado = buscarIndice(huesped);
        coleccionHuespedes[indiceBorrado] = null;
        desplazarUnaPosicionHaciaIzquierda(indiceBorrado);
        tamano--;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice)throws OperationNotSupportedException{
        if (indice<0 || indice > capacidad)
            throw new OperationNotSupportedException("No se puede, fuera array");

        for (int i = indice; i<getTamano() ; i++)
            coleccionHuespedes[i] = new Huesped(coleccionHuespedes[i+1]);

        coleccionHuespedes[getTamano()] = null;
    }

}
