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
public class ServletRecogerServicios extends HttpServlet {

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
            HttpSession SesionCarrito = request.getSession(true);
//            HttpSession SessionServicios = request.getSession(true);
            HttpSession SessionOcupacionesIda = request.getSession(true);
            Carrito carrito = (Carrito) SesionCarrito.getAttribute("carrito");
            ArrayList<Servicio> arraySercicioSeleccionado = new ArrayList();
            Operaciones op = new Operaciones();
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String param = (String) parametros.nextElement();
                String valor = request.getParameter(param);
                out.println(param + " = " + valor);
            }
            int adultos = carrito.getNumAdultos();
            int ninos = carrito.getNumNinos();
            int bebes = carrito.getNumBebe();
            ArrayList<Pasajero> arrayPasajeros = carrito.getReserva().getPasajeros();
            ArrayList<Bebe> arrayBebe = carrito.getReserva().getBebes();
            ArrayList<Ocupacion> ocupacionIda = carrito.getReserva().getIda().getArrayOcupacion();

            Operaciones OP = new Operaciones();
            ArrayList<Ocupacion> arrayOcupadasIda = OP.OcupacionVuelo(carrito.getReserva().getIda(), conexion);
//            ArrayList asientosOcupadosIda = new ArrayList();
//            carrito.getReserva().getIda().setArrayOcupacion(arrayOcupadasIda);
//            for (Ocupacion arrayOcupadasIda1 : arrayOcupadasIda) {
//                ocupacionIda.add(arrayOcupadasIda1);
//            }

            ArrayList<String> asientosIda = new ArrayList();

            for (int a = 1; a <= ocupacionIda.size(); a++) {
                if (a == 1) {
                    asientosIda.add(a + "A");
                } else if (a % 2 == 0) {
                    asientosIda.add((a / 2) + "B");
                } else {
                    asientosIda.add(((a + 1) / 2) + "A");
                }
            }

            boolean esta;
            ArrayList asientosLibresIda = new ArrayList(8);
            for (int as = 0; as < asientosIda.size(); as++) {
                esta = false;
                for (int j = 0; j < arrayOcupadasIda.size() && esta==false ; j++) {
                    if (arrayOcupadasIda.get(j).getAsiento().equals(asientosIda.get(as))) {
                        esta = true;
                    } 
                }
                if (esta == false) {
                    asientosLibresIda.add(asientosIda.get(as));
                }
                
            }

            ArrayList<Ocupacion> ocupacionVuelta = null;
            ArrayList<Ocupacion> arrayOcupadasVuelta = null;
            ArrayList<String> asientosVuelta = new ArrayList();
            boolean estaV = false;
            ArrayList asientosLibresVuelta = new ArrayList();
            double precioTotal=0;
            System.out.println("GetVuelta: " + carrito.getReserva().getVuelta());
            if (carrito.getReserva().getVuelta() != null) {
                ocupacionVuelta = carrito.getReserva().getVuelta().getArrayOcupacion();
                arrayOcupadasVuelta = OP.OcupacionVuelo(carrito.getReserva().getVuelta(), conexion);
                for (int a = 1; a <= ocupacionVuelta.size(); a++) {
                    if (a == 1) {
                        asientosVuelta.add(a + "A");
                    } else if (a % 2 == 0) {
                        asientosVuelta.add((a / 2) + "B");
                    } else {
                        asientosVuelta.add(((a + 1) / 2) + "A");
                    }
                }
                for (int as = 0; as < asientosVuelta.size(); as++) {
                     estaV = false;
                    for (int j = 0; j < arrayOcupadasVuelta.size() &&  estaV == false; j++) {
                        if (arrayOcupadasVuelta.get(j).getAsiento().equals(asientosVuelta.get(as))) {
                            estaV = true;
                        }
                    }
                    if (estaV == false) {
                        asientosLibresVuelta.add(asientosVuelta.get(as));
                    }
                }
            }

            int f = 1;
            boolean eleccionAsientoIda = false;
            boolean eleccionAsientoVuelta = false;
            
            for (int s = 0; s < arrayPasajeros.size(); s++, f++) {
                double precio=0;
                System.out.println(arrayPasajeros.get(s).getNombre());
                ArrayList<ServiciosContratados> servContIda = new ArrayList();
                ArrayList<ServiciosContratados> servContVuelta = new ArrayList();
                String[] serviciosIda = request.getParameterValues("serviciosIda" + f);
                if (serviciosIda != null && serviciosIda.length > 0) {
                    for (String serviciosIda1 : serviciosIda) {
                        servContIda.add((ServiciosContratados) op.MostrarServicio(serviciosIda1, conexion));
                        System.out.println("S: " + s + " longitud: " + arrayPasajeros.size());
                        
                        System.out.println("ServiciosIda n" + f + ": " + serviciosIda1);
                    }
                }
                String asientoIda = request.getParameter("serviciosIdaAsiento"+ f);
                servContIda.add((ServiciosContratados) op.MostrarServicio(asientoIda, conexion));
                System.out.println("Tipo de asiento n" + f + ": " + asientoIda);
                String maletaIda = request.getParameter("serviciosIdaMaleta" + f);
                servContIda.add((ServiciosContratados) op.MostrarServicio(maletaIda, conexion));
                System.out.println("Tipo maleta n" + f + ": " + maletaIda);
                arrayPasajeros.get(s).setServicios(servContIda);
                boolean salir = false;
                if ("3".equals(asientoIda)) {
                    eleccionAsientoIda = true;
                    for (int i = 0; i < carrito.getReserva().getIda().getPlazas_totales() && salir == false; i++) {
                        if (ocupacionIda.get(i).getPasajero() == null) {
                            ocupacionIda.get(i).setPasajero(arrayPasajeros.get(s));
                            precio += carrito.getReserva().getIda().getPrecio();
                            for (int ser = 0; ser < arrayPasajeros.get(s).getServicios().size(); ser++) {
                                precio += arrayPasajeros.get(s).getServicios().get(ser).getPrecio();
                                System.out.println("SERVICIO IDA-" + ser + ": " + arrayPasajeros.get(s).getServicios().get(ser).getSiglas());
                            }
                            precioTotal+=precio;
                            ocupacionIda.get(i).setImporte(precio);
                            salir = true;
                        }
                    }
                } else {
                    for (int i = 0; i < carrito.getReserva().getIda().getPlazas_totales() && salir == false; i++) {
                        if (ocupacionIda.get(i).getPasajero() == null) {
                            ocupacionIda.get(i).setPasajero(arrayPasajeros.get(s));
                            ocupacionIda.get(i).setAsiento((String) asientosLibresIda.get(0));
                            asientosLibresIda.remove(0);
                            precio += carrito.getReserva().getIda().getPrecio();
                            for (int ser = 0; ser < arrayPasajeros.get(s).getServicios().size(); ser++) {
                                precio += arrayPasajeros.get(s).getServicios().get(ser).getPrecio();
                                System.out.println("SERVICIO IDA-" + ser + ": " + arrayPasajeros.get(s).getServicios().get(ser).getSiglas());
                            }
                            precioTotal+=precio;
                            ocupacionIda.get(i).setImporte(precio);
                            salir = true;
                        }
                    }
                }

                if (carrito.getReserva().getVuelta() != null) {
                   precio = 0;
                    String[] serviciosVuelta = request.getParameterValues("serviciosVuelta" + f);
                    if (serviciosVuelta != null && serviciosVuelta.length > 0) {
                        for (String serviciosVuelta1 : serviciosVuelta) {
                            if (serviciosVuelta1 != null) {
                                servContVuelta.add((ServiciosContratados) op.MostrarServicio(serviciosVuelta1, conexion));
                            }
                        }
                    }
                    String asientoVuelta = request.getParameter("serviciosVueltaAsiento" + f);
                      System.out.println("Tipo de asiento n" + f + ": " + asientoVuelta);
                    servContVuelta.add((ServiciosContratados) op.MostrarServicio(asientoVuelta, conexion));
                    String maletaVuelta = request.getParameter("serviciosVueltaMaleta" + f);
                    System.out.println("Tipo maleta n" + f + ": " + maletaVuelta);
                    servContVuelta.add((ServiciosContratados) op.MostrarServicio(maletaVuelta, conexion));
                    arrayPasajeros.get(s).setServicios(servContVuelta);
                    salir = false;
                    if ("3".equals(asientoVuelta)) {
                        eleccionAsientoVuelta = true;
                        for (int i = 0; i < carrito.getReserva().getVuelta().getPlazas_totales() && salir == false; i++) {
                            if (ocupacionVuelta.get(i).getPasajero() == null) {
                                ocupacionVuelta.get(i).setPasajero(arrayPasajeros.get(s));
                                precio += carrito.getReserva().getVuelta().getPrecio();
                                for (int ser = 0; ser < arrayPasajeros.get(s).getServicios().size(); ser++) {
                                    precio += arrayPasajeros.get(s).getServicios().get(ser).getPrecio();
                                    System.out.println("SERVICIO VUELTA-" + ser + ": " + arrayPasajeros.get(s).getServicios().get(ser).getSiglas());
                                }
                                precioTotal+=precio;
                                ocupacionVuelta.get(i).setImporte(precio);
                                salir = true;
                            }
                        }
                    } else {
                        for (int i = 0; i < carrito.getReserva().getVuelta().getPlazas_totales() && salir == false; i++) {
                            System.out.println("carrito reserva vuelta: " + carrito.getReserva().getVuelta().getPlazas_totales());
                            if (ocupacionVuelta.get(i).getPasajero() == null) {
                                ocupacionVuelta.get(i).setPasajero(arrayPasajeros.get(s));
                                ocupacionVuelta.get(i).setAsiento((String) asientosLibresVuelta.get(0));
                                asientosLibresVuelta.remove(0);
                                System.out.println("Asiento: -----------" + i + 1);
                                precio += carrito.getReserva().getVuelta().getPrecio();
                                for (int ser = 0; ser < arrayPasajeros.get(s).getServicios().size(); ser++) {
                                    precio += arrayPasajeros.get(s).getServicios().get(ser).getPrecio();
                                    System.out.println("SERVICIO VUELTA-" + ser + ": " + arrayPasajeros.get(s).getServicios().get(ser).getSiglas());
                                }
                                precioTotal+=precio;
                                ocupacionVuelta.get(i).setImporte(precio);
                                salir = true;
                            }
                        }
                    }
                }
            }
            
            double totalIda = carrito.getReserva().getIda().getPrecio()*(carrito.getNumAdultos()+carrito.getNumNinos());
            SesionCarrito.setAttribute("totalIda", totalIda);
            Pago pago = new Pago();
            carrito.getReserva().setPago(pago);
            carrito.getReserva().getPago().setImporteTotal(precioTotal);
