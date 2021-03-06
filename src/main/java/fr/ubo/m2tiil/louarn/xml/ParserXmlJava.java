package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.commun.Array;
import fr.ubo.m2tiil.louarn.modele.commun.Collection;
import fr.ubo.m2tiil.louarn.modele.commun.Type;
import fr.ubo.m2tiil.louarn.modele.commun.TypeElement;
import fr.ubo.m2tiil.louarn.modele.java.*;
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
    }

    /*
     * Methodes
     */

    public void lire() {
        Element element = this.document.getDocumentElement();
        this.modeleJava = new ModeleJava();
        modeleJava.setName(element.getAttribute("name"));

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
        clazz.setApackage(classElement.getAttribute("package"));
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
                        String subtype = element.getAttribute("name");
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
                        clazz.getConstructeurs().add(this.getConstructeur(element));
                        break;
                    case "accesseurs":
                        clazz.setAccesseurs(this.getMethodes(element));
                        break;
                    case "methodes":
                        clazz.setMethodes(this.getMethodes(element));
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

    private List<MotsCles> getMotsCles(Element motsCleselement){
        List<MotsCles> motsCles = new ArrayList<>();
        NodeList nodeList = motsCleselement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                motsCles.add(MotsCles.valueOf(element.getFirstChild().getNodeValue()));
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
                interfaces.add(node.getFirstChild().getNodeValue());
            }
        }
        return interfaces;
    }

    private Constructeur getConstructeur(Element constructeurElement){
        Constructeur constructeur = new Constructeur();
        constructeur.setName(constructeurElement.getAttribute("name"));

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
                bloc.getLignes().append(node.getFirstChild().getNodeValue());
            }
        }
        return bloc;
    }

    private List<Methode> getMethodes(Element methodesElement){
        List<Methode> methodes = new ArrayList<>();
        NodeList nodeList = methodesElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                methodes.add(this.getMethode(element));
            }
        }
        return methodes;
    }

    private Methode getMethode (Element methodeElement){
        Methode methode = new Methode();
        methode.setName(methodeElement.getAttribute("name"));

        NodeList nodeList = methodeElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                switch (element.getNodeName()) {
                    case "motsCles":
                        methode.setMotsCles(this.getMotsCles(element));
                        break;
                    case "argument":
                        methode.getArguments().add(this.getArgument(element));
                        break;
                    case "bloc":
                        methode.setBloc(this.getBloc(element));
                        break;
                    case "returnType":
                        methode.setType(this.getTypeElement(element));
                        break;
                    default:
                        throw new RuntimeException("fail default switch getMethode");
                }
            }
        }
        return methode;
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
