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
public class Procdimiento_Venta {
    public static void Entrada_venta(String dni_cliente, String nombres, String direccion, String tipo_balon, String precio )
        throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Entrada_venta(?,?,?,?,?)}");
        entrada.setString(1, dni_cliente);
        entrada.setString(2, nombres);
        entrada.setString(3, direccion);
        entrada.setString(4, tipo_balon);
        entrada.setString(5, precio);
        entrada.execute();
    }
  
    public static void Eliminar_venta(int a) throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Eliminar_venta(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }
    
    public static void Buscar_venta(int b)throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Buscar_venta(?)}");
        entrada.setInt(1, b);
        entrada.execute();
    }
}
