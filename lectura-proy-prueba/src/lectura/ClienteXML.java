package lectura;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClienteXML {
	public static void main(String[] args) {
		ClienteXML ejemplo = new ClienteXML();
		ejemplo.leerArchivo("src/infoClientes.xml");
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
				List<Element> lista_campos = tabla.getChildren();
				System.out.println( "\tdireccion\t\tnumero\t\tfecha\t\tperfil\tcontra\t\trecibir");
				for(int j = 0; j < lista_campos.size(); j++) {
					Element campo = (Element)lista_campos.get(j);
					String dirrecion = campo.getChildTextTrim("dirrecion");
					String numero = campo.getChildTextTrim("numero");
					String fecha = campo.getChildTextTrim("fechaN");
					String perfil = campo.getChildTextTrim("perfilC");
					String contrasena = campo.getChildTextTrim("contrasena");
					String recibir = campo.getChildTextTrim("recibirN");
					System.out.println( "\t"+dirrecion+"\t"+numero+"\t"+fecha+"\t"+perfil+"\t"+contrasena+"\t"+recibir);
				}
			}
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		
	}

}
