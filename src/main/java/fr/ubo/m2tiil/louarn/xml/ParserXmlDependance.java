package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.dependance.Dependance;
import fr.ubo.m2tiil.louarn.modele.dependance.Primitive;
import fr.ubo.m2tiil.louarn.modele.dependance.ReferenceModele;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;

public class ParserXmlDependance {

    /*
     * Attribut
     */

    private Document document;
    private Map<String, Dependance> dependencies;

    /*
     * Constructeur
     */
    public ParserXmlDependance(Document document) {
        super();
        this.document = document;
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
                Dependance dependance = this.getDependence(element);
                this.dependencies.put(dependance.getName(), dependance);
            }
        }
    }

    private Dependance getDependence(Element element){
        switch (element.getNodeName()) {
            case "model":
                ReferenceModele referenceModele = new ReferenceModele();
                referenceModele.setName(element.getAttribute("name"));
                referenceModele.setPackageName(element.getAttribute("package"));
                return referenceModele;
            case "primitive":
                Primitive primitive = new Primitive();
                primitive.setType(element.getAttribute("type"));
                primitive.setName(element.getAttribute("name"));
                primitive.setPackageName(element.getAttribute("package"));
                return primitive;
            default:
                System.out.println("Problème switch private Type getType(Element element)");
                return null;
        }
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

    public Map<String, Dependance> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Map<String, Dependance> dependencies) {
        this.dependencies = dependencies;
    }
}
