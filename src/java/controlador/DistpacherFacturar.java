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
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;
import otros.QR;

/**
 *
 * @author Miriam
 */
public class DistpacherFacturar extends HttpServlet {

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
            Cliente cliente = (Cliente) SesionUsuario.getAttribute("cliente");
            HttpSession sesionFacturacion = request.getSession(true);
            ArrayList ocupaciones = (ArrayList) sesionFacturacion.getAttribute("ocupaciones");
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
                out.println(param + " = " + valor);
            }
            Operaciones op = new Operaciones();
            int vuelo = Integer.parseInt(request.getParameter("facturar"));
            ArrayList<Ocupacion> Ocup = new ArrayList();
            boolean salir = false;
            int facturado = 0;
            for (int i = 0; i < ocupaciones.size(); i++) {
                ArrayList<Ocupacion> ocupaciones2 = (ArrayList) ocupaciones.get(i);
                for (int j = 0; j < ocupaciones2.size() && salir == false; j++) {
                    if (ocupaciones2.get(j).getVuelo().getCodigo() == vuelo) {
                        facturado = op.Facturar(ocupaciones2.get(j), conexion);
                        sesionFacturacion.removeAttribute("ocupaciones");
                        Ocup = (ArrayList<Ocupacion>) ocupaciones2;
                        sesionFacturacion.setAttribute("ocupaciones", ocupaciones2);
                        for (int o = 0; o < ocupaciones2.size(); o++) {
                            String datos = "Nombre pasajero: " + ocupaciones2.get(o).getPasajero().getNombre() + " \n NIF: " + ocupaciones2.get(o).getPasajero().getNif();
                            datos += "\n Origen: " + ocupaciones2.get(o).getVuelo().getViaje().getOrigen() + "\n Destino: " + ocupaciones2.get(o).getVuelo().getViaje().getDestino() +"\n Fecha salida: " + ocupaciones2.get(o).getVuelo().getFecha_salida();

                            QR.createCode(datos, o);
                        }
                        salir = true;
                    }
                }
            }

            if (facturado == 0) {

                SesionUsuario.setAttribute("error", "Error al facturar");
                response.sendRedirect("/NavisLines/vista/error.jsp");

            } else {

//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    System.out.println("Thread Interrupted");
//                }
                response.sendRedirect("/NavisLines/vista/MostrarBilletes.jsp");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DistpacherFacturar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DistpacherFacturar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(DistpacherFacturar.class.getName()).log(Level.SEVERE, null, ex);
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
