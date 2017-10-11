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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Pago;
import modelo.Reserva;

/**
 *
 * @author Miriam
 */
public class ServletReservas extends HttpServlet {
   
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
            HttpSession SesionUsuario = request.getSession(true);
           HttpSession SesionReserva = request.getSession(true);
            Enumeration parametros = request.getParameterNames();
             while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
             String user = request.getParameter("mail").trim();
             System.out.println(user);
             String pass = request.getParameter("pass").trim();
             System.out.println(pass);
             
             
             Operaciones op = new Operaciones();
//              String passEnc=null;
             
             String passEnc= op.encriptar(pass);
             System.out.println(passEnc);
             Cliente objCliente = new Cliente(user, passEnc);
             Cliente objClienteCompleto = op.validarCliente(objCliente, conexion);
              Reserva nuevaReserva ;
            
            
           
                 ArrayList <Reserva>  arrayReservas = new ArrayList();
             if(objClienteCompleto==null){
                 SesionUsuario.setAttribute("error", "Error al iniciar sesión. Inténtalo de nuevo");
                 response.sendRedirect("/NavisLines/vista/error.jsp");
             } else{
                 
                 ArrayList <Pago> pagos = op.BuscarPagos(objClienteCompleto, conexion);
                 
                 for ( int i = 0; i<pagos.size(); i++){
                     nuevaReserva=op.buscarReservas(pagos.get(i), conexion);
                     arrayReservas.add(nuevaReserva);
                     
                 }                 
                 
                 
                 
                 
                 
                 
                 SesionReserva.setAttribute("reservas", arrayReservas);
                 SesionUsuario.setAttribute("cliente", objClienteCompleto);
                
               
              response.sendRedirect("/NavisLines/vista/vistaReservas.jsp");
             }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletReservas</title>");  
            out.println("</head>");
            out.println("<body>");
            for(int o = 0; o<arrayReservas.size(); o++){
            out.println("<h1>Servlet ServletReservas at " + arrayReservas.get(o).getPago().getBooking_code() + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
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
