/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.security.MessageDigest;
import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author Miriam
 */
public class Operaciones {

    public Operaciones() {

    }

    public ArrayList<Aeropuerto> OrigenTodos(Connection conexion) {

        ArrayList<Aeropuerto> ArrayAeropuerto = new ArrayList();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aeropuerto");
            while (rs.next()) {
                int codigo = rs.getInt("code_aeropuerto");
                String IATA = rs.getString("IATA");
                String nombre = rs.getString("nombre_aeropuerto");
                String ciudad = rs.getString("ciudad_aeropuerto");
                String pais = rs.getString("pais_aeropuerto");
                Aeropuerto aeropuerto = new Aeropuerto(codigo, IATA, nombre, ciudad, pais);
                ArrayAeropuerto.add(aeropuerto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayAeropuerto;
    }

    public Aeropuerto ObtenerAeropuerto(Connection conexion, int codigo) {
        Aeropuerto aeropuerto = null;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aeropuerto where code_aeropuerto=" + codigo);
            while (rs.next()) {
                int code = rs.getInt("code_aeropuerto");
                String IATA = rs.getString("IATA");
                String nombre = rs.getString("nombre_aeropuerto");
                String ciudad = rs.getString("ciudad_aeropuerto");
                String pais = rs.getString("pais_aeropuerto");
                aeropuerto = new Aeropuerto(code, IATA, nombre, ciudad, pais);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aeropuerto;
    }

    public ArrayList<Aeropuerto> DestinoAjax(Connection conexion, Aeropuerto aer) {
        int codigo = aer.getCodigo();
        ArrayList<Aeropuerto> Arrayaeropuerto = new ArrayList<Aeropuerto>();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aeropuerto a, conexion c where a.code_aeropuerto=c.IATA_destino and c.IATA_origen=" + codigo);
            while (rs.next()) {
                int code = rs.getInt("code_aeropuerto");
                String IATA = rs.getString("IATA");
                String nombre = rs.getString("nombre_aeropuerto");
                String ciudad = rs.getString("ciudad_aeropuerto");
                String pais = rs.getString("pais_aeropuerto");
                Aeropuerto aeropuerto = new Aeropuerto(code, IATA, nombre, ciudad, pais);
                Arrayaeropuerto.add(aeropuerto);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrayaeropuerto;
    }

    public Conexiones ObtenerConexiones(Connection conexion, int origen, int destino) {
        Conexiones conex = null;
        int or = origen;
        int des = destino;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT code FROM conexion WHERE IATA_origen=" + or + " and IATA_destino=" + des);
            rs.first();
            int code = rs.getInt("code");
//            int _destino = rs.getInt("IATA_destino");
//            int _origen = rs.getInt("IATA_origen");

//            String _Dest = Integer.toString(_destino);
//             String _Orig = Integer.toString(_origen);
            Aeropuerto Destino = ObtenerAeropuerto(conexion, des);
            Aeropuerto Origen = ObtenerAeropuerto(conexion, or);

            conex = new Conexiones(code, Origen, Destino);
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }

    public Conexiones ObtenerConexiones(int CodeConexiones, Connection conexion) {
        Conexiones conex = null;

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conexion WHERE code=" + CodeConexiones);
            rs.first();
            int code = rs.getInt("code");
            int _destino = rs.getInt("IATA_destino");
            int _origen = rs.getInt("IATA_origen");

            Aeropuerto Destino = ObtenerAeropuerto(conexion, _destino);
            Aeropuerto Origen = ObtenerAeropuerto(conexion, _origen);

            conex = new Conexiones(code, Origen, Destino);
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }

    public ArrayList<Vuelo> MostrarIdas(Connection conexion, int origen, int destino, LocalDate fechaIda) {
        Conexiones conex = ObtenerConexiones(conexion, origen, destino);
        Vuelo vuelo = null;
        ArrayList<Vuelo> ArrayVuelos = new ArrayList<Vuelo>();
        try {
            Statement stmt = conexion.createStatement();
            LocalDate anterior = fechaIda.minusDays(2);
            LocalDate siguiente = fechaIda.plusDays(2);
            System.out.println("anterior: " + anterior + " Siguiente: " + siguiente);
//            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelo where fecha_salida = '" + fechaIda+"'");
//            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelo where conexion= 2 and fecha_salida between '" + anterior + "' and '" + siguiente + "'");

            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos where conexion=" + conex.getCodigo() + " and fecha_salida between '" + anterior + "' and '" + siguiente + "'");
            System.out.println("RS: " + rs);
            while (rs.next()) {
                int code = rs.getInt("codigo");
                LocalDate fecha_salida = LocalDate.parse(rs.getString("fecha_salida"));
                LocalTime hora_salida = LocalTime.parse(rs.getString("hora_salida"));
                LocalTime duracion = LocalTime.parse(rs.getString("duracion"));
                String numVuelo = rs.getString("numero_vuelo");
                double precio = rs.getDouble("precio");
                int plazas = rs.getInt("plazas");
                vuelo = new Vuelo(conex, fecha_salida, hora_salida, duracion, numVuelo, precio, plazas);
                System.out.println("Vuelo: " + vuelo);
                vuelo.setCodigo(code);
                ArrayVuelos.add(vuelo);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayVuelos;
    }

    public ArrayList<Vuelo> MostrarVueltas(Connection conexion, int origen, int destino, LocalDate fechaVuelta) {
        Conexiones conex = ObtenerConexiones(conexion, destino, origen);
        Vuelo vuelo = null;
        ArrayList<Vuelo> ArrayVuelos = new ArrayList<Vuelo>();
        try {
            Statement stmt = conexion.createStatement();
            LocalDate anterior = fechaVuelta.minusDays(2);
            LocalDate siguiente = fechaVuelta.plusDays(2);
            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos where conexion=" + conex.getCodigo() + "  and fecha_salida between '" + anterior + "' and '" + siguiente + "'");
            while (rs.next()) {
                int code = rs.getInt("codigo");
                LocalDate fecha_salida = LocalDate.parse(rs.getString("fecha_salida"));
                LocalTime hora_salida = LocalTime.parse(rs.getString("hora_salida"));
                LocalTime duracion = LocalTime.parse(rs.getString("duracion"));
                String numVuelo = rs.getString("numero_vuelo");
                double precio = rs.getDouble("precio");
                int plazas = rs.getInt("plazas");
                vuelo = new Vuelo(conex, fecha_salida, hora_salida, duracion, numVuelo, precio, plazas);
                vuelo.setCodigo(code);
                ArrayVuelos.add(vuelo);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayVuelos;
    }

    public Vuelo BuscarVuelo(int codigoVuelo, Connection conexion) {
        Vuelo vuelo = null;
        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos WHERE codigo=" + codigoVuelo);
            rs.first();
            int code = rs.getInt("codigo");
            int codeConexion = rs.getInt("conexion");
            LocalDate fSalida = LocalDate.parse(rs.getString("fecha_salida"));
            LocalTime hSalida = LocalTime.parse(rs.getString("hora_salida"));
            LocalTime duracion = LocalTime.parse(rs.getString("duracion"));
            String nVuelo = rs.getString("numero_vuelo");
            double precio = rs.getDouble("precio");
            int plazas = rs.getInt("plazas");

            conexi = ObtenerConexiones(codeConexion, conexion);
            vuelo = new Vuelo(conexi, fSalida, hSalida, duracion, nVuelo, precio, plazas);
            vuelo.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelo;

    }

    public Vuelo BuscarVuelo(Vuelo objVuelo, Connection conexion) {
        Vuelo vuelo = null;
        String numVuelo = objVuelo.getNum_vuelo();
        LocalDate fecha = objVuelo.getFecha_salida();

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vuelos WHERE numero_vuelo='" + numVuelo + "' and fecha_salida='" + fecha + "'");
            rs.first();
            int code = rs.getInt("codigo");
            int codeConexion = rs.getInt("conexion");
            LocalDate fSalida = LocalDate.parse(rs.getString("fecha_salida"));
            LocalTime hSalida = LocalTime.parse(rs.getString("hora_salida"));
            LocalTime duracion = LocalTime.parse(rs.getString("duracion"));
            String nVuelo = rs.getString("numero_vuelo");
            double precio = rs.getDouble("precio");
            int plazas = rs.getInt("plazas");

            vuelo = new Vuelo(code, fSalida, hSalida, duracion, nVuelo, precio, plazas);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelo;

    }

    public Vuelo BuscarVueloB(int codigoVuelo, Connection conexion) {
        Vuelo vuelo = null;
        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_vuelos WHERE codigo=" + codigoVuelo);
            rs.first();
            int code = rs.getInt("codigo");
            int codeConexion = rs.getInt("conexion");
            LocalDate fSalida = LocalDate.parse(rs.getString("fecha_salida"));
            LocalTime hSalida = LocalTime.parse(rs.getString("hora_salida"));
            LocalTime duracion = LocalTime.parse(rs.getString("duracion"));
            String nVuelo = rs.getString("numero_vuelo");
            double precio = rs.getDouble("precio");
            int plazas = rs.getInt("plazas");

            conexi = ObtenerConexiones(codeConexion, conexion);
            vuelo = new Vuelo(conexi, fSalida, hSalida, duracion, nVuelo, precio, plazas);
            vuelo.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelo;

    }

    public Pasajero BuscarPasajero(int codigo, Connection conexion) {
        Pasajero objPasajero = null;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pasajeros WHERE codigo=" + codigo);
            rs.first();
            int code = rs.getInt("codigo");
            String nif = rs.getString("nif");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            LocalDate fNac = LocalDate.parse(rs.getString("fechaNacimiento"));
            String pais = rs.getString("pais_expedicion");
            objPasajero = new Pasajero(nif, nombre, apellidos, pais, fNac);
            int tutor = rs.getInt("tutor");
            if (tutor != 0) {
                objPasajero.setTutor(BuscarPasajero(tutor, conexion));
            }
            objPasajero.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPasajero;
    }

    public Pasajero BuscarPasajero(String nif, Connection conexion) {
        Pasajero objPasajero = null;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pasajeros WHERE nif='" + nif + "'");
            rs.last();
            int code = rs.getInt("codigo");

            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            LocalDate fNac = LocalDate.parse(rs.getString("fechaNacimiento"));
            String pais = rs.getString("pais_expedicion");
            objPasajero = new Pasajero(nif, nombre, apellidos, pais, fNac);
            int tutor = rs.getInt("tutor");
            if (tutor != 0) {
                objPasajero.setTutor(BuscarPasajero(tutor, conexion));
            }
            objPasajero.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPasajero;
    }

    public Pasajero BuscarPasajeroB(int codigo, Connection conexion) {
        Pasajero objPasajero = null;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_pasajeros WHERE codigo=" + codigo);
            rs.first();
            int code = rs.getInt("codigo");
            String nif = rs.getString("nif");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            LocalDate fNac = LocalDate.parse(rs.getString("fechaNacimiento"));
            String pais = rs.getString("pais_expedicion");
            objPasajero = new Pasajero(nif, nombre, apellidos, pais, fNac);
            int tutor = rs.getInt("tutor");
            if (tutor != 0) {
                objPasajero.setTutor(BuscarPasajeroB(tutor, conexion));
            }
            objPasajero.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPasajero;
    }

    public ArrayList<Ocupacion> OcupacionVuelo(Vuelo objVuelo, Connection conexion) {
        ArrayList<Ocupacion> arrayOcupacion = new ArrayList();
        Ocupacion objOcupacion = null;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ocupacion where vuelo=" + objVuelo.getCodigo());
//            System.out.println("RS: " + rs);
            while (rs.next()) {
                int code = rs.getInt("codigo");
                int vuelo = rs.getInt("vuelo");
                String asiento = rs.getString("asiento");
                String BK = rs.getString("booking_code");
                int pasajero = rs.getInt("pasajero");
                double importe = rs.getDouble("importe");
                Pasajero ObjPasajero = BuscarPasajero(pasajero, conexion);
                objOcupacion = new Ocupacion(code, asiento, ObjPasajero, BK, importe);
                arrayOcupacion.add(objOcupacion);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayOcupacion;
    }

    public ArrayList<Servicio> MostrarServicios(Connection conexion) {
        ArrayList<Servicio> arrayServicios = new ArrayList();

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM servicios");
//            System.out.println("RS: " + rs);
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String siglas = rs.getString("siglas");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                Servicio serv = new Servicio(siglas, descripcion, precio);
                serv.setCodigo(code);
                arrayServicios.add(serv);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayServicios;
    }

    public ServiciosContratados MostrarServicio(String codigo, Connection conexion) {
        ServiciosContratados ObjServicio = null;

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM servicios where codigo =" + codigo);
//            System.out.println("RS: " + rs);
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String siglas = rs.getString("siglas");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                ObjServicio = new ServiciosContratados(siglas, descripcion, precio);
                ObjServicio.setCodigo(code);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ObjServicio;
    }

    public String encriptar(String sinCifrar) {
        String passwordToHash = sinCifrar;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;
    }

    public Cliente validarCliente(Cliente Obj, Connection conexion) {
        direccionCliente direccion = null;
        Cliente objCliente = null;
        String user = Obj.getMail();
        String pass = Obj.getPassword();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente c, direccioncliente d where c.direccion_facturacion=d.CODIGODIRECC and mail='" + user + "' and password='" + pass + "'");
            System.out.println("RS: " + rs);
            rs.first();
            int codigo = rs.getInt("CODIGODIRECC");
            String tipoVia = rs.getString("TIPO_VIA");
            String nombreVia = rs.getString("NOMBRE_VIA");
            String numeroVia = rs.getString("NUMERO");
            String poblacion = rs.getString("POBLACION");
            String provincia = rs.getString("PROVINCIA");
            String cp = rs.getString("CODIGO_POSTAL");
            String pais = rs.getString("PAIS");

            direccion = new direccionCliente(tipoVia, nombreVia, numeroVia, poblacion, provincia, cp, pais);
            direccion.setCodigo(codigo);

            int code = rs.getInt("codigo");
            String nombre = rs.getString("nombre_completo");
            String password = rs.getString("password");

            String nif = rs.getString("nif");
            String mail = rs.getString("mail");
            String telefono = rs.getString("telefono");
            String tarjeta = rs.getString("tarjeta");

            String tipo_tarjeta = rs.getString("tipoTarjeta");
            LocalDate fecha_nac = LocalDate.parse(rs.getString("fecha_nac"));
            objCliente = new Cliente(nombre, fecha_nac, nif, direccion, telefono, mail, password, tarjeta, tipo_tarjeta);
            objCliente.setCodigo(code);

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCliente;
    }

    public String generarBookingCode() {
        String booking = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < 6) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                booking += c;
                i++;
            }
        }
//        String NUMEROS = "0123456789";
//        String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String key = NUMEROS + MAYUSCULAS;
//        String booking = "";
//        for (int i = 0; i < 6; i++) {
//            int Random = (int) Math.random() * key.length();
//            booking += (key.charAt(Random));
//        }
        return booking;
    }

    public boolean InsertarServicio(Servicio ObjServicio, int ObjOcupacion, Connection conexion) throws SQLException {
        boolean insertServi = false;

        int result = 0;
//        try {
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        String query = "INSERT INTO servicios_contratados (cod_ocupacion,cod_servicio) VALUES (" + ObjOcupacion + ", " + ObjServicio.getCodigo() + ")";
        result = stmt.executeUpdate(query);

        //COMPROBAR EL TUTOR, SI TIENE TUTOR, LLAMAR A BUSCAR PASAJERO PARA AÑADIR EL ID
//        } catch (SQLException ex) {
//            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return insertServi;
    }

    public int insertarPasajero(Pasajero objPasajero, Connection conexion) throws SQLException {
        boolean insertarPasajero = false;
        String fecha = objPasajero.getFechaNacimiento().toString();
        int idPasajero = 0;
        int hecho = 0;
//        try {
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        PreparedStatement pstmt;
        pstmt = conexion.prepareStatement("INSERT INTO pasajeros (codigo, nif,nombre,apellidos,fechaNacimiento, pais_expedicion) VALUES (null,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
//        pstmt.setInt(1, 22);
        pstmt.setString(1, objPasajero.getNif());
        pstmt.setString(2, objPasajero.getNombre());
        pstmt.setString(3, objPasajero.getApellidos());
        pstmt.setDate(4, Date.valueOf(fecha));
        pstmt.setString(5, objPasajero.getPais());

        int tmp = pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        while (rs.next()) {
            idPasajero = rs.getInt(1);
            System.out.println("Clave generada = " + idPasajero);
        }
        //COMPROBAR EL TUTOR, SI TIENE TUTOR, LLAMAR A BUSCAR PASAJERO PARA AÑADIR EL ID
//        } catch (SQLException ex) {
//            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return idPasajero;
        //        }
    }

    public int insertarPasajeroN(Pasajero objPasajero, Connection conexion) throws SQLException {
        boolean insertarPasajero = false;
        int idTutor = objPasajero.getTutor().getCodigo();
        int idPasajero = 0;
        int hecho = 0;
//        try {
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        PreparedStatement pstmt;
        pstmt = conexion.prepareStatement("INSERT INTO pasajeros (codigo, nif,nombre,apellidos,fechaNacimiento, pais_expedicion, tutor) VALUES (null, ?,?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
//        pstmt.setInt(1, 22);
        pstmt.setString(1, objPasajero.getNif());
        pstmt.setString(2, objPasajero.getNombre());
        pstmt.setString(3, objPasajero.getApellidos());

        String fecha = objPasajero.getFechaNacimiento().toString();
        pstmt.setDate(4, Date.valueOf(fecha));
        pstmt.setString(5, objPasajero.getPais());
        pstmt.setInt(6, idTutor);

        int tmp = pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        while (rs.next()) {
            idPasajero = rs.getInt(1);
            System.out.println("Clave generada = " + idPasajero);
        }
        //COMPROBAR EL TUTOR, SI TIENE TUTOR, LLAMAR A BUSCAR PASAJERO PARA AÑADIR EL ID
//        } catch (SQLException ex) {
//            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return idPasajero;
    }

    public boolean InsertarBebe(Bebe objBebe, Pasajero ObjPasajero, Connection conexion) throws SQLException {
        boolean insertBebe = false;

        int idPasajero = 0;
//        try {
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        String query = "INSERT INTO bebe (nif,nombre,apellidos, fechaNacimiento,tutor, pais) VALUES ('" + objBebe.getNif() + "', '" + objBebe.getNombre() + "','" + objBebe.getApellidos() + "','" + objBebe.getFechaNacimiento() + "','" + ObjPasajero.getCodigo() + "', '" + objBebe.getPais() + "')";
        idPasajero = stmt.executeUpdate(query);

        //COMPROBAR EL TUTOR, SI TIENE TUTOR, LLAMAR A BUSCAR PASAJERO PARA AÑADIR EL ID
//        } catch (SQLException ex) {
//            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return insertBebe;
    }

    public int insertarOcupacion(Ocupacion objOcupacion, Vuelo objVuelo, Connection conexion) throws SQLException {

        int idOcupacion = 0;
        int hecho = 0;
        int codigoVuelo = objVuelo.getCodigo();
        int Pasajero = objOcupacion.getPasajero().getCodigo();
        String asiento = objOcupacion.getAsiento();
        String bk = objOcupacion.getBookingCode();
        double importe = objOcupacion.getImporte();
        System.out.println("codVuelo: " + codigoVuelo);
        System.out.println("Asiento: " + asiento);
        System.out.println("Pasajero: " + Pasajero);
        System.out.println("BK: " + bk);
//        try {
        conexion.setAutoCommit(false);
        PreparedStatement pstmt;
        pstmt = conexion.prepareStatement("INSERT INTO ocupacion (codigo, vuelo,asiento,pasajero, booking_code, importe) VALUES(null,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
//        pstmt.setInt(1, 22);
        pstmt.setInt(1, codigoVuelo);
        pstmt.setString(2, asiento);
        pstmt.setInt(3, Pasajero);
        pstmt.setString(4, bk);
        pstmt.setDouble(5, importe);
        int tmp = pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        while (rs.next()) {
            idOcupacion = rs.getInt(1);
            System.out.println("Clave generada = " + idOcupacion);
        }

//        Statement stmt = conexion.createStatement();
//        String query = "INSERT INTO ocupacion (vuelo,asiento,pasajero, booking_code) VALUES(" + codigoVuelo + ", '" + asiento + "', " + Pasajero + ", '" + bk + "')";
//
//        idOcupacion = stmt.executeUpdate(query, stmt.RETURN_GENERATED_KEYS);
//        } catch (SQLException ex) {
//            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        boolean 
        return idOcupacion;
    }

    public boolean insertarPago(Pago pago, Connection conexion) throws SQLException {
        int resultado = 0;
        boolean hecho = false;
        int codCliente = pago.getCliente().getCodigo();
        double total = pago.getImporteTotal();
        String BK = pago.getBooking_code();
        LocalDate fecha = pago.getFecha();
//        try {
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        resultado = stmt.executeUpdate("INSERT INTO pagos (booking_code, cod_cliente, importe_total, fecha) VALUES('" + BK + "', " + codCliente + "," + total + ", '" + fecha + "')");

        if (resultado == 0) {
            hecho = false;
        } else {
            hecho = true;
        }

//        } 
        return hecho;
    }

    public int comprobarPago(Pago pago, Connection conexion) {
        int code = 0;
        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as filas FROM pagos WHERE booking_code='" + pago.getBooking_code() + "' and cod_cliente=" + pago.getCliente().getCodigo());
            rs.first();
            code = rs.getInt("filas");

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return code;
    }
    public void insertarTarjeta(Cliente objcliente, Connection conexion){
        try{
        conexion.setAutoCommit(false);
        Statement stmt = conexion.createStatement();
        stmt.executeUpdate("UPDATE cliente SET tarjeta='"+objcliente.getNumeroTarjeta()+"', tipoTarjeta='"+objcliente.getTipoTarjeta()+"' where codigo="+objcliente.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean HacerReserva(Carrito Objcarrito, Connection conexion) {
        boolean valido = false;
        int PasjeroInsertado = 0;
        int OcupacionInsertada;
        LocalDate hoy = LocalDate.now();
        String bookingCode = "";
        Reserva objReserva = Objcarrito.getReserva();
        ArrayList<Bebe> arrayBebes = objReserva.getBebes();
        Vuelo vueloIda = objReserva.getIda();
        Vuelo vueloVuelta = objReserva.getVuelta();
        ArrayList<Ocupacion> ocupacionVuelta = null;
        if (vueloVuelta != null) {
            ocupacionVuelta = vueloVuelta.getArrayOcupacion();
        }
        ArrayList<Ocupacion> ocupacionIda = vueloIda.getArrayOcupacion();

        try {
            for (int i = 0; i < ocupacionIda.size(); i++) {
                if (ocupacionIda.get(i).getPasajero() != null) {

                    bookingCode = ocupacionIda.get(i).getBookingCode();

                    if (ocupacionIda.get(i).getPasajero().getTutor() == null) {
                        PasjeroInsertado = insertarPasajero(ocupacionIda.get(i).getPasajero(), conexion);
                        if (vueloVuelta != null) {
                            for (int ocv = 0; ocv < ocupacionVuelta.size(); ocv++) {
                                if (ocupacionVuelta.get(ocv).getPasajero() != null) {
                                    if (ocupacionVuelta.get(ocv).getPasajero().getNif().equals(ocupacionIda.get(i).getPasajero().getNif())) {
                                        ocupacionVuelta.get(ocv).getPasajero().setCodigo(PasjeroInsertado);
                                    }
                                }
                            }
                        }
                    } else {

                        ocupacionIda.get(i).getPasajero().setTutor(BuscarPasajero(ocupacionIda.get(i).getPasajero().getTutor().getNif(), conexion));
                        PasjeroInsertado = insertarPasajeroN(ocupacionIda.get(i).getPasajero(), conexion);

                        if (vueloVuelta != null) {
                            for (int ocv = 0; ocv < ocupacionVuelta.size(); ocv++) {
                                if (ocupacionVuelta.get(ocv).getPasajero() != null) {
                                    if (ocupacionVuelta.get(ocv).getPasajero().getNif().equals(ocupacionIda.get(i).getPasajero().getNif())) {
                                        ocupacionVuelta.get(ocv).getPasajero().setTutor(ocupacionIda.get(i).getPasajero().getTutor());
                                        ocupacionVuelta.get(ocv).getPasajero().setCodigo(PasjeroInsertado);

                                    }
                                }
                            }
                        }
                    }
                    ocupacionIda.get(i).getPasajero().setCodigo(PasjeroInsertado);

                    OcupacionInsertada = insertarOcupacion(ocupacionIda.get(i), vueloIda, conexion);
                    ocupacionIda.get(i).setCodigo(OcupacionInsertada);

                    for (int s = 0; s < ocupacionIda.get(i).getPasajero().getServicios().size(); s++) {
                        if ("B".equals(ocupacionIda.get(i).getPasajero().getServicios().get(s).getSiglas())) {
                            InsertarServicio(ocupacionIda.get(i).getPasajero().getServicios().get(s), ocupacionIda.get(i).getCodigo(), conexion);
                            for (int b = 0; b < arrayBebes.size(); b++) {
                                if (arrayBebes.get(b).getTutor().getNif().equals(ocupacionIda.get(i).getPasajero().getNif())) {
                                    InsertarBebe(arrayBebes.get(b), ocupacionIda.get(i).getPasajero(), conexion);
                                }
                            }
                        } else {
                            InsertarServicio(ocupacionIda.get(i).getPasajero().getServicios().get(s), ocupacionIda.get(i).getCodigo(), conexion);

                        }
                    }
                }
            }
            if (vueloVuelta != null) {
                for (int i = 0; i < ocupacionVuelta.size(); i++) {
                    if (ocupacionVuelta.get(i).getPasajero() != null) {

                        bookingCode = ocupacionVuelta.get(i).getBookingCode();
                        OcupacionInsertada = insertarOcupacion(ocupacionVuelta.get(i), vueloVuelta, conexion);
                        ocupacionVuelta.get(i).setCodigo(OcupacionInsertada);

                        for (int s = 0; s < ocupacionVuelta.get(i).getPasajero().getServicios().size(); s++) {
                            if ("B".equals(ocupacionVuelta.get(i).getPasajero().getServicios().get(s).getSiglas())) {
                                InsertarServicio(ocupacionVuelta.get(i).getPasajero().getServicios().get(s), ocupacionVuelta.get(i).getCodigo(), conexion);

                            } else {
                                InsertarServicio(ocupacionVuelta.get(i).getPasajero().getServicios().get(s), ocupacionVuelta.get(i).getCodigo(), conexion);

                            }
                        }
                    }
                }
            }
            insertarTarjeta(objReserva.getPago().getCliente(), conexion);
            Pago pago = new Pago(bookingCode, objReserva.getPago().getCliente(), objReserva.getPago().getImporteTotal(), hoy);
            insertarPago(pago, conexion);
            
            conexion.commit();
            valido = true;

        } catch (SQLException SQLE) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, SQLE);
            String mensaje = SQLE.getMessage();
            System.out.println(mensaje);

        }

        return valido;

    }

//    public ArrayList<Ocupacion>
    public ArrayList<Vuelo> recogerFacturacion(Reserva reserva, Connection conexion) {
        ArrayList<Vuelo> vuelos = new ArrayList();
        Vuelo vuelo = null;
        int code = 0;
        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT(vuelo) FROM ocupacion WHERE booking_code='" + reserva.getPago().getBooking_code() + "'");
            while (rs.next()) {
                code = rs.getInt("vuelo");
                vuelo = BuscarVuelo(code, conexion);
                vuelos.add(vuelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelos;
    }

    public ArrayList<Ocupacion> BuscarFacturacion(Vuelo objVuelo, String bk, Connection conexion) {
        ArrayList<Ocupacion> ocupacionesR = new ArrayList();
        Ocupacion ocp = null;

        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ocupacion WHERE booking_code='" + bk + "' and vuelo=" + objVuelo.getCodigo());
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String asiento = rs.getString("asiento");
                int facturado = rs.getInt("facturado");
                String bokCode = rs.getString("booking_code");
                int pasajero = rs.getInt("pasajero");
                double importe = rs.getDouble("importe");
                Pasajero ObjPasajero = BuscarPasajero(pasajero, conexion);
                ocp = new Ocupacion(code, asiento, ObjPasajero, bokCode, importe);
                ocp.setFacturado(facturado);
                ocupacionesR.add(ocp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ocupacionesR;

    }

    public int Facturar(Ocupacion objOcupacion, Connection conexion) {

        Vuelo dni = objOcupacion.getVuelo();
        int resultado = 0;
        try {
            Statement stmt = conexion.createStatement();
            resultado = stmt.executeUpdate("UPDATE ocupacion SET facturado=1 WHERE booking_code = '" + objOcupacion.getBookingCode() + "' and vuelo =" + objOcupacion.getVuelo().getCodigo());

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public boolean Despegar(Vuelo objVuelo, Connection conexion) {

        
        boolean valido = false;
        int borrado = 0;

        try {
            conexion.setAutoCommit(false);
            Statement stmt = conexion.createStatement();
            borrado = stmt.executeUpdate("DELETE FROM vuelos WHERE codigo=" + objVuelo.getCodigo());

            if (borrado > 0) {
                conexion.commit();
                valido = true;
            } else {
                conexion.rollback();

            }

        } catch (SQLException SQLE) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, SQLE);
            String mensaje = SQLE.getMessage();
            System.out.println(mensaje);
//                    conexion.rollback();               
        }

        return valido;

    }

    public ArrayList<ServiciosContratados> serviciosContratados(Ocupacion ocup, Connection conexion) {
        ArrayList<ServiciosContratados> servicios = new ArrayList();

        ServiciosContratados ObjServicio = null;

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_servicios_contratados where cod_ocupacion =" + ocup.getCodigo());
//            System.out.println("RS: " + rs);
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String siglas = rs.getString("siglas");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                ObjServicio = new ServiciosContratados(siglas, descripcion, precio);
                ObjServicio.setCodigo(code);
                servicios.add(ObjServicio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicios;
    }

    public ArrayList<Vuelo> recogerReserva(Reserva reserva, Connection conexion) {
        ArrayList<Vuelo> vuelos = new ArrayList();
        Vuelo vuelo = null;
        int code = 0;
        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT(vuelo) FROM backup_ocupacion WHERE booking_code='" + reserva.getPago().getBooking_code() + "'");
            while (rs.next()) {
                code = rs.getInt("vuelo");
                vuelo = BuscarVueloB(code, conexion);
                vuelos.add(vuelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelos;
    }

    public ArrayList<Ocupacion> BuscarReservas(Vuelo objVuelo, String bk, Connection conexion) {
        ArrayList<Ocupacion> ocupacionesR = new ArrayList();
        Ocupacion ocp = null;

        Conexiones conexi;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_ocupacion WHERE booking_code='" + bk + "' and vuelo=" + objVuelo.getCodigo());
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String asiento = rs.getString("asiento");
                int facturado = rs.getInt("facturado");
                String bokCode = rs.getString("booking_code");
                int pasajero = rs.getInt("pasajero");
                double importe = rs.getDouble("importe");
                Pasajero ObjPasajero = BuscarPasajeroB(pasajero, conexion);

                ocp = new Ocupacion(code, asiento, ObjPasajero, bokCode, importe);
                ocp.setFacturado(facturado);
                ocupacionesR.add(ocp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ocupacionesR;

    }

    public Bebe buscarBebes(Pasajero pasajero, Connection conexion) {
        Bebe bebe = null;

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_bebe WHERE tutor=" + pasajero.getCodigo());
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                LocalDate fecha = LocalDate.parse(rs.getString("fechaNacimiento"));
                String nif = rs.getString("nif");
                String pais = rs.getString("pais");

                bebe = new Bebe(code, nombre, apellidos, nif, pais, pasajero, fecha);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bebe;
    }

    public ArrayList<Pago> BuscarPagos(Cliente cliente, Connection conexion) {
        ArrayList<Pago> pagos = new ArrayList();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM backup_pagos WHERE cod_cliente=" + cliente.getCodigo());
            while (rs.next()) {
                int code = rs.getInt("codigo");
                String bk = rs.getString("booking_code");
                LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
                int clientep = rs.getInt("cod_cliente");
                double importe = rs.getDouble("importe_total");

                Pago pago = new Pago(bk, cliente, importe, fecha);
                pago.setCodigo(code);
                pagos.add(pago);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagos;
    }

    public Reserva buscarReservas(Pago Objpago, Connection conexion) {

        Reserva objReserva = new Reserva();

        Cliente cliente = Objpago.getCliente();

        objReserva.setPago(Objpago);

        ArrayList<Vuelo> vuelos = recogerReserva(objReserva, conexion);
        Vuelo nuevoVuelo = new Vuelo();
        ArrayList<Ocupacion> ocupacion = new ArrayList();
        ArrayList<Bebe> bebes = new ArrayList();
        objReserva.setBebes(bebes);
        for (int i = 0; i < vuelos.size(); i++) {
            nuevoVuelo = vuelos.get(i);
            ocupacion = BuscarReservas(nuevoVuelo, Objpago.getBooking_code(), conexion);
            for (int o = 0; o < ocupacion.size(); o++) {
                ocupacion.get(o).getPasajero().setServicios(serviciosContratados(ocupacion.get(o), conexion));
                for (int s = 0; s < ocupacion.get(o).getPasajero().getServicios().size(); s++) {
                    if (ocupacion.get(o).getPasajero().getServicios().get(s).getSiglas().equals("B")) {
                        if (objReserva.getBebes().isEmpty()) {
                            objReserva.getBebes().add(buscarBebes(ocupacion.get(o).getPasajero(), conexion));
                        } else {
                            for (int b = 0; b < objReserva.getBebes().size(); b++) {
                                Bebe bebe = buscarBebes(ocupacion.get(o).getPasajero(), conexion);
                                if (objReserva.getBebes().get(b).getCodigo() != bebe.getCodigo()) {
                                    objReserva.getBebes().add(buscarBebes(ocupacion.get(o).getPasajero(), conexion));
                                }
                            }
                        }
                    }
                }
                nuevoVuelo.setArrayOcupacion(ocupacion);
                int desinoVuelo = Integer.parseInt(nuevoVuelo.getNum_vuelo().substring(nuevoVuelo.getNum_vuelo().length() - 1, nuevoVuelo.getNum_vuelo().length()));
                if (desinoVuelo % 2 != 0) {
                    objReserva.setVuelta(nuevoVuelo);
                } else {
                    objReserva.setIda(nuevoVuelo);
                }
            }
        }
        return objReserva;
    }

    public int BuscarUsuario(Cliente objCliente, Connection conexion) {

        int esta = 0;
        String user = objCliente.getMail();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as contador FROM cliente c where mail='" + user + "'");
            System.out.println("RS: " + rs);
            rs.first();
            int codigo = rs.getInt("contador");
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return esta;
    }

    public int RegistrarCliente(Cliente objCliente, Connection conexion) {
        direccionCliente direcCliente = objCliente.getDireccion();
        int resultado = 0;
        try {
            conexion.setAutoCommit(false);
            int idDirecc = 0;

            PreparedStatement pstmt;
            pstmt = conexion.prepareStatement("INSERT INTO direccioncliente VALUES (null, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
//        pstmt.setInt(1, 22);
            pstmt.setString(1, direcCliente.getTipoVia());
            pstmt.setString(2, direcCliente.getNombreVia());
            pstmt.setString(3, direcCliente.getNumero());
            pstmt.setString(4, direcCliente.getPoblacion());
            pstmt.setString(5, direcCliente.getProvincia());
            pstmt.setString(6, direcCliente.getCodigoPostal());
            pstmt.setString(7, direcCliente.getPais());
            int tmp = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                idDirecc = rs.getInt(1);
                System.out.println("Clave generada = " + idDirecc);
            }

            int idCliente=0;
            PreparedStatement pstmt2;

            pstmt2 = conexion.prepareStatement("INSERT INTO cliente VALUES (null,?,?,?,?,?,?,?,null,null)", PreparedStatement.RETURN_GENERATED_KEYS
            );
       
         pstmt2.setString(1, objCliente.getNombreCompleto());
            pstmt2.setString(2, objCliente.getPassword());
            pstmt2.setDate(3, Date.valueOf(objCliente.getFechaNacimiento()));
            pstmt2.setString(4, objCliente.getNif());
            pstmt2.setInt(5, idDirecc);
            pstmt2.setString(6, objCliente.getTelefono());
            pstmt2.setString(7, objCliente.getMail());
//            pstmt2.setString(8, objCliente.getNumeroTarjeta());
//            pstmt2.setString(9, objCliente.getTipoTarjeta());
            int tmp2 = pstmt2.executeUpdate();

            ResultSet rs2 = pstmt2.getGeneratedKeys();
            while (rs2.next()) {
                idCliente = rs2.getInt(1);
                System.out.println("Clave generada = " + idCliente);
            }
            resultado=idCliente;
            conexion.commit();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
}
