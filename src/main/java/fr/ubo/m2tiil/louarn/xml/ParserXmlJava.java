package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.ModeleJava;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import fr.ubo.m2tiil.louarn.modele.minispec.ModeleMinispec;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXmlJava {

    /*
     * Attribut
     */

    private Document document;
    private ModeleJava modeleJava;

    /*
     * Constructeur
     */
    public ParserXmlJava(Document document) {
        super();
        this.document = document;
        this.modeleJava = new ModeleJava();
    }

    /*
     * Methodes
     */

    public void lire() {
        Element element = this.document.getDocumentElement();
        this.modeleJava.setName(element.getAttribute("name"));
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                this.modeleJava.getClazzes().add(this.getEntity((Element) node));
            }
        }
    }

    private Entity getEntity(Element element) {
        Entity entity = new Entity();
        entity.setName(element.getAttribute("name"));

        String subtype = element.getAttribute("supertype");
        if (subtype != null) {
            entity.setSuperType(subtype);
        }

        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elementAttribute = (Element) node;
                entity.getAttributeMinispecs().add(this.getAttribute(elementAttribute));
            }
        }
        return entity;
    }


    private AttributeMinispec getAttribute(Element element) {
        AttributeMinispec attributeMinispec = new AttributeMinispec();
        attributeMinispec.setName(element.getAttribute("name"));

        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elementType = (Element) node;
                attributeMinispec.setType(this.getType(elementType));
            }
        }
        return attributeMinispec;
    }

    private Type getType(Element element) {
        switch (element.getNodeName()) {
            case "array":
                Array array = new Array();
                array.setSize(new Integer(element.getAttribute("size")));
                array.setType(this.getTypeElement(element));
                return array;
            case "collection":
                Collection collection = new Collection();
                collection.setTypeCollection(element.getAttribute("typeCollection"));

                // ce champ n'est pas obligatoire
                // si une exeption survient il ne faut pas metre a jour la valeur
                try {
                    collection.setMin(new Integer(element.getAttribute("min")));
                } catch (NumberFormatException e) {}

                // ce champ n'est pas obligatoire
                // si une exeption survient il ne faut pas metre a jour la valeur
                try {
                    collection.setMax(new Integer(element.getAttribute("max")));
                } catch (NumberFormatException e) {}

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

    private Type getTypeElement(Element element) {
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

    public ModeleJava getModeleJava() {
        return modeleJava;
    }

    public void setModeleJava(ModeleJava modeleJava) {
        this.modeleJava = modeleJava;
    }

}
