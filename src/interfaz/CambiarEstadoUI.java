/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Estado;
import aplicacion.Paquete;
import aplicacion.Soporte;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class CambiarEstadoUI extends javax.swing.JFrame {

    private Soporte soporte;
    private Paquete paquete;
    
    /**
     * Creates new form CambiarEstadoUI
     */
    public CambiarEstadoUI(Soporte pSoporte) {
        initComponents();
        soporte = pSoporte;
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        valorTotalLabel.setVisible(false);
        
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
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        duenoLabel = new javax.swing.JLabel();
        tiendaLabel = new javax.swing.JLabel();
        courierLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        estadosComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        valorTotalLabel = new javax.swing.JLabel();
        verficarButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pesoField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cambiar estado de paquete");

        jLabel2.setText("ID del paquete : ");

        duenoLabel.setText("jLabel3");

        tiendaLabel.setText("jLabel4");

        courierLabel.setText("jLabel5");

        categoriaLabel.setText("jLabel6");

        descripcionLabel.setText("jLabel7");

        jLabel3.setText("Estado : ");

        estadosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosComboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar Estado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        valorTotalLabel.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(estadosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(valorTotalLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(categoriaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(duenoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tiendaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(courierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descripcionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(duenoLabel)
                .addGap(18, 18, 18)
                .addComponent(tiendaLabel)
                .addGap(18, 18, 18)
                .addComponent(courierLabel)
                .addGap(18, 18, 18)
                .addComponent(categoriaLabel)
                .addGap(18, 18, 18)
                .addComponent(descripcionLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(estadosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(valorTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        verficarButton.setText("Verificar ID Paquete");
        verficarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verficarButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Peso :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesoField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesoField))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(verficarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verficarButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verficarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verficarButtonActionPerformed
        String id = idField.getText();
        paquete = soporte.verificarPaquete(id);
        if(paquete != null){
            duenoLabel.setText("Dueño : " + paquete.getDueno().getNombre());
            tiendaLabel.setText("Tienda : " + paquete.getTienda());
            courierLabel.setText("Compañia Courier : " + paquete.getCourier());
            categoriaLabel.setText("Categoria : " + paquete.getCategoria());
            descripcionLabel.setText("Descripción : " + paquete.getDescripcion());
            valorTotalLabel.setText("Valor total : " + paquete.getValor());
            jPanel1.setVisible(true);
            ArrayList<Estado> estados = Paquete.getEstados();
            for(Estado estado:estados){
                estadosComboBox.addItem(estado.getDescripcion());
            }
        }else{
            JOptionPane.showMessageDialog(null,"El paquete con es id no existe,por favor ingrese un id valido", "Error",JOptionPane.ERROR_MESSAGE);                                           
        }
    }//GEN-LAST:event_verficarButtonActionPerformed

    private void estadosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosComboBoxActionPerformed
        String estado = estadosComboBox.getSelectedItem().toString();
        if(estado.equals("Recibido en Miami")){
            jPanel2.setVisible(true);
        }else{
            jPanel2.setVisible(false);
        }
    }//GEN-LAST:event_estadosComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tipo = estadosComboBox.getSelectedItem().toString();
        if(tipo.equals("Recibido en Miami")){
            String peso = pesoField.getText();
            if(!peso.equals("")){
                //try{
                    paquete.setPeso(Double.parseDouble(peso));
                    soporte.costoFinal(paquete);
                    valorTotalLabel.setText(String.valueOf(paquete.getValorTotal()));
                    valorTotalLabel.setVisible(true);
                    String estado = estadosComboBox.getSelectedItem().toString();
                    soporte.cambiarEstadoPaquete(paquete, estado);
                    
                /*}catch( Exception e ){
                    System.out.println("no entro");
                }*/
            }else{

            } 
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JLabel courierLabel;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JLabel duenoLabel;
    private javax.swing.JComboBox<String> estadosComboBox;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pesoField;
    private javax.swing.JLabel tiendaLabel;
    private javax.swing.JLabel valorTotalLabel;
    private javax.swing.JButton verficarButton;
    // End of variables declaration//GEN-END:variables
}
