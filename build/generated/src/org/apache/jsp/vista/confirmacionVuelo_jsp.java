package org.apache.jsp.vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.*;

public final class confirmacionVuelo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

boolean vuelo = (Boolean) session.getAttribute("vuelo");


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/jpg\" href=\"../images/iconoNavi.png\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/style.css\">\n");
      out.write("        <script src=\"../js/script.js\"></script>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Navi´s Line</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <header class=\"row\">\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <a href=\"../index.jsp\" ><img src=\"../images/naviLogoHorizontal2-medio.png\" alt=\"navi\" class=\"img-responsive centrar img-rounded\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                    <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                        <!-- Indicators -->\n");
      out.write("                        <ol class=\"carousel-indicators\">\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("                            <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("                        </ol>\n");
      out.write("                        <!-- Wrapper for slides -->\n");
      out.write("                        <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("                            <div class=\"item active\">\n");
      out.write("                                <div id=\"cont_39a6238c3e6e86a90fc698469b7b84dd\"><span id=\"h_39a6238c3e6e86a90fc698469b7b84dd\"><a id=\"a_39a6238c3e6e86a90fc698469b7b84dd\" href=\"http://www.tiempo.com/madrid.htm\" target=\"_blank\" rel=\"nofollow\" style=\"color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;\">El Tiempo en Madrid</a></span><script type=\"text/javascript\" async src=\"https://www.tiempo.com/wid_loader/39a6238c3e6e86a90fc698469b7b84dd\"></script></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <div id=\"cont_0ff4369480fb1fa4aacdce167d76b3fd\">\n");
      out.write("                                    <span id=\"h_0ff4369480fb1fa4aacdce167d76b3fd\">\n");
      out.write("                                        <a id=\"a_0ff4369480fb1fa4aacdce167d76b3fd\" href=\"http://www.tiempo.com/tokio.htm\" target=\"_blank\" rel=\"nofollow\" style=\"color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;\">El Tiempo en Tokio</a>\n");
      out.write("                                    </span>\n");
      out.write("                                    <script type=\"text/javascript\" async src=\"https://www.tiempo.com/wid_loader/0ff4369480fb1fa4aacdce167d76b3fd\"></script>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <div id=\"cont_cc6126bfb94adfdff4087e8ab9756833\"><span id=\"h_cc6126bfb94adfdff4087e8ab9756833\"><a id=\"a_cc6126bfb94adfdff4087e8ab9756833\" href=\"http://www.tiempo.com/nueva-york-aeropuerto-internacional-kennedy.htm\" target=\"_blank\" rel=\"nofollow\" style=\"color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;\">El Tiempo en Aeropuerto Internacional Kennedy Nueva York</a></span><script type=\"text/javascript\" async src=\"https://www.tiempo.com/wid_loader/cc6126bfb94adfdff4087e8ab9756833\"></script></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <div id=\"cont_eae8921345c6415363687f4b6f127563\"><span id=\"h_eae8921345c6415363687f4b6f127563\"><a id=\"a_eae8921345c6415363687f4b6f127563\" href=\"http://www.tiempo.com/paris.htm\" target=\"_blank\" rel=\"nofollow\" style=\"color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;\">El Tiempo en Par&iacute;s</a></span><script type=\"text/javascript\" async src=\"https://www.tiempo.com/wid_loader/eae8921345c6415363687f4b6f127563\"></script></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Left and right controls -->\n");
      out.write("                        <!-- <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                          <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("                          <span class=\"sr-only\">Previous</span>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("                          <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("                          <span class=\"sr-only\">Next</span>\n");
      out.write("                        </a> -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-12 col-md-12\">\n");
      out.write("                    <nav class=\"navbar navbar-inverse\" role=\"navigation\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"navbar-ex1-collapse\">\n");
      out.write("                                <span class=\"sr-only\">Desplegar navegación</span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                            </button>\n");
      out.write("                            <!-- <span class=\"letra-logo\">Navi´s</span> <span class=\"letra-logo\">Lines</span>-->\n");
      out.write("                            <!-- <a href=\"index.html\" class=\"navbar-brand\"><img src=\"images/naviLogoHorizontal2-mini.png\" alt=\"navi\" class=\"img-responsive logo\"></a> -->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"collapse navbar-collapse navbar-ex1-collapse navbar-static-top\">\n");
      out.write("                            <ul class=\"nav navbar-nav \">\n");
      out.write("                                <li class=\"active\"><a href=\"../index.jsp\">Inicio</a></li>\n");
      out.write("                                <li><a href=\"Facturacion.jsp\">Facturación</a></li>\n");
      out.write("                                <li><a href=\"Volar.jsp\">Volar</a></li>\n");
      out.write("                                <li><a href=\"misReservas.jsp\">Mis reservas</a></li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"row center-block\">\n");
      out.write("                            <div style=\"text-align:center;width:250px;padding:0.5em 0;\" class=\"center-block\"> <h4><a style=\"text-decoration:none;\" href=\"http://www.zeitverschiebung.net/es/city/6544494\"><span style=\"color:gray;\">Hora actual en</span><br />City Center, Spain</a></h4> <iframe src=\"http://www.zeitverschiebung.net/clock-widget-iframe?language=es&timezone=Europe%2FMadrid\" width=\"100%\" height=\"130\" frameborder=\"0\" seamless></iframe></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row center-block\">\n");
      out.write("                            <div style=\"text-align:center;width:250px;padding:0.5em 0;\" class=\"center-block\"> <h4><a style=\"text-decoration:none;\" href=\"http://www.zeitverschiebung.net/es/city/5128581\"><span style=\"color:gray;\">Hora actual en</span><br />New York City, United States</a></h4> <iframe src=\"http://www.zeitverschiebung.net/clock-widget-iframe?language=es&timezone=America%2FNew_York\" width=\"100%\" height=\"130\" frameborder=\"0\" seamless></iframe> </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <br/><br/><br/>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                        ");
 if(vuelo==true){
      out.write("\n");
      out.write("                        <img src=\"../images/vuelo.png\" class=\"img img-responsive\" alt=\"exito\">\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                        <img src=\"../images/error2.png\" class=\"img img-responsive\" alt=\"exito\">\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <button id=\"atras\" class=\"btn btn-success\" onclick=\"window.location = '../index.html'\">Aceptar</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"row \">\n");
      out.write("                            <div style=\"text-align:center;width:250px;padding:0.5em 0;\" class=\"center-block\"> <h4><a style=\"text-decoration:none;\" href=\"http://www.zeitverschiebung.net/es/city/1850147\"><span style=\"color:gray;\">Hora actual en</span><br />Tokyo, Japan</a></h4> <iframe src=\"http://www.zeitverschiebung.net/clock-widget-iframe?language=es&timezone=Asia%2FTokyo\" width=\"100%\" height=\"130\" frameborder=\"0\" seamless></iframe> </div>\n");
      out.write("                        </div>\n");
      out.write("                          <div class=\"row center-block\">\n");
      out.write("                            <div style=\"text-align:center;width:250px;padding:0.5em 0;\" class=\"center-block\"> <h4><a style=\"text-decoration:none;\" href=\"http://www.zeitverschiebung.net/es/city/2988507\"><span style=\"color:gray;\">Hora actual en</span><br />Paris, France</a></h4> <iframe src=\"http://www.zeitverschiebung.net/clock-widget-iframe?language=es&timezone=Europe%2FParis\" width=\"100%\" height=\"130\" frameborder=\"0\" seamless></iframe> </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- <h1>Navi´s Lines</h1> -->\n");
      out.write("        <script src=\"../js/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery-ui.structure.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/jquery-ui.theme.css\">\n");
      out.write("        <script src=\"../js/jquery-ui.js\"></script>\n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
