/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;

/**
 *
 * @author Miriam
 */
public class Conexion_DB {
     private static Conexion_DB UnicaConexion = null;
    private Connection Conex;
    private Conexion_DB() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://localhost:3306/aeropuerto";
        Conex = DriverManager.getConnection(connectionURL, "root", "root");
    }
    
    public synchronized static Conexion_DB GetConexion() throws ClassNotFoundException, SQLException {
        if(UnicaConexion == null){
            UnicaConexion = new Conexion_DB();
        }
        return UnicaConexion;
    }
    public Connection GetCon(){
        return Conex;
    }
    
    public void Destroy()throws SQLException{
        Conex.close();
    }
}
