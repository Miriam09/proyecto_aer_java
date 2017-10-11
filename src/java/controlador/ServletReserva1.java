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
import java.time.LocalDate;
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
public class ServletReserva1 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession SesionCarrito = request.getSession(true);
            
            HttpSession SesionUsuario = request.getSession(true);
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
//                out.println (param+" = "+valor);
            }
 Carrito carrito = new Carrito();
            String origen = request.getParameter("origen");
            String destino = request.getParameter("destino");
            String idaVuelta = request.getParameter("idaVuelta");
//            String fechaIda=null;
//            String fechaVuelta = null;
            int codigovueloVuelta = 0;
            Vuelo vueloVuelta = null;
            int codigovueloIda = 0;
            Vuelo vueloIda = null;
            Operaciones op = new Operaciones();
            
            codigovueloIda = Integer.parseInt(request.getParameter("vueloIda"));
            vueloIda = op.BuscarVuelo(codigovueloIda, conexion);

            if ("idaYvuelta".equals(idaVuelta)) {
//           
                codigovueloVuelta = Integer.parseInt(request.getParameter("vueloVuelta"));
                vueloVuelta = op.BuscarVuelo(codigovueloVuelta, conexion);

            }
            int adultos = Integer.parseInt(request.getParameter("adultos"));
            int ninos = Integer.parseInt(request.getParameter("ninos"));
            int bebes = Integer.parseInt(request.getParameter("bebes"));
            Reserva nuevaReserva = new Reserva();
            carrito.setReserva(nuevaReserva);
            carrito.getReserva().setIda(vueloIda);
            carrito.getReserva().setVuelta(vueloVuelta);

            carrito.setNumAdultos(adultos);
            carrito.setNumBebe(bebes);
            carrito.setNumNinos(ninos);
            Cliente cliente = null;
          SesionUsuario.setAttribute("cliente", cliente);
           SesionCarrito.setAttribute("carrito", carrito);
            
            response.sendRedirect("/NavisLines/vista/Paso2.jsp");
//            response.sendRedirect("/NavisLines/vista/Login_Registro.jsp");
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletReserva1</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<p><strong> Origen </strong>" + origen + "</p>");
//            out.println("<p><strong> Destino </strong>" + destino + "</p>");
//            
//            out.println("<p><strong> Adultos </strong>" + adultos + "</p>");
//            out.println("<p><strong> Niños </strong>" + ninos + "</p>");
//            out.println("<p><strong> Bebés </strong>" + bebes + "</p>");
//             out.println("<p><strong> Fecha Salida </strong>" + vueloIda.toString() + "</p>");
//              if ("idaYvuelta".equals(idaVuelta)) {
//            out.println("<p><strong> Fecha vuelta </strong>" + vueloVuelta.toString() + "</p>");
//              }
////            out.println("<h1>Servlet ServletReserva1 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
