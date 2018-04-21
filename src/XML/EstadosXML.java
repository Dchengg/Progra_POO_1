package XML;

import aplicacion.Estados;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class EstadosXML {
    private ArrayList<Estados> estados;
    private String xmlFile;
    
    public EstadosXML(ArrayList<Estados> pEstados, String pXMLFile){
        setEstados(pEstados);
        setXmlFile(pXMLFile);
    }
    
    public void leerArchivo() {
        SAXBuilder builder = new SAXBuilder();
		File xml = new File(xmlFile);
		try {
			Document document = (Document)builder.build(xml);
			Element rootNode = document.getRootElement();
                        List<Element> list = rootNode.getChildren("estado");
                        for(int i = 0; i < list.size(); i++){
                            Element est = (Element)list.get(i);
                            String des = est.getChildTextTrim("descripcion");
                            Estados estadoCargado = new Estados(des);
                            estados.add(estadoCargado);
                        }
                    }catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
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
