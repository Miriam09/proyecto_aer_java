package org.apache.jsp.vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.*;

public final class MostrarBilletes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ArrayList<Ocupacion> ocupaciones = (ArrayList) session.getAttribute("ocupaciones");

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
      out.write("                        <div class=\"col-md-2\"></div>\n");
      out.write("                <div class=\"col-md-6\">Tarjetas de embarque</div>\n");
      out.write("              \n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-1\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        \n");
      out.write("                        <table class=\"table table-responsive table-condensed\" border=\"1px\">\n");
      out.write("                          <tbdoy>\n");
      out.write("                              <tr style=\"background:#D5E1DD\">\n");
      out.write("                                  <td><img src=\"naviLogoHorizontal2-mini.png\" alt=\"navi\" class=\"img-responsive centrar img-rounded\"></td>\n");
      out.write("                              </tr>\n");
      out.write("                              <tr>\n");
      out.write("                                  <td>\n");
      out.write("                                      <span class=\"row\">\n");
      out.write("                                          <span class=\"col-md-12\">\n");
      out.write("                                              <small>Nombre:</small> <br>Miriam Moreno Sánchez\n");
      out.write("                                          </span>\n");
      out.write("                                      </span>\n");
      out.write("                                      <span class=\"row\">\n");
      out.write("                                          <span class=\"col-md-3\">\n");
      out.write("                                              <small>De:</small> <br>Madrid\n");
      out.write("                                          </span>\n");
      out.write("                                           <span class=\"col-md-3\">\n");
      out.write("                                              <small>A:</small> <br>Tokio\n");
      out.write("                                          </span>\n");
      out.write("                                      </span>    \n");
      out.write("                                      <span class=\"row\">\n");
      out.write("                                          <span class=\"col-md-3\">\n");
      out.write("                                              <small>Vuelo:</small> <br>MT6014\n");
      out.write("                                          </span>\n");
      out.write("                                           <span class=\"col-md-3\">\n");
      out.write("                                              <small>Fecha:</small> <br>16 Marzo 2016\n");
      out.write("                                          </span>\n");
      out.write("                                          <span class=\"col-md-3\">\n");
      out.write("                                              <small>Hora:</small> <br>10:45\n");
      out.write("                                          </span>\n");
      out.write("                                          \n");
      out.write("                                      </span>    \n");
      out.write("                                  </td>\n");
      out.write("                              </tr>\n");
      out.write("                              <tr>\n");
      out.write("                                  <td>\n");
      out.write("                                      Tarjeta de embarque <span class=\"well pull-right\">Ref Reserva <strong>BHT58D6</strong></span>\n");
      out.write("                                  </td>\n");
      out.write("                              </tr>\n");
      out.write("                          </tbdoy>\n");
      out.write("                      </table>  \n");
      out.write("                        \n");
      out.write("                        \n");
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
