package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {

    SOLO_ALOJAMIENTO("Solo Alojamiento", 0),
    ALOJAMIENTO_DESAYUNO("Alojamiento y Desayuno", 15),
    MEDIA_PENSION("Media Pensión", 30),
    PENSION_COMPLETA("Pensión Completa", 50);

    private String cadenaAMostrar;
    private double incrementoPrecio;

    private Regimen(String cadenaAMostrar, int incrementoPrecio){
        this.cadenaAMostrar=cadenaAMostrar;
        this.incrementoPrecio=incrementoPrecio;
    }

    public double getIncrementoPrecio() {
        return incrementoPrecio;
    }

    @Override
    public String toString() {

        String resultado;
        if (incrementoPrecio == 0) {
            resultado = "no incrementa el precio";
        } else {
            resultado = incrementoPrecio + "?";
        }
        return cadenaAMostrar + "  Incrementa el precio en: " + resultado;

    }
}
