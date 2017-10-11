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
public class Conexiones {
    private int codigo ;
    private Aeropuerto origen;
    private Aeropuerto destino;
  

    public Conexiones(int codigo, Aeropuerto origen, Aeropuerto destino) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return  origen.toString() + " <strong>-</strong> " + destino.toString();
    }

    
    
    
}
