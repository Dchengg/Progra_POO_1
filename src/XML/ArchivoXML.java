package XML;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class ArchivoXML {
	public static void main(String[] args) {
		ArchivoXML ejemplo = new ArchivoXML();
		ejemplo.leerArchivo("src/archivo.xml");
	}
	public void leerArchivo(String xmlFile) {
		SAXBuilder builder = new SAXBuilder();
		File xml = new File(xmlFile);
		
		try {
			Document document = (Document)builder.build(xml);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("tabla");
			for(int i = 0; i < list.size(); i++){
				Element tabla = (Element) list.get(i);
				String nombreTabla = tabla.getAttributeValue("nombre");
				System.out.println("Tabla: " + nombreTabla);
				List lista_campos = tabla.getChildren();
				System.out.println( "\tNombre\tTipo\t\tValor");
				for(int j = 0; j < lista_campos.size(); j++) {
					Element campo = (Element)lista_campos.get(j);
					String nombre = campo.getChildTextTrim("Nombre");
					String tipo = campo.getChildTextTrim("tipo");
					String valor = campo.getChildTextTrim("valor");
					System.out.println( "\t"+nombre+"\t"+tipo+"\t\t"+valor);
				}
			}	
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		
	}

}
