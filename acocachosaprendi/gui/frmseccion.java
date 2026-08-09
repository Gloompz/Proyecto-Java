package acocachosaprendi.gui;

import acocachosaprendi.clases.seccion;
import acocachosaprendi.implementaciones.implseccion;
import acocachosaprendi.interfases.Iseccion;
import javax.swing.JOptionPane;

public class frmseccion extends javax.swing.JFrame {
    
    Iseccion seccion=new implseccion();
    //declaramos variables
    private int cod=0;
    private String nom="";
    private boolean est=false;
    //creamos un objeto de la clase TipoDocumento
    seccion obj=new seccion(); 

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmseccion.class.getName());

    private void Bloquear(){
        txtcod.setEnabled(false);
        txtnom.setEnabled(false);
        chkest.setEnabled(false);
        btnregistrar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
    }
    
    private void Desbloquear(){
        txtcod.setEnabled(true);
        txtnom.setEnabled(true);
        chkest.setEnabled(true);
        btnregistrar.setEnabled(true);
        btnactualizar.setEnabled(true);
        btneliminar.setEnabled(true);
    }
    
    private void SoloLectura(){
        txtcod.setEditable(false);
    }
    
    public void Limpiar(){
        txtcod.setText("");
        txtnom.setText("");
        chkest.setText("");
    }

    public frmseccion() {
        initComponents();
        this.setLocationRelativeTo(null);
        seccion.findAllCustom(jtbseccion);
        Bloquear();
        SoloLectura();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkest = new javax.swing.JCheckBox();
        btnnuevo = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnhabilitar = new javax.swing.JButton();
        txtnom = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbseccion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento de Seccion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 115, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 190, -1, -1));

        chkest.setText("Habilitado");
        getContentPane().add(chkest, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 191, -1, -1));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 251, -1, -1));

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 251, -1, -1));

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 251, -1, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 251, -1, -1));

        btnhabilitar.setText("Habilitado");
        getContentPane().add(btnhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 251, -1, -1));
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 115, 110, -1));
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 61, 110, -1));

        jtbseccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbseccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbseccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbseccion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 292, 737, 465));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        Desbloquear();
        //agregamos el codigo
        txtcod.setText(""+seccion.GenerarCodigo());
        //asignamos el foco al nombre
        txtnom.requestFocus();
        //bloqueamos el boton nuevo
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        if(txtnom.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Ingresa el nombre");
        txtnom.requestFocus();
        }else{
        //capturando valores
        cod=Integer.parseInt(txtcod.getText());
        nom=txtnom.getText();
        est=chkest.isSelected();
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        obj.setNombre(nom);
        obj.setEstado(est);
        //realizamos el registro
        boolean res=seccion.add(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se registro la seccion");
        Limpiar();
        Bloquear();
        seccion.findAllCustom(jtbseccion);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo registrar el documento"); 
        }
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void jtbseccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbseccionMouseClicked
        if(evt.getButton()==1){
        Desbloquear();
        btnregistrar.setEnabled(false);
        //capturamos la fila seleccionada
        int fila=jtbseccion.getSelectedRow();
        txtcod.setText(jtbseccion.getValueAt(fila, 0).toString());
        txtnom.setText(jtbseccion.getValueAt(fila, 1).toString());
        if(jtbseccion.getValueAt(fila, 2).toString().equals("Habilitado")){
        chkest.setSelected(true);
        }else{
        chkest.setSelected(false);
        }
        }
    }//GEN-LAST:event_jtbseccionMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        nom=txtnom.getText();
        est=chkest.isSelected();
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        obj.setNombre(nom);
        obj.setEstado(est);
        //realizamos el registro
        boolean res=seccion.update(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se actualizo la seccion");
        Limpiar();
        Bloquear();
        seccion.findAllCustom(jtbseccion);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo actualizar la seccion");
        } 
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        //realizamos el registro
        boolean res=seccion.delete(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se elimino el tipo de documento");
        Limpiar();
        Bloquear();
        seccion.findAllCustom(jtbseccion);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo eliminar el documento");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmseccion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnhabilitar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JCheckBox chkest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbseccion;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
