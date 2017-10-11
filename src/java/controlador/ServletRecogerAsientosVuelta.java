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
public class ServletRecogerAsientosVuelta extends HttpServlet {
   
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
            HttpSession SesionCarrito = request.getSession(true);
            HttpSession SessionOcupacionesVuelta = request.getSession(true);
            Carrito carrito = (Carrito) SesionCarrito.getAttribute("carrito");

            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
                out.println(param + " = " + valor);
            }
             ArrayList<Ocupacion> arrayOcupacionVuelta = carrito.getReserva().getVuelta().getArrayOcupacion();
            
            
//            ArrayList asientosOcupados = (ArrayList) SessionOcupacionesIda.getAttribute("asientosOcupadosIda");
//            ArrayList asientosLibres = (ArrayList) SessionOcupacionesIda.getAttribute("asientosLibresIda");
            ArrayList <Ocupacion> arrayElegir = (ArrayList)SessionOcupacionesVuelta.getAttribute("PasajerosElegirVuelta");
//            boolean irSeleccionVuelta = (boolean) SessionOcupacionesVuelta.getAttribute("seleccionAsientosVuelta");
            
            
            for( int i =0; i<arrayElegir.size(); i++){
                boolean encontrado = false;
                String Asiento = request.getParameter((arrayElegir.get(i).getPasajero().getNif()));
                System.out.println(Asiento);
                for(int ocu = 0; ocu<arrayOcupacionVuelta.size() && encontrado == false; ocu++){
                    String nifPasajero = arrayElegir.get(i).getPasajero().getNif();
                    String nifOcupacion = arrayOcupacionVuelta.get(ocu).getPasajero().getNif();
                    System.out.println(nifPasajero);
                     System.out.println(nifOcupacion);
                     if(arrayOcupacionVuelta.get(ocu).getPasajero()!= null){
                    if(nifPasajero.equals(nifOcupacion)){
                        System.out.println(arrayOcupacionVuelta.get(ocu).getPasajero().getNombre());
                        arrayOcupacionVuelta.get(ocu).setAsiento(Asiento);
                        encontrado = true;
//                        arrayElegir.remove(i);
                    }
                }}
            }
            
          
                response.sendRedirect("/NavisLines/vista/Resumen.jsp");
            
//            String asientoElegido = request.getParameter("asientoElegido");
//            Operaciones OP = new Operaciones();
//            asientosOcupados.add(asientoElegido);
//
//            asientosLibres.remove(asientoElegido);
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletRecogerAsientos</title>");
//            out.println("</head>");
//            out.println("<body>");
//            for (int o = 0; o< arrayOcupacionVuelta.size(); o++){
//                if(arrayOcupacionVuelta.get(o).getPasajero() != null){
//                    out.println("<h1>Pasajero " + arrayOcupacionVuelta.get(o).getPasajero().getNombre() + "</h1>");
//                    out.println("<h1>asiento " + arrayOcupacionVuelta.get(o).getAsiento() + "</h1>");
//                }
//            }
//            out.println("<h1>Servlet ServletRecogerAsientos at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
