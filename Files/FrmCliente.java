

package Files;


import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.*;





public class FrmCliente extends javax.swing.JFrame {

DefaultTableModel ModeloTabla;
static ResultSet res;
int cont;

    
public FrmCliente() {
this.setLocationRelativeTo(null);
DefaultTableModel ModeloTabla;
initComponents();        
CargarClientes();

}

public void CargarClientes(){
    
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        res = ConexionBD.Consulta("select * from cliente order by dni_cliente");
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                modelo.addRow(v);
                jTable1.setModel(modelo);
            }
        }catch (SQLException e){
        }
    }


public void modifica(){
    try{
            PreparedStatement pps = ConexionBD.getConexion().prepareStatement("update cliente set nombre='" + 
                    jTextNombres.getText() + "', apellido='" + jTextApellidos.getText() + "', direccion='" + jTextDireccion.getText() + 
                    "', telefono='" + jTextTelefono.getText() +
                    "' where dni_cliente='" + jTextDNI.getText() + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                jTextDNI.setText("");
                jTextNombres.setText("");
                jTextApellidos.setText("");
                jTextDireccion.setText("");
                jTextTelefono.setText("");
                jTextDNI.requestFocus();
                jTextNombres.requestFocus();
                jTextApellidos.requestFocus();
                jTextDireccion.requestFocus();
                jTextDireccion.requestFocus();
        }catch(SQLException e){
        }

}

public void consulta(){
if(jTextDNI.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese bien sus datos", "Error", JOptionPane.ERROR_MESSAGE);
            jTextDNI.setText("");
            jTextDNI.requestFocus();
        } else {
            try {
                String dni;
                Procedimiento_Cliente.Buscar_cliente(Integer.parseInt(jTextDNI.getText()));
                dni = jTextDNI.getText();
                jTextDNI.setText("");
                jTextNombres.setText("");
                jTextApellidos.setText("");
                jTextDireccion.setText("");
                jTextTelefono.setText("");
                jTextDNI.requestFocus();
                jTextNombres.requestFocus();
                
                jTextApellidos.requestFocus();
                jTextDireccion.requestFocus();
                jTextTelefono.requestFocus();
                res = ConexionBD.Consulta("select * from cliente");
                while(res.next()){
                    if(res.getString(1).equals(dni)){
                         JOptionPane.showMessageDialog(null, "Datos encontrados");
                        jTextDNI.setText(res.getString(1));
                        jTextNombres.setText(res.getString(2));
                        jTextApellidos.setText(res.getString(3));
                        jTextDireccion.setText(res.getString(4));
                        jTextTelefono.setText(res.getString(5));
                    }
                    else JOptionPane.showMessageDialog(null, "Información no encontrada");
                }
                
            }catch(SQLException e){
            }
        }
}



public void eliminacion(){
     int row = jTable1.getSelectedRow();
        int opc = JOptionPane.showConfirmDialog(this, "Está seguro de desear eliminar el registro?","Pregunta",
                  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            try{
                Procedimiento_Cliente.Eliminar_cliente(Integer.parseInt(jTable1.getValueAt(row, 0).toString()));
            }catch (SQLException e){
            }
        }
}


    

public Image getIconImage() {
Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/AloGas.jpg"));
return retValue;
}
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jTextNombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jTextApellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextDNI = new javax.swing.JTextField();
        msj01 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setName("PaginaDeCliente"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dirección:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 280, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 30));

        btnRegresar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 20));

        jTextNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombresActionPerformed(evt);
            }
        });
        getContentPane().add(jTextNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 280, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombres:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        btnBuscar.setBackground(new java.awt.Color(0, 51, 102));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 90, 30));

        btnModifica.setBackground(new java.awt.Color(0, 51, 102));
        btnModifica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModifica.setForeground(new java.awt.Color(255, 255, 255));
        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, 30));

        btnEliminar.setBackground(new java.awt.Color(0, 51, 102));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 90, 30));

        jTextApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidosActionPerformed(evt);
            }
        });
        getContentPane().add(jTextApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 280, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Apellidos:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DNI:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTextDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDNIActionPerformed(evt);
            }
        });
        getContentPane().add(jTextDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, -1));
        getContentPane().add(msj01, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 20, 20));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("Gestión de Clientes:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Teléfono:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        getContentPane().add(jTextTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AloGas.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Dirección", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 120));

        btnActualizar.setBackground(new java.awt.Color(0, 51, 102));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ventas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 500));

        setSize(new java.awt.Dimension(637, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//CAPTURANDO LA INFORMACION DE LOS EMPLEADOS DE LOS OBJETOS DEL FORMULARIO
        if(jTextDNI.getText().isEmpty() || jTextNombres.getText().isEmpty() || jTextApellidos.getText().isEmpty() 
        || jTextDireccion.getText().isEmpty() || jTextTelefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese de nuevo sus datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            jTextDNI.setText("");
            jTextNombres.setText("");
            jTextApellidos.setText("");
            jTextDireccion.setText("");
            jTextTelefono.setText("");       
            jTextDNI.requestFocus();
            jTextNombres.requestFocus();
            jTextApellidos.requestFocus();
            jTextDireccion.requestFocus();
            jTextTelefono.requestFocus(); 
        } else {
            try {
                res = ConexionBD.Consulta("Select dni_cliente from cliente where dni_cliente='" + jTextDNI.getText() + "'");
                try{
                    while(res.next()){
                        cont = res.getInt(1);
                    }
                }catch (SQLException  e){
                }
                if(cont >= 1){
                    JOptionPane.showMessageDialog(this, "Ya existe información con el mismo DNI" , "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Procedimiento_Cliente.Entrada_cliente(jTextDNI.getText(), jTextNombres.getText(), jTextApellidos.getText(),
                    jTextDireccion.getText(), jTextTelefono.getText());
                    jTextDNI.setText("");
                    jTextNombres.setText("");
                    jTextApellidos.setText("");
                    jTextDireccion.setText("");
                    jTextTelefono.setText("");       
                    jTextDNI.requestFocus();
                    jTextNombres.requestFocus();
                    jTextApellidos.requestFocus();
                    jTextDireccion.requestFocus();
                    jTextTelefono.requestFocus(); 
                    JOptionPane.showMessageDialog(this, "Registro exitoso");
                }
            }catch (SQLException e){
            }
        }

//resumen();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu menu=new FrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jTextNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombresActionPerformed

    }//GEN-LAST:event_jTextNombresActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consulta();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        modifica();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminacion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTextApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidosActionPerformed

   
    
    
    private void jTextDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDNIActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CargarClientes();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmVen vn= new FrmVen();
        vn.setVisible(true);  //mantiene abierto
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextApellidos;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextNombres;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel msj01;
    // End of variables declaration//GEN-END:variables
}
