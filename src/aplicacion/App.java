package aplicacion;

import email.AplEmail;

import java.util.ArrayList;
import java.util.Scanner;


import XML.ClienteXML;
import XML.Writer;

public class App {
	
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ClienteXML lector = new ClienteXML(clientes,"src/XML/Usuarios.xml");
		lector.leerArchivo();
		Cliente clientenuevo = new Cliente("Mario Hidalgo", "jeje@gmail.com	", "moravia", "666", "5/6/7",true, "sumadre", true, "a222");
		//AplEmail.init(clientes);
		clientes.add(clientenuevo);
		for(Cliente cliente:clientes) {
			System.out.println(cliente.toString());
		}
		Writer escritor = new Writer(clientes,"src/XML/Usuarios.xml" );
		escritor.escribirArchivo();
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
//		String msg;
		//CloseShieldInputStream stream = new CloseShieldInputStream(System.in);
		Scanner reader = new Scanner(System.in);
		String msg = "";
		msg = "Bienvenido a Package Notifier"+ "\n";
		msg += "LOG IN"+ "\n";
		msg += "ID : " ;
		System.out.println(msg);
		String id = reader.nextLine();
		System.out.print("Contraseña: ");
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

