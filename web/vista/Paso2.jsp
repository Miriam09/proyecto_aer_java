<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.Carrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Carrito carrito = (Carrito) session.getAttribute("carrito");
    Cliente user = (Cliente) session.getAttribute("cliente");

    int adultos = carrito.getNumAdultos();
    int ninos = carrito.getNumNinos();
    int bebes = carrito.getNumBebe();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="icon" type="image/jpg" href="../images/iconoNavi.png" />
        <link rel="stylesheet" href="../css/style.css">
        <script src="../js/script.js"></script>
        <style>
            select:required:invalid {
                color: gray;
            }
            option[value=""][disabled] {
                display: none;
            }
            option {
                color: black;
            }
        </style>



        <title>Navi´s Line</title>
    </head>
    <body>

        <div class="container-fluid">
            <header class="row">
                <div class="col-md-3">
                    <a href="../index.jsp" ><img src="../images/naviLogoHorizontal2-medio.png" alt="navi" class="img-responsive centrar img-rounded"></a>
                </div>
                <div class="col-md-9">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <div id="cont_39a6238c3e6e86a90fc698469b7b84dd"><span id="h_39a6238c3e6e86a90fc698469b7b84dd"><a id="a_39a6238c3e6e86a90fc698469b7b84dd" href="http://www.tiempo.com/madrid.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Madrid</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/39a6238c3e6e86a90fc698469b7b84dd"></script></div>
                            </div>
                            <div class="item">
                                <div id="cont_0ff4369480fb1fa4aacdce167d76b3fd">
                                    <span id="h_0ff4369480fb1fa4aacdce167d76b3fd">
                                        <a id="a_0ff4369480fb1fa4aacdce167d76b3fd" href="http://www.tiempo.com/tokio.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Tokio</a>
                                    </span>
                                    <script type="text/javascript" async src="https://www.tiempo.com/wid_loader/0ff4369480fb1fa4aacdce167d76b3fd"></script>
                                </div>
                            </div>
                            <div class="item">
                                <div id="cont_cc6126bfb94adfdff4087e8ab9756833"><span id="h_cc6126bfb94adfdff4087e8ab9756833"><a id="a_cc6126bfb94adfdff4087e8ab9756833" href="http://www.tiempo.com/nueva-york-aeropuerto-internacional-kennedy.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Aeropuerto Internacional Kennedy Nueva York</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/cc6126bfb94adfdff4087e8ab9756833"></script></div>
                            </div>
                            <div class="item">
                                <div id="cont_eae8921345c6415363687f4b6f127563"><span id="h_eae8921345c6415363687f4b6f127563"><a id="a_eae8921345c6415363687f4b6f127563" href="http://www.tiempo.com/paris.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Par&iacute;s</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/eae8921345c6415363687f4b6f127563"></script></div>
                            </div>
                        </div>
                        <!-- Left and right controls -->
                        <!-- <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                          <span class="sr-only">Next</span>
                        </a> -->
                    </div>
                </div>
            </header>

            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <nav class="navbar navbar-inverse" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navbar-ex1-collapse">
                                <span class="sr-only">Desplegar navegación</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <!-- <span class="letra-logo">Navi´s</span> <span class="letra-logo">Lines</span>-->
                            <!-- <a href="index.html" class="navbar-brand"><img src="images/naviLogoHorizontal2-mini.png" alt="navi" class="img-responsive logo"></a> -->
                        </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse navbar-static-top">
                            <ul class="nav navbar-nav ">
                                <li ><a href="../index.jsp">Inicio</a></li>
                                <li><a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li><a href="misReservas.jsp">Mis reservas</a></li>
                                <li class="active"><a href="#">Reserva de vuelo</a></li>
                            </ul>
                            <% if (user == null) {%>
                            <!--                            <form class=" form-inline pull-right formularioUser" role="form" action="/NavisLines/ServletLogin">
                                                            <input type="text" class="input-sm form-control inputUser" placeholder="usuario" id="usuario" name="usuario">
                                                            <input type="password" class="input-sm form-control inputUser" placeholder="contraseña" id="password" name="password">
                                                            <input type="submit" class="btn btn-info btn-md form-control botonUser" value="Log in">
                                                        </form>-->
                            <% } else { %>
                            <form class=" form-inline  formularioUser" role="form" action="/NavisLines/ServletSalir">
                                <span class="text-success"  style="margin-left:23%">Bienvenido</span> <span class="text-warning" style="margin-right: 2%"><strong><%out.print(user.getNombreCompleto());%></strong></span>

                                <input type="submit" class="btn btn-danger btn-md form-control botonUser" value="Salir">

                            </form>
                            <% }%>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-9">
                        <form  role="form" id="formularioPasajeros" action="/NavisLines/ServletCargarServicios">
                            <%if (adultos > 0) {
                                    for (int i = 1; i <= adultos; i++) {%>
                            <div class="panel panel-primary">
                                <div class="panel-heading pasajeros">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group titulo-pasajeros">
                                                <p>Adulto #<%out.println(i);%></p>
                                            </div>
                                        </div>
                                        <!--
                                        <div class="col-md-4"> 

                                        </div>-->
                                        <div class="col-md-4">
                                            <div class="col-md-10">
                                                <div  id="valnifAdulto<%out.print(i);%>">
                                                    <label class="sr-only" for="nifAdulto<%out.print(i);%>">NIF</label>
                                                    <input type="text" class="form-control pull-left nifAdultos" id="nifAdulto<%out.print(i);%>" name="nifAdulto<%out.print(i);%>" placeholder="NIF" width="50px" maxlength="9" onfocusout="validarNif(this.id)" pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))" required>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <select class="form-control">
                                                <option>Sr.</option>
                                                <option>Sra.</option>
                                                <option>Srta.</option>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <div class=" ">

                                                <label class="sr-only" for="nombreAdulto<%out.print(i);%>">Nombre</label>
                                                <!--<input type="text">-->
                                                <input type="text" class="form-control datosPasajeros" id="nombreAdulto<%out.print(i);%>" name="nombreAdulto<%out.print(i);%>" placeholder="Nombre" required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="">
                                                <label class="sr-only" for="apellidosAdulto<%out.print(i);%>">Apellidos</label>
                                                <input type="text" class="form-control inputs2" id="apellidosAdulto<%out.print(i);%>" 
                                                       name="apellidosAdulto<%out.print(i);%>" placeholder="Apellidos" required>
                                            </div>
                                        </div>

                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="col-md-3"><small>Fecha nacimiento</small></div>
                                            <div class="form-group" id="fechaAdulto<%out.print(i);%>">
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoDAdulto<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoDAdulto<%out.print(i);%>" name="nacimientoDAdulto<%out.print(i);%>" placeholder="Día" required maxlength="2" >
                                                </div>
                                                <div class="col-md-3">

                                                    <label class="sr-only" for="nacimientoMAdulto<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoMAdulto<%out.print(i);%>" name="nacimientoMAdulto<%out.print(i);%>" placeholder="Mes" required maxlength="2" >
                                                </div>
                                                <div class="col-md-3">
                                                    <input type="number" class="form-control" id="nacimientoAAdulto<%out.print(i);%>" name="nacimientoAAdulto<%out.print(i);%>" placeholder="Año" required maxlength="4" onfocusout="ComprobarFechaAdulto(this.id)">
                                                    <label class="sr-only" for="nacimientoAAdulto<%out.print(i);%>">Fecha de nacimiento</label>

                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <div class="form-group" id="caduNifAdulto<%out.print(i);%>">
                                                <div class="col-md-4">
                                                    <small>Cad NIF</small>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifMAdulto<%out.print(i);%>">Mes</label>
                                                    <input type="text" class="form-control" id="caduNifMAdulto<%out.print(i);%>" 
                                                           name="caduNifAdultoM<%out.print(i);%>" placeholder="Mes" maxlength="2" required>
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifAAdulto<%out.print(i);%>">Año</label>
                                                    <input type="text" class="form-control" id="caduNifAAdulto<%out.print(i);%>" 
                                                           name="caduNifAdultoA<%out.print(i);%>" placeholder="Año" maxlength="2" required  onfocusout="caducidadNif(this.id)">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="sr-only" for="paisAdulto<%out.print(i);%>">País Expedición</label>
                                                <input type="text" class="form-control" id="paisAdulto<%out.print(i);%>" 
                                                       name="paisAdulto<%out.print(i);%>" placeholder="País expedición" required>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <!--</div>-->

                            <%}
                                }%>
                            <% if (ninos > 0 || bebes > 0) { %>
                            <p class="btn btn-success" id="botonSiguiente" onclick="mostrarSiguiente()">Siguiente</p>
                            <%}%>
                            <!--<hr>-->
                            <%if (ninos > 0) {
                                    for (int i = 1; i <= ninos; i++) {%>
                            <div class="panel panel-info ocultado">
                                <div class="panel-heading pasajeros">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group titulo-pasajeros">
                                                <p>Niño #<%out.println(i);%></p>
                                            </div>
                                        </div>
                                            <div class="col-md-7"> 
                                            <div id="errorpResponsableN<%out.print(i);%>"  style="visibility:hidden" class="alert alert-danger noMargin text-center">
                                                 <span>¡Error! El NIF del responsable debe ser el de un pasajero</span>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div id="valnifNino<%out.print(i);%>">
                                                <label class="sr-only" for="nifNino<%out.print(i);%>">NIF</label>
                                                <input type="text" class="form-control" id="nifNino<%out.print(i);%>" 
                                                       name="nifNino<%out.print(i);%>" placeholder="NIF" required pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))" maxlength="9" onfocusout="validarNif(this.id)">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class=" ">
                                                <label class="sr-only" for="nombreNino<%out.print(i);%>">Nombre</label>
                                                <!--<input type="text">-->
                                                <input type="text" class="form-control datosPasajeros" id="nombreNino<%out.print(i);%>" placeholder="Nombre" name="nombreNino<%out.print(i);%>" required>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="">
                                                <label class="sr-only" for="apellidosNino<%out.print(i);%>">Apellidos</label>
                                                <input type="text" class="form-control inputs2" id="apellidosNino<%out.print(i);%>" 
                                                       name="apellidosNino<%out.print(i);%>" placeholder="Apellidos" required>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div id="valpResponsableN<%out.print(i);%>">
                                                <label class="sr-only" for="pResponsableN<%out.print(i);%>">NIF</label>
                                                <input type="text" class="form-control nifResponsableN" id="pResponsableN<%out.print(i);%>" 
                                                       name="pResponsableN<%out.print(i);%>" placeholder="NIF responsable" required onfocusout="validarNifResp(this.id, <%out.print(adultos);%>)" pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))" maxlength="9">
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group" id="fechaNino<%out.print(i);%>">
                                                <div class="col-md-3"><small>Fecha nacimiento</small></div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoDNino<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoDNino<%out.print(i);%>" name="nacimientoDNino<%out.print(i);%>" placeholder="Día" required maxlength="2">
                                                </div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoMNino<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoMNino<%out.print(i);%>" name="nacimientoMNino<%out.print(i);%>" placeholder="Mes" required maxlength="2">
                                                </div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoANino<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoANino<%out.print(i);%>" name="nacimientoANino<%out.print(i);%>" placeholder="Año" required maxlength="4" onfocusout="ComprobarFechaNino(this.id)">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group" id="caduNifNino<%out.print(i);%>">
                                                <div class="col-md-4"><small>Cad NIF</small></div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifMNino<%out.print(i);%>">Mes</label>
                                                    <input type="text" class="form-control" id="caduNifMNino<%out.print(i);%>" 
                                                           name="caduNifNinoM<%out.print(i);%>" placeholder="Mes" required maxlength="2">
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifANino<%out.print(i);%>">Año</label>
                                                    <input type="text" class="form-control" id="caduNifANino<%out.print(i);%>" 
                                                           name="caduNifNinoA<%out.print(i);%>" placeholder="Año" required maxlength="2" onfocusout="caducidadNif(this.id)">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="sr-only" for="paisNino<%out.print(i);%>">País Expedición</label>
                                                <input type="text" class="form-control" id="paisNino<%out.print(i);%>" 
                                                       name="paisNino<%out.print(i);%>" placeholder="País expedición" required>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <br>
                            <!--</div>-->

                            <%}
                                }%>
                            <hr>
                            <%if (bebes > 0) {
                                    for (int i = 1; i <= bebes; i++) {%>
                            <div class="panel panel-warning ocultado">
                                <div class="panel-heading pasajeros">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="form-group titulo-pasajeros">
                                                <p>Bebé #<%out.println(i);%></p>
                                            </div>
                                        </div>
                                            <div class="col-md-7"> 
                                            <div id="errorpResponsableB<%out.print(i);%>" style="visibility:hidden" class="alert alert-danger noMargin text-center">
                                                <p>¡Error! El NIF del responsable debe ser el de un pasajero</p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div id="valnifBebe<%out.print(i);%>">
                                                <label class="sr-only" for="nifBebe<%out.print(i);%>">NIF</label>
                                                <input type="text" class="form-control" id="nifBebe<%out.print(i);%>" 
                                                       name="nifBebe<%out.print(i);%>" placeholder="NIF" required maxlength="9" onfocusout="validarNif(this.id)" pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class=" ">
                                                <label class="sr-only" for="nombreBebe<%out.print(i);%>">Nombre</label>
                                                <!--<input type="text">-->
                                                <input type="text" class="form-control datosPasajeros" id="nombreBebe<%out.print(i);%>" name="nombreBebe<%out.print(i);%>" placeholder="Nombre" required>
                                            </div>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="">
                                                <label class="sr-only" for="apellidosBebe<%out.print(i);%>">Apellidos</label>
                                                <input type="text" class="form-control inputs2" id="apellidosBebe<%out.print(i);%>" 
                                                       name="apellidosBebe<%out.print(i);%>" placeholder="Apellidos" required>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div id="valpResponsableB<%out.print(i);%>">
                                                <label class="sr-only" for="pResponsableB<%out.print(i);%>">NIF</label>
                                                <input type="text" class="form-control nifResponsableB" id="pResponsableB<%out.print(i);%>" 
                                                       name="pResponsableB<%out.print(i);%>" placeholder="NIF responsable" onfocusout="validarNifResp(this.id, <%out.print(adultos);%>)" required pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))" maxlength="9">
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group" id="fechaBebe<%out.print(i);%>">
                                                <div class="col-md-3"><small>Fecha nacimiento</small></div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoDBebe<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoDBebe<%out.print(i);%>" placeholder="Día" name="nacimientoDBebe<%out.print(i);%>" required maxlength="2">
                                                </div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoMBebe<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoMBebe<%out.print(i);%>" placeholder="Mes" name="nacimientoMBebe<%out.print(i);%>" required maxlrngth="2">
                                                </div>
                                                <div class="col-md-3">
                                                    <label class="sr-only" for="nacimientoABebe<%out.print(i);%>">Fecha de nacimiento</label>
                                                    <input type="number" class="form-control" id="nacimientoABebe<%out.print(i);%>" placeholder="Año" name="nacimientoABebe<%out.print(i);%>" required maxlength="4" onfocusout="ComprobarFechaBebe(this.id)">

                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group" id="caduNifBebe<%out.print(i);%>">
                                                <div class="col-md-4"><small>Cad NIF</small></div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifMBebe<%out.print(i);%>">Mes</label>
                                                    <input type="text" class="form-control" id="caduNifMBebe<%out.print(i);%>" 
                                                           name="caduNifBebeM<%out.print(i);%>" placeholder="Mes" required maxlength="2">
                                                </div>
                                                <div class="col-md-4">
                                                    <label class="sr-only" for="caduNifABebe<%out.print(i);%>">Año</label>
                                                    <input type="text" class="form-control" id="caduNifABebe<%out.print(i);%>" 
                                                           name="caduNifBebeA<%out.print(i);%>" placeholder="Año" required maxlength="2" onfocusout="caducidadNif(this.id)">
                                                </div>
                                            </div>

                                        </div>

                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label class="sr-only" for="paisBebe<%out.print(i);%>">País Expedición</label>
                                                <input type="text" class="form-control" id="paisBebe<%out.print(i);%>" 
                                                       name="paisBebe<%out.print(i);%>" placeholder="País expedición" required>
                                            </div>
                                        </div>
                                        <!--                                        <div class="col-md-2">
                                                                                     Persona a cargo 
                                                                                </div>-->
                                        <div class="col-md-3">
                                            <div class="">

                                            </div>
                                            <!--                                    <select class="form-control" id="pResponsableB" name="pResponsable" required>
                                                                                    <option value="0" class="help-block form-control" disabled selected hidden>Pasajero a cargo</option>
                                                                                </select>-->
                                            <!--<span class="help-block"> <small>* Debe ser el DNI de un pasajero</small></span>-->
                                        </div>


                                    </div>
                                </div>
                            </div>
                            <br>
                            <!--</div>-->

                            <%}
                                }%>
                            <button type="submit" id="siguienteOculto" class="btn btn-success" <%  if (ninos < 1 && bebes < 1) { %>style="display:block" <% } else {%>style="display:none" <%}%>>Siguiente</button>

                        </form>
                    </div>
                    <div class="col-md-3">
                        <div class="well">

                            <h4  class="text-center">Proceso de reserva</h4>
                            <div class="row ">
                                <p><%out.println(carrito.getReserva().getIda().toString());%></p>  
                                <% //out.println(carrito.toString());%>
                            </div>
                            <div class="row">
                                <p>Adultos  x <%out.println(adultos);%> -------- <%out.println(adultos+" x "+(carrito.getReserva().getIda().getPrecio())+"€");%><small>Ida</small></p>
                                <%if((carrito.getReserva().getVuelta())!=null){%>
                                <p>Adultos  x <%out.println(adultos);%> -------- <%out.println(adultos+" x "+(carrito.getReserva().getVuelta().getPrecio())+"€");%><small>Vuelta</small></p>
                                <%} if (ninos>0){%>
                                <p>Niños  x <%out.println(ninos);%> -------- <%out.println(ninos+" x "+(carrito.getReserva().getIda().getPrecio())+"€");%><small>Ida</small></p>
                                <%if((carrito.getReserva().getVuelta())!=null){%>
                                <p>Niños  x <%out.println(ninos);%> -------- <%out.println(ninos+" x "+(carrito.getReserva().getVuelta().getPrecio())+"€");%><small>Vuelta</small></p>

                                <% } }if(bebes>0){ %>
                                <p>Bebés  x <%out.println(bebes);%>25€</p>
                                <%}%>
                            </div>
                            <hr>
                            <%if((carrito.getReserva().getVuelta())!=null){%>
                            <span class="lead">TOTAL: </span><span><%out.println(((adultos+ninos)*carrito.getReserva().getIda().getPrecio())+((adultos+ninos)*carrito.getReserva().getVuelta().getPrecio())+bebes*25+"€");%></span>
                            <% } else{ %>
                            <span class="lead">TOTAL: </span><span><%out.println((adultos+ninos)*carrito.getReserva().getIda().getPrecio()+bebes*25+"€");%></span>

                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- <h1>Navi´s Lines</h1> -->
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../css/jquery-ui.css">
        <link rel="stylesheet" href="../css/jquery-ui.structure.css">
        <link rel="stylesheet" href="../css/jquery-ui.theme.css">
        <script src="../js/jquery-ui.js"></script>
        <script>
//
//                               $(function () {
//                                    $.datepicker.regional['es'] = {
//                                        closeText: 'Cerrar',
////                                        prevText: ' nextText: 'Sig > ',
//                                                currentText: 'Hoy',
//                                        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
//                                            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
//                                        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
//                                            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
//                                        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
//                                        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié;', 'Juv', 'Vie', 'Sáb'],
//                                        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
//                                        weekHeader: 'Sm',
//                                        dateFormat: 'yyyy/mm/dd',
//                                        firstDay: 1,
//                                        isRTL: false,
//                                        showMonthAfterYear: false,
//                                        yearSuffix: ''
//                                    };
//                                    $.datepicker.setDefaults($.datepicker.regional['es']);
//                                });
                                var hoy = new Date().toJSON();
                                $(function () {
                                    $input = $(':input[id*=nacimiento]');
                                    $("#nacimientoAdulto1").datepicker({
                                        dateFormat: "yy-mm-dd",
                                        autoclose: true,
//                                        onClose: function (selectedDate) {
//                                            $input.datepicker("option", "maxDate", selectedDate);
//                                        }
                                    });

                                });

//                                 $(function () {
//                                                $("#fechaSalida").datepicker({
//                                                    dateFormat: "yy-mm-dd",
//                                                    autoclose: true,
//                                                    onClose: function (selectedDate) {
//                                                        $("#fechaVuelta").datepicker("option", "minDate", selectedDate);
//                                                    }
//                                                });
//                                                $("#fechaVuelta").datepicker({
//                                                    dateFormat: "yy-mm-dd",
//                                                    autoclose: true,
//                                                    onClose: function (selectedDate) {
//                                                        $("#fechaSalida").datepicker("option", "maxDate", selectedDate);
//                                                    }
//                                                });
//                                            });
        </script>
    </body>
</html>
