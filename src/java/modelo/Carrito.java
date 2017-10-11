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
public class Carrito {
    private Reserva reserva;
    private int numBebe;
    private int numNinos;
    private int numAdultos;

    public Carrito(){
        
    }
    public Carrito(Reserva reserva, int numBebe, int numNinos, int numAdultos) {
        this.reserva = reserva;
        this.numBebe = numBebe;
        this.numNinos = numNinos;
        this.numAdultos = numAdultos;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public int getNumBebe() {
        return numBebe;
    }

    public void setNumBebe(int numBebe) {
        this.numBebe = numBebe;
    }

    public int getNumNinos() {
        return numNinos;
    }

    public void setNumNinos(int numNinos) {
        this.numNinos = numNinos;
    }

    public int getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    @Override
    public String toString() {
        return "Carrito{" + "reserva=" + reserva + ", numBebe=" + numBebe + ", numNinos=" + numNinos + ", numAdultos=" + numAdultos + '}';
    }
    
    
    
}
