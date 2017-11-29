/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;


/**
 *
 * @author RUBIO
 */
public class ConexionBD {
    static Connection cnx = null;   
    public static String usuario;
    public static String password; 
    public static boolean status=false;
  
    
    public static Connection getConexion(){
      status=false;
      String url = "jdbc:sqlserver://localhost;databaseName=Alogas";
      try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
      }catch(ClassNotFoundException e){
        System.out.println("Error: "+e);
      }
      try{
        cnx=DriverManager.getConnection(url, ConexionBD.usuario, ConexionBD.password);
        status=true;
        
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Error"+e.getMessage(),"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        System.out.println("Error: "+e);
      }
      return cnx;
      
      
      
    } 
    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    public static void main(String[] args) {
    getConexion();
    
    
    }
    
    public static void setcuenta(String usuario,String password) {
    ConexionBD.usuario=usuario;
    ConexionBD.password=password;
    
    }
     public static boolean getStatus() {
    return status;
    
    }
      
    
}


