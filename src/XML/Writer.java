package escritura;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
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
		Cliente a = new Cliente("Vazques de Coronado","22990823","10-03-1999", "si","mecagoenChenga","si"); //this
		Cliente b = new Cliente("Tres Rios","0932123746","30-11-2018", "no","kek","no"); //this
		Cliente c = new Cliente("Cartago","11111111","01-01-01","si","believenot","si");  //this
		list.add(a);
		list.add(b);
		list.add(c); //this
		
		escribirArchivo(fileName,list);
	}
	private static void escribirArchivo(List<Cliente> list) {
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
	        	direccion.appendChild(doc.createTextNode(cliente.getDireccion()));
	        	campo.appendChild(direccion);
	        	
	        	Element numero = doc.createElement("numero");
	        	numero.appendChild(doc.createTextNode(cliente.getNumero()));
	        	campo.appendChild(numero);
	        	
	        	Element fechaN = doc.createElement("fechaN");
	        	fechaN.appendChild(doc.createTextNode(cliente.getFechaN()));
	        	campo.appendChild(fechaN);
	        	
	        	Element perfil = doc.createElement("perfilC");
	        	perfil.appendChild(doc.createTextNode(cliente.getPerfilC()));
	        	campo.appendChild(perfil);
	        	
	        	Element contraseña = doc.createElement("contrasena");
	        	contraseña.appendChild(doc.createTextNode(cliente.getContrasena()));
	        	campo.appendChild(contraseña);
	        	
	        	Element recibirN = doc.createElement("recibirN");
	        	recibirN.appendChild(doc.createTextNode(cliente.getRecibirN()));
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
	            FileWriter fos = new FileWriter("src/infoClientes.xml");
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
