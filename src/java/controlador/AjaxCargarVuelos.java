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
import modelo.*;

/**
 *
 * @author Miriam
 */
public class AjaxCargarVuelos extends HttpServlet {

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
                System.out.println(param + " = " + valor);
            }
            try {
                
                int _origen = Integer.parseInt(request.getParameter("origen"));
                int _destino = Integer.parseInt(request.getParameter("destino"));
                LocalDate fechaIda = LocalDate.parse(request.getParameter("fechaIda"));
                boolean ida = Boolean.parseBoolean(request.getParameter("ida"));
                boolean idaYvuelta = Boolean.parseBoolean(request.getParameter("idaYvuelta"));
                boolean mostrarBoton = true;
                int adultos = Integer.parseInt(request.getParameter("adultos"));
                int ninos = Integer.parseInt(request.getParameter("ninos"));
                String options = "";
//                if (_origen == 0) {
//                    options += "<div class='row'> <div class='col-md-10'>";
//                    options += "<div class='alert alert-danger'>Debes seleccionar un origen</div>";
//                    options += "</div> </div>";
//                    out.print(options);
//                    
//                } else if (_destino == 0) {
//                    options += "<div class='row'> <div class='col-md-10'>";
//                    options += "<div class='alert alert-danger'>Debes seleccionar un destino</div>";
//                    options += "</div> </div>";
//                    out.print(options);
//                } else if(fechaIda==null){
//                    options += "<div class='row'> <div class='col-md-10'>";
//                    options += "<div class='alert alert-danger'>Debes seleccionar una fecha de ida.</div>";
//                    options += "</div> </div>";
//                    out.print(options);
                
                
                
                
                int pasajeros = adultos + ninos;
                Operaciones OP = new Operaciones();
                Conexiones conexiones = OP.ObtenerConexiones(conexion, _origen, _destino);

                System.out.println("Ninos: " + ninos);
                System.out.println("Adultos: " + adultos);
//                out.print("VAAAAAAAAA");
//                out.println("adultos: "+adultos);
//                out.println("ninos: "+ninos);
                if (ida == true) {
                    ArrayList<Vuelo> vuelosIda = OP.MostrarIdas(conexion, _origen, _destino, fechaIda);

                    System.out.println("Origen " + _origen + " destino: " + _destino + " decha_ida: " + fechaIda);

                    options += "<div class='row'> <div class='col-md-10'> <table class='table table-bordered table-responsive table-striped'>";
                    options += "<tr>";
                    options += "<th colspan='6' class='active'>Vuelos de ida</th>";
                    options += "</tr>";
                    if (vuelosIda.isEmpty()) {
                        mostrarBoton = false;
                        options += "<tr>";
                        options += "<td colspan='6' class='danger'><strong>No hay vuelos próximos a esta fecha.</strong></td>";

                        options += "</tr>";
                    } else {
                        for (int i = 0; i < vuelosIda.size(); i++) {
                            ArrayList<Ocupacion> arrayOcupacion = OP.OcupacionVuelo(vuelosIda.get(i), conexion);

                            int ocupadas = 0;
                            if (arrayOcupacion == null) {
                                ocupadas = 0;
                            } else {
                                ocupadas = arrayOcupacion.size();
                            }
                            int libres = (vuelosIda.get(i).getPlazas_totales() - ocupadas);
                            if (ocupadas <= (vuelosIda.get(i).getPlazas_totales()) && (libres >= pasajeros)) {
                                options += "<tr>";
                                options += "<td rowspan='2' class='success'><input type='radio' name='vueloIda' value='" + vuelosIda.get(i).getCodigo() + "' </td>";
                                options += "<td class='success'><strong>Fecha de salida </strong></td>";
                                options += "<td class='success'><strong>Hora de salida </strong></td>";
                                options += "<td class='success'><strong>Duración </strong></td>";
                                options += "<td class='success'><strong>Número de vuelo </strong></td>";
                                options += "<td class='success'><strong>Precio </strong></td>";
                                options += "</tr>";
                                options += "<tr>";

                                options += "<td>" + vuelosIda.get(i).getFecha_salida() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getHora_salida() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getDuracion() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getNum_vuelo() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getPrecio() + "€</td>";
                                options += "</tr>";
                            } else {
                                mostrarBoton = false;
                                options += "<tr>";
                                options += "<td colspan='6' class='danger'><strong>No hay vuelo disponible. </strong></td>";

                                options += "</tr>";
                            }
                        }
                    }
                    options += " </table> </div> </div>";
                    if (vuelosIda.size() > 0) {
                        options += "<div class='row'><input type='submit' class='btn btn-success center-block' value='Siguiente'></div>";
                    }
                } else if (idaYvuelta == true) {
                    LocalDate fechaVuelta = LocalDate.parse(request.getParameter("fechaVuelta"));
                   
                    ArrayList<Vuelo> vuelosIda = OP.MostrarIdas(conexion, _origen, _destino, fechaIda);
                    ArrayList<Vuelo> vuelosVuelta = OP.MostrarVueltas(conexion, _origen, _destino, fechaVuelta);
                    options += "<div class='row'> <div class='col-md-10'> <table class=' table table-bordered table-responsive table-striped'>";
                    options += "<tr>";
                    options += "<th colspan='6' class='active'>Vuelos de ida</th>";
                    options += "</tr>";
                    if (vuelosIda.isEmpty()) {
                        mostrarBoton = false;
                        options += "<tr>";
                        options += "<td colspan='6' class='danger'><strong>No hay vuelos próximos a esta fecha. </strong></td>";

                        options += "</tr>";
                    } else {
                        for (int i = 0; i < vuelosIda.size(); i++) {
                            ArrayList<Ocupacion> arrayOcupacion = OP.OcupacionVuelo(vuelosIda.get(i), conexion);
                            int ocupadas = 0;
                            if (arrayOcupacion == null) {
                                ocupadas = 0;
                            } else {
                                ocupadas = arrayOcupacion.size();
                            }
                            int libres = (vuelosIda.get(i).getPlazas_totales() - ocupadas);
                            if (ocupadas <= (vuelosIda.get(i).getPlazas_totales()) && (libres >= pasajeros)) {
                                options += "<tr>";
                                options += "<td rowspan='2' class='success'><input type='radio' name='vueloIda' value='" + vuelosIda.get(i).getCodigo() + "' </td>";
                                options += "<td class='success'><strong>Fecha de salida </strong></td>";
                                options += "<td class='success'><strong>Hora de salida </strong></td>";
                                options += "<td class='success'><strong>Duración </strong></td>";
                                options += "<td class='success'><strong>Número de vuelo </strong></td>";
                                options += "<td class='success'><strong>Precio </strong></td>";
                                options += "</tr>";
                                options += "<tr>";

                                options += "<td>" + vuelosIda.get(i).getFecha_salida() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getHora_salida() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getDuracion() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getNum_vuelo() + "</td>";
                                options += "<td>" + vuelosIda.get(i).getPrecio() + "€</td>";
                                options += "</tr>";
                            } else {
                                mostrarBoton = false;
                                options += "<tr>";
                                options += "<td colspan='6' class='danger'><strong>No hay vuelo disponible. </strong></td>";

                                options += "</tr>";
                            }
                        }
                    }
                    options += " </table> </div> </div>";
                    options += "<div class='row'>  <div class='col-md-10'><table class='table table-bordered table-responsive table-striped'>";
                    options += "<tr>";
                    options += "<th colspan='6' class='active'>Vuelos de vuelta</th>";
                    options += "</tr>";
                    if (vuelosVuelta.isEmpty()) {
                        mostrarBoton = false;
                        options += "<tr>";
                        options += "<td colspan='6' class='danger'><strong>No hay vuelos próximos a esta fecha. </strong></td>";

                        options += "</tr>";
                    } else {
                        for (int i = 0; i < vuelosVuelta.size(); i++) {
                            ArrayList<Ocupacion> arrayOcupacion = OP.OcupacionVuelo(vuelosVuelta.get(i), conexion);
                            int ocupadas = 0;
                            if (arrayOcupacion == null) {
                                ocupadas = 0;
                            } else {
                                ocupadas = arrayOcupacion.size();
                            }
                            int libres = (vuelosVuelta.get(i).getPlazas_totales() - ocupadas);
                            if (ocupadas < (vuelosVuelta.get(i).getPlazas_totales()) && (libres >= pasajeros)) {
                                options += "<tr>";
                                options += "<td rowspan='2' class='success'><input type='radio' name='vueloVuelta' value='" + vuelosVuelta.get(i).getCodigo() + "' </td>";
                                options += "<td class='success'><strong>Fecha de salida </strong></td>";
                                options += "<td class='success'><strong>Hora de salida </strong></td>";
                                options += "<td class='success'><strong>Duración </strong></td>";
                                options += "<td class='success'><strong>Número de vuelo </strong></td>";
                                options += "<td class='success'><strong>Precio </strong></td>";
                                options += "</tr>";
                                options += "<tr>";

                                options += "<td>" + vuelosVuelta.get(i).getFecha_salida() + "</td>";
                                options += "<td>" + vuelosVuelta.get(i).getHora_salida() + "</td>";
                                options += "<td>" + vuelosVuelta.get(i).getDuracion() + "</td>";
                                options += "<td>" + vuelosVuelta.get(i).getNum_vuelo() + "</td>";
                                options += "<td>" + vuelosVuelta.get(i).getPrecio() + "€</td>";
                                options += "</tr>";
                            } else {
                                mostrarBoton = false;
                                options += "<tr>";
                                options += "<td colspan='6' class='danger'><strong>No hay vuelo disponible. </strong></td>";

                                options += "</tr>";
                            }
                        }
                    }
                    options += "</table></div> </div> ";
                    if (mostrarBoton == true) {
                        options += "<div class='row'><input type='submit' class='btn btn-success center-block' value='Siguiente'></div>";
                    }}
                
//            

                out.print(options);
            } catch (Exception e) {
                out.println("ERROR: 'AjaxCargarVueltos.java'<br><br>");
                out.println("EXCEPCION: " + e.getClass().getName() + "<br><br>");
                out.println("MENSAJE: " + e.getMessage() + "<br><br>");
                e.printStackTrace(out);
            }
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
