/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var objetoAjax;

function AJAXCrearObjeto() {
    if (window.XMLHttpRequest) {
        objetoAjax = new XMLHttpRequest();
    } else {
        objetoAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return objetoAjax;
}

function cargarOrigen() {
    objetoAjax = AJAXCrearObjeto();
    objetoAjax.onreadystatechange = function () {
        if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
            document.getElementById("origen").innerHTML = objetoAjax.responseText;
        }
    };
    objetoAjax.open("GET", "AjaxCargarOrigen", true);
    objetoAjax.send();
}

function cargarDestino(_valor) {
    if (_valor == "") {
        document.getElementById("destino").innerHTML = "";
        return;
    }
    objetoAjax = AJAXCrearObjeto();
    objetoAjax.onreadystatechange = function () {
        if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
            document.getElementById("destino").innerHTML = objetoAjax.responseText;
        }
    };
    objetoAjax.open("GET", "AjaxCargarDestino?origen=" + _valor, true);
    objetoAjax.send();
}

function comprobarNinos() {
    var bebes = document.getElementById("bebes");
    var bebesValue = parseInt(bebes.value);
//    alert(bebesValue);
    var adultos = document.getElementById("adultos");
    var adultosValue = parseInt(adultos.value);
//    alert(adultosValue);
    var ninos = document.getElementById("ninos");
    var ninosValue = parseInt(ninos.value);
//    alert(ninosValue);
//    alert(bebesValue+ninosValue);
//    alert("Niños: " + ninosValue + " Bebes: " + bebesValue + " Adultos: " + adultosValue)
    if ((ninosValue + bebesValue) <= adultosValue) {
        bebes.parentNode.setAttribute("class", "form-group has-success");
        adultos.parentNode.setAttribute("class", "form-group has-success");
        ninos.parentNode.setAttribute("class", "form-group has-success");
    } else {
        bebes.parentNode.setAttribute("class", "form-group has-error");
        adultos.parentNode.setAttribute("class", "form-group has-error");
        ninos.parentNode.setAttribute("class", "form-group has-error");
    }
}

function borrarContenido(id_padre) {
    var cuerpo = document.getElementById(id_padre);
    while (1 <= cuerpo.childNodes.length) {
        cuerpo.removeChild(cuerpo.firstChild);
    }
}
function cargarVuelos() {
    objetoAjax = AJAXCrearObjeto();
    var padre = document.getElementById("tablaVuelos");
    while (1 <= padre.childNodes.length) {
        padre.removeChild(padre.firstChild);
    }
    var _vuelta = document.getElementById("vuelta");
    var _ida = document.getElementById("ida");
    var _origen = document.getElementById("origen").value;
    var _destino = document.getElementById("destino").value;
    var _fechaIda = document.getElementById("fechaSalida").value;
    var _adultos = document.getElementById("adultos").value;
    var _ninos = document.getElementById("ninos").value;
    var _pasajeros = _adultos + _ninos;
//alert(_pasajeros);
    if (_origen == 0) {
        var divAlerta = document.createElement("div");
        divAlerta.setAttribute("class", "alert alert-danger");
        padre.appendChild(divAlerta)
        var textoAlerta = document.createTextNode("Debes seleccionar un origen");
        divAlerta.appendChild(textoAlerta);
    } else if (_destino == 0) {
        var divAlerta = document.createElement("div");
        divAlerta.setAttribute("class", "alert alert-danger");
        padre.appendChild(divAlerta)
        var textoAlerta = document.createTextNode("Debes seleccionar un destino");
        divAlerta.appendChild(textoAlerta);
    } else if (_fechaIda == 0) {
        var divAlerta = document.createElement("div");
        divAlerta.setAttribute("class", "alert alert-danger");
        padre.appendChild(divAlerta)
        var textoAlerta = document.createTextNode("Debes seleccionar una fecha de ida");
        divAlerta.appendChild(textoAlerta);
    } else if (_ida.checked === true) {
        var _fechaVuelta = null;
        var idaV = _ida.checked;
        objetoAjax.open("GET", "AjaxCargarVuelos?origen=" + _origen + "&destino=" + _destino + "&fechaIda=" + _fechaIda + "&fechaVuelta=" + _fechaVuelta + "&ida=" + idaV + "&adultos=" + _adultos + "&ninos=" + _ninos, true);
        objetoAjax.send();
        objetoAjax.onreadystatechange = function () {
            if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
                document.getElementById("tablaVuelos").innerHTML = objetoAjax.responseText;
            }
        };
    }
    else if (_vuelta.checked === true) {
        var _fechaVuelta = document.getElementById("fechaVuelta").value;
        if (_fechaVuelta == 0) {
            var divAlerta = document.createElement("div");
            divAlerta.setAttribute("class", "alert alert-danger");
            padre.appendChild(divAlerta)
            var textoAlerta = document.createTextNode("Debes seleccionar una fecha de vuelta");
            divAlerta.appendChild(textoAlerta);
        } else {
//        alert(_fechaVuelta);
            var vueltaV = _vuelta.checked;
            objetoAjax.open("GET", "AjaxCargarVuelos?origen=" + _origen + "&destino=" + _destino + "&fechaIda=" + _fechaIda + "&fechaVuelta=" + _fechaVuelta + "&idaYvuelta=" + vueltaV + "&adultos=" + _adultos + "&ninos=" + _ninos, true);
            objetoAjax.send();
            objetoAjax.onreadystatechange = function () {
                if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
//            alert("ReadyState: " + objetoAjax.readyState + " Status: " + objetoAjax.status);
//            alert(objetoAjax.responseText);
                    document.getElementById("tablaVuelos").innerHTML = objetoAjax.responseText;
                }
            };
        }
    }
}

