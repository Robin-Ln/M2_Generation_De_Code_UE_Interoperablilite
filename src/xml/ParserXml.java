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

		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementType = (Element) node;
				attribute.setType(this.getType(elementType));
			}
		}

		//attribute.setType(this.getType(element));

		return attribute;
	}

	private Type getType(Element element){
		switch (element.getNodeName()) {
			case "array":
				Array array = new Array();
				array.setType(this.getTypeElement(element));
				return array;
			case "collection":
				Collection collection = new Collection();
				collection.setTypeCollection(element.getAttribute("typeCollection"));
				collection.setType(this.getTypeElement(element));
				return collection;
			case "typeElement":
				TypeElement typeElement = new TypeElement();
				typeElement.setType(element.getAttribute("type"));
				return typeElement;
			default:
				System.out.println("Problème switch private Type getType(Element element)");
				break;
		}
		return null;
	}

	private Type getTypeElement(Element element){
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementType = (Element) node;
				return this.getType(elementType);
			}
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

}
