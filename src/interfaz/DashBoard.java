/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Administrador;
import java.awt.BorderLayout;

/**
 *
 * @author Diego
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard(Administrador admin) {
        initComponents();
        setTitle("Package Notifier");
        setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-box-24.png")).getImage());
        GraficoCircular estados = new GraficoCircular(admin.getEstados(),"Estados de los paquetes","Estados");
        GraficoCircular tiendas = new GraficoCircular(admin.getTiendas(),"Tiendas más populares","Tiendas");
        GraficoBarras categorias = new GraficoBarras(admin.getCategorias(),"Categorias");
        GraficoBarras couriers = new GraficoBarras(admin.getCouriers(),"Compañias Courier");
        estados.setSize(400,300);
        estados.setLocation(0,0);
        tiendas.setSize(400,300);
        tiendas.setLocation(400,0);
        categorias.setSize(400,300);
        categorias.setLocation(0,300);
        couriers.setSize(400,300);
        couriers.setLocation(400,300);
        add(estados);
        add(tiendas);
        add(categorias);
        add(couriers);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