function imprimirPagina() {
    if (window.print) {
        window.print();
    }
    else {
        alert("Lo siento, pero a tu navegador no se le puede ordenar imprimir desde la web.Actualiza o hazlo desde los menús");
    }

}
function desactivarVuelta() {
    var fechaVuelta = document.getElementById("fechaVuelta");
    fechaVuelta.setAttribute("disabled", "disabled");
}

function activarVuelta() {
    var fechaVuelta = document.getElementById("fechaVuelta");
    fechaVuelta.removeAttribute("disabled");
}

function mostrarSiguiente() {
    var oculto = document.getElementsByClassName("ocultado");
    var botonS = document.getElementById("botonSiguiente");
    var botonSiguiente = document.getElementById("siguienteOculto");
    botonS.setAttribute("style", "display:none");
    for (var i = 0; i < oculto.length; i++) {
        oculto[i].setAttribute("style", "display:inherit");
    }
    botonSiguiente.setAttribute("style", "display:block");
}

function siguientePagina(numPagina, totalPaginas) {
    idActual = "pasajero" + (numPagina - 1);
    var actual = document.getElementById(idActual);
    actual.setAttribute("style", "display: none");
    idNuevo = "pasajero" + numPagina;
    var nuevo = document.getElementById(idNuevo);
    nuevo.setAttribute("style", "display:block");
    var pagina = "pagina" + numPagina;
    var paginaAnt = "pagina" + (numPagina - 1);
    var idPag = document.getElementById(pagina);
    idPag.setAttribute("class", "active");
    var idPagAnt = document.getElementById(paginaAnt);
    idPagAnt.removeAttribute("class");
    for (var i = numPagina - 1; i > 1; i--) {
        var id = "pasajero" + i;
        var ocultar = document.getElementById(id);
        ocultar.setAttribute("style", "display:none");
    }
    if (numPagina == totalPaginas) {
        var boton = document.getElementById("botonSiguiente");
        boton.setAttribute("style", "display:block");
    }
}

function siguientePaginaA(numPagina, totalPaginas) {
    idActual = "pasajero" + (numPagina - 1);
    var actual = document.getElementById(idActual);
    actual.setAttribute("style", "display: none");
    idNuevo = "pasajero" + numPagina;
    var nuevo = document.getElementById(idNuevo);
    nuevo.setAttribute("style", "display:block");
    var pagina = "pagina" + numPagina;
    var paginaAnt = "pagina" + (numPagina - 1);
    var idPag = document.getElementById(pagina);
    idPag.setAttribute("class", "active");
    var idPagAnt = document.getElementById(paginaAnt);
    idPagAnt.removeAttribute("class");
    for (var i = numPagina - 1; i > 1; i--) {
        var id = "pasajero" + i;
        var ocultar = document.getElementById(id);
        ocultar.setAttribute("style", "display:none");
    }
    if (numPagina == totalPaginas) {
        var boton = document.getElementById("botonSiguiente");
        boton.setAttribute("style", "display:block");
    }
    var barraProgreso = document.getElementById("barraProgreso");
    barraProgreso.setAttribute("aria-valuenow", (100 / (totalPaginas - (numPagina - 1))));
    var width = "width:" + (100 / (totalPaginas - (numPagina - 1))) + "%";
    barraProgreso.setAttribute("style", width);
    var textoBarraProgreso = document.getElementById("textoBarraProgreso");
    while (1 <= textoBarraProgreso.childNodes.length) {
        textoBarraProgreso.removeChild(textoBarraProgreso.firstChild);
    }
    var textoPorcentaje = document.createTextNode((100 / (totalPaginas - (numPagina - 1))) + "% completado");
    textoBarraProgreso.appendChild(textoPorcentaje);
}

