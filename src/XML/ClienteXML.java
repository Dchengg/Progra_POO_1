package XML;  

import aplicacion.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClienteXML {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static void leerXML() {
		ClienteXML ejemplo = new ClienteXML();
		ejemplo.leerArchivo("src/XML/Usuarios.xml");
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
					String nombre = campo.getChildTextTrim("nombre");
					String email = campo.getChildTextTrim("email");
					String dir = campo.getChildTextTrim("dirrecion");
					String numTel = campo.getChildTextTrim("numTel");
					String fecha = campo.getChildTextTrim("fechaN");
					boolean perfil = (campo.getChildTextTrim("perfilC").equals("si"));
					String contra = campo.getChildTextTrim("contrasena");
					boolean recibir = (campo.getChildTextTrim("recibirN").equals("si"));
					String casillero = campo.getChildTextTrim("casillero");
					System.out.println( "\t"+dir+"\t"+numTel+"\t"+fecha+"\t"+perfil+"\t"+contra+"\t"+recibir);
					Cliente clienteCargado = new Cliente(nombre,email,dir,numTel,fecha,perfil,contra,recibir,casillero);
					clientes.add(clienteCargado);
					
				}
			}
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		
	}
	
	public static ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
}
