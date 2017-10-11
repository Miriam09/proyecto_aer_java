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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Miriam
 */
public class ServletLogin extends HttpServlet {
   
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
             HttpSession SesionCarrito = request.getSession(true);
             
            Enumeration parametros = request.getParameterNames();
             while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
             String user = request.getParameter("usuario").trim();
             System.out.println(user);
             String pass = request.getParameter("password").trim();
             System.out.println(pass);
             
             
             Operaciones op = new Operaciones();
//              String passEnc=null;
             
             String passEnc= op.encriptar(pass);
//             System.out.println(passEnc);
//            String tarjeta = op.encriptar("5101332384154013");
//             System.out.println(tarjeta);
             Cliente objCliente = new Cliente(user, passEnc);
             Cliente objClienteCompleto = op.validarCliente(objCliente, conexion);
              Reserva nuevaReserva = new Reserva();
            nuevaReserva.getPago().setFecha(LocalDate.now());
            

            Carrito nuevoCarrito = new Carrito();
            
            nuevoCarrito.setReserva(nuevaReserva);

          
            SesionCarrito.setAttribute("carrito", nuevoCarrito);
            
             if(objClienteCompleto==null){
                 SesionUsuario.setAttribute("error", "Error al iniciar sesión. Inténtalo de nuevo");
                 response.sendRedirect("/NavisLines/vista/error.jsp");
             } else{
                 SesionUsuario.setAttribute("cliente", objClienteCompleto);
                 nuevaReserva.getPago().setCliente(objClienteCompleto);
                 System.out.println(objClienteCompleto);
                 System.out.println("Bien");
                 
//                 carrito.getReserva().inicioCliente();
//                 carrito.getReserva().getCliente().setCodigo(objClienteCompleto.getCodigo());
//                 carrito.getReserva().getCliente().setNombreCompleto(objClienteCompleto.getNombreCompleto());
//                 carrito.getReserva().getCliente().setFechaNacimiento(objClienteCompleto.getFechaNacimiento());
//                 carrito.getReserva().getCliente().setNif(objClienteCompleto.getNif());
//                 carrito.getReserva().getCliente().setDireccion(objClienteCompleto.getDireccion());
//                 carrito.getReserva().getCliente().setTelefono(objClienteCompleto.getTelefono());
//                 carrito.getReserva().getCliente().setPassword(objClienteCompleto.getPassword());
//                 carrito.getReserva().getCliente().setNumeroTarjeta(objClienteCompleto.getPassword());
//                 carrito.getReserva().getCliente().setTipoTarjeta(objClienteCompleto.getTipoTarjeta());
             System.out.println(objClienteCompleto.toString());
              response.sendRedirect("/NavisLines/vista/Pagar.jsp");
             }
             
              
              
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletLogin</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>tarj " + passEnc + "</h1>");
//            out.println("<h1>tarj " + tarjeta + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
