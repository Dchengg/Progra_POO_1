/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Paquete;
import aplicacion.Soporte;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class PaquetesGlobalesUI extends javax.swing.JFrame {

    /**
     * Creates new form PaquetesGlobalesUI
     * @param pSoporte
     */
    public PaquetesGlobalesUI(Soporte pSoporte) {
        initComponents();
        setTitle("Package Notifier");
        setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-box-24.png")).getImage());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel()  ;
        ArrayList<Paquete> paquetes = pSoporte.listaPaquetes();
        for(Paquete paquete:paquetes){
            String ID = paquete.getTrackingID();
            String tienda = paquete.getTienda();
            String courier = paquete.getCourier();
            String valor = String.valueOf(paquete.getValor());
            String peso = String.valueOf(paquete.getPeso());
            String descripcion = paquete.getDescripcion();
            String estado = paquete.getEstado().getDescripcion();
            String categoria = paquete.getCategoria();
            String dueno = paquete.getDueno().getNombre();
            Object[] row = {ID,descripcion,tienda,categoria,valor,peso,courier,estado,dueno};   
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ID", "Descripción", "Tienda", "Categoria", "Valor", "Peso", "Courier", "Estado", "Dueño"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
