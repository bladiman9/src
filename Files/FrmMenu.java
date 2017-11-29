
package Files;

import java.awt.Image;
import java.awt.Toolkit;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        this.setLocationRelativeTo(null);
        initComponents();
        
    }
    
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStock = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBalón = new javax.swing.JButton();
        imgBalón = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStock.setBackground(new java.awt.Color(0, 0, 102));
        btnStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStock.setForeground(new java.awt.Color(255, 255, 255));
        btnStock.setText("Consultar Stock");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, 30));

        btnSalir.setBackground(new java.awt.Color(0, 0, 102));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 80, 20));

        btnCliente.setBackground(new java.awt.Color(0, 0, 102));
        btnCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 160, 20));

        btnVenta.setBackground(new java.awt.Color(0, 0, 102));
        btnVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setText("Ventas");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 160, 20));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        btnBalón.setBackground(new java.awt.Color(0, 0, 102));
        btnBalón.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBalón.setForeground(new java.awt.Color(255, 255, 255));
        btnBalón.setText("Precios de Balón");
        btnBalón.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalónActionPerformed(evt);
            }
        });
        getContentPane().add(btnBalón, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 160, -1));

        imgBalón.setEnabled(false);
        getContentPane().add(imgBalón, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\RUBIO\\Desktop\\Alogas\\AloGas\\InterfazHotelCielo\\build\\classes\\Imagenes\\AloGas.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setEnabled(false);
        jToggleButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 380));

        setSize(new java.awt.Dimension(428, 405));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        FrmCliente c= new FrmCliente();
        c.setVisible(true);  //mantiene abierto
        this.dispose();//cierra a esta clase   
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        FrmStock s= new FrmStock();
        s.setVisible(true);  //mantiene abierto
        this.dispose();//cierra a esta clase
        
    }//GEN-LAST:event_btnStockActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        FrmVen vn= new FrmVen();
        vn.setVisible(true);  //mantiene abierto
        this.dispose();//cierra a esta clase
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnBalónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalónActionPerformed
       FrmBalón ba= new FrmBalón();
        ba.setVisible(true);  //mantiene abierto
        this.dispose();//cierra a esta clase
    }//GEN-LAST:event_btnBalónActionPerformed

    public Image getIconImage() {
Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/AloGas.jpg"));
return retValue;
} 
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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalón;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel imgBalón;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
