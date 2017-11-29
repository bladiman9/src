/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;
import static Files.FrmBalón.res;
import static Files.FrmCliente.res;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
/**
 *
 * @author RUBIO
 */
public class FrmVen extends javax.swing.JFrame {
DefaultTableModel ModeloTabla;
static ResultSet res;
int cont;
    /**
     * Creates new form FrmVen
     */
    public FrmVen() {
        this.setLocationRelativeTo(null);
        DefaultTableModel ModeloTabla;
        initComponents();        
        cargarVenta();
    }

    public void cargarVenta(){
        DefaultTableModel modelo = (DefaultTableModel) tablaventas.getModel();
        modelo.setRowCount(0);
        res = ConexionBD.Consulta("select cod_venta, tipo_balon, precio,nombres,direccion,fecha from venta order by cod_venta desc");
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                modelo.addRow(v);
                tablaventas.setModel(modelo);
            }
        }catch (SQLException e){
        }
} 
    
public void consulta_venta(){
if(txtVenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese bien el código de balón", "Error", JOptionPane.ERROR_MESSAGE);
            txtVenta.setText("");
            txtVenta.requestFocus();
        } else {
            try {
                String venta;
                Procdimiento_Venta.Buscar_venta(Integer.parseInt(txtVenta.getText()));
                venta = txtVenta.getText();
                txtVenta.setText("");
                txtDni.setText("");
                txtBalon.setText("");
                txtPrecio.setText("");
                txtnom.setText("");
                txtdir.setText("");
                txtVenta.requestFocus();
                txtDni.requestFocus();
                txtBalon.requestFocus();
                txtPrecio.requestFocus();
                txtnom.requestFocus();
                txtdir.requestFocus();
                res = ConexionBD.Consulta("select cod_venta, dni_cliente,tipo_balon,precio , nombres ,direccion   from venta");
                while(res.next()){
                    if(res.getString(1).equals(venta)){
                        JOptionPane.showMessageDialog(null, "Datos encontrados");
                        txtVenta.setText(res.getString(1));
                        txtDni.setText(res.getString(2)); 
                        txtBalon.setText(res.getString(3));
                        txtPrecio.setText(res.getString(4));                        
                         txtnom.setText(res.getString(5));
                        txtdir.setText(res.getString(6));
                    }
                    else JOptionPane.showMessageDialog(null, "Información no encontrada");
                }
                
            }catch(SQLException e){
            }
        }

}    
    
    
    
    
    public void eliminar(){
     int row = tablaventas.getSelectedRow();
        int opc = JOptionPane.showConfirmDialog(this, "Está seguro de desear eliminar el registro?","Pregunta",
                  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            try{
                Procdimiento_Venta.Eliminar_venta(Integer.parseInt(tablaventas.getValueAt(row, 0).toString()));
            }catch (SQLException e){
            }
        }
        
}
    public Image getIconImage() {
Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/AloGas.jpg"));
return retValue;
} 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtVenta = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnBuscarVenta = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        btnBuscaDni = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtBalon = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("N° de Venta: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de Balón: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Precio:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Nombres del Cliente: ");

        btnModificar.setBackground(new java.awt.Color(0, 0, 102));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("N° de DNI: ");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        btnBuscarVenta.setBackground(new java.awt.Color(0, 0, 102));
        btnBuscarVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarVenta.setText("Buscar");
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        btnRegistar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistar.setText("Registrar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° de Venta", "Tipo de Balón", "Precio", "Nombres", "Dirección", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablaventas);

        btnBuscaDni.setBackground(new java.awt.Color(0, 0, 102));
        btnBuscaDni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscaDni.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscaDni.setText("Buscar");
        btnBuscaDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaDniActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Gestión de Ventas:");

        btnEliminar.setBackground(new java.awt.Color(8, 10, 106));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AloGas.jpg"))); // NOI18N

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        txtBalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Dirección:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel3)
                            .addGap(37, 37, 37)
                            .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel8)
                            .addGap(3, 3, 3)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel5)
                            .addGap(50, 50, 50)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnBuscaDni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2)
                            .addGap(83, 83, 83)
                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBalon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2))
                            .addGap(19, 19, 19)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(560, 560, 560)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)))
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarVenta)
                        .addComponent(jLabel8)
                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscaDni)
                        .addComponent(jLabel2)
                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel6)
                            .addGap(23, 23, 23)
                            .addComponent(jLabel10)
                            .addGap(53, 53, 53)
                            .addComponent(btnRegistar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtBalon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(90, 90, 90)
                            .addComponent(btnModificar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(97, 97, 97)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(btnEliminar)))
                    .addGap(73, 73, 73)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(698, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      try{
                PreparedStatement mod = ConexionBD.getConexion().prepareStatement("update venta set tipo_balon='" + 
                txtBalon.getText() + "', precio='" + txtPrecio.getText() + "', nombres='" + txtnom.getText() + 
                "', direccion='" + txtdir.getText() + "' where cod_venta='" + txtVenta.getText() + "'");
                mod.executeUpdate();
                JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                txtVenta.setText("");
                txtBalon.setText("");
                txtPrecio.setText("");
                txtnom.setText("");
                txtdir.setText("");
                txtVenta.requestFocus();
                txtBalon.requestFocus();
                txtPrecio.requestFocus();
                txtnom.requestFocus();
                txtdir.requestFocus();
        }catch(SQLException e){
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmMenu menu=new FrmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        consulta_venta();
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        if(txtDni.getText().isEmpty() || txtBalon.getText().isEmpty()
            || txtPrecio.getText().isEmpty() ||txtnom.getText().isEmpty()
            || txtdir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese de nuevo sus datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            txtDni.setText("");
            txtnom.setText("");
            txtdir.setText("");
            txtBalon.setText("");
            txtPrecio.setText("");
            txtDni.requestFocus();
            txtnom.requestFocus();
            txtdir.requestFocus();
            txtBalon.requestFocus();
            txtPrecio.requestFocus();
        } else {
            try {
                res = ConexionBD.Consulta("Select dni_cliente, nombres ,direccion ,tipo_balon ,precio from venta"
                    + " where dni_cliente='" + txtDni.getText() + "'");
                try{
                    while(res.next()){
                        cont = res.getInt(1);
                    }
                }catch (SQLException  e){
                }
                if(cont >= 1){
                    JOptionPane.showMessageDialog(this, "Información ya existe" , "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Procdimiento_Venta.Entrada_venta( txtDni.getText(), txtnom.getText(),
                        txtdir.getText(), txtBalon.getText(),txtPrecio.getText());
                    txtDni.setText("");
                    txtnom.setText("");
                    txtdir.setText("");
                    txtBalon.setText("");
                    txtPrecio.setText("");
                    txtnom.requestFocus();
                    txtdir.requestFocus();
                    txtBalon.requestFocus();
                    txtPrecio.requestFocus();
                    JOptionPane.showMessageDialog(this, "Registro exitoso");
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage().toString());
            }
        }
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnBuscaDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaDniActionPerformed
            FrmDetalleCliente obj = new FrmDetalleCliente();
            obj.setVisible(true);
        
    }//GEN-LAST:event_btnBuscaDniActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtBalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarVenta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            FrmDetalleBalon obj = new FrmDetalleBalon();
            obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaDni;
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaventas;
    private javax.swing.JTextField txtBalon;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtVenta;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
