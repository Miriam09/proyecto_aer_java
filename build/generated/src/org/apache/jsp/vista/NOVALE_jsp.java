package org.apache.jsp.vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.*;

public final class NOVALE_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                           \n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\"></div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <form  role=\"form\" name=\"Pagar\" id=\"Pagar\" action=\"/NavisLines/Facturar\">\n");
      out.write("                            <input type=\"radio\" class=\"btn btn-success\" name=\"raiod\" id=\"dario\" value=\"novale\">HOla\n");
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
