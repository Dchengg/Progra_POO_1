package XML;  

import aplicacion.Cliente;
import aplicacion.Soporte;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;




public class ClienteXML {
	private ArrayList<Soporte> soportes;
	private ArrayList<Cliente> clientes;
	private String xmlFile;
	
        
        
	public ClienteXML (ArrayList<Cliente> pClientes, ArrayList<Soporte> pSoportes, String pXmlFile) {
		setSoportes(pSoportes);
		setClientes(pClientes);
		setXmlFile(pXmlFile);
	}
       
        
        /**
 * Lee los datos de los clientes y soportes desde un .XML, los guarda en una lista
 */
	public void leerArchivo() {
		SAXBuilder builder = new SAXBuilder();
		File xml = new File(xmlFile);
		try {
			Document document = (Document)builder.build(xml);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("tabla");
			for(int i = 0; i < list.size(); i++){
				Element tabla = (Element) list.get(i);
				String nombreTabla = tabla.getAttributeValue("Nombre");
				if(nombreTabla.equals("Clientes")) {
					List<Element> lista_campos = tabla.getChildren();
					for(int j = 0; j < lista_campos.size(); j++) {
						Element campo = (Element)lista_campos.get(j);
						String nombre = campo.getChildTextTrim("nombre");
						String email = campo.getChildTextTrim("email");
						String dir = campo.getChildTextTrim("dirrecion");
						String numTel = campo.getChildTextTrim("numTel");
						String fecha = campo.getChildTextTrim("fechaDeNacimiento");
						boolean perfil = (campo.getChildTextTrim("perfilCompleto").equals("true"));
						String contra = campo.getChildTextTrim("contrasena");
						boolean recibir = (campo.getChildTextTrim("notificaciones").equals("true"));
						String casillero = campo.getChildTextTrim("numCasillero");
                                                String numCasillero = casillero.substring(4);
                                                Cliente.setCantCasilleros(Integer.parseInt(numCasillero));
						Cliente clienteCargado = new Cliente(nombre,email,dir,numTel,fecha,perfil,contra,recibir,casillero);
						Element paquetes = campo.getChild("paquetes");
						List<Element> paquetesP = paquetes.getChildren();
						for(int k = 0; k < paquetesP.size(); k++) {
							Element paquete = (Element) paquetesP.get(k);
							String trackingID = paquete.getChildTextTrim("trackingID");
							String tienda = paquete.getChildTextTrim("tienda");
							String courier = paquete.getChildTextTrim("courier");
							double valor = Double.parseDouble(paquete.getChildTextTrim("valor"));
							double peso = Double.parseDouble(paquete.getChildTextTrim("peso"));
							String descripcion = paquete.getChildTextTrim("descripcion");
							String estado = paquete.getChildTextTrim("estado");
							String categoria = paquete.getChildTextTrim("categoria");
                                                        String horaCambio = paquete.getChildTextTrim("horaCambio");
                                                        String fechaCambio = paquete.getChildTextTrim("fechaCambio");
							clienteCargado.agregarPaquete(trackingID, tienda, courier, valor, peso, descripcion, estado, categoria, fechaCambio, horaCambio);
						}
						clientes.add(clienteCargado);
						}
					}
				if(nombreTabla.equals("Soportes")) {
					List<Element> lista_campos = tabla.getChildren();
					for(int j = 0; j < lista_campos.size(); j++) {
						Element campo = (Element)lista_campos.get(j);
						String nombre = campo.getChildTextTrim("nombre");
						String email = campo.getChildTextTrim("email");
						String contra = campo.getChildTextTrim("contrasena");
						Soporte soporteCargado = new Soporte(nombre,contra,email);
						soportes.add(soporteCargado);
					}
				}
			}
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
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
	
	public ArrayList<Soporte> getSoportes() {
		return soportes;
	}

	public void setSoportes(ArrayList<Soporte> soportes) {
		this.soportes = soportes;
	}
	
	
	
}
