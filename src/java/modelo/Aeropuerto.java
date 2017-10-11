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
public class Aeropuerto {
    private int codigo;
    private String IATA;
    private String nombre;
    private String ciudad;
    private String pais;

    
    //Constructores 
    public Aeropuerto(int codigo, String IATA, String nombre, String ciudad, String pais) {
        this.codigo = codigo;
        this.IATA = IATA;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    public Aeropuerto (Aeropuerto Obj){
        this.codigo = Obj.getCodigo();
        this.IATA = Obj.getIATA();
        this.nombre = Obj.getNombre();
        this.ciudad = Obj.getCiudad();
        this.pais = Obj.getPais();
    }
    //Getter and Setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return IATA ;
    }
    
    
}
