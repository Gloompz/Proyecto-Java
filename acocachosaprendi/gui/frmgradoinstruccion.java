package acocachosaprendi.gui;

import acocachosaprendi.clases.gradoinstruccion;
import acocachosaprendi.implementaciones.implgradoinstruccion;
import acocachosaprendi.interfases.Igradoinstruccion;
import javax.swing.JOptionPane;

public class frmgradoinstruccion extends javax.swing.JFrame {
    
    Igradoinstruccion gradoinstruccion=new implgradoinstruccion();
    private int cod=0;
    private String nom="";
    private boolean est=false;
    gradoinstruccion obj=new gradoinstruccion(); 

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmgradoinstruccion.class.getName());

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
    
    public frmgradoinstruccion() {
        initComponents();
        this.setLocationRelativeTo(null);
        gradoinstruccion.findAllCustom(jtbgradoinstruccion);
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
        txtnom = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnhabilitado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbgradoinstruccion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtcod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento de Grado Instruccion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 113, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, -1, -1));

        chkest.setText("Habilitar");
        getContentPane().add(chkest, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 171, -1, -1));
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 113, 90, -1));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 235, -1, -1));

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 235, -1, -1));

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 235, -1, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 235, -1, -1));

        btnhabilitado.setText("Habilitado");
        getContentPane().add(btnhabilitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 235, -1, -1));

        jtbgradoinstruccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbgradoinstruccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbgradoinstruccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbgradoinstruccion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 276, 775, 496));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(698, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        Desbloquear();
        //agregamos el codigo
        txtcod.setText(""+gradoinstruccion.GenerarCodigo());
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
            boolean res=gradoinstruccion.add(obj);
            //evaluamos el registro
            if(res==true){
                JOptionPane.showMessageDialog(null, "Se registro el grado instruccion");
                Limpiar();
                Bloquear();
                gradoinstruccion.findAllCustom(jtbgradoinstruccion);
                btnnuevo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo registrar el grado instruccion"); 
            }
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void jtbgradoinstruccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbgradoinstruccionMouseClicked
        if(evt.getButton()==1){
            Desbloquear();
            btnregistrar.setEnabled(false);
            //capturamos la fila seleccionada
            int fila=jtbgradoinstruccion.getSelectedRow();
            txtcod.setText(jtbgradoinstruccion.getValueAt(fila, 0).toString());
            txtnom.setText(jtbgradoinstruccion.getValueAt(fila, 1).toString());
            if(jtbgradoinstruccion.getValueAt(fila, 2).toString().equals("Habilitado")){
                chkest.setSelected(true);
            }else{
                chkest.setSelected(false);
            }
        }
    }//GEN-LAST:event_jtbgradoinstruccionMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
            cod=Integer.parseInt(txtcod.getText());
            nom=txtnom.getText();
            est=chkest.isSelected();
            //enviamos los datos hacia el objeto
            obj.setCodigo(cod);
            obj.setNombre(nom);
            obj.setEstado(est);
            //realizamos el registro
            boolean res=gradoinstruccion.update(obj);
            //evaluamos el registro
            if(res==true){
                JOptionPane.showMessageDialog(null, "Se actualizo el grado instruccion");
                Limpiar();
                Bloquear();
                gradoinstruccion.findAllCustom(jtbgradoinstruccion);
                btnnuevo.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el grado instruccion");
        } 
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        //realizamos el registro
        boolean res=gradoinstruccion.delete(obj);
        //evaluamos el registro
        if(res==true){
            JOptionPane.showMessageDialog(null, "Se elimino el grado instruccion");
            Limpiar();
            Bloquear();
            gradoinstruccion.findAllCustom(jtbgradoinstruccion);
            btnnuevo.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el grado instruccion");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new frmgradoinstruccion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnhabilitado;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JCheckBox chkest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbgradoinstruccion;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
