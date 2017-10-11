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
import java.time.LocalDate;
import java.time.Month;
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
public class RegistrarUsuario extends HttpServlet {

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
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
            HttpSession SesionUsuario = request.getSession(true);
            Operaciones op = new Operaciones();
            String nombre = request.getParameter("nombre").trim();
            String apellidos = request.getParameter("apellidos").trim();
            int day = Integer.parseInt(request.getParameter("dia").trim());
            int month = Integer.parseInt(request.getParameter("mes").trim());
            int year = Integer.parseInt(request.getParameter("year").trim());
            String nif = request.getParameter("nif").trim();
            String telefono = request.getParameter("telefono").trim();
            String mail = request.getParameter("mail").trim();
            
//            String nt1 = request.getParameter("nT1");
//             String nt2 = request.getParameter("nT1"); 
//             String nt3 = request.getParameter("nT1"); 
//             String nt4 = request.getParameter("nT1");
//             String numTarjeta = nt1+nt2+nt3+nt4;
//             
//             
            String pass = request.getParameter("password2");
            String password = op.encriptar(pass);
//            String  numTarjetacr = op.encriptar(numTarjeta);
            String tipoVia = request.getParameter("tvia").trim();
            String nomVia = request.getParameter("nvia").trim();
            String numVia = request.getParameter("nuvia").trim();
            String poblacion = request.getParameter("poblacion").trim();
            String cp = request.getParameter("cp").trim();
            String provincia = request.getParameter("provincia").trim();
            String pais = request.getParameter("pais").trim();
//             String tipoT = request.getParameter("tipoTarjeta");
            direccionCliente direccion = new direccionCliente(tipoVia, nomVia, numVia, poblacion, provincia, cp, pais);
            
            String nomCompleto = nombre+" "+apellidos;
            LocalDate fechaNac = LocalDate.of(year, month, day);
            Cliente nuevoCliente = new Cliente(nomCompleto, fechaNac, nif, direccion, telefono, mail, password);
//            nuevoCliente.setNumeroTarjeta(numTarjetacr);
//            nuevoCliente.setTipoTarjeta(tipoT);
            int buscar = op.BuscarUsuario(nuevoCliente, conexion);
            if(buscar==0){
            int registrado = op.RegistrarCliente(nuevoCliente, conexion);
                if (registrado > 0){
                    nuevoCliente.setCodigo(registrado);
                   SesionUsuario.setAttribute("cliente", nuevoCliente);
                 response.sendRedirect("/NavisLines/vista/Pagar.jsp");
                } else {
                    SesionUsuario.setAttribute("error", "Error en el registro.");
                 response.sendRedirect("/NavisLines/vista/error.jsp");
                }
            } else{
                SesionUsuario.setAttribute("error", "Ya existe un cliente con ese correo.");
                 response.sendRedirect("/NavisLines/vista/error.jsp");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
