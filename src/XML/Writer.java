package XML;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

import aplicacion.Cliente;

import javax.xml.parsers.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Writer{
	public static void main(String[] args) {
		List<Cliente> list = new ArrayList<Cliente>();
		Cliente a = new Cliente("Diego Cheng", "diegocheng1973@gmail.com", "Santa ana","123","1/2/3",true,"contra",false,"a221");
		Cliente b = new Cliente("Luis Chavarraria","luisSeMamo@hotmail.com","San jose","3456","5/7/5",false,":p",false,"a231");
		Cliente c = new Cliente("Bruh","Pos@yahoo.com","brasil","6854","5/7/7",false,"password",true,"a999");
		list.add(a);
		list.add(b);
		list.add(c);
		String fileName = "src/infoClientes.xml";
		escribirArchivo(fileName,list);
	}
	private static void escribirArchivo(String XMLFile,List<Cliente> list) {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();
	        
	        Element root = doc.createElement("tables");
	        doc.appendChild(root);
	        
	        Element tabla = doc.createElement("tabla");
	        root.appendChild(tabla);
	        
	        
	        
	        for(Cliente cliente : list){
	        	Element campo = doc.createElement("campo");
		        tabla.appendChild(campo);
		        
	        	Element direccion = doc.createElement("dirrecion");
	        	direccion.appendChild(doc.createTextNode(cliente.getDirección()));
	        	campo.appendChild(direccion);
	        	
	        	Element numero = doc.createElement("numero");
	        	numero.appendChild(doc.createTextNode(cliente.getNumCasillero()));
	        	campo.appendChild(numero);
	        	
	        	Element fechaN = doc.createElement("fechaN");
	        	fechaN.appendChild(doc.createTextNode(cliente.getFechaDeNacimiento()));
	        	campo.appendChild(fechaN);
	        	
	        	Element perfil = doc.createElement("perfilC");
	        	if(cliente.isPerfilCompleto()) {
	        		perfil.appendChild(doc.createTextNode("true"));
	        	}else {
	        		perfil.appendChild(doc.createTextNode("false"));
	        	}
	        	campo.appendChild(perfil);
	     
	        	Element contraseña = doc.createElement("contrasena");
	        	contraseña.appendChild(doc.createTextNode(cliente.getContraseña()));
	        	campo.appendChild(contraseña);
	        	
	        	Element recibirN = doc.createElement("recibirN");
	        	if(cliente.isNotificaciones()) {
	        		recibirN.appendChild(doc.createTextNode("true"));
	        	}else {
	        		recibirN.appendChild(doc.createTextNode("false"));
	        	}
	        	
	        	campo.appendChild(recibirN);
	   
	        }
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();
	        
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        
	        DOMSource source = new DOMSource(doc);
	        try {
	            FileWriter fos = new FileWriter(XMLFile);
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
		}
		catch (TransformerException ex) {
	        System.out.println("Error outputting document");

	    } catch (ParserConfigurationException ex) {
	        System.out.println("Error building document");
		
	    }
	}
}
