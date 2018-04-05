package aplicacion;

import email.AplEmail;

import java.util.ArrayList;

import XML.ClienteXML;

public class App {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void main(String[] args) {
		//AplEmail.init();
		ClienteXML lector = new ClienteXML(clientes,"src/XML/Usuarios");
	}

	private void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	
	
}
