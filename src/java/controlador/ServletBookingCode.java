/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import com.mysql.jdbc.Connection;
import dao.Conexion_DB;
import dao.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

/**
 *
 * @author Miriam
 */
public class ServletBookingCode extends HttpServlet {
   
    private Connection conexion;
    String mensaje = "No error";

    public void init() throws ServletException {

        //establecemos la conexion, si no existe
        try {
            Conexion_DB Conex = Conexion_DB.GetConexion();
            //Conex se crea en el JSpInit(), luego usa aquel y no crea objeto.
            conexion = (Connection) Conex.GetCon();
        } catch (ClassNotFoundException cnfe) {

        } catch (SQLException sqle) {

        }
    }
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
                out.println(param + " = " + valor);
            }
             HttpSession SesionUsuario = request.getSession(true);
             HttpSession sesionFacturacion = request.getSession(true);
            Operaciones op = new Operaciones();
            String mail = request.getParameter("mail");
            String password = request.getParameter("pass");
            String bokkC = request.getParameter("bk");
            
            String passEncript = op.encriptar(password);
            
            Cliente cliente = new Cliente(mail, passEncript);
            
            Cliente clienteValidado = op.validarCliente(cliente, conexion);
                   Pago pagoRealizado = new Pago(bokkC, clienteValidado);
            int valido = op.comprobarPago(pagoRealizado, conexion);
            
            if(valido==1){
                 SesionUsuario.setAttribute("cliente",clienteValidado );
                Reserva reserva = new Reserva();
                reserva.setPago(pagoRealizado);
                ArrayList <Vuelo> vuelosReservados = op.recogerFacturacion(reserva, conexion);
              
                ArrayList<Ocupacion> ocupaciones = new ArrayList();
                ArrayList arrayOcupaciones = new ArrayList();
               for (Vuelo vuelosReservado : vuelosReservados) {
                   arrayOcupaciones.add(ocupaciones=op.BuscarFacturacion(vuelosReservado,bokkC, conexion ));
                    for (Ocupacion ocupacione : ocupaciones) {
                        ocupacione.setVuelo(vuelosReservado);
                    }
               }
               
               sesionFacturacion.setAttribute("ocupaciones", arrayOcupaciones);
                
                response.sendRedirect("/NavisLines/vista/vistaFacturacion.jsp");
            } else {
                
                 SesionUsuario.setAttribute("error", "No tiene ninguna reserva con ese bookingcode");
                 response.sendRedirect("/NavisLines/vista/error.jsp");
            }
            
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