function disponibilidad(numP, totalP) {
    idActual = "Pasajero" + (numP);
    var actual = document.getElementById(idActual);
//    alert(idActual);
    idNuevo = "Pasajero" + (numP + 1);
    var nuevo = document.getElementById(idNuevo);
//    alert(idNuevo);
    var asientoElegido = actual.value;
    objetoAjax = AJAXCrearObjeto();
    objetoAjax.open("GET", "/NavisLines/AjaxCargarAsientos?asientoElegido=" + asientoElegido, true);
    objetoAjax.send();
    objetoAjax.onreadystatechange = function () {
        if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
            document.getElementById(idNuevo).innerHTML = objetoAjax.responseText;
        }
    };
}

function disponibilidadVuelta(numP, totalP) {
    idActual = "Pasajero" + (numP);
    var actual = document.getElementById(idActual);
    idNuevo = "Pasajero" + (numP + 1);
    var nuevo = document.getElementById(idNuevo);
    var asientoElegido = actual.value;
    objetoAjax = AJAXCrearObjeto();
    objetoAjax.open("GET", "/NavisLines/AjaxCargarAsientosVuelta?asientoElegido=" + asientoElegido, true);
    objetoAjax.send();
    objetoAjax.onreadystatechange = function () {
        if (objetoAjax.readyState == 4 && objetoAjax.status == 200) {
            document.getElementById(idNuevo).innerHTML = objetoAjax.responseText;
        }
    };
}

function irPagar() {
    window.locationf = "/NavisLines/vista/Pagar.jsp";
}

function ComprobarPassword() {
    var pass = document.getElementById("password2");
    var pass2 = document.getElementById("password3");
    if (pass2.value === null) {
        pass2.parentNode.setAttribute("class", "form-group has-warning");
        pass.parentNode.setAttribute("class", "form-group has-warning");
    }
    else if (pass.value != pass2.value) {
        pass2.parentNode.setAttribute("class", " form-group has-error");
        pass.parentNode.setAttribute("class", "form-group has-error");
    } else {
        pass2.parentNode.setAttribute("class", "form-group has-success");
        pass.parentNode.setAttribute("class", " form-group has-success");
    }
}

function validarTarjeta() {
    var num1 = document.getElementById("nT1");
    var num2 = document.getElementById("nT2");
    var num3 = document.getElementById("nT3");
    var num4 = document.getElementById("nT4");
    // sumamos el resultado
    var numTarjeta = num1.value + num2.value + num3.value + num4.value;
    var cadena = numTarjeta.toString();
    var longitud = cadena.length;
    var cifra = null;
    var cifra_cad = null;
    var suma = 0;
    for (var i = 0; i < longitud; i += 2) {
        cifra = parseInt(cadena.charAt(i)) * 2;
        // Si la cifra resultante es mayor que 9 sumamos las cifras
        if (cifra > 9) {
            cifra_cad = cifra.toString();
            cifra = parseInt(cifra_cad.charAt(0)) + parseInt(cifra_cad.charAt(1));
        }
        suma += cifra;
    }
    // Paso 2: Tomamos las cifras en posiciones pares y las sumamos
    for (var i = 1; i < longitud; i += 2) {
        suma += parseInt(cadena.charAt(i));
    }
    var numTar = document.getElementById("numTarj");
    // Paso 3: Comprobamos que el resultado es múltiplo de 10
    if ((suma % 10) == 0) {
        // Si todo es correcto enviamos el formulario
        numTar.setAttribute("class", "form-group has-success");
    } else {
        numTar.setAttribute("class", "form-group has-error");
    }
}

function mostrarTabla(id) {
    var desplegar = id + "T";
    var click = document.getElementById(id);
    var aparecer = document.getElementById(desplegar);
    $(document).ready(function () {
        $(aparecer).toggle("slow");
    });
}

function validarFecha(year, mon, day) {
    if ((year <= 2016 && year >= 1900) && (mon >= 1 && mon <= 12) && (day >= 1 && day <= 31)) {
        return true;
    } else {
        return false;
    }
}

function ComprobarYear(id) {
    var year = document.getElementById(id);
    var day = document.getElementById("dia");
    var mon = document.getElementById("mes");
    var fecha = document.getElementById("fecha");
    if ((year.value <= 1998 && year.value >= 1900) && (mon.value >= 1 && mon.value <= 12) && (day.value >= 1 && day.value <= 31)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        day.value = "";
        year.value = "";
    }
}


