package org.apache.jsp.vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.*;

public final class Pagar_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    Cliente user = (Cliente) session.getAttribute("cliente");


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
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <a href=\"index.html\" ><img src=\"../images/naviLogoHorizontal2-medio.png\" alt=\"navi\" class=\"img-responsive centrar img-rounded\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
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
      out.write("                                <!--<img src=\"images/banner1.jpg\" alt=\"oferta\" class=\"img-responsive\">-->\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <!--<img src=\"images/banner2.jpg\" alt=\"Chania\" class=\"img-responsive\">-->\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <!--<img src=\"images/banner3.jpg\" alt=\"Flower\" class=\"img-responsive\">-->\n");
      out.write("                            </div>\n");
      out.write("                            <!--                <div class=\"item\">\n");
      out.write("                                              <img src=\"../images/panda.jpg\" alt=\"Flower\" class=\"img-responsive\">\n");
      out.write("                                            </div>-->\n");
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
      out.write("                                <li class=\"active\"><a href=\"#\">Inicio</a></li>\n");
      out.write("                                <li><a href=\"#\">Enlace #2</a></li>\n");
      out.write("                                <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Enlace #3 <b class=\"caret\"></b></a>\n");
      out.write("                                    <ul class=\"dropdown-menu\">\n");
      out.write("                                        <li><a href=\"\">Desplegable #1</a></li>\n");
      out.write("                                        <li><a href=\"\">Desplegable #2</a></li>\n");
      out.write("                                        <li><a href=\"\">Desplegable #3</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#\">Enlace #4</a></li>\n");
      out.write("                                <li><a href=\"#\">Enlace #5</a></li>\n");
      out.write("                                <li><a href=\"#\">Enlace #6</a></li>\n");
      out.write("                                <li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Enlace #7 <b class=\"caret\"></b></a>\n");
      out.write("                                    <ul class=\"dropdown-menu\">\n");
      out.write("                                        <li><a href=\"\">Desplegable #1</a></li>\n");
      out.write("                                        <li><a href=\"\">Desplegable #2</a></li>\n");
      out.write("                                        <li><a href=\"\">Desplegable #3</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            ");
 if (user == null) {
      out.write("\n");
      out.write("                            <form class=\" form-inline pull-right formularioUser\" role=\"form\" action=\"/NavisLines/ServletLogin\">\n");
      out.write("                                <input type=\"text\" class=\"input-sm form-control inputUser\" placeholder=\"usuario\" id=\"usuario\" name=\"usuario\">\n");
      out.write("                                <input type=\"password\" class=\"input-sm form-control inputUser\" placeholder=\"contraseña\" id=\"password\" name=\"password\">\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-info btn-md form-control botonUser\" value=\"Log in\">\n");
      out.write("                            </form>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                            <form class=\" form-inline  formularioUser\" role=\"form\" action=\"/NavisLines/ServletSalir\">\n");
      out.write("                                <span class=\"text-success\"  style=\"margin-left:23%\">Bienvenido</span> <span class=\"text-warning\" style=\"margin-right: 2%\"><strong>");
out.print(user.getNombreCompleto());
      out.write("</strong></span>\n");
      out.write("\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-danger btn-md form-control botonUser\" value=\"Salir\">\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\"></div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <form  role=\"form\" name=\"Pagar\" id=\"Pagar\" action=\"/NavisLines/RealizarPago\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-2\"><small>Nº Tarjeta</small></div>\n");
      out.write("                                <div class=\"col-md-8\"><input type=\"number\" class=\"form-control\" id=\"nT1\" name=\"nT1\" min=\"0\" max=\"9999999999999999\" required></div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <br/>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-2\"><input type=\"number\" class=\"form-control\" placeholder=\"CVV\" id=\"CVV\" name=\"CVV\" min=\"0\" max=\"999\" required></div>\n");
      out.write("                                <div class=\"col-md-2\"><small>Caducidad tarjeta: </small></div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <div class=\"col-md-2\"><input type=\"number\" class=\"form-control\" id=\"mes\" name=\"mes\" min=\"1\" max=\"12\" required></div>\n");
      out.write("                                    <div class=\"col-md-2\"><input type=\"number\" class=\"form-control\" id=\"year\" name=\"year\" min=\"1\" max=\"99\" required></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br/>\n");
      out.write("                            <div class=\"row\" style=\"display:none\" id=\"alertaTarjeta\">\n");
      out.write("                                <div class=\"col-md-12    \">\n");
      out.write("                                    <div class=\" alert alert-danger  alert-dismissable\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                        <strong>¡Error!</strong> El número de tarjeta no es válido.\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\" style=\"display:none\" id=\"alertaCampos\">\n");
      out.write("                                <div class=\"col-md-12    \">\n");
      out.write("                                    <div class=\" alert alert-warning  alert-dismissable\">\n");
      out.write("                                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                        <strong>¡Advertencia!</strong> Todos los campos deben estar rellenos.\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <br/>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-info center-block form-control botonUser\" id=\"botonSiguiente\" >Confirmar reserva</button>\n");
      out.write("                            <!--onclick=\"validarTarjeta(this.form.nT1.value)\"-->\n");
      out.write("                        </form>\n");
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
      out.write("        <script>\n");
      out.write("\n");
      out.write("        </script>\n");
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
