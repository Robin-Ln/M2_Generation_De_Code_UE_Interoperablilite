package xml;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import meta.modele.Array;
import meta.modele.Attribute;
import meta.modele.Collection;
import meta.modele.Entity;
import meta.modele.Modele;

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
		Entity entity = new Entity(element.getAttribute("name"));
		
		String subtype = element.getAttribute("subtype");
		if( subtype != null) {
			entity.setSubtype(subtype);
		}
		
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementNode = (Element)node;
				switch (elementNode.getNodeName()) {
				case "attribute":
					entity.getAttributes().add(this.getAttribute(elementNode));
					break;
				case "array":
					entity.getAttributes().add(this.getArray(elementNode));
					break;
				case "collection":
					entity.getAttributes().add(this.getColellection(elementNode));
					break;
				default:
					break;
				}
			}
		}
		return entity;
	}
	
	private Attribute getAttribute(Element element) {
		String name = element.getAttribute("name");
		String type = element.getAttribute("type");
		return new Attribute(name, type);
	}
	
	private Array getArray(Element element) {
		String name = element.getAttribute("name");
		String type = element.getAttribute("type");
		String typeElements = element.getAttribute("typeElements");
		Integer size = new Integer(element.getAttribute("size"));
		return new Array(name, type, size, typeElements);
	}
	
	private Collection getColellection(Element element) {
		String name = element.getAttribute("name");
		String type = element.getAttribute("type");
		String typeElements = element.getAttribute("typeElements");
		return new Collection(name, type, typeElements);
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
