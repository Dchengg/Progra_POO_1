package XML;

import aplicacion.Categoria;


import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class CategoriasXML {
	private ArrayList<Categoria> categorias;
	private String xmlFile;
	
	public CategoriasXML (ArrayList<Categoria> pCategorias, String pXmlFile) {
		setCategorias(pCategorias);
		setXmlFile(pXmlFile);
	}
	public void leerArchivo() {
		SAXBuilder builder = new SAXBuilder();
		File xml = new File(xmlFile);
		try {
			Document document = (Document)builder.build(xml);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("tr");
			for(int i = 0; i < list.size(); i++){
				Element cat = (Element)list.get(i);
				String td =  cat.getChildTextTrim("td");
				double tdval = Double.parseDouble(cat.getChildTextTrim("tdval"));
				Categoria categoriaCargada = new Categoria(td, tdval);
				categorias.add(categoriaCargada);
			}
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}catch(JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
}