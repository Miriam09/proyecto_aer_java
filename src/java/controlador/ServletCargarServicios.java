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
public class ServletCargarServicios extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            HttpSession SesionCarrito = request.getSession(true);
            HttpSession SesionUsuario = request.getSession(true);
            
            Carrito carrito = (Carrito) SesionCarrito.getAttribute("carrito");
            Cliente cliente = (Cliente) SesionUsuario.getAttribute("cliente");
            if(cliente!=null){
            carrito.getReserva().getPago().setCliente(cliente);}
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
                out.println(param + " = " + valor);
            }

            ArrayList<Pasajero> arrayPasajeros = new ArrayList();
            ArrayList<Bebe> arrayBebes = new ArrayList();
            ArrayList<Pasajero> arrayPasajeroUsado = new ArrayList();
            for (int o = 1; o <= carrito.getNumAdultos(); o++) {
//                System.out.println(o);
//                System.out.println(carrito.getNumAdultos());
                String nifA = request.getParameter("nifAdulto" + o);
                String nombreA = request.getParameter("nombreAdulto" + o);
                String apellidosA = request.getParameter("apellidosAdulto" + o);
                int nacimientoAD = Integer.parseInt(request.getParameter("nacimientoDAdulto" + o));
                int nacimientoAM = Integer.parseInt(request.getParameter("nacimientoMAdulto" + o));
                int nacimientoAA = Integer.parseInt(request.getParameter("nacimientoAAdulto" + o));
                String caduNifAM = request.getParameter("caduNifAdultoM" + o);
                String caduNifAA = request.getParameter("caduNifAdultoA" + o);
                String paisA = request.getParameter("paisAdulto" + o);

//                System.out.println("NAcimientoooooooooooo"+nacimientoAA);
//                System.out.println("nif " +nifA);
//                System.out.println("nombre " +nombreA);
//                System.out.println("apellidos " +apellidosA);
//                System.out.println("dia " +nacimientoAD);
//                System.out.println("mes " +nacimientoAM);
//                System.out.println("año " +nacimientoAA);
//                System.out.println("cadnif " +caduNifAM+"-"+caduNifAA);
//                System.out.println("pais " +paisA);
//                System.out.println("apellidos " +apellidosA);
//                System.out.println("FECHAAAAAAAAAAAAAAAAAAAAAAA"+fecha);
                LocalDate nacimientoA = LocalDate.of(nacimientoAA, nacimientoAM, nacimientoAD);
                Pasajero Adulto = new Pasajero(nifA, nombreA, apellidosA, paisA, nacimientoA);
                arrayPasajeros.add(Adulto);
               
            }
