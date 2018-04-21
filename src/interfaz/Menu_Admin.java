/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Administrador;
import aplicacion.Cliente;
import aplicacion.Soporte;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Diego
 */
public class Menu_Admin extends javax.swing.JFrame {

    private Administrador admin;
    private ArrayList<Cliente> clientes;
    private ArrayList<Soporte> soportes;
    /**
     * Creates new form Menu_Admin
     */
    public Menu_Admin(Administrador pAdmin,ArrayList<Cliente> pClientes,ArrayList<Soporte>pSoportes) {
        initComponents();
        admin = pAdmin;
        clientes = pClientes;
        soportes = pSoportes;
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido");

        jButton1.setText("Crear cuenta de Soporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Show chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addGap(50, 50, 50)
                .addComponent(jButton2)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NuevoSoporteUI nuevoSoporte = new NuevoSoporteUI(admin);
        nuevoSoporte.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DashBoard dashboard = new DashBoard(admin);
        dashboard.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    /*private static PieDataset createDateSet(ArrayList<Paquete> paquetes){
        DefaultPieDataset dataset = new DefaultPieDataset();
        ArrayList<Paquete> paquetesGlobales = new ArrayList<Paquete>();
        for(Cliente cliente:clientes){
            
        }
        
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
