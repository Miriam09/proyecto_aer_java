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
public class direccionCliente {
    private int codigo;
    private String tipoVia;
    private String nombreVia;
    private String numero;
    private String poblacion;
    private String provincia;
    private String codigoPostal;
    private String pais;

    public direccionCliente() {
    }

    
    public direccionCliente(String tipoVia, String nombreVia, String numero, String poblacion, String provincia, String codigoPostal, String pais) {
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "direccionCliente{" + "codigo=" + codigo + ", tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", numero=" + numero + ", poblacion=" + poblacion + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", pais=" + pais + '}';
    }
    
    
}
