/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Diego
 */
import aplicacion.Administrador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
 
public class GraficoCircular extends JPanel{
   
   
   public GraficoCircular(Map<String,String> pDatos,String titulo,String borde){
      JFreeChart chart = crearGrafico(crearDataset( pDatos),titulo ); 
      ChartPanel cp = new ChartPanel(chart);
      JPanel subPanel = new JPanel(new BorderLayout());   
      subPanel.setBorder(BorderFactory.createTitledBorder(titulo));
      subPanel.setPreferredSize(new Dimension(400, 200));    
      subPanel.add(cp);
      add(subPanel,BorderLayout.CENTER);
      validate();
   }
   
   private PieDataset crearDataset(Map<String,String> datos) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      for(String name: datos.keySet()){
          dataset.setValue(name, Integer.parseInt(datos.get(name)));
      }
      return dataset;         
   }
   
   private JFreeChart crearGrafico( PieDataset dataset,String titulo ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         titulo ,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      return chart;
   }
}
