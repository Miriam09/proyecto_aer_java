/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Miriam
 */
public class Vuelo {
    private int codigo;
    private Conexiones viaje;
    private LocalDate fecha_salida;
    private LocalTime hora_salida;
    private LocalTime duracion;
    private String num_vuelo;
    private double precio;
    private int plazas_totales;
    private ArrayList<Ocupacion> arrayOcupacion = new ArrayList();

    public Vuelo(Conexiones viaje, LocalDate fecha_salida, LocalTime hora_salida, LocalTime duracion, String num_vuelo, double precio, int plazas_totales) {
        this.viaje = viaje;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.duracion = duracion;
        this.num_vuelo = num_vuelo;
        this.precio = precio;
        this.plazas_totales = plazas_totales;
        this.arrayOcupacion = new ArrayList(plazas_totales);
        for(int i = 0; i<plazas_totales;i++){
            Ocupacion ocu = new Ocupacion();
            arrayOcupacion.add(ocu);
        }
    }

    public Vuelo() {
    }

    public Vuelo(int codigo, LocalDate fecha_salida, LocalTime hora_salida, LocalTime duracion, String num_vuelo, double precio, int plazas_totales) {
        this.codigo = codigo;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.duracion = duracion;
        this.num_vuelo = num_vuelo;
        this.precio = precio;
        this.plazas_totales = plazas_totales;
    }
    
    public Vuelo(LocalDate fecha_salida, String num_vuelo) {
        this.fecha_salida = fecha_salida;
        this.num_vuelo = num_vuelo;
    }

    public Vuelo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Conexiones getViaje() {
        return viaje;
    }

    public void setViaje(Conexiones viaje) {
        this.viaje = viaje;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getNum_vuelo() {
        return num_vuelo;
    }

    public void setNum_vuelo(String num_vuelo) {
        this.num_vuelo = num_vuelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazas_totales() {
        return plazas_totales;
    }

    public void setPlazas_totales(int plazas_totales) {
        this.plazas_totales = plazas_totales;
    }

    public ArrayList<Ocupacion> getArrayOcupacion() {
        return arrayOcupacion;
    }

    public void setArrayOcupacion(ArrayList<Ocupacion> arrayOcupacion) {
        this.arrayOcupacion = arrayOcupacion;
    }

    
    @Override
    public String toString() {
        return "Vuelo <strong>"+num_vuelo+"</strong><br> " + viaje.toString() + "<br> <strong>Salida:</strong> " + fecha_salida + ", " + hora_salida + "<br> <strong>Duración:</strong> " + duracion +" <br><strong> Precio:</strong> " + precio;
    }
    
    
    
}
