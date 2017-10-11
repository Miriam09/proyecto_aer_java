/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.jdbc.Connection;
import dao.Conexion_DB;
import dao.Operaciones;
import java.util.ArrayList;
import modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miriam
 */
public class RealizarPago extends HttpServlet {

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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            HttpSession SesionUsuario = request.getSession(true);
            HttpSession SesionCarrito = request.getSession(true);
            Enumeration parametros = request.getParameterNames();
            Cliente cliente = (Cliente) SesionUsuario.getAttribute("cliente");
            Carrito carrito = (Carrito) SesionCarrito.getAttribute("carrito");
            carrito.getReserva().getPago().setCliente(cliente);

            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
            String num1 = request.getParameter("nT1").trim();
            String num2 = request.getParameter("nT2").trim();
            String num3 = request.getParameter("nT3").trim();
            String num4 = request.getParameter("nT4").trim();
            
               String tipoT = request.getParameter("tipoTarjeta").trim();
            String tarjeta = num1+num2+num3+num4;
            Operaciones op = new Operaciones();
           
            String tarjetaEcn = op.encriptar(tarjeta);

          carrito.getReserva().getPago().getCliente().setNumeroTarjeta(tarjetaEcn);
           carrito.getReserva().getPago().getCliente().setTipoTarjeta(tipoT);

//            if (tarjetaEcn.equals(clienteTarjeta)) {

//              if(tarjetaEcn == cliente.getNumeroTarjeta()){
                String bookingCode = op.generarBookingCode();
//                 Pago pago = new Pago(bookingCode, carrito.getReserva().getCliente(), carrito.getReserva().getPrecioTotal());
//                 
                carrito.getReserva().getPago().setBooking_code(bookingCode);
                for (int i = 0; i < carrito.getReserva().getIda().getArrayOcupacion().size(); i++) {
                    carrito.getReserva().getIda().getArrayOcupacion().get(i).setBookingCode(bookingCode);
                }

                if (carrito.getReserva().getVuelta() != null) {
                    for (int i = 0; i < carrito.getReserva().getVuelta().getArrayOcupacion().size(); i++) {
                        carrito.getReserva().getVuelta().getArrayOcupacion().get(i).setBookingCode(bookingCode);
                    }
                }

                boolean Insertado = op.HacerReserva(carrito, conexion);
                if(Insertado == true){
                    response.sendRedirect("/NavisLines/vista/Factura.jsp");
                } else {
                    response.sendRedirect("/NavisLines/vista/error.jsp");
                    SesionUsuario.setAttribute("error", "Error al realizar el pago.");
                }
            
              
//
////              String passEnc=null;
////             byte[] passEnc= op.encriptar(pass);
////             System.out.println(passEnc);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RealizarPago</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RealizarPago at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(RealizarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
