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
public class Cliente {
    private int codigo;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nif;
    private direccionCliente direccion;
    private String telefono;
    private String mail;
    private String password;
    private String numeroTarjeta;
    private String tipoTarjeta;

    public Cliente() {
    }

    public Cliente(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Cliente(String nombreCompleto, LocalDate fechaNacimiento, String nif, direccionCliente direccion, String telefono, String mail, String password) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.password = password;
    }
    
    
    
    public Cliente(String nombreCompleto, LocalDate fechaNacimiento, String nif, direccionCliente direccion, String telefono, String mail, String password, String numeroTarjeta, String tipoTarjeta) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        //cambiar para que se añada pasando ya por el metodo de encriptacion
        this.password = password; 
        //cambiar para que se añada pasando ya por el metodo de encriptacion y comprobar que es un numero valido de tarjeta
        this.numeroTarjeta = numeroTarjeta;
        //comprobar que la tarjeta no caduque el mes en el que nos encontramos
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public direccionCliente getDireccion() {
        return direccion;
    }

    public void setDireccion(direccionCliente direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", mail=" + mail + ", password=" + password + ", numeroTarjeta=" + numeroTarjeta + ", tipoTarjeta=" + tipoTarjeta + '}';
    }
    
    
    
    
    
}
