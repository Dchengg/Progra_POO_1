package aplicacion;

import email.AplEmail;

import java.util.ArrayList;


import XML.ClienteXML;
import XML.Writer;
import XML.EstadosWriter;
import XML.EstadosXML;
import interfaz.UI;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegramBot.PackageNotifierBot;

/**
 * En esta clase se cargan los datos base
 * @author Diego
 */

public class App {
	
 /**
        * Se cargan todos los datos de los XML en listas
        */
	
	public static void main(String[] args) {
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            ArrayList<Soporte> soportes = new ArrayList<Soporte>();
            ArrayList<Estado> EstadosN = new ArrayList<Estado>();
            EstadosXML lectorEstados = new EstadosXML(EstadosN,"src/XML/Estados.xml" );
            lectorEstados.leerArchivo();
            Soporte.setClientes(clientes);
            Paquete.setEstados(EstadosN);
            Administrador admin = new Administrador();
            Administrador.setClientes(clientes);
            Administrador.setSoportes(soportes);
            //clientes.add(new Cliente("Diego Cheng","diegocheng1973@gmail.com","Santa ana","86564739","31/3/99",true,"contra",false,"a213"));
            //soportes.add(new Soporte("Marco","marcorules","marco@gmail.com"));
            ClienteXML lector = new ClienteXML(clientes,soportes, "src/XML/Usuarios.xml");
            lector.leerArchivo();

            AplEmail.init(clientes);
           
            
            
            ApiContextInitializer.init();
            TelegramBotsApi botsApi = new TelegramBotsApi();
            try {
                botsApi.registerBot(new PackageNotifierBot(clientes));
            }catch(TelegramApiException e) {
                e.printStackTrace();
            }
            UI.init(clientes, soportes,admin);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                public void run() {
                    Writer escritor = new Writer(clientes,soportes, "src/XML/Usuarios.xml" );
                    escritor.escribirArchivo();
                }
            }, "Shutdown-thread"));
                
	}
	
}
