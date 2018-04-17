package aplicacion;

import email.AplEmail;

import java.util.ArrayList;
import java.util.Scanner;


import XML.ClienteXML;
import XML.Writer;
import interfaz.Log_in_UI;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegramBot.PackageNotifierBot;

public class App {
	

	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                ArrayList<Soporte> soportes = new ArrayList<Soporte>();
		ClienteXML lector = new ClienteXML(clientes,soportes, "src/XML/Usuarios.xml");
		lector.leerArchivo();
		//AplEmail.init(clientes);
		/*ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();
		try {
                    botsApi.registerBot(new PackageNotifierBot(clientes));
	        }catch(TelegramApiException e) {
                    e.printStackTrace();
                }*/
		for(Cliente cliente:clientes) {
			System.out.println(cliente.toString());
		}
		
		for(Cliente cliente:clientes) {
			System.out.println(cliente.toString());
		}
                /*Writer escritor = new Writer(clientes,soportes, "src/XML/Usuarios.xml" );
		escritor.escribirArchivo();*/
		Log_in_UI loginUI = new Log_in_UI();
                //loginUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginUI.setVisible(true);
                
	}
	
	private static boolean menuLogIn(ArrayList<Cliente> clientes) {
		String msg;
		//CloseShieldInputStream stream = new CloseShieldInputStream(System.in);
		Scanner reader = new Scanner(System.in);
		msg = "Bienvenido a Package Notifier"+ "\n";
		msg += "LOG IN"+ "\n";
		msg += "ID : " ;
		System.out.println(msg);
		String id = reader.nextLine();
		System.out.print("Contrase�a: ");
		String contra = reader.nextLine();
		System.out.println("");
		for(Cliente cliente:clientes) {
			if(cliente.logIn(id,contra)){
				//reader.close();
				return true;
			}
		}
		//reader.close();
		return false;
		
	}


	
	
	
}
