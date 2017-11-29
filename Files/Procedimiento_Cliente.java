/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;
import java.sql.CallableStatement;
import java.sql.SQLException;
/**
 *
 * @author RUBIO
 */
public class Procedimiento_Cliente {

    public static void Entrada_cliente(String dni_cliente, String nombre, String apellido, String direccion, String telefono)
        throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Entrada_cliente(?,?,?,?,?)}");
        entrada.setString(1, dni_cliente);
        entrada.setString(2, nombre);
        entrada.setString(3, apellido);
        entrada.setString(4, direccion);
        entrada.setString(5, telefono);
        entrada.execute();
    }
  
    public static void Eliminar_cliente(int b) throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Eliminar_cliente(?)}");
        entrada.setInt(1, b);
        entrada.execute();
    }
    
    public static void Buscar_cliente(int a)throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Buscar_cliente(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }

    
}
   