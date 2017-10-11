/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Miriam
 */
public class Bebe {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String nif;
    private String pais;
    private Pasajero tutor;
    private LocalDate fechaNacimiento;
    
    //Constructores

  

    //Getter and Setter

    public Bebe(String nombre, String apellidos, String nif, String pais, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public Bebe(int codigo, String nombre, String apellidos, String nif, String pais, Pasajero tutor, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.pais = pais;
        this.tutor = tutor;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    @Override
    public String toString() {
        return "Bebe{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif +", pais=" + pais + ", Tutor=" + tutor + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
    
}
