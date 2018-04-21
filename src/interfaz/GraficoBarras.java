/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Diego
 */
public class GraficoBarras extends JPanel{
    
    public GraficoBarras(Map<String,String> datos,String titulo){
        JFreeChart chart = crearGrafico(crearDataset(datos),titulo);
        ChartPanel cp = new ChartPanel(chart);
        JPanel subPanel = new JPanel(new BorderLayout());   
        subPanel.setBorder(BorderFactory.createTitledBorder(titulo));
        subPanel.setPreferredSize(new Dimension(400, 200));    
        subPanel.add(cp);
        add(subPanel,BorderLayout.CENTER);
        validate();
        
    }
    
    private JFreeChart crearGrafico(CategoryDataset dataset,String titulo){
       JFreeChart barChart = ChartFactory.createBarChart(
         titulo,           
         "Category",            
         "Score",            
         dataset,          
         PlotOrientation.VERTICAL,           
         true, true, false);
       return barChart;
    }
    
    private CategoryDataset crearDataset(Map<String,String> datos){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String name:datos.keySet()){
            dataset.addValue(Integer.parseInt(datos.get(name)),name,"Categoria");
        }
        return dataset;
    }
}
