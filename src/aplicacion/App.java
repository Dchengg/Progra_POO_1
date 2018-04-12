package aplicacion;

import email.AplEmail;

import java.util.ArrayList;
import java.util.Scanner;


import XML.ClienteXML;

public class App {
	
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ClienteXML lector = new ClienteXML(clientes,"src/XML/Usuarios.xml");
		lector.leerArchivo();
		AplEmail.init(clientes);
		for(Cliente cliente:clientes) {
			System.out.println(cliente.toString());
		}
		while(true) {
			if(menuLogIn(clientes)) {
				System.out.println("We are in!!!");
				for(Cliente cliente:clientes) {
					System.out.println(cliente.toString());
				}
			}
		}
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
		System.out.print("Contraseña: ");
		String contra = reader.nextLine();
		//System.out.println("");
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
