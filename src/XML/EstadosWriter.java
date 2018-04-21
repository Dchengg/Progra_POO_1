package XML;

import aplicacion.Estados;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class EstadosWriter {
    private ArrayList<Estados> estados;
    private String xmlFile;
    
    public EstadosWriter(ArrayList<Estados> pEstados, String pXMLFile){
        setEstados(pEstados);
        setXmlFile(pXMLFile);
    }
    
    public void escribirArchivo() {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();
                
                Element root = doc.createElement("table");
	        doc.appendChild(root);
                
                for(Estados estado : estados){
                    Element campo = doc.createElement("estado");
		    root.appendChild(campo);
                    
                    Element descripcion = doc.createElement("descripcion");
                    descripcion.appendChild(doc.createTextNode(estado.getDescripcion()));
		    campo.appendChild(descripcion);
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

    public ArrayList<Estados> getEstados() {
        return estados;
    }

    public String getXmlFile() {
        return xmlFile;
    }

    public void setEstados(ArrayList<Estados> estados) {
        this.estados = estados;
    }

    public void setXmlFile(String xmlFile) {
        this.xmlFile = xmlFile;
    }
}
