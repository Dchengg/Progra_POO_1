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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Writer{
	private ArrayList<Cliente> clientes;
	private String xmlFile;
	
	public Writer (ArrayList<Cliente> pClientes, String pXmlFile) {
		setClientes(pClientes);
		setXmlFile(pXmlFile);
	}
	
	public void escribirArchivo() {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();
	        
	        Element root = doc.createElement("tables");
	        doc.appendChild(root);
	        
	        Element tabla = doc.createElement("tabla");
	        tabla.setAttribute("Nombre", "Clientes");
	        root.appendChild(tabla);
	        
	        for(Cliente cliente : clientes){
	        	Element campo = doc.createElement("campo");
		        tabla.appendChild(campo);
		        
		        Element nombre = doc.createElement("nombre");
	        	nombre.appendChild(doc.createTextNode(cliente.getNombre()));
	        	campo.appendChild(nombre);
	        	
	        	Element correo = doc.createElement("email");
	        	correo.appendChild(doc.createTextNode(cliente.getEmail()));
	        	campo.appendChild(correo);
		        
	        	Element direccion = doc.createElement("dirrecion");
	        	direccion.appendChild(doc.createTextNode(cliente.getDirección()));
	        	campo.appendChild(direccion);
	        	
	        	Element numTel = doc.createElement("numTel");
	        	numTel.appendChild(doc.createTextNode(cliente.getNumTel()));
	        	campo.appendChild(numTel);
	        	
	        	Element fechaDeNacimiento = doc.createElement("fechaDeNacimiento");
	        	fechaDeNacimiento.appendChild(doc.createTextNode(cliente.getFechaDeNacimiento()));
	        	campo.appendChild(fechaDeNacimiento);
	        	
	        	Element perfilCompleto = doc.createElement("perfilCompleto");
	        	if(cliente.isPerfilCompleto()) {
	        		perfilCompleto.appendChild(doc.createTextNode("true"));
	        	}else {
	        		perfilCompleto.appendChild(doc.createTextNode("false"));
	        	}
	        	campo.appendChild(perfilCompleto);
	     
	        	Element contraseña = doc.createElement("contraseña");
	        	contraseña.appendChild(doc.createTextNode(cliente.getContraseña()));
	        	campo.appendChild(contraseña);
	        	
	        	Element notificaciones = doc.createElement("notificaciones");
	        	if(cliente.isNotificaciones()) {
	        		notificaciones.appendChild(doc.createTextNode("true"));
	        	}else {
	        		notificaciones.appendChild(doc.createTextNode("false"));
	        	}
	        	
	        	campo.appendChild(notificaciones);
	        	
	        	Element numCasillero = doc.createElement("numCasillero");
	        	numCasillero.appendChild(doc.createTextNode(cliente.getNumCasillero()));
	        	campo.appendChild(numCasillero);
	        	
	        	/*Not ready, need more time
	        	 * 
	        	 * Element paquetes = doc.createElement("paquetes");
	        	paquetes.appendChild(doc.createTextNode(cliente.getPaquetes()));
	        	campo.appendChild(paquetes);*/
	   
	        }
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();
	        
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        
	        DOMSource source = new DOMSource(doc);
	        try {
	            FileWriter fos = new FileWriter(xmlFile);
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
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
}
