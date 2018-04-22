package XML;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;




public class CategoriasXML {
	private static String xmlFile = "src/XML/Categorias.xml";

        /**
 * Lee los datos de las categorias desde un .XML
 */
        
	public static Double leerArchivo(String categoria) {
		SAXBuilder builder = new SAXBuilder();
		File xml = new File(xmlFile);
		try {
			Document document = (Document)builder.build(xml);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("tr");
			for(int i = 0; i < list.size(); i++){
				Element cat = (Element)list.get(i);
				String td =  cat.getChildTextTrim("td");
                                if(td.equals(categoria)){
                                    double tdval = Double.parseDouble(cat.getChildTextTrim("tdval"));
                                    return tdval;
                                }
				
				
			}
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
                return null;
	}
        
        /**
 * Guarda los datos de las categorias en una lista
 */
        
        public static ArrayList<String> getCategorias(){
            ArrayList<String> categorias = new ArrayList<String>();
            SAXBuilder builder = new SAXBuilder();
            File xml = new File(xmlFile);
            try {
                Document document = (Document)builder.build(xml);
                Element rootNode = document.getRootElement();
                List<Element> list = rootNode.getChildren("tr");
                for(int i = 0; i < list.size(); i++){
                    Element cat = (Element)list.get(i);
                    String td =  cat.getChildTextTrim("td");
                    categorias.add(td);
                }
            }catch (IOException io) {
                    System.out.println(io.getMessage());
            }catch(JDOMException jdomex) {
                    System.out.println(jdomex.getMessage());
            }
            return categorias;
        }
	
	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
}