//
            for (int i = 1; i <= carrito.getNumNinos(); i++) {
                String nifN = request.getParameter("nifNino" + i);
                System.out.println("nif: " + nifN);
                String nombreN = request.getParameter("nombreNino" + i);
                System.out.println("nombre: " + nombreN);
                String apellidosN = request.getParameter("apellidosNino" + i);
                System.out.println("apellidos: " + apellidosN);
                int nacimientoND = Integer.parseInt(request.getParameter("nacimientoDNino" + i));
                System.out.println("dia: " + nacimientoND);
                int nacimientoNM = Integer.parseInt(request.getParameter("nacimientoMNino" + i));
                System.out.println("mes: " + nacimientoNM);
                int nacimientoNA = Integer.parseInt(request.getParameter("nacimientoANino" + i));
                System.out.println("año: " + nacimientoNA);
                String caduNifNM = request.getParameter("caduNifNinoM" + i);
                System.out.println("cadnif mes: " + caduNifNM);
                String caduNifNA = request.getParameter("caduNifNinoA" + i);
                System.out.println("cadnif año: " + caduNifNA);
                String paisN = request.getParameter("paisNino" + i);
                System.out.println("pais: " + paisN);
                String nifTutorN = request.getParameter("pResponsableN" + i);
                System.out.println("responsable: " + nifTutorN);
                LocalDate nacimientoN = LocalDate.of(nacimientoNA, nacimientoNM, nacimientoND);
                Pasajero Nino = new Pasajero(nifN, nombreN, apellidosN, paisN, nacimientoN);
                
                
                for (int m = 0; m < arrayPasajeros.size(); m++) {
                    if (arrayPasajeros.get(m).getNif().equals(nifTutorN)) {
                        Nino.setTutor(arrayPasajeros.get(m));
                        arrayPasajeroUsado.add(arrayPasajeros.get(m));
                    }
                }

                arrayPasajeros.add(Nino);
            }
            for (int i = 1; i <= carrito.getNumBebe(); i++) {
                String nifB = request.getParameter("nifBebe" + i);
                String nombreB = request.getParameter("nombreBebe" + i);
                String apellidosB = request.getParameter("apellidosBebe" + i);
                int nacimientoBD = Integer.parseInt(request.getParameter("nacimientoDBebe" + i));
                int nacimientoBM = Integer.parseInt(request.getParameter("nacimientoMBebe" + i));
                int nacimientoBA = Integer.parseInt(request.getParameter("nacimientoABebe" + i));
                String caduNifBM = request.getParameter("caduNifBebeM" + i);
                String caduNifBA = request.getParameter("caduNifBebeA" + i);
                String paisB = request.getParameter("paisBebe" + i);
                String nifTutorB = request.getParameter("pResponsableB"+i);
                LocalDate nacimientoB = LocalDate.of(nacimientoBA, nacimientoBM, nacimientoBD);
                Bebe bebe = new Bebe(nombreB,apellidosB, nifB,paisB, nacimientoB);
                for (int m = 0; m < arrayPasajeros.size(); m++) {
                    if (arrayPasajeros.get(m).getNif().equals(nifTutorB)) {
                        bebe.setTutor(arrayPasajeros.get(m));
                        arrayPasajeroUsado.add(arrayPasajeros.get(m));
                    }
                }

                arrayBebes.add(bebe);
            }

            carrito.getReserva().setPasajeros(arrayPasajeros);
            carrito.getReserva().setBebes(arrayBebes);
//
            Operaciones op = new Operaciones();
            ArrayList<Servicio> arrayServicios = op.MostrarServicios(conexion);
            HttpSession SessionServicios = request.getSession(true);
//            for (int i = 0; i<arrayServicios.size(); i++){
//                System.out.println(arrayServicios.get(i));
//            }

            SessionServicios.setAttribute("servicios", arrayServicios);
            SessionServicios.setAttribute("tutores", arrayPasajeroUsado);
            response.sendRedirect("/NavisLines/vista/SeleccionarServivios.jsp");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletReserva1</title>");
            out.println("</head>");
            out.println("<body>");
//            for (int i = 0; i < arrayPasajeros.size(); i++) {
//                out.println("<p><strong> Pasajeros </strong>" + arrayPasajeros.get(i).toString() + "</p>");
//            }
//            for( int j = 0; j<arrayBebes.size(); j++){
//            out.println("<p><strong> Bebes </strong>" + arrayBebes.get(j).toString() + "</p>");
//            }
//            for (Servicio arrayServicio : arrayServicios) {
//                out.println("<p><strong> Servicios </strong>" + arrayServicio.getDescripcion() + "</p>");
//            }
//            out.println("<p><strong> Adultos </strong></p>");
//            out.println("<p><strong> Niños </strong>" + ninos + "</p>");
//            out.println("<p><strong> Bebés </strong>" + bebes + "</p>");
//            out.println("<p><strong> Fecha Salida </strong>" + vueloIda.toString() + "</p>");
//            if ("idaYvuelta".equals(idaVuelta)) {
//                out.println("<p><strong> Fecha vuelta </strong>" + vueloVuelta.toString() + "</p>");
//            }
//            out.println("<h1>Servlet ServletReserva1 at " + request.getContextPath() + "</h1>");
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
