package acocachosaprendi.gui;

import acocachosaprendi.clases.tipodocumento;
import acocachosaprendi.implementaciones.impltipodocumento;
import acocachosaprendi.interfases.Itipodocumento;
import javax.swing.JOptionPane;

public class frmtipodocumento extends javax.swing.JFrame {
    
    Itipodocumento tipodocumento=new impltipodocumento();
    private int cod=0;
    private String nom="";
    private boolean est=false;
    tipodocumento obj=new tipodocumento();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmtipodocumento.class.getName());
    
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

    public frmtipodocumento() {
        initComponents();
        this.setLocationRelativeTo(null);
        tipodocumento.findAllCustom(jtbtipodocumento);
        Bloquear();
        SoloLectura();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkest = new javax.swing.JCheckBox();
        btnnuevo = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnhabilitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbtipodocumento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento de Tipo de Documento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, -1, -1));
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 66, 71, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 118, -1, -1));
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 122, 71, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 174, -1, -1));

        chkest.setText("Habilitado");
        getContentPane().add(chkest, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 179, -1, -1));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(this::btnnuevoActionPerformed);
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 233, -1, -1));

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(this::btnregistrarActionPerformed);
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 233, -1, -1));

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(this::btnactualizarActionPerformed);
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 233, -1, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(this::btneliminarActionPerformed);
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 233, -1, -1));

        btnhabilitar.setText("Habilitar");
        getContentPane().add(btnhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 233, -1, -1));

        jtbtipodocumento.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbtipodocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbtipodocumentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbtipodocumento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 272, 869, 332));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        Desbloquear();
        txtcod.setText(""+tipodocumento.GenerarCodigo());
        txtnom.requestFocus();
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        if(txtnom.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingresa el nombre");
            txtnom.requestFocus();
        }else{
            cod=Integer.parseInt(txtcod.getText());
            nom=txtnom.getText();
            est=chkest.isSelected();
            obj.setCodigo(cod);
            obj.setNombre(nom);
            obj.setEstado(est);
            boolean res=tipodocumento.add(obj);
            if(res==true){
                JOptionPane.showMessageDialog(null, "Se registro el tipo de documento ");
                Limpiar();
                Bloquear();
                tipodocumento.findAllCustom(jtbtipodocumento);
                btnnuevo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo registrar el documento");
            }
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void jtbtipodocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtipodocumentoMouseClicked
        if(evt.getButton()==1){
            Desbloquear();
            btnregistrar.setEnabled(false);
            int fila=jtbtipodocumento.getSelectedRow();
            txtcod.setText(jtbtipodocumento.getValueAt(fila,0).toString());
            txtnom.setText(jtbtipodocumento.getValueAt(fila,1).toString());
            if(jtbtipodocumento.getValueAt(fila,2).toString().equals("Habilitado")){
                chkest.setSelected(true);
            }else{
                chkest.setSelected(false);
            }
        }
    }//GEN-LAST:event_jtbtipodocumentoMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        nom=txtnom.getText();
        est=chkest.isSelected();
        obj.setCodigo(cod);
        obj.setNombre(nom);
        obj.setEstado(est);
        boolean res=tipodocumento.update(obj);
        if(res==true){
            JOptionPane.showMessageDialog(null,"Se actualizo el tipo de documento");
            Limpiar();
            Bloquear();
            tipodocumento.findAllCustom(jtbtipodocumento);
            btnnuevo.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el documento");
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       cod=Integer.parseInt(txtcod.getText());
        nom=txtnom.getText();
        est=chkest.isSelected();
        obj.setCodigo(cod);
        obj.setNombre(nom);
        obj.setEstado(est);
        boolean res=tipodocumento.delete(obj);
        if(res==true){
            JOptionPane.showMessageDialog(null,"Se actualizo el tipo de documento");
            Limpiar();
            Bloquear();
            tipodocumento.findAllCustom(jtbtipodocumento);
            btnnuevo.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el documento");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    
    
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
        java.awt.EventQueue.invokeLater(() -> new frmtipodocumento().setVisible(true));
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
    private javax.swing.JTable jtbtipodocumento;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
