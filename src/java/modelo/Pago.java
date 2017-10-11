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
public class Pago {
    private int codigo;
    private String booking_code;
    private Cliente cliente;
    private Double importeTotal;
    private LocalDate fecha;

    public Pago(String booking_code, Cliente cliente, Double importeTotal, LocalDate fecha) {
        this.booking_code = booking_code;
        this.cliente = cliente;
        this.importeTotal = importeTotal;
        this.fecha=fecha;
    }

    public Pago() {
    }

    public Pago(String booking_code, Cliente cliente) {
        this.booking_code = booking_code;
        this.cliente = cliente;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getBooking_code() {
        return booking_code;
    }

    public void setBooking_code(String booking_code) {
        this.booking_code = booking_code;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
    
}
