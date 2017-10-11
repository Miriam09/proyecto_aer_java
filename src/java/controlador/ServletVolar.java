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
import modelo.Vuelo;

/**
 *
 * @author Miriam
 */
public class ServletVolar extends HttpServlet {

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
            HttpSession SesionUsuario = request.getSession(true);
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
            HttpSession SesionVuelo = request.getSession(true);
            String vuelo = request.getParameter("numVuelo");
            LocalDate fechaVuelo = LocalDate.parse(request.getParameter("fechaVuelo"));

            Vuelo vueloDespegar = new Vuelo(fechaVuelo, vuelo);

            Operaciones op = new Operaciones();
            Vuelo vueloCompleto = op.BuscarVuelo(vueloDespegar, conexion);
            if (vueloCompleto == null) {
                SesionUsuario.setAttribute("error", "No hay vuelos con estas características");
                response.sendRedirect("/NavisLines/vista/error.jsp");
            } else {
                boolean volando = op.Despegar(vueloCompleto, conexion);

                SesionVuelo.setAttribute("vuelo", volando);
                response.sendRedirect("/NavisLines/vista/confirmacionVuelo.jsp");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletVolar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
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
