package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {

    private final String ER_TELEFONO="[0-9]{9}";
    private final String ER_CORREO="[\\w$-&%.]+[@][\\w.-]+[.][a-zA-Z]+";
    private final String ER_DNI="([\\d]{8})([a-zA-Z])";
    public final String FORMATO_FECHA="dd/MM/yyyy";
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;


    public Huesped(String nombre, String dni, String correo,  String telefono, LocalDate fechaNacimiento){
        setNombre(nombre);
        setDni(dni);
        setCorreo(correo);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
    }

    public Huesped(Huesped huesped){
        if (huesped == null)
            throw new NullPointerException("ERROR: No es posible copiar un huésped nulo.");

        setNombre(huesped.getNombre());
        setTelefono(huesped.getTelefono());
        setDni(huesped.getDni());
        setCorreo(huesped.getCorreo());
        setFechaNacimiento(huesped.getFechaNacimiento());
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = formateaNombre(nombre);
    }

    private String formateaNombre(String nombre){
        if (nombre==null)
            throw new NullPointerException("ERROR: El nombre de un huésped no puede ser nulo.");
        if (nombre.isBlank())
            throw new IllegalArgumentException("ERROR: El nombre de un huésped no puede estar vacío.");

        String nombreFormateado="";
        String nombreModif = nombre.toLowerCase().trim();
        String[] nombreArray = nombreModif.split("\\s+");

        for (int i = 0; i<nombreArray.length; i++)
            nombreFormateado += nombreArray[i].substring(0,1).toUpperCase() + nombreArray[i].substring(1)+" ";

        return nombreFormateado.trim();
    }

    public String getTelefono() {

        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefono==null)
            throw new NullPointerException("ERROR: El teléfono de un huésped no puede ser nulo.");
        if (telefono.isBlank())
            throw new IllegalArgumentException("ERROR: El teléfono del huésped no tiene un formato válido.");
        if (!telefono.matches(ER_TELEFONO))
            throw new IllegalArgumentException("ERROR: El teléfono del huésped no tiene un formato válido.");

        this.telefono = telefono;
    }

    public String getCorreo() {

        return correo;
    }

    public void setCorreo(String correo) {

        if (correo==null)
            throw new NullPointerException("ERROR: El correo de un huésped no puede ser nulo.");
        if (correo.isBlank())
            throw new IllegalArgumentException("ERROR: El correo del huésped no tiene un formato válido.");

        if (correo.matches(ER_CORREO))
            this.correo = correo;
        else
            throw new IllegalArgumentException("ERROR: El correo del huésped no tiene un formato válido.");
    }

    public String getDni() {

        return dni;
    }

    private void setDni(String dni) {
        if (comprobarLetraDni(dni))
            this.dni = dni;
    }

    private Boolean comprobarLetraDni(String dni){
        if (dni == null)
            throw new NullPointerException("ERROR: El dni de un huésped no puede ser nulo.");
        if (dni.isBlank())
            throw new IllegalArgumentException("ERROR: El dni del huésped no tiene un formato válido.");

        Pattern patronDNI = Pattern.compile(ER_DNI);
        Matcher m;
        m = patronDNI.matcher(dni);

        if (!m.matches())
            throw new IllegalArgumentException("ERROR: El dni del huésped no tiene un formato válido.");

        if (!comprobarLetraDni(dni)){

            throw new IllegalArgumentException("ERROR: La letra del dni del huesped no es correcta.");
        }

        int numeroDni = Integer.parseInt(m.group(1));

        int resultadoDivision = numeroDni%23;
        String[] tablaLetras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

        if (m.group(2).equals(tablaLetras[resultadoDivision]))
            return true;

        return false;
    }

    public LocalDate getFechaNacimiento() {

        return fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {

        if (fechaNacimiento==null)
            throw new NullPointerException("Fecha nacimiento nula");
        if (fechaNacimiento.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de nacimiento no puedeser posterior");
        if (fechaNacimiento.isBefore(LocalDate.of(1900, 1, 1)))
            throw new IllegalArgumentException("La persona esta muerta a menos que sea un vampiro");

        this.fechaNacimiento = fechaNacimiento;
    }

    private String getIniciales(){

        String[] nombreArray = this.getNombre().split(" ");
        String iniciales = "";

        for (int i=0; i< nombreArray.length;i++)
            iniciales += nombreArray[i].substring(0,1);

        return iniciales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Huesped huesped = (Huesped) o;
        return Objects.equals(dni, huesped.dni);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "nombre=" + getNombre()+ " (" +getIniciales()+ "), DNI=" +getDni()+
                ", correo=" +getCorreo()+ ", teléfono="+getTelefono()+
                ", fecha nacimiento="+getFechaNacimiento().format(DateTimeFormatter.ofPattern(FORMATO_FECHA));
    }
}
