/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Cliente;

/**
 *
 * @author Diego
 */
public class PerfilUsuarioUI extends javax.swing.JFrame {

    private Cliente cliente;
    /**
     * Creates new form PerfilUsuarioUI
     */
    public PerfilUsuarioUI(Cliente pCliente) {
        initComponents();
        setCliente(pCliente);
        nombreLabel.setText(cliente.getNombre());
        dirLabel.setText(cliente.getDireccion());
        numLabel.setText(cliente.getNumTel());
        emailLabel.setText(cliente.getEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        dirLabel = new javax.swing.JLabel();
        numLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        notificacionesToggleButton = new javax.swing.JToggleButton();
        cambiarContraButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 374));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(115, 137, 167));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel6.setText("Perfil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dirección");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número Telefonico");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Recibir Notificaciones de mis paquetes a mi correo");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo");

        nombreLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        dirLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        numLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        emailLabel.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        notificacionesToggleButton.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        notificacionesToggleButton.setText("No");
        notificacionesToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificacionesToggleButtonActionPerformed(evt);
            }
        });

        cambiarContraButton.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        cambiarContraButton.setText("Cambiar Contraseña");
        cambiarContraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContraButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(notificacionesToggleButton))
                            .addComponent(cambiarContraButton))
                        .addGap(0, 151, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dirLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(numLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(notificacionesToggleButton))
                .addGap(18, 18, 18)
                .addComponent(cambiarContraButton)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notificacionesToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificacionesToggleButtonActionPerformed
        if(notificacionesToggleButton.isSelected()){
            notificacionesToggleButton.setText("Si");
            cliente.setNotificaciones(true);
        }else{
            notificacionesToggleButton.setText("No");
            cliente.setNotificaciones(false);
        }
    }//GEN-LAST:event_notificacionesToggleButtonActionPerformed

    private void cambiarContraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContraButtonActionPerformed
        CambiarContraUI cambiar = new CambiarContraUI(cliente);
        cambiar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cambiarContraButtonActionPerformed

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarContraButton;
    private javax.swing.JLabel dirLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JToggleButton notificacionesToggleButton;
    private javax.swing.JLabel numLabel;
    // End of variables declaration//GEN-END:variables
}
