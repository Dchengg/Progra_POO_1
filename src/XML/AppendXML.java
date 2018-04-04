package XML;

import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

import aplicacion.Cliente;

import javax.xml.parsers.*;


public class AppendXML {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/XML/archivo.xml");
		Element root = document.getDocumentElement();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Diego Cheng","diegocheng1973@gmail.com"));
		for(Cliente cliente : clientes) {
			Element newCliente = document.createElement("Cliente");
			
		}
		
	}
}
