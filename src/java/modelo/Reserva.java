/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Miriam
 */
public class Reserva {
    private Vuelo ida = new Vuelo();
    private Vuelo vuelta = new Vuelo();
//    private Cliente cliente = new Cliente();
//    private LocalDate fechaReserva;
//    private String bookingCode; //se mete al final de todo el proceso
    private ArrayList<Pasajero> pasajeros;
    private ArrayList<Bebe> bebes;
//    private double precioTotal;
    private Pago pago = new Pago();

    public Reserva(){
        
    }
    public Reserva(Vuelo ida, Vuelo vuelta, ArrayList<Pasajero> pasajeros, ArrayList<Bebe> bebes) {
        this.ida = ida;
        this.vuelta = vuelta;
        this.pasajeros = pasajeros;
        this.bebes = bebes;
    }

    public Reserva(Vuelo ida, Vuelo vuelta, ArrayList<Pasajero> pasajeros, ArrayList<Bebe> bebes, Pago pago) {
        this.ida = ida;
        this.vuelta = vuelta;
        this.pasajeros = pasajeros;
        this.bebes = bebes;
        this.pago = pago;
    }

    
    
    public Vuelo getIda() {
        return ida;
    }

    public void setIda(Vuelo ida) {
        this.ida = ida;
    }

    public Vuelo getVuelta() {
        return vuelta;
    }

    public void setVuelta(Vuelo vuelta) {
        this.vuelta = vuelta;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public ArrayList<Bebe> getBebes() {
        return bebes;
    }

    public void setBebes(ArrayList<Bebe> bebes) {
        this.bebes = bebes;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    
    @Override
    public String toString() {
        return "Reserva{" + "ida=" + ida + ", vuelta=" + vuelta + ", pasajeros=" + pasajeros + ", bebes=" + bebes + '}';
    }

   
         
    
}
