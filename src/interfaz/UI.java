/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aplicacion.Cliente;
import aplicacion.Soporte;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class UI {
    
    public static void init(ArrayList<Cliente> clientes, ArrayList<Soporte> soportes){
        Log_in_UI loginUI = new Log_in_UI(clientes);
        loginUI.setVisible(true);
    }
}
