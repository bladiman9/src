
package Files;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.*;

public class FrmBalón extends javax.swing.JFrame {
DefaultTableModel ModeloTabla;
static ResultSet res;
int cont;


    public FrmBalón() {
        this.setLocationRelativeTo(null);
        DefaultTableModel ModeloTabla;
        initComponents();        
        cargarBalon();
    }

public void cargarBalon(){
        DefaultTableModel modelo = (DefaultTableModel) jTableBalon.getModel();
        modelo.setRowCount(0);
        res = ConexionBD.Consulta("select id_producto, tipo_balon, unidad_media, precio from producto order by id_producto ");
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                modelo.addRow(v);
                jTableBalon.setModel(modelo);
            }
        }catch (SQLException e){
        }
} 
    
   
public void modifica(){
try{
                PreparedStatement mod = ConexionBD.getConexion().prepareStatement("update producto set tipo_balon='" + 
                txtTipo.getText() + "', unidad_media='" + txtum.getText() + "', precio='" + txtPrecio.getText() + 
                "' where id_producto='" + txtIDBalon.getText() + "'");
                mod.executeUpdate();
                JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                txtIDBalon.setText("");
                txtTipo.setText("");
                txtum.setText("");
                txtPrecio.setText("");
                txtIDBalon.requestFocus();
                txtTipo.requestFocus();
                txtum.requestFocus();
                txtPrecio.requestFocus();
        }catch(SQLException e){
        }
}



public void consulta_ba(){
if(txtIDBalon.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese bien el código de balón", "Error", JOptionPane.ERROR_MESSAGE);
            txtIDBalon.setText("");
            txtIDBalon.requestFocus();
        } else {
            try {
                String balon;
                Procdimiento_Balon.Buscar_balon(Integer.parseInt(txtIDBalon.getText()));
                balon = txtIDBalon.getText();
                txtIDBalon.setText("");
                txtTipo.setText("");
                txtum.setText("");
                txtPrecio.setText("");
                txtIDBalon.requestFocus();
                txtTipo.requestFocus();
                txtum.requestFocus();
                txtPrecio.requestFocus();
                res = ConexionBD.Consulta("select id_producto, tipo_balon, unidad_media, precio from producto");
                while(res.next()){
                    if(res.getString(1).equals(balon)){
                        JOptionPane.showMessageDialog(null, "Datos encontrados");
                        txtIDBalon.setText(res.getString(1));
                        txtTipo.setText(res.getString(2));
                        txtum.setText(res.getString(3));
                        txtPrecio.setText(res.getString(4));
                    }
                    else JOptionPane.showMessageDialog(null, "Información no encontrada");
                }
                
            }catch(SQLException e){
            }
        }

}

public void eliminar(){
     int row = jTableBalon.getSelectedRow();
        int opc = JOptionPane.showConfirmDialog(this, "Está seguro de desear eliminar el registro?","Pregunta",
                  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            try{
                Procdimiento_Balon.Eliminar_balon(Integer.parseInt(jTableBalon.getValueAt(row, 0).toString()));
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

        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIDBalon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBalon = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtum = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tipo de balón:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        txtIDBalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBalonActionPerformed(evt);
            }
        });
        getContentPane().add(txtIDBalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 130, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Precio:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 51));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, 30));

        btnModifica.setBackground(new java.awt.Color(0, 0, 51));
        btnModifica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModifica.setForeground(new java.awt.Color(255, 255, 255));
        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 100, 30));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 51));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 100, 30));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 130, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("ID_Balón:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jTableBalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID_Balón", "Tipo de Balón", "Unidad Media", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBalon);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 460, 90));

        btnRegresar.setBackground(new java.awt.Color(0, 0, 51));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 100, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("Gestión de precios de Balones");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AloGas.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Unidad Media:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtumActionPerformed(evt);
            }
        });
        getContentPane().add(txtum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 20));

        btnActualizar.setBackground(new java.awt.Color(0, 0, 51));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtIDBalon.getText().isEmpty() || txtTipo.getText().isEmpty() || txtum.getText().isEmpty()
            || txtPrecio.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Ingrese de nuevo sus datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            txtIDBalon.setText("");
            txtTipo.setText("");
            txtum.setText("");
            txtPrecio.setText("");      
            txtIDBalon.requestFocus();
            txtTipo.requestFocus();
            txtum.requestFocus();
            txtPrecio.requestFocus();
        } else {
            try {
                res = ConexionBD.Consulta("Select id_producto, tipo_balon, unidad_media, precio from producto where id_producto='" +
                        txtIDBalon.getText() + "'");
                try{
                    while(res.next()){
                        cont = res.getInt(1);
                    }
                }catch (SQLException  e){
                }
                if(cont >= 1){
                    JOptionPane.showMessageDialog(this, "Ya existe información con el mismo ID del balón" , "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Procdimiento_Balon.Entrada_balon(txtIDBalon.getText(), txtTipo.getText(), txtum.getText(),txtPrecio.getText());
                    txtIDBalon.setText("");
                    txtTipo.setText("");
                    txtum.setText("");
                    txtPrecio.setText(""); 
                    txtIDBalon.requestFocus();
                    txtTipo.requestFocus();
                    txtum.requestFocus();
                    txtPrecio.requestFocus(); 
                    JOptionPane.showMessageDialog(this, "Registro exitoso");
                }
            }catch (SQLException e){
            }
        }                     
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        modifica();
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consulta_ba();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu menu=new FrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtIDBalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBalonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBalonActionPerformed

    private void txtumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtumActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarBalon();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBalón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBalón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBalón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBalón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalón().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBalon;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtIDBalon;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtum;
    // End of variables declaration//GEN-END:variables
}
