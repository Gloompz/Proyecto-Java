package acocachosaprendi.gui;

import acocachosaprendi.clases.curso;
import acocachosaprendi.implementaciones.implcurso;
import acocachosaprendi.interfases.Icurso;
import javax.swing.JOptionPane;

public class frmcurso extends javax.swing.JFrame {
    
    Icurso curso=new implcurso();
    //declaramos variables
    private int cod=0;
    private String nom="";
    private boolean est=false;
    //creamos un objeto de la clase TipoDocumento
    curso obj=new curso();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmcurso.class.getName());


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
    
    public frmcurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        curso.findAllCustom(jtbcurso);
        Bloquear();
        SoloLectura();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkest = new javax.swing.JCheckBox();
        btnnuevo = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnhabilitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcurso = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mantenimiento de Curso");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 122, -1, -1));
        getContentPane().add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 62, 100, -1));
        getContentPane().add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 122, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 183, -1, -1));

        chkest.setText("Habilitado");
        getContentPane().add(chkest, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 184, -1, -1));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 245, -1, -1));

        btnregistrar.setText("Registrar");
        btnregistrar.setToolTipText("");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 245, -1, -1));

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 245, -1, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 245, -1, -1));

        btnhabilitar.setText("Habilitado");
        getContentPane().add(btnhabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 245, -1, -1));

        jtbcurso.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbcurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbcursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbcurso);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 755, 465));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        Desbloquear();
        //agregamos el codigo
        txtcod.setText(""+curso.GenerarCodigo());
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
        boolean res=curso.add(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se registro el curso");
        Limpiar();
        Bloquear();
        curso.findAllCustom(jtbcurso);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo registrar el curso"); 
        }
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void jtbcursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbcursoMouseClicked
        if(evt.getButton()==1){
        Desbloquear();
        btnregistrar.setEnabled(false);
        //capturamos la fila seleccionada
        int fila=jtbcurso.getSelectedRow();
        txtcod.setText(jtbcurso.getValueAt(fila, 0).toString());
        txtnom.setText(jtbcurso.getValueAt(fila, 1).toString());
        if(jtbcurso.getValueAt(fila, 2).toString().equals("Habilitado")){
        chkest.setSelected(true);
        }else{
        chkest.setSelected(false);
        }
        }
    }//GEN-LAST:event_jtbcursoMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        nom=txtnom.getText();
        est=chkest.isSelected();
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        obj.setNombre(nom);
        obj.setEstado(est);
        //realizamos el registro
        boolean res=curso.update(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se actualizo el curso");
        Limpiar();
        Bloquear();
        curso.findAllCustom(jtbcurso);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo actualizar el curso");
        } 
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        cod=Integer.parseInt(txtcod.getText());
        //enviamos los datos hacia el objeto
        obj.setCodigo(cod);
        //realizamos el registro
        boolean res=curso.delete(obj);
        //evaluamos el registro
        if(res==true){
        JOptionPane.showMessageDialog(null, "Se elimino el curso");
        Limpiar();
        Bloquear();
        curso.findAllCustom(jtbcurso);
        btnnuevo.setEnabled(true);
        }else{
        JOptionPane.showMessageDialog(null, "No se pudo eliminar el curso");
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
        java.awt.EventQueue.invokeLater(() -> new frmcurso().setVisible(true));
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
    private javax.swing.JTable jtbcurso;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtnom;
    // End of variables declaration//GEN-END:variables
}
