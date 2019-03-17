package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
import fr.ubo.m2tiil.louarn.modele.minispec.AttributeMinispec;
import fr.ubo.m2tiil.louarn.modele.minispec.Entity;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

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
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                this.modeleJava.getClazzes().add(this.getClass((Element) node));
            }
        }
    }

    private Clazz getClass(Element classElement) {
        Clazz clazz = new Clazz();
        clazz.setName(classElement.getAttribute("name"));



        NodeList nodeList = classElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                switch (element.getNodeName()) {
                    case "motsCles":
                        clazz.setMotsCles(this.getMotsCles(element));
                        break;
                    case "superType":
                        String subtype = element.getAttribute("supertype");
                        if (StringUtils.isNotBlank(subtype)) {
                            clazz.setSupertype(subtype);
                        }
                        break;
                    case "interfaces":
                        clazz.setImplementsClasses(this.getIntefaces(element));
                        break;
                    case "attribute":
                        clazz.getAttributeJavas().add(this.getAttribute(element));
                        break;
                    case "constructeur":
                        break;
                    case "accesseurs":
                        break;
                    case "methodes":
                        break;
                    default:
                        throw new RuntimeException("fail default switch getClass");
                }
            }
        }
        return clazz;
    }


    private AttributeJava getAttribute(Element AttributeElement) {
        AttributeJava attributeJava = new AttributeJava();
        attributeJava.setName(AttributeElement.getAttribute("name"));

        NodeList nodeList = AttributeElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                switch (element.getNodeName()) {
                    case "motsCles":
                        attributeJava.setMotsCles(this.getMotsCles(element));
                        break;
                    case "typeElement": // meme traitement que collection
                    case "collection":
                        attributeJava.setType(this.getType(element));
                        break;
                    default:
                        throw new RuntimeException("fail default switch getAttribute");
                }
            }
        }
        return attributeJava;
    }

    private Argument getArgument(Element element) {
        Argument argument = new Argument();
        argument.setName(element.getAttribute("name"));

        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elementType = (Element) node;
                argument.setType(this.getType(elementType));
            }
        }
        return argument;
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

    private List<MotsCles> getMotsCles(Element element){
        List<MotsCles> motsCles = new ArrayList<>();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                motsCles.add(MotsCles.valueOf(element.getNodeValue()));
            }
        }
        return motsCles;
    }

    private List<String> getIntefaces(Element element){
        List<String> interfaces = new ArrayList<>();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                interfaces.add(node.getNodeValue());
            }
        }
        return interfaces;
    }

    private Constructeur getConstructeur(Element constructeurElement){
        Constructeur constructeur = new Constructeur();

        NodeList nodeList = constructeurElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                switch (element.getNodeName()) {
                    case "motsCles":
                        constructeur.setMotsCles(this.getMotsCles(element));
                        break;
                    case "argument":
                        constructeur.getArguments().add(this.getArgument(element));
                        break;
                    case "bloc":
                        constructeur.setBloc(this.getBloc(element));
                        break;
                    default:
                        throw new RuntimeException("fail default switch getConstructeur");
                }
            }
        }

        return constructeur;
    }

    private Bloc getBloc (Element blocElement){
        Bloc bloc = new Bloc();
        NodeList nodeList = blocElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                bloc.getLignes().append(node.getNodeValue());
            }
        }
        return bloc;
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