function validarNif(id) {
    var elemNif = document.getElementById(id);
    var nif = elemNif.value;
    var group = document.getElementById("val" + id);
    var numero = nif.substr(0, nif.length - 1);
    var let = nif.substr(nif.length - 1, 1);
    numero = numero % 23;
    var letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
    letra = letra.substring(numero, numero + 1);
    if (letra != let) {
        group.setAttribute("class", "form-group has-error error");
        elemNif.value = "";
    } else {
        group.setAttribute("class", "form-group has-success");
    }
}

function validarNifResp(id, adultos) {
    var nifResp = document.getElementById(id);
    var valornif = nifResp.value;
    var coincide = false;
    for (var i = 1; i <= adultos && coincide == false; i++) {
        var idAdulto = "nifAdulto" + i;
        var contenido = document.getElementById(idAdulto).value;
        if (valornif == contenido) {
            coincide = true;
        }
    }
    var idGroup = "val" + id;
    var group = document.getElementById(idGroup);
    var iderror = "error" + id;
    var error = document.getElementById(iderror);
    if (coincide == false) {
        group.setAttribute("class", "form-group has-error");
        error.setAttribute("style", "visibility:visible");
        nifResp.value = "";
    } else {
        group.setAttribute("class", "form-group has-success");
        error.setAttribute("style", "visibility:hidden");
    }
}

function ComprobarFechaAdulto(id) {
    var numP = id.substr(17, id.length);
    var diaP = "nacimientoDAdulto" + numP;
    var mesP = "nacimientoMAdulto" + numP;
    var fecha = "fechaAdulto" + numP;

    var mon = document.getElementById(mesP);
    var day = document.getElementById(diaP);
    var fecha = document.getElementById(fecha);
    var year = document.getElementById(id);

    if ((year.value <= 1998 && year.value >= 1900) && (mon.value >= 1 && mon.value <= 12) && (day.value >= 1 && day.value <= 31)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        day.value = "";
        year.value = "";
    }
}

function ComprobarFechaNino(id) {
    var numP = id.substr(15, id.length);
    var diaP = "nacimientoDNino" + numP;
    var mesP = "nacimientoMNino" + numP;
    var fecha = "fechaNino" + numP;
    var mon = document.getElementById(mesP);
    var day = document.getElementById(diaP);
    var fecha = document.getElementById(fecha);
    var year = document.getElementById(id);

    if ((year.value >= 1998 && year.value <= 2013) && (mon.value >= 1 && mon.value <= 12) && (day.value >= 1 && day.value <= 31)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        day.value = "";
        year.value = "";
    }
}

function ComprobarFechaBebe(id) {
    var numP = id.substr(15, id.length);
    var diaP = "nacimientoDBebe" + numP;
    var mesP = "nacimientoMBebe" + numP;
    var fecha = "fechaBebe" + numP;

    var mon = document.getElementById(mesP);
    var day = document.getElementById(diaP);
    var fecha = document.getElementById(fecha);
    var year = document.getElementById(id);

    if ((year.value >= 2013 && year.value <= 2016) && (mon.value >= 1 && mon.value <= 12) && (day.value >= 1 && day.value <= 31)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        day.value = "";
        year.value = "";
    }
}

function caducidadNif(id) {
    var tipo = id.substr(8, id.length);
    var mesP = "caduNifM" + tipo;
    var fecha = "caduNif" + tipo;

    var mon = document.getElementById(mesP);
    var fecha = document.getElementById(fecha);
    var year = document.getElementById(id);
    if (year.value == 16) {
        if (mon.value >= 3 && mon.value <= 12) {
            fecha.setAttribute("class", " form-group has-success");
        } else {
            fecha.setAttribute("class", " form-group has-error");
            mon.value = "";
            year.value = "";
        }
    }
    else if ((year.value > 16) && (mon.value >= 1 && mon.value <= 12)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        year.value = "";
    }
}

function caducidadTarjeta(id) {
    var mon = document.getElementById("mes");
    var fecha = document.getElementById("caduTar");
    var year = document.getElementById(id);

    if (year.value == 16) {
        if (mon.value >= 3 && mon.value <= 12) {
            fecha.setAttribute("class", " form-group has-success");
        } else {
            fecha.setAttribute("class", " form-group has-error");
            mon.value = "";
            year.value = "";
        }
    }
    else if ((year.value > 16) && (mon.value >= 1 && mon.value <= 12)) {
        fecha.setAttribute("class", " form-group has-success");
    } else {
        fecha.setAttribute("class", " form-group has-error");
        mon.value = "";
        year.value = "";
    }
}



