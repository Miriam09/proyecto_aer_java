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
public class Pasajero {
    private int codigo;
    private String nif;
    private String nombre;
    private String apellidos;
    private String pais;
    private Pasajero tutor = null;
    private LocalDate fechaNacimiento;
    private ArrayList<ServiciosContratados> servicios;
    
    
    public Pasajero(String nif, String nombre, String apellidos, String pais, LocalDate fechaNacimiento) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Pasajero getTutor() {
        return tutor;
    }

    public void setTutor(Pasajero tutor) {
        this.tutor = tutor;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<ServiciosContratados> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<ServiciosContratados> servicios) {
        this.servicios = servicios;
    }

    

   

    @Override
    public String toString() {
        return "Pasajero{" + "codigo=" + codigo + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos +  ", pais=" + pais + ", tutor=" + tutor + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    
}
