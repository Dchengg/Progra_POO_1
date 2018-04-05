package aplicacion;

import email.AplEmail;

import java.util.ArrayList;

import XML.ClienteXML;

public class App {
	
	
	public static void main(String[] args) {
		//AplEmail.init();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ClienteXML lector = new ClienteXML(clientes,"src/XML/Usuarios.xml");
		lector.leerArchivo();
		for(Cliente cliente:clientes) {
			System.out.println(cliente.toString());
		}
	}


	
	
	
}