//            double totalIdaServicios=totalIda;
//            for (Ocupacion ocupacionIda1 : ocupacionIda) {
//                if(ocupacionIda1.getPasajero()!=null){
//                ArrayList <ServiciosContratados> servicios = new ArrayList();
//                servicios = ocupacionIda1.getPasajero().getServicios();;
//                for (ServiciosContratados servicio : servicios) {
//                    totalIdaServicios += servicio.getPrecio();
//                } 
//            }}
            
//            SessionOcupacionesIda.setAttribute("totalIdaSercvicios", totalIdaServicios);
            SessionOcupacionesIda.setAttribute("totalAsientosIda", asientosIda);
            SessionOcupacionesIda.setAttribute("asientosOcupadosIda", arrayOcupadasIda);
            SessionOcupacionesIda.setAttribute("asientosLibresIda", asientosLibresIda);

            if (carrito.getReserva().getVuelta() != null) {
                double totalVuelta= carrito.getReserva().getVuelta().getPrecio()*(carrito.getNumAdultos()+carrito.getNumNinos());
            SesionCarrito.setAttribute("totalVuelta", totalVuelta);
//            double totalVueltaServicios=totalVuelta;
//                for (Ocupacion ocupacionVuelta1 : ocupacionVuelta) {
//                    if(ocupacionVuelta1.getPasajero() != null){
//                    ArrayList <ServiciosContratados> servicios = new ArrayList();
//                    servicios = ocupacionVuelta1.getPasajero().getServicios();
//                    for (ServiciosContratados servicio : servicios) {
//                        totalVueltaServicios += servicio.getPrecio();
//                    }}
//                }
            
//            SesionCarrito.setAttribute("totalVueltaServicios", totalVueltaServicios);
                HttpSession SessionOcupacionesVuelta = request.getSession(true);
                SessionOcupacionesVuelta.setAttribute("totalAsientosVuelta", asientosVuelta);
                SessionOcupacionesVuelta.setAttribute("asientosOcupadosVuelta", arrayOcupadasVuelta);
                SessionOcupacionesVuelta.setAttribute("asientosLibresVuelta", asientosLibresVuelta);
            }

            
            
            if (eleccionAsientoIda == true) {
                response.sendRedirect("/NavisLines/vista/SeleccionarAsientos.jsp");
                SessionOcupacionesIda.setAttribute("seleccionAsientosVuelta", eleccionAsientoVuelta);
            } else if (eleccionAsientoVuelta == true) {
                response.sendRedirect("/NavisLines/vista/SeleccionarAsientosVuelta.jsp");
            } else {
                response.sendRedirect("/NavisLines/vista/Resumen.jsp");
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletRecogerServicios</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h2>vuelo Ida </h2>");
//            for (int i = 0; i < ocupacionIda.size(); i++) {
//                if(ocupacionIda.get(i).getPasajero() != null){
//                out.println("<h4> Asiento: " + ocupacionIda.get(i).getAsiento() + "</h4>");
//
//                out.println("<h4> Pasajero" + ocupacionIda.get(i).getPasajero().toString() + "</h4>");
//                ArrayList<ServiciosContratados> serviIda = ocupacionIda.get(i).getPasajero().getServiciosIda();
//                for (int j = 0; j < serviIda.size(); j++) {
//                    out.println("<h4>Servicios Pasajero " + i + ": " + serviIda.get(j).toString() + "</h4>");
//                }
//
//            }}
//            out.println("<h2>vuelo Vuelta </h2>");
//            for (int i = 0; i < ocupacionVuelta.size(); i++) {
//                if(ocupacionVuelta.get(i).getPasajero() != null){
//                out.println("<h4> Asiento: " + ocupacionVuelta.get(i).getAsiento() + "</h4>");
//
//                out.println("<h4> Pasajero" + ocupacionVuelta.get(i).getPasajero().toString() + "</h4>");
//                ArrayList<ServiciosContratados> serviVuelta = ocupacionVuelta.get(i).getPasajero().getServiciosVuelta();
//                for (int j = 0; j < serviVuelta.size(); j++) {
//                    out.println("<h4>Servicios Pasajero " + i + ": " + serviVuelta.get(j).toString() + "</h4>");
//                }
//
//            }}
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
