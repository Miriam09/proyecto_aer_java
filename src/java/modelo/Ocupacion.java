/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Miriam
 */
public class Ocupacion {

    private int codigo;
    private String Asiento;
    private Pasajero pasajero = null;
    private String bookingCode;
    private double importe;
    private int facturado=0;
    private Vuelo vuelo= null;

    public Ocupacion() {
    }

    public Ocupacion(int codigo, String Asiento, Pasajero pasajero, String bookingCode, double importe) {
        this.codigo = codigo;
        this.Asiento = Asiento;
        this.pasajero = pasajero;
        this.bookingCode = bookingCode;
        this.importe = importe;
    }

    public String getAsiento() {
        return Asiento;
    }

    public void setAsiento(String Asiento) {
        this.Asiento = Asiento;
    }

    public void setAsiento(int num) {
        if (num == 1) {
            this.Asiento = num  + "A";
        } else if (num % 2 == 0) {
            this.Asiento = (num / 2) + "B";
        } else {
            this.Asiento = (num + 1) / 2 + "A";
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getFacturado() {
        return facturado;
    }

    public void setFacturado(int facturado) {
        this.facturado = facturado;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
}
