/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.jdbc.Connection;
import dao.Conexion_DB;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 *
 * @author Miriam
 */
public class AjaxCargarDestino extends HttpServlet {
private Connection conexion;
    String mensaje = "No error";

    public void init() throws ServletException {
        
        //establecemos la conexion, si no existe
        
        try{
            Conexion_DB Conex = Conexion_DB.GetConexion();
            //Conex se crea en el JSpInit(), luego usa aquel y no crea objeto.
            conexion = (Connection) Conex.GetCon();
        } catch (ClassNotFoundException cnfe){
            
        } catch (SQLException sqle){
            
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
        try (PrintWriter out = response.getWriter()) {
                request.setCharacterEncoding("UTF-8");
            String valor = request.getParameter("origen");
            int _valor = Integer.parseInt(valor);
            Operaciones OP = new Operaciones();
            Aeropuerto aer = OP.ObtenerAeropuerto(conexion, _valor);
            ArrayList<Aeropuerto> aerDestino = new ArrayList<Aeropuerto>();
            aerDestino = OP.DestinoAjax(conexion, aer);
            
             String options="<option value='0'> -- Select -- </option>";
            
            for (int i = 0; i < aerDestino.size(); i++) {
                options +=  "<option value="+ aerDestino.get(i).getCodigo()+">"+aerDestino.get(i).getCiudad()+" - "+aerDestino.get(i).getIATA()+"</option>";
//                 options+="<option> no va </option>";
                
            }
            out.print(options);
            
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AjaxCargarDestino</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AjaxCargarDestino at " + request.getContextPath() + "</h1>");
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
