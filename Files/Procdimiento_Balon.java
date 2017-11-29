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
public class Procdimiento_Balon {
    public static void Entrada_balon(String id_producto, String tipo_balon, String unidad_media,String precio)
        throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Entrada_balon(?,?,?,?)}");
        entrada.setString(1, id_producto);
        entrada.setString(2, tipo_balon);
        entrada.setString(3, unidad_media);
        entrada.setString(4,precio);
        entrada.execute();
    }
  
    public static void Eliminar_balon(int id_producto) throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Eliminar_balon(?)}");
        entrada.setInt(1, id_producto);
        entrada.execute();
    }
    
    public static void Buscar_balon(int id_producto)throws SQLException{
        CallableStatement entrada = ConexionBD.getConexion().prepareCall("{call Buscar_balon(?)}");
        entrada.setInt(1, id_producto);
        entrada.execute();
    }
}
