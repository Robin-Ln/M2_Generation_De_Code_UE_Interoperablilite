package fr.ubo.m2tiil.louarn.xml;

import fr.ubo.m2tiil.louarn.modele.java.Dependance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ParserXmlDependance {

    /*
     * Attribut
     */

    private Document document;
    private List<Dependance> dependencies;

    /*
     * Constructeur
     */
    public ParserXmlDependance(Document document) {
        super();
        this.document = document;
        this.dependencies = new ArrayList<>();
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
                Element NodeElement = (Element) node;
                Dependance dependance = this.getDependence(NodeElement);
                this.dependencies.add(dependance);
            }
        }
    }

    private Dependance getDependence(Element element){
        Dependance dependance = new Dependance();
        dependance.setName(element.getAttribute("name"));
        dependance.setType(element.getAttribute("type"));
        dependance.setPackageName(element.getAttribute("package"));
        return dependance;
    }


    /*
     * Accesseurs
     */

    public List<Dependance> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependance> dependencies) {
        this.dependencies = dependencies;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
