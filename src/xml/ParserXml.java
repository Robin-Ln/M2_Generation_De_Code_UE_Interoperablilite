package xml;

import java.util.List;

import meta.modele.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXml {

	/*
	 * Attribut
	 */

	private Document document;
	private Modele modele;
	private List<Attribute> attributes;

	/*
	 * Constructeur
	 */
	public ParserXml(Document document) {
		super();
		this.document = document;
		this.modele = new Modele();
	}

	/*
	 * Methodes
	 */

	public void lire() {
		Element element = this.document.getDocumentElement();
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				this.modele.getEntities().add(this.getEntity((Element)node));
			}
		}
	}
	
	private Entity getEntity(Element element) {
		Entity entity = new Entity();
		entity.setName(element.getAttribute("name"));
		
		String subtype = element.getAttribute("subtype");
		if( subtype != null) {
			entity.setSubtype(subtype);
		}
		
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementAttribute = (Element) node;
				entity.getAttributes().add(this.getAttribute(elementAttribute));
			}
		}
		return entity;
	}


	
	private Attribute getAttribute(Element element) {
		Attribute attribute = new Attribute();
		attribute.setName(element.getAttribute("name"));

		Element elementType =(Element) element.getFirstChild();

		attribute.setType(this.getType(elementType));
		return attribute;
	}

	private Type getType(Element element){
		switch (element.getNodeName()) {
			case "typeElement":
				TypeElement typeElement = new TypeElement();
				typeElement.setType(element.getAttribute("type"));
				return typeElement;
			case "array":
				Array array = new Array();
				array.setType(this.getType(element));
				return array;
			case "collection":
				Collection collection = new Collection();
				collection.setType(this.getType(element));
			default:
				break;
		}
		return null;
	}

	/*
	 * Accesseurs
	 */
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

}